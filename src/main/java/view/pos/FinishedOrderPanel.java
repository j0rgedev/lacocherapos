/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view.pos;

public class FinishedOrderPanel extends javax.swing.JPanel {

    public FinishedOrderPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOrderId = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnNewOrder = new javax.swing.JButton();
        svgImage = new view.components.SVGImage();

        setBackground(new java.awt.Color(45, 52, 63));

        lblOrderId.setFont(new java.awt.Font("Iceland", 0, 80)); // NOI18N
        lblOrderId.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderId.setText("B00001");

        lblTitle.setFont(new java.awt.Font("Iceland", 1, 100)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Número de pedido");

        btnNewOrder.setBackground(new java.awt.Color(66, 100, 250));
        btnNewOrder.setFont(new java.awt.Font("Iceland", 1, 70)); // NOI18N
        btnNewOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnNewOrder.setText("Nuevo Pedido");
        btnNewOrder.setBorder(null);
        btnNewOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        svgImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOrderId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNewOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(svgImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(svgImage, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblOrderId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnNewOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnNewOrder;
    public javax.swing.JLabel lblOrderId;
    private javax.swing.JLabel lblTitle;
    public view.components.SVGImage svgImage;
    // End of variables declaration//GEN-END:variables

}
