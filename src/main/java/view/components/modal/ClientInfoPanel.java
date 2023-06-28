/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view.components.modal;

public class ClientInfoPanel extends javax.swing.JPanel {

    public ClientInfoPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDni = new view.components.TextField();
        txtNames = new view.components.TextField();
        txtLastNames = new view.components.TextField();

        setOpaque(false);

        txtDni.setBackground(new java.awt.Color(240, 240, 240));
        txtDni.setForeground(new java.awt.Color(0, 0, 0));
        txtDni.setCaretColor(new java.awt.Color(50, 50, 50));
        txtDni.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtDni.setLabelText("DNI");

        txtNames.setBackground(new java.awt.Color(240, 240, 240));
        txtNames.setForeground(new java.awt.Color(0, 0, 0));
        txtNames.setCaretColor(new java.awt.Color(50, 50, 50));
        txtNames.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtNames.setLabelText("Nombres");

        txtLastNames.setBackground(new java.awt.Color(240, 240, 240));
        txtLastNames.setForeground(new java.awt.Color(0, 0, 0));
        txtLastNames.setCaretColor(new java.awt.Color(50, 50, 50));
        txtLastNames.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtLastNames.setLabelText("Apellidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtLastNames, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(txtNames, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtLastNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public view.components.TextField txtDni;
    public view.components.TextField txtLastNames;
    public view.components.TextField txtNames;
    // End of variables declaration//GEN-END:variables

}
