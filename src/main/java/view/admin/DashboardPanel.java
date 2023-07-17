package view.admin;

public class DashboardPanel extends javax.swing.JPanel {

    public DashboardPanel() {
        initComponents();
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
        barChart = new view.components.admin.charts.barChart.Chart();

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
                .addComponent(salesProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
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
                .addGap(39, 39, 39)
                .addGroup(progressBarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(progressBarsPanelLayout.createSequentialGroup()
                        .addComponent(progressPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
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
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
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
            .addGroup(barChartPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(barChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        barChartPanelLayout.setVerticalGroup(
            barChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barChartPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(barChart, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(progressBarsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    public view.components.admin.charts.barChart.Chart barChart;
    private view.components.RoundPanel barChartPanel;
    public javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblProgress1;
    private javax.swing.JLabel lblProgress2;
    public view.components.admin.charts.lineChart.chart.CurveLineChart lineChart;
    private view.components.RoundPanel lineChartPanel;
    public view.components.admin.Progress ordersProgress;
    private view.components.RoundPanel progressBarsPanel;
    private javax.swing.JPanel progressPanel1;
    private javax.swing.JPanel progressPanel2;
    public view.components.admin.Progress salesProgress;
    // End of variables declaration//GEN-END:variables

}
