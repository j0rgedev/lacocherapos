/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view.pos;

public class PaymentMethodsPanel extends javax.swing.JPanel {

    public PaymentMethodsPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCash = new javax.swing.JButton();
        btnCard = new javax.swing.JButton();
        btnYape = new javax.swing.JButton();

        setBackground(new java.awt.Color(45, 52, 63));

        btnCash.setBackground(new java.awt.Color(21, 22, 26));
        btnCash.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        btnCash.setForeground(new java.awt.Color(240, 240, 240));
        btnCash.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCash.setPreferredSize(new java.awt.Dimension(260, 260));

        btnCard.setBackground(new java.awt.Color(21, 22, 26));
        btnCard.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        btnCard.setForeground(new java.awt.Color(240, 240, 240));
        btnCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCard.setPreferredSize(new java.awt.Dimension(260, 260));

        btnYape.setBackground(new java.awt.Color(21, 22, 26));
        btnYape.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        btnYape.setForeground(new java.awt.Color(240, 240, 240));
        btnYape.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnYape.setPreferredSize(new java.awt.Dimension(260, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(btnCash, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnCard, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnYape, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnYape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCard;
    public javax.swing.JButton btnCash;
    public javax.swing.JButton btnYape;
    // End of variables declaration//GEN-END:variables

}
