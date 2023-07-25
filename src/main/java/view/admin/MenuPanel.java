package view.admin;

public class MenuPanel extends javax.swing.JPanel {

    public MenuPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        spinnerPanel = new javax.swing.JPanel();
        spinnerProgress = new view.components.spinner.SpinnerProgress();
        jScrollPane1 = new javax.swing.JScrollPane();
        dishesTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(21, 22, 26));

        jLabel1.setFont(new java.awt.Font("Iceland", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de la carta");

        btnDelete.setBackground(new java.awt.Color(250, 66, 66));
        btnDelete.setFont(new java.awt.Font("Iceland", 0, 46)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.setBorder(null);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAdd.setBackground(new java.awt.Color(66, 100, 250));
        btnAdd.setFont(new java.awt.Font("Iceland", 0, 46)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Nuevo");
        btnAdd.setBorder(null);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEdit.setBackground(new java.awt.Color(55, 55, 55));
        btnEdit.setFont(new java.awt.Font("Iceland", 0, 46)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Editar");
        btnEdit.setBorder(null);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mainPanel.setLayout(new java.awt.CardLayout());

        spinnerPanel.setBackground(new java.awt.Color(21, 22, 26));
        spinnerPanel.setName("spinnerPanel"); // NOI18N

        spinnerProgress.setFont(new java.awt.Font("Iceland", 0, 36)); // NOI18N
        spinnerProgress.setIndeterminate(true);

        javax.swing.GroupLayout spinnerPanelLayout = new javax.swing.GroupLayout(spinnerPanel);
        spinnerPanel.setLayout(spinnerPanelLayout);
        spinnerPanelLayout.setHorizontalGroup(
            spinnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spinnerPanelLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(spinnerProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(294, 294, 294))
        );
        spinnerPanelLayout.setVerticalGroup(
            spinnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spinnerPanelLayout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(spinnerProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        mainPanel.add(spinnerPanel, "spinnerPanel");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 22, 26)));
        jScrollPane1.setName("dishesTable"); // NOI18N

        dishesTable.setBackground(new java.awt.Color(33, 35, 39));
        dishesTable.setFont(new java.awt.Font("Iceland", 0, 26)); // NOI18N
        dishesTable.setForeground(new java.awt.Color(255, 255, 255));
        dishesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Hamburguesa de pollo", "Bebidas frías", "S/10.00"}
            },
            new String [] {
                "Nombre", "Categoria", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dishesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dishesTable.setFocusable(false);
        dishesTable.setRequestFocusEnabled(false);
        dishesTable.setRowHeight(40);
        dishesTable.setSelectionBackground(new java.awt.Color(34, 107, 130));
        dishesTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        dishesTable.getTableHeader().setResizingAllowed(false);
        dishesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dishesTable);
        if (dishesTable.getColumnModel().getColumnCount() > 0) {
            dishesTable.getColumnModel().getColumn(0).setResizable(false);
            dishesTable.getColumnModel().getColumn(0).setPreferredWidth(300);
            dishesTable.getColumnModel().getColumn(1).setResizable(false);
            dishesTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            dishesTable.getColumnModel().getColumn(2).setResizable(false);
            dishesTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        mainPanel.add(jScrollPane1, "dishesTable");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(531, 531, 531))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEdit;
    public javax.swing.JTable dishesTable;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel mainPanel;
    public javax.swing.JPanel spinnerPanel;
    public view.components.spinner.SpinnerProgress spinnerProgress;
    // End of variables declaration//GEN-END:variables

}
