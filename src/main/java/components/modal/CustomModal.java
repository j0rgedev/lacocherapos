package components.modal;

import javax.swing.*;

public class CustomModal extends javax.swing.JDialog {

    public CustomModal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new components.modal.Background();
        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReducir = new javax.swing.JButton();
        btnIncrementar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);

        background1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbTitle.setFont(new java.awt.Font("Iceland", 1, 28)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(25, 27, 22));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Message Title");

        txtQuantity.setEditable(false);
        txtQuantity.setBackground(new java.awt.Color(204, 204, 204));
        txtQuantity.setFont(new java.awt.Font("Iceland", 1, 18)); // NOI18N
        txtQuantity.setForeground(java.awt.Color.black);
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantity.setBorder(null);

        btnCancel.setBackground(new java.awt.Color(73, 73, 73));
        btnCancel.setFont(new java.awt.Font("Iceland", 0, 32)); // NOI18N
        btnCancel.setForeground(java.awt.Color.white);
        btnCancel.setText("CANCELAR");
        btnCancel.setBorderPainted(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEdit.setBackground(new java.awt.Color(44, 205, 70));
        btnEdit.setFont(new java.awt.Font("Iceland", 0, 32)); // NOI18N
        btnEdit.setForeground(java.awt.Color.white);
        btnEdit.setText("EDITAR");
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnReducir.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnReducir.setForeground(new java.awt.Color(255, 255, 255));
        btnReducir.setText("-");
        btnReducir.setBorder(null);
        btnReducir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReducir.setPreferredSize(new java.awt.Dimension(20, 30));

        btnIncrementar.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnIncrementar.setForeground(new java.awt.Color(255, 255, 255));
        btnIncrementar.setText("+");
        btnIncrementar.setBorder(null);
        btnIncrementar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnReducir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnIncrementar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lbTitle)
                .addGap(17, 17, 17)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncrementar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReducir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.modal.Background background1;
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnIncrementar;
    public javax.swing.JButton btnReducir;
    private javax.swing.JLabel lbIcon;
    public javax.swing.JLabel lbTitle;
    public javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
