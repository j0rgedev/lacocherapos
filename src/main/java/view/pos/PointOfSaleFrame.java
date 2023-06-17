package view.pos;

public class PointOfSaleFrame extends javax.swing.JFrame {

    public PointOfSaleFrame() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        posHeader = new components.pos.Header();
        posSecondaryHeader = new components.pos.SecondaryHeader();
        mainPanel = new javax.swing.JPanel();
        orderPanel = new view.pos.OrderPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        topPanel.setBackground(new java.awt.Color(45, 52, 63));
        topPanel.setLayout(new java.awt.CardLayout());
        topPanel.add(posHeader, "header1");
        topPanel.add(posSecondaryHeader, "header2");

        mainPanel.setBackground(new java.awt.Color(0, 0, 0));
        mainPanel.setLayout(new java.awt.CardLayout());

        orderPanel.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(orderPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel mainPanel;
    public view.pos.OrderPanel orderPanel;
    public components.pos.Header posHeader;
    public components.pos.SecondaryHeader posSecondaryHeader;
    public javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
