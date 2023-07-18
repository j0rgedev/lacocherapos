package controller.admin;

import model.service.AdminCharts;
import view.admin.DashboardPanel;
import view.components.admin.charts.common.ModelChart;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DashboardPanelController extends AdminAbstractController {

    private final DashboardPanel dashboardPanel;
    private final AdminCharts adminCharts = new AdminCharts();

    public DashboardPanelController(DashboardPanel dashboardPanel) {
        this.dashboardPanel = dashboardPanel;
    }

    @Override
    public void init() {
        // Date
        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String formattedDate = fechaHoy.format(formatter);
        dashboardPanel.lblDate.setText("Fecha: "+formattedDate);

        lineChartDefaults();
        barChartDefaults();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            // Progress
            initProgress();
            // Charts
            showLineChartData();
            showBarChartData();

            SwingUtilities.invokeLater(() -> {

            });
        });

        executorService.shutdown();
    }

    private void initProgress(){
        // Amount progress
        int amountMaximumValue = adminCharts.getOrdersTotalAmountForToday().goalAmount();
        int amountCurrentValue = adminCharts.getOrdersTotalAmountForToday().currentAmount();
        dashboardPanel.amountProgress.setMaximum(amountMaximumValue);
        dashboardPanel.amountProgress.setValue(amountCurrentValue);

        // Quantity progress
        int quantityMaximumValue = adminCharts.getOrdersPercentageForToday().goalQuantity();
        int quantityCurrentValue = adminCharts.getOrdersPercentageForToday().currentQuantity();
        dashboardPanel.quantityProgress.setMaximum(quantityMaximumValue);
        dashboardPanel.quantityProgress.setValue(quantityCurrentValue);
    }

    private void lineChartDefaults(){
        dashboardPanel.lineChart.setTitle("Cantidad de pedidos por tipo de pago");
        dashboardPanel.lineChart.addLegend("Efectivo", Color.decode("#7b4397"), Color.decode("#dc2430"));
        dashboardPanel.lineChart.addLegend("Tarjeta", Color.decode("#e65c00"), Color.decode("#F9D423"));
        dashboardPanel.lineChart.addLegend("Billetera digital", Color.decode("#0099F7"), Color.decode("#F11712"));
    }

    private void showLineChartData(){
        dashboardPanel.lineChart.clear();
        List<ModelChart> ordersByMonthAndPaymentMethod = adminCharts.getOrdersByMonthAndPaymentMethod();
        for (ModelChart modelChart : ordersByMonthAndPaymentMethod) {
            dashboardPanel.lineChart.addData(modelChart);
        }
        dashboardPanel.lineChart.start();
    }

    private void barChartDefaults(){
        dashboardPanel.barChart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        dashboardPanel.barChart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        dashboardPanel.barChart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        dashboardPanel.barChart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
    }

    private void showBarChartData(){
        dashboardPanel.barChart.clear();
        dashboardPanel.barChart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        dashboardPanel.barChart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        dashboardPanel.barChart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        dashboardPanel.barChart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        dashboardPanel.barChart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        dashboardPanel.barChart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        dashboardPanel.barChart.start();
    }
}
