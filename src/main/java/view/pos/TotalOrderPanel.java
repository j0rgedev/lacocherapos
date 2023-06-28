/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view.pos;

public class TotalOrderPanel extends javax.swing.JPanel {

    public TotalOrderPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblTB = new javax.swing.JLabel();
        lblDiscounts = new javax.swing.JLabel();
        lblIgv = new javax.swing.JLabel();
        lblIgvPrice = new javax.swing.JLabel();
        lblBasePrice = new javax.swing.JLabel();
        lblDiscountPrice = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));

        lblTitle.setFont(new java.awt.Font("Iceland", 1, 80)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("<html> <body style=\"text-align: center\"> TOTAL <br> CUENTA </body> </html>");

        lblTB.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        lblTB.setForeground(new java.awt.Color(0, 0, 0));
        lblTB.setText("Total Bruto");

        lblDiscounts.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        lblDiscounts.setForeground(new java.awt.Color(0, 0, 0));
        lblDiscounts.setText("Descuentos");

        lblIgv.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        lblIgv.setForeground(new java.awt.Color(0, 0, 0));
        lblIgv.setText("IGV");

        lblIgvPrice.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        lblIgvPrice.setForeground(new java.awt.Color(0, 0, 0));
        lblIgvPrice.setText("S/00.00");

        lblBasePrice.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        lblBasePrice.setForeground(new java.awt.Color(0, 0, 0));
        lblBasePrice.setText("S/00.00");

        lblDiscountPrice.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        lblDiscountPrice.setForeground(new java.awt.Color(0, 0, 0));
        lblDiscountPrice.setText("S/00.00");

        lblTotalPrice.setFont(new java.awt.Font("Iceland", 0, 70)); // NOI18N
        lblTotalPrice.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalPrice.setText("S/. 00.00");

        btnEdit.setBackground(new java.awt.Color(55, 55, 55));
        btnEdit.setFont(new java.awt.Font("Iceland", 1, 48)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Editar");
        btnEdit.setBorder(null);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnPay.setBackground(new java.awt.Color(66, 100, 250));
        btnPay.setFont(new java.awt.Font("Iceland", 1, 60)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Pagar");
        btnPay.setBorder(null);
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCancel.setBackground(new java.awt.Color(255, 66, 66));
        btnCancel.setFont(new java.awt.Font("Iceland", 1, 48)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setBorder(null);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiscounts)
                    .addComponent(lblTB)
                    .addComponent(lblIgv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBasePrice, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDiscountPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIgvPrice, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48))
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
            .addComponent(lblTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTB)
                    .addComponent(lblBasePrice))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiscounts)
                    .addComponent(lblDiscountPrice))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIgv)
                    .addComponent(lblIgvPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(lblTotalPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnPay;
    public javax.swing.JLabel lblBasePrice;
    public javax.swing.JLabel lblDiscountPrice;
    private javax.swing.JLabel lblDiscounts;
    private javax.swing.JLabel lblIgv;
    public javax.swing.JLabel lblIgvPrice;
    private javax.swing.JLabel lblTB;
    private javax.swing.JLabel lblTitle;
    public javax.swing.JLabel lblTotalPrice;
    // End of variables declaration//GEN-END:variables

}
