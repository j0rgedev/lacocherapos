/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package components.modal;

public class EditDishPanel extends javax.swing.JPanel {

    public EditDishPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        btnDecrease = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        btnIncrease = new javax.swing.JButton();
        txtDetails = new components.TextField();

        setOpaque(false);

        lbTitle.setFont(new java.awt.Font("Iceland", 1, 28)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(25, 27, 22));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Message Title");

        btnDecrease.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnDecrease.setForeground(java.awt.Color.red);
        btnDecrease.setText("-");
        btnDecrease.setBorder(null);
        btnDecrease.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDecrease.setPreferredSize(new java.awt.Dimension(20, 30));

        txtQuantity.setEditable(false);
        txtQuantity.setBackground(new java.awt.Color(204, 204, 204));
        txtQuantity.setFont(new java.awt.Font("Iceland", 1, 18)); // NOI18N
        txtQuantity.setForeground(java.awt.Color.black);
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantity.setBorder(null);

        btnIncrease.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnIncrease.setForeground(java.awt.Color.green);
        btnIncrease.setText("+");
        btnIncrease.setBorder(null);
        btnIncrease.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtDetails.setBackground(new java.awt.Color(240, 240, 240));
        txtDetails.setForeground(new java.awt.Color(0, 0, 0));
        txtDetails.setCaretColor(new java.awt.Color(50, 50, 50));
        txtDetails.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtDetails.setLabelText("Detalles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(txtDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDecrease;
    public javax.swing.JButton btnIncrease;
    public javax.swing.JLabel lbTitle;
    private components.TextField txtDetails;
    public javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}
