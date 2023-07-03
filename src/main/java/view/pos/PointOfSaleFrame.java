package view.pos;

import view.components.pos.Header;
import view.components.pos.SecondaryHeader;

public class PointOfSaleFrame extends javax.swing.JFrame {

    private static PointOfSaleFrame instance;

    private PointOfSaleFrame() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    public static PointOfSaleFrame getInstance() {
        if (instance == null) {
            instance = new PointOfSaleFrame();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        posHeader = new view.components.pos.Header();
        posSecondaryHeader = new view.components.pos.SecondaryHeader();
        mainPanel = new javax.swing.JPanel();
        orderPanel = new view.pos.OrderPanel();
        orderConfirmationPanel = new view.pos.OrderConfirmationPanel();
        paymentMethodsPanel1 = new view.pos.PaymentMethodsPanel();
        cashPanel1 = new view.pos.CashPanel();
        finishedOrderPanel1 = new view.pos.FinishedOrderPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        topPanel.setBackground(new java.awt.Color(45, 52, 63));
        topPanel.setLayout(new java.awt.CardLayout());
        topPanel.add(posHeader, "mainHeader");
        topPanel.add(posSecondaryHeader, "secondaryHeader");

        mainPanel.setBackground(new java.awt.Color(0, 0, 0));
        mainPanel.setLayout(new java.awt.CardLayout());

        orderPanel.setForeground(new java.awt.Color(255, 255, 255));
        orderPanel.setName("orderPanel"); // NOI18N
        mainPanel.add(orderPanel, "orderPanel");

        orderConfirmationPanel.setName("orderConfirmationPanel"); // NOI18N
        mainPanel.add(orderConfirmationPanel, "orderConfirmationPanel");

        paymentMethodsPanel1.setName("paymentMethodsPanel"); // NOI18N
        mainPanel.add(paymentMethodsPanel1, "paymentMethodsPanel");

        cashPanel1.setName("cashPanel"); // NOI18N
        mainPanel.add(cashPanel1, "cashPanel");

        finishedOrderPanel1.setName("finishedOrderPanel"); // NOI18N
        mainPanel.add(finishedOrderPanel1, "finishedOrderPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public view.pos.CashPanel cashPanel1;
    public view.pos.FinishedOrderPanel finishedOrderPanel1;
    public javax.swing.JPanel mainPanel;
    public view.pos.OrderConfirmationPanel orderConfirmationPanel;
    public view.pos.OrderPanel orderPanel;
    public view.pos.PaymentMethodsPanel paymentMethodsPanel1;
    public view.components.pos.Header posHeader;
    public view.components.pos.SecondaryHeader posSecondaryHeader;
    public javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
