package controller.admin;

import view.admin.DashboardPanel;
import view.components.admin.charts.barChart.ModelBarChart;
import view.components.admin.charts.lineChart.chart.ModelChart;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DashboardPanelController extends AdminAbstractController {

    private final DashboardPanel dashboardPanel;

    public DashboardPanelController(DashboardPanel dashboardPanel) {
        this.dashboardPanel = dashboardPanel;
    }

    @Override
    public void init() {
        // Date
        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy");
        String formattedDate = fechaHoy.format(formatter);
        dashboardPanel.lblDate.setText("Fecha: "+formattedDate);

        // Charts
        initLineChart();
        initBarChart();
    }

    private void initLineChart(){
        dashboardPanel.lineChart.setTitle("Cantidad de pedidos por tipo de pago");
        dashboardPanel.lineChart.addLegend("Efectivo", Color.decode("#7b4397"), Color.decode("#dc2430"));
        dashboardPanel.lineChart.addLegend("Tarjeta", Color.decode("#e65c00"), Color.decode("#F9D423"));
        dashboardPanel.lineChart.addLegend("Billetera digital", Color.decode("#0099F7"), Color.decode("#F11712"));

        dashboardPanel.lineChart.clear();
        dashboardPanel.lineChart.addData(new ModelChart("January", new double[]{500, 50, 100}));
        dashboardPanel.lineChart.addData(new ModelChart("February", new double[]{600, 300, 150}));
        dashboardPanel.lineChart.addData(new ModelChart("March", new double[]{200, 50, 900}));
        dashboardPanel.lineChart.addData(new ModelChart("April", new double[]{480, 700, 100}));
        dashboardPanel.lineChart.addData(new ModelChart("May", new double[]{350, 540, 500}));
        dashboardPanel.lineChart.addData(new ModelChart("June", new double[]{450, 800, 100}));
        dashboardPanel.lineChart.start();
    }

    private void initBarChart(){
        dashboardPanel.barChart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        dashboardPanel.barChart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        dashboardPanel.barChart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        dashboardPanel.barChart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        dashboardPanel.barChart.addData(new ModelBarChart("January", new double[]{500, 200, 80, 89}));
        dashboardPanel.barChart.addData(new ModelBarChart("February", new double[]{600, 750, 90, 150}));
        dashboardPanel.barChart.addData(new ModelBarChart("March", new double[]{200, 350, 460, 900}));
        dashboardPanel.barChart.addData(new ModelBarChart("April", new double[]{480, 150, 750, 700}));
        dashboardPanel.barChart.addData(new ModelBarChart("May", new double[]{350, 540, 300, 150}));
        dashboardPanel.barChart.addData(new ModelBarChart("June", new double[]{190, 280, 81, 200}));
        dashboardPanel.barChart.start();
    }
}
