package controller.admin;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import model.dto.DashboardDTOS;
import model.enums.Category;
import model.service.AdminCharts;
import view.admin.AdminIntranetFrame;
import view.admin.AnalyticsPanel;
import view.components.admin.charts.pieChart.ModelPieChart;
import view.components.admin.charts.pieChart.PieChart;
import view.components.spinner.SpinnerProgress;
import view.components.spinner.SpinnerProgressUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnalyticsPanelController extends AdminAbstractController implements ItemListener {

    private final AnalyticsPanel analyticsPanel;
    private PieChart pieChart;
    private final AdminCharts adminCharts = new AdminCharts();
    private List<DashboardDTOS.TopFiveDishes> topFiveDishes;
    private String selectedCategory;
    private int selectedMonth;
    private final static Color[] PIE_CHART_COLORS = {
            new Color(23, 126, 238),
            new Color(221, 65, 65),
            new Color(47, 157, 64),
            new Color(196, 151, 58),
            new Color(150, 70, 111)
    };

    public AnalyticsPanelController(AdminIntranetFrame adminIntranetFrame, AnalyticsPanel analyticsPanel) {
        super(adminIntranetFrame);
        this.analyticsPanel = analyticsPanel;
        this.selectedCategory = null;
        this.selectedMonth = -1;
    }

    @Override
    public void init() {
        pieChart = new PieChart();
        analyticsPanel.cbCategories.addItemListener(this);
        analyticsPanel.cbMonth.addItemListener(this);
        pieChart.setFont(new Font("Iceland", Font.BOLD, 18));
        fetchData();
    }
    
    private void fetchData(){
        showSpinner();
        pieChart.clearData();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            if(selectedCategory == null) {
                if(selectedMonth == -1) {
                    topFiveDishes = adminCharts.getTopFiveDishes();
                } else {
                    topFiveDishes = adminCharts.getTopFiveDishesByMonth(selectedMonth);
                }
            } else {
                topFiveDishes = adminCharts.getTopFiveDishesByCategory(selectedCategory);
            }

            SwingUtilities.invokeLater(() -> {
                for(int i=0;i<topFiveDishes.size();i++){
                    pieChart.addData(
                            new ModelPieChart(
                                    topFiveDishes.get(i).dishName(),
                                    topFiveDishes.get(i).totalQuantity(),
                                    PIE_CHART_COLORS[i]
                            )
                    );
                }
                showPieChart();
                showTextInfo();
                if(topFiveDishes.isEmpty()) {
                    analyticsPanel.lblInfoText.setText("Sin datos para mostrar");
                    JOptionPane.showMessageDialog(
                            null,
                            "Sin información disponible para la selección actual",
                            "404 - No encontrado",
                            JOptionPane.INFORMATION_MESSAGE,
                            new FlatSVGIcon("icons/notfound.svg",30,30)
                    );
                }
            });
        });
        executorService.shutdown();
    }

    private void showSpinner(){
        analyticsPanel.jPanel1.removeAll();
        analyticsPanel.jPanel1.setLayout(new BoxLayout(analyticsPanel.jPanel1, BoxLayout.LINE_AXIS));
        SpinnerProgress spinnerProgress = new SpinnerProgress();
        spinnerProgress.setUI(new SpinnerProgressUI(7));
        spinnerProgress.setIndeterminate(true);
        analyticsPanel.jPanel1.add(spinnerProgress);
        analyticsPanel.jPanel1.repaint();
        analyticsPanel.jPanel1.revalidate();
    }

    private void showPieChart(){
        analyticsPanel.jPanel1.removeAll();
        analyticsPanel.jPanel1.setLayout(new BorderLayout());
        analyticsPanel.jPanel1.add(pieChart);
        analyticsPanel.jPanel1.repaint();
        analyticsPanel.jPanel1.revalidate();
    }

    private void showTextInfo(){
        String defaultText = "Mostrando los 5 productos más vendidos de todas las categorías y meses en el año 2023";

        String categoryText = "";
        if (selectedCategory != null) {
            Category category = Category.getCategoryById(selectedCategory);
            if (category != null) {
                categoryText = "Mostrando los 5 productos más vendidos de la categoría " + category.getName() + " en el año 2023";
            }
        }

        String monthText = "Mostrando los 5 productos más vendidos de todas las categorías y del mes " + selectedMonth + " en el año 2023";
        analyticsPanel.lblInfoText.setText(selectedCategory == null ?
                (selectedMonth == -1 ? defaultText : monthText) :
                categoryText);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            if(e.getSource() == analyticsPanel.cbCategories){
                this.selectedMonth = -1;
                analyticsPanel.cbMonth.setSelectedIndex(-1);
                Category category = Category.getCategoryByName((String) analyticsPanel.cbCategories.getSelectedItem());
                this.selectedCategory = category.getId();
                fetchData();
            }
            if(e.getSource() == analyticsPanel.cbMonth){
                this.selectedCategory = null;
                analyticsPanel.cbCategories.setSelectedIndex(-1);
                this.selectedMonth = analyticsPanel.cbMonth.getSelectedIndex() + 1;
                fetchData();
            }
        }
    }
}
