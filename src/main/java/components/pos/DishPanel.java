package components.pos;

public class DishPanel extends javax.swing.JPanel {

    public DishPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        btnIncrease = new javax.swing.JButton();
        btnReduce = new javax.swing.JButton();

        setBackground(new java.awt.Color(21, 22, 26));
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(200, 200));

        lblName.setFont(new java.awt.Font("Iceland", 1, 30)); // NOI18N
        lblName.setForeground(java.awt.Color.white);
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("<html> <body style=\"text-align:center\"> TITULO DEL PRODUCTO </body>  </html>");
        lblName.setToolTipText("");

        btnAdd.setBackground(new java.awt.Color(0, 87, 255));
        btnAdd.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("AGREGAR");
        btnAdd.setBorder(null);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtQuantity.setEditable(false);
        txtQuantity.setBackground(new java.awt.Color(204, 204, 204));
        txtQuantity.setFont(new java.awt.Font("Iceland", 1, 22)); // NOI18N
        txtQuantity.setForeground(java.awt.Color.black);
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantity.setText("1");
        txtQuantity.setToolTipText("");
        txtQuantity.setBorder(null);
        txtQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtQuantity.setPreferredSize(new java.awt.Dimension(35, 25));
        txtQuantity.setSelectedTextColor(null);
        txtQuantity.setSelectionColor(null);

        btnIncrease.setFont(new java.awt.Font("Iceland", 1, 30)); // NOI18N
        btnIncrease.setForeground(java.awt.Color.green);
        btnIncrease.setText("+");
        btnIncrease.setBorder(null);
        btnIncrease.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIncrease.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIncrease.setPreferredSize(new java.awt.Dimension(25, 25));

        btnReduce.setFont(new java.awt.Font("Iceland", 1, 30)); // NOI18N
        btnReduce.setForeground(java.awt.Color.red);
        btnReduce.setText("-");
        btnReduce.setBorder(null);
        btnReduce.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReduce.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReduce.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(btnReduce, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(btnIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnReduce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        );

        txtQuantity.setHighlighter(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnIncrease;
    public javax.swing.JButton btnReduce;
    public javax.swing.JLabel lblName;
    public javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}
