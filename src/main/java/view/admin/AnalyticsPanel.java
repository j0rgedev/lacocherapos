/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view.admin;

public class AnalyticsPanel extends javax.swing.JPanel {

    public AnalyticsPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbCategories = new view.components.customComboBox.Combobox();
        cbMonth = new view.components.customComboBox.Combobox();
        lblInfoText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(21, 22, 26));

        jLabel1.setFont(new java.awt.Font("Iceland", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Platos más vendidos");

        cbCategories.setBackground(new java.awt.Color(21, 22, 26));
        cbCategories.setForeground(new java.awt.Color(255, 255, 255));
        cbCategories.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carta", "Antojitos", "Bebidas Calientes", "Bebidas Frias", "Tragos", "Cervezas", "Postres" }));
        cbCategories.setSelectedIndex(-1);
        cbCategories.setCaretColor(new java.awt.Color(220, 220, 220));
        cbCategories.setFocusable(false);
        cbCategories.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        cbCategories.setLabeText("Categorías");

        cbMonth.setBackground(new java.awt.Color(21, 22, 26));
        cbMonth.setForeground(new java.awt.Color(255, 255, 255));
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbMonth.setSelectedIndex(-1);
        cbMonth.setCaretColor(new java.awt.Color(220, 220, 220));
        cbMonth.setFocusable(false);
        cbMonth.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        cbMonth.setLabeText("Mes");

        lblInfoText.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        lblInfoText.setForeground(new java.awt.Color(200, 200, 200));
        lblInfoText.setText("Mostrando los 5 productos más vendidos de todas las categorías y meses en el año 2023");

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                        .addGap(340, 340, 340))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInfoText, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoText)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public view.components.customComboBox.Combobox cbCategories;
    public view.components.customComboBox.Combobox cbMonth;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblInfoText;
    // End of variables declaration//GEN-END:variables

}
