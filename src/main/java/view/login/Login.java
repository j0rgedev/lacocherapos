package view.login;

import com.formdev.flatlaf.FlatLightLaf;
public class Login extends javax.swing.JFrame {

    public Login() {
        FlatLightLaf.setup();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgRoles = new javax.swing.ButtonGroup();
        roundPanel1 = new components.RoundPanel();
        roundPanel2 = new components.RoundPanel();
        lblTitle = new javax.swing.JLabel();
        txtUser = new components.TextField();
        btnLogin = new javax.swing.JButton();
        txtPassword = new components.PasswordField();
        rbEmployee = new javax.swing.JRadioButton();
        rbAdmin = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        roundPanel1.setBackground(new java.awt.Color(21, 22, 26));

        roundPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lblTitle.setFont(new java.awt.Font("Poppins", 1, 46)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("INICIAR SESIÓN");

        txtUser.setBackground(new java.awt.Color(204, 204, 204));
        txtUser.setForeground(new java.awt.Color(0, 0, 0));
        txtUser.setCaretColor(new java.awt.Color(150, 150, 150));
        txtUser.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtUser.setLabelText("Usuario");

        btnLogin.setBackground(new java.awt.Color(21, 22, 26));
        btnLogin.setFont(new java.awt.Font("Poppins", 1, 28)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("INICIAR SESIÓN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPassword.setBackground(new java.awt.Color(204, 204, 204));
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtPassword.setLabelText("Contraseña");
        txtPassword.setShowAndHide(true);

        rbEmployee.setBackground(new java.awt.Color(204, 204, 204));
        bgRoles.add(rbEmployee);
        rbEmployee.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        rbEmployee.setText("Empleado");
        rbEmployee.setOpaque(true);

        rbAdmin.setBackground(new java.awt.Color(204, 204, 204));
        bgRoles.add(rbAdmin);
        rbAdmin.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        rbAdmin.setText("Administrador");
        rbAdmin.setOpaque(true);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(rbEmployee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(rbAdmin))
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(27, 27, 27)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEmployee)
                    .addComponent(rbAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgRoles;
    public javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblTitle;
    public javax.swing.JRadioButton rbAdmin;
    public javax.swing.JRadioButton rbEmployee;
    private components.RoundPanel roundPanel1;
    private components.RoundPanel roundPanel2;
    public components.PasswordField txtPassword;
    public components.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
