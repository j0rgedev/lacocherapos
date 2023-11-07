/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view.components.modal.employees;

import view.components.modal.dishes.*;

public class EmployeeActionPanel extends javax.swing.JPanel {

    public EmployeeActionPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtName = new view.components.TextField();
        txtLastNames = new view.components.TextField();
        cbRoles = new view.components.customComboBox.Combobox();
        txtPassword = new view.components.PasswordField();

        setOpaque(false);

        lbTitle.setFont(new java.awt.Font("Iceland", 1, 28)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(25, 27, 22));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Message Title");

        txtName.setBackground(new java.awt.Color(240, 240, 240));
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setCaretColor(new java.awt.Color(50, 50, 50));
        txtName.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtName.setLabelText("Nombres");

        txtLastNames.setBackground(new java.awt.Color(240, 240, 240));
        txtLastNames.setForeground(new java.awt.Color(0, 0, 0));
        txtLastNames.setCaretColor(new java.awt.Color(50, 50, 50));
        txtLastNames.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtLastNames.setLabelText("Apellidos");

        cbRoles.setBackground(new java.awt.Color(240, 240, 240));
        cbRoles.setForeground(new java.awt.Color(0, 0, 0));
        cbRoles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Cajero", "Mozo", "Chef" }));
        cbRoles.setSelectedIndex(-1);
        cbRoles.setFocusable(false);
        cbRoles.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        cbRoles.setLabeText("Rol");

        txtPassword.setBackground(new java.awt.Color(240, 240, 240));
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setCaretColor(new java.awt.Color(50, 50, 50));
        txtPassword.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtPassword.setLabelText("Contraseña");
        txtPassword.setShowAndHide(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLastNames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbRoles, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public view.components.customComboBox.Combobox cbRoles;
    public javax.swing.JLabel lbTitle;
    public view.components.TextField txtLastNames;
    public view.components.TextField txtName;
    public view.components.PasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

}
