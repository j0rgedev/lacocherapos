/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view.components.modal;

public class DishActionPanel extends javax.swing.JPanel {

    public DishActionPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtName = new view.components.TextField();
        txtPrice = new view.components.TextField();
        cbCategories = new view.components.customComboBox.Combobox();

        setOpaque(false);

        lbTitle.setFont(new java.awt.Font("Iceland", 1, 28)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(25, 27, 22));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Message Title");

        txtName.setBackground(new java.awt.Color(240, 240, 240));
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setCaretColor(new java.awt.Color(50, 50, 50));
        txtName.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtName.setLabelText("Nombre");

        txtPrice.setBackground(new java.awt.Color(240, 240, 240));
        txtPrice.setForeground(new java.awt.Color(0, 0, 0));
        txtPrice.setCaretColor(new java.awt.Color(50, 50, 50));
        txtPrice.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        txtPrice.setLabelText("Precio");

        cbCategories.setBackground(new java.awt.Color(240, 240, 240));
        cbCategories.setForeground(new java.awt.Color(0, 0, 0));
        cbCategories.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carta", "Antojitos", "Bebidas Calientes", "Bebidas Frias", "Tragos", "Cervezas", "Postres" }));
        cbCategories.setSelectedIndex(-1);
        cbCategories.setFocusable(false);
        cbCategories.setFont(new java.awt.Font("Iceland", 0, 22)); // NOI18N
        cbCategories.setLabeText("Categoría");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(cbCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbTitle)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public view.components.customComboBox.Combobox cbCategories;
    public javax.swing.JLabel lbTitle;
    public view.components.TextField txtName;
    public view.components.TextField txtPrice;
    // End of variables declaration//GEN-END:variables

}
