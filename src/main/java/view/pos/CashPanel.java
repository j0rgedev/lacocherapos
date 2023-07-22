/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view.pos;

public class CashPanel extends javax.swing.JPanel {

    public CashPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTwentySoles = new javax.swing.JButton();
        btnTenSoles = new javax.swing.JButton();
        btnFiftySoles = new javax.swing.JButton();
        btnHundredSoles = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblChange = new javax.swing.JLabel();
        lblChangeAmount = new javax.swing.JLabel();
        totalOrderPanel1 = new view.pos.TotalOrderPanel();

        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(45, 52, 63));

        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Iceland", 1, 46)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Billetes comunes");

        btnTwentySoles.setBackground(new java.awt.Color(21, 22, 26));
        btnTwentySoles.setFont(new java.awt.Font("Iceland", 1, 36)); // NOI18N
        btnTwentySoles.setForeground(new java.awt.Color(255, 255, 255));
        btnTwentySoles.setText("S/. 20");
        btnTwentySoles.setToolTipText("");
        btnTwentySoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTwentySoles.setName("10"); // NOI18N
        btnTwentySoles.setPreferredSize(new java.awt.Dimension(120, 90));

        btnTenSoles.setBackground(new java.awt.Color(21, 22, 26));
        btnTenSoles.setFont(new java.awt.Font("Iceland", 1, 36)); // NOI18N
        btnTenSoles.setForeground(new java.awt.Color(255, 255, 255));
        btnTenSoles.setText("S/. 10");
        btnTenSoles.setToolTipText("");
        btnTenSoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTenSoles.setName("10"); // NOI18N
        btnTenSoles.setPreferredSize(new java.awt.Dimension(120, 90));

        btnFiftySoles.setBackground(new java.awt.Color(21, 22, 26));
        btnFiftySoles.setFont(new java.awt.Font("Iceland", 1, 36)); // NOI18N
        btnFiftySoles.setForeground(new java.awt.Color(255, 255, 255));
        btnFiftySoles.setText("S/. 50");
        btnFiftySoles.setToolTipText("");
        btnFiftySoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiftySoles.setName("10"); // NOI18N
        btnFiftySoles.setPreferredSize(new java.awt.Dimension(120, 90));

        btnHundredSoles.setBackground(new java.awt.Color(21, 22, 26));
        btnHundredSoles.setFont(new java.awt.Font("Iceland", 1, 36)); // NOI18N
        btnHundredSoles.setForeground(new java.awt.Color(255, 255, 255));
        btnHundredSoles.setText("S/. 100");
        btnHundredSoles.setToolTipText("");
        btnHundredSoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHundredSoles.setName("10"); // NOI18N
        btnHundredSoles.setPreferredSize(new java.awt.Dimension(120, 90));
        btnHundredSoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHundredSolesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Iceland", 1, 46)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Monto exacto");

        txtAmount.setBackground(new java.awt.Color(204, 204, 204));
        txtAmount.setFont(new java.awt.Font("Iceland", 1, 32)); // NOI18N
        txtAmount.setForeground(java.awt.Color.black);
        txtAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAmount.setPreferredSize(new java.awt.Dimension(90, 90));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnTenSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnTwentySoles, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnFiftySoles, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnHundredSoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTenSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTwentySoles, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiftySoles, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHundredSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60))
        );

        jPanel1.setBackground(new java.awt.Color(45, 52, 63));

        lblChange.setFont(new java.awt.Font("Iceland", 0, 60)); // NOI18N
        lblChange.setForeground(new java.awt.Color(255, 255, 255));
        lblChange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChange.setText("Vuelto:");

        lblChangeAmount.setFont(new java.awt.Font("Iceland", 0, 60)); // NOI18N
        lblChangeAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblChangeAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChangeAmount.setText("------");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChangeAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(lblChangeAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalOrderPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(totalOrderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHundredSolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHundredSolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHundredSolesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnFiftySoles;
    public javax.swing.JButton btnHundredSoles;
    public javax.swing.JButton btnTenSoles;
    public javax.swing.JButton btnTwentySoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblChange;
    public javax.swing.JLabel lblChangeAmount;
    public view.pos.TotalOrderPanel totalOrderPanel1;
    public javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables

}
