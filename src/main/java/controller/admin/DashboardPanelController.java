package controller.admin;

import model.service.AdminCharts;
import view.admin.AdminIntranetFrame;
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

    public DashboardPanelController(AdminIntranetFrame adminIntranetFrm, DashboardPanel dashboardPanel) {
        super(adminIntranetFrm);
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
        });

        executorService.shutdown();
    }

    private void initProgress(){
        // Amount progress
        int amountMaximumValue = adminCharts.getOrdersTotalAmountForToday().goalAmount();
        int amountCurrentValue = adminCharts.getOrdersTotalAmountForToday().currentAmount();
        dashboardPanel.amountProgress.setMaximum(amountMaximumValue);
        dashboardPanel.amountProgress.setValue(amountCurrentValue);
        dashboardPanel.amountProgress.start();
        dashboardPanel.amountProgress.setType(new String[]{"S/.", ""});

        // Quantity progress
        int quantityMaximumValue = adminCharts.getOrdersPercentageForToday().goalQuantity();
        int quantityCurrentValue = adminCharts.getOrdersPercentageForToday().currentQuantity();
        dashboardPanel.quantityProgress.setMaximum(quantityMaximumValue);
        dashboardPanel.quantityProgress.setValue(quantityCurrentValue);
        dashboardPanel.quantityProgress.start();
        dashboardPanel.quantityProgress.setType(new String[]{"%", ""});
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
        dashboardPanel.barChart.addLegend("Carta", new Color(12, 84, 175), new Color(0, 108, 247));
        dashboardPanel.barChart.addLegend("Antojitos", new Color(54, 4, 143), new Color(104, 49, 200));
        dashboardPanel.barChart.addLegend("Bebidas Calientes",  new Color(125, 5, 0), new Color(209, 69, 69));
        dashboardPanel.barChart.addLegend("Bebidas Frias", new Color(0, 125, 115), new Color(69, 209, 193));
        dashboardPanel.barChart.addLegend("Tragos", new Color(176, 186, 37, 255), new Color(232, 241, 100, 207));
        dashboardPanel.barChart.addLegend("Cervezas", new Color(186, 151, 37), new Color(241, 196, 100));
        dashboardPanel.barChart.addLegend("Postres", new Color(159, 37, 186), new Color(241, 100, 229));
    }

    private void showBarChartData(){
        dashboardPanel.barChart.clear();
        List<ModelChart> dishesQuantityByCategory = adminCharts.getDishesQuantityByCategory();
        for (ModelChart modelChart : dishesQuantityByCategory) {
            dashboardPanel.barChart.addData(modelChart);
        }
        dashboardPanel.barChart.start();
    }
}
