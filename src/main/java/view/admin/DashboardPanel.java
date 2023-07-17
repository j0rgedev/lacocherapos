/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.admin;

import java.awt.Color;
import view.components.admin.charts.lineChart.chart.ModelChart;

public class DashboardPanel extends javax.swing.JPanel {

    public DashboardPanel() {
        initComponents();
        lineChart.setTitle("Chart Data");
        lineChart.addLegend("Amount", Color.decode("#7b4397"), Color.decode("#dc2430"));
        lineChart.addLegend("Cost", Color.decode("#e65c00"), Color.decode("#F9D423"));
        lineChart.addLegend("Profit", Color.decode("#0099F7"), Color.decode("#F11712"));
        test();
    }

    private void test() {
        lineChart.clear();
        lineChart.addData(new ModelChart("January", new double[]{500, 50, 100}));
        lineChart.addData(new ModelChart("February", new double[]{600, 300, 150}));
        lineChart.addData(new ModelChart("March", new double[]{200, 50, 900}));
        lineChart.addData(new ModelChart("April", new double[]{480, 700, 100}));
        lineChart.addData(new ModelChart("May", new double[]{350, 540, 500}));
        lineChart.addData(new ModelChart("June", new double[]{450, 800, 100}));
        lineChart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBarsPanel = new view.components.RoundPanel();
        lblDate = new javax.swing.JLabel();
        progressPanel1 = new javax.swing.JPanel();
        lblProgress1 = new javax.swing.JLabel();
        salesProgress = new view.components.admin.Progress();
        progressPanel2 = new javax.swing.JPanel();
        lblProgress2 = new javax.swing.JLabel();
        ordersProgress = new view.components.admin.Progress();
        lineChartPanel = new view.components.RoundPanel();
        lineChart = new view.components.admin.charts.lineChart.chart.CurveLineChart();
        barChartPanel = new view.components.RoundPanel();

        progressBarsPanel.setBackground(new java.awt.Color(21, 22, 26));

        lblDate.setFont(new java.awt.Font("Iceland", 1, 36)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Fecha: 16 de Julio del 2023");

        progressPanel1.setOpaque(false);

        lblProgress1.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        lblProgress1.setForeground(new java.awt.Color(255, 255, 255));
        lblProgress1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProgress1.setText("Monto vendido");

        salesProgress.setBackground(new java.awt.Color(66, 246, 84));
        salesProgress.setForeground(new java.awt.Color(19, 153, 32));
        salesProgress.setMaximum(1000);
        salesProgress.setFont(new java.awt.Font("Iceland", 0, 24)); // NOI18N

        javax.swing.GroupLayout progressPanel1Layout = new javax.swing.GroupLayout(progressPanel1);
        progressPanel1.setLayout(progressPanel1Layout);
        progressPanel1Layout.setHorizontalGroup(
            progressPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProgress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(salesProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        progressPanel1Layout.setVerticalGroup(
            progressPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanel1Layout.createSequentialGroup()
                .addComponent(lblProgress1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salesProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
        );

        progressPanel2.setOpaque(false);

        lblProgress2.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        lblProgress2.setForeground(new java.awt.Color(255, 255, 255));
        lblProgress2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProgress2.setText("Cantidad de pedidos");

        ordersProgress.setBackground(new java.awt.Color(132, 66, 246));
        ordersProgress.setForeground(new java.awt.Color(64, 18, 153));
        ordersProgress.setFont(new java.awt.Font("Iceland", 0, 24)); // NOI18N

        javax.swing.GroupLayout progressPanel2Layout = new javax.swing.GroupLayout(progressPanel2);
        progressPanel2.setLayout(progressPanel2Layout);
        progressPanel2Layout.setHorizontalGroup(
            progressPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProgress2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ordersProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        progressPanel2Layout.setVerticalGroup(
            progressPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanel2Layout.createSequentialGroup()
                .addComponent(lblProgress2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ordersProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout progressBarsPanelLayout = new javax.swing.GroupLayout(progressBarsPanel);
        progressBarsPanel.setLayout(progressBarsPanelLayout);
        progressBarsPanelLayout.setHorizontalGroup(
            progressBarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressBarsPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(progressBarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(progressBarsPanelLayout.createSequentialGroup()
                        .addComponent(progressPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        progressBarsPanelLayout.setVerticalGroup(
            progressBarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressBarsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(progressBarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        lineChartPanel.setBackground(new java.awt.Color(21, 22, 26));

        lineChart.setForeground(new java.awt.Color(200, 200, 200));
        lineChart.setFillColor(true);
        lineChart.setFont(new java.awt.Font("Iceland", 0, 18)); // NOI18N
        lineChart.setTitleFont(new java.awt.Font("Iceland", 1, 20)); // NOI18N

        javax.swing.GroupLayout lineChartPanelLayout = new javax.swing.GroupLayout(lineChartPanel);
        lineChartPanel.setLayout(lineChartPanelLayout);
        lineChartPanelLayout.setHorizontalGroup(
            lineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lineChartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
        lineChartPanelLayout.setVerticalGroup(
            lineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lineChartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        barChartPanel.setBackground(new java.awt.Color(21, 22, 26));

        javax.swing.GroupLayout barChartPanelLayout = new javax.swing.GroupLayout(barChartPanel);
        barChartPanel.setLayout(barChartPanelLayout);
        barChartPanelLayout.setHorizontalGroup(
            barChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        barChartPanelLayout.setVerticalGroup(
            barChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(progressBarsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(barChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBarsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.components.RoundPanel barChartPanel;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblProgress1;
    private javax.swing.JLabel lblProgress2;
    public view.components.admin.charts.lineChart.chart.CurveLineChart lineChart;
    private view.components.RoundPanel lineChartPanel;
    private view.components.admin.Progress ordersProgress;
    private view.components.RoundPanel progressBarsPanel;
    private javax.swing.JPanel progressPanel1;
    private javax.swing.JPanel progressPanel2;
    private view.components.admin.Progress salesProgress;
    // End of variables declaration//GEN-END:variables

}
