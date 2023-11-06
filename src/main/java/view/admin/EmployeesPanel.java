package view.admin;

public class EmployeesPanel extends javax.swing.JPanel {

    public EmployeesPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeesTable = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(21, 22, 26));

        jLabel1.setFont(new java.awt.Font("Iceland", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de empleados");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 22, 26)));
        jScrollPane1.setName("dishesTable"); // NOI18N

        employeesTable.setBackground(new java.awt.Color(33, 35, 39));
        employeesTable.setFont(new java.awt.Font("Iceland", 0, 26)); // NOI18N
        employeesTable.setForeground(new java.awt.Color(255, 255, 255));
        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"U0001", "Victor Vallejos", "Administrador"}
            },
            new String [] {
                "Código", "Nombres", "Rol"
            }
        ));
        employeesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeesTable.setFocusable(false);
        employeesTable.setRequestFocusEnabled(false);
        employeesTable.setRowHeight(40);
        employeesTable.setSelectionBackground(new java.awt.Color(34, 107, 130));
        employeesTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        employeesTable.getTableHeader().setResizingAllowed(false);
        employeesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(employeesTable);
        if (employeesTable.getColumnModel().getColumnCount() > 0) {
            employeesTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            employeesTable.getColumnModel().getColumn(1).setPreferredWidth(350);
            employeesTable.getColumnModel().getColumn(2).setPreferredWidth(125);
        }

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

        btnDelete.setBackground(new java.awt.Color(250, 66, 66));
        btnDelete.setFont(new java.awt.Font("Iceland", 0, 46)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.setBorder(null);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEdit;
    private javax.swing.JTable employeesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainPanel1;
    private javax.swing.JPanel mainPanel2;
    private javax.swing.JPanel mainPanel3;
    private javax.swing.JPanel mainPanel4;
    private javax.swing.JPanel mainPanel5;
    private javax.swing.JPanel mainPanel6;
    private javax.swing.JPanel spinnerPanel;
    private javax.swing.JPanel spinnerPanel1;
    private javax.swing.JPanel spinnerPanel2;
    private javax.swing.JPanel spinnerPanel3;
    private javax.swing.JPanel spinnerPanel4;
    private javax.swing.JPanel spinnerPanel5;
    private javax.swing.JPanel spinnerPanel6;
    public view.components.spinner.SpinnerProgress spinnerProgress;
    public view.components.spinner.SpinnerProgress spinnerProgress1;
    public view.components.spinner.SpinnerProgress spinnerProgress2;
    public view.components.spinner.SpinnerProgress spinnerProgress3;
    public view.components.spinner.SpinnerProgress spinnerProgress4;
    public view.components.spinner.SpinnerProgress spinnerProgress5;
    public view.components.spinner.SpinnerProgress spinnerProgress6;
    // End of variables declaration//GEN-END:variables
}
