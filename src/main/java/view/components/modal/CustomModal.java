package view.components.modal;

public class CustomModal extends javax.swing.JDialog {

    public CustomModal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new view.components.modal.Background();
        lblIcon = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setModal(true);
        setUndecorated(true);

        background1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblIcon.setForeground(new java.awt.Color(0, 0, 0));
        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        containerPanel.setOpaque(false);
        containerPanel.setLayout(new java.awt.CardLayout());

        btnCancel.setBackground(new java.awt.Color(55, 55, 55));
        btnCancel.setFont(new java.awt.Font("Iceland", 0, 32)); // NOI18N
        btnCancel.setForeground(java.awt.Color.white);
        btnCancel.setText("CANCELAR");
        btnCancel.setBorderPainted(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEdit.setBackground(new java.awt.Color(44, 205, 70));
        btnEdit.setFont(new java.awt.Font("Iceland", 0, 32)); // NOI18N
        btnEdit.setForeground(java.awt.Color.white);
        btnEdit.setText("GUARDAR");
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGap(15, 15, 15)
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
    private view.components.modal.Background background1;
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnEdit;
    public javax.swing.JPanel containerPanel;
    public javax.swing.JLabel lblIcon;
    // End of variables declaration//GEN-END:variables
}
