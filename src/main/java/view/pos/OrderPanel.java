package view.pos;

import view.components.pos.TabbedPane;

public class OrderPanel extends javax.swing.JPanel {

    public OrderPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoriesTabbedPane = new view.components.pos.TabbedPane();
        foodPanel = new javax.swing.JPanel();
        btnCarta = new javax.swing.JButton();
        btnAntojitos = new javax.swing.JButton();
        drinkPanel = new javax.swing.JPanel();
        btnHotDrinks = new javax.swing.JButton();
        btnColdDrinks = new javax.swing.JButton();
        barPanel = new javax.swing.JPanel();
        btnBeer = new javax.swing.JButton();
        btnDrinks = new javax.swing.JButton();
        othersPanel = new javax.swing.JPanel();
        btnDesserts = new javax.swing.JButton();
        cartPanel = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        scrollPaneDishes = new javax.swing.JScrollPane();
        tableDishes = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(21, 21, 21));

        categoriesTabbedPane.setForeground(new java.awt.Color(255, 255, 255));
        categoriesTabbedPane.setFont(new java.awt.Font("Iceland", 0, 26)); // NOI18N

        foodPanel.setBackground(new java.awt.Color(21, 21, 21));
        foodPanel.setFont(new java.awt.Font("Iceland", 0, 18)); // NOI18N

        btnCarta.setBackground(new java.awt.Color(255, 140, 72));
        btnCarta.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnCarta.setForeground(new java.awt.Color(0, 0, 0));
        btnCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/carta.png"))); // NOI18N
        btnCarta.setText("Carta");
        btnCarta.setBorder(null);
        btnCarta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarta.setInheritsPopupMenu(true);
        btnCarta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnAntojitos.setBackground(new java.awt.Color(58, 236, 215));
        btnAntojitos.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnAntojitos.setForeground(new java.awt.Color(0, 0, 0));
        btnAntojitos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/antojitos.png"))); // NOI18N
        btnAntojitos.setText("Antojitos");
        btnAntojitos.setBorder(null);
        btnAntojitos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAntojitos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAntojitos.setInheritsPopupMenu(true);
        btnAntojitos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout foodPanelLayout = new javax.swing.GroupLayout(foodPanel);
        foodPanel.setLayout(foodPanelLayout);
        foodPanelLayout.setHorizontalGroup(
            foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnAntojitos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(489, Short.MAX_VALUE))
        );
        foodPanelLayout.setVerticalGroup(
            foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAntojitos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        categoriesTabbedPane.addTab("Comidas", foodPanel);

        drinkPanel.setBackground(new java.awt.Color(21, 21, 21));
        drinkPanel.setFont(new java.awt.Font("Iceland", 0, 18)); // NOI18N

        btnHotDrinks.setBackground(new java.awt.Color(255, 72, 72));
        btnHotDrinks.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnHotDrinks.setForeground(new java.awt.Color(0, 0, 0));
        btnHotDrinks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bebidas-calientes.png"))); // NOI18N
        btnHotDrinks.setText("Calientes");
        btnHotDrinks.setBorder(null);
        btnHotDrinks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHotDrinks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHotDrinks.setInheritsPopupMenu(true);
        btnHotDrinks.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnColdDrinks.setBackground(new java.awt.Color(196, 237, 234));
        btnColdDrinks.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnColdDrinks.setForeground(new java.awt.Color(0, 0, 0));
        btnColdDrinks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bebidas-frias.png"))); // NOI18N
        btnColdDrinks.setText("Frías");
        btnColdDrinks.setBorder(null);
        btnColdDrinks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnColdDrinks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnColdDrinks.setInheritsPopupMenu(true);
        btnColdDrinks.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout drinkPanelLayout = new javax.swing.GroupLayout(drinkPanel);
        drinkPanel.setLayout(drinkPanelLayout);
        drinkPanelLayout.setHorizontalGroup(
            drinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drinkPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnHotDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnColdDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(489, Short.MAX_VALUE))
        );
        drinkPanelLayout.setVerticalGroup(
            drinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drinkPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(drinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnColdDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHotDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        categoriesTabbedPane.addTab("Bebidas", drinkPanel);

        barPanel.setBackground(new java.awt.Color(21, 21, 21));
        barPanel.setFont(new java.awt.Font("Iceland", 0, 18)); // NOI18N

        btnBeer.setBackground(new java.awt.Color(248, 216, 50));
        btnBeer.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnBeer.setForeground(new java.awt.Color(0, 0, 0));
        btnBeer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cervezas.png"))); // NOI18N
        btnBeer.setText("Cervezas");
        btnBeer.setBorder(null);
        btnBeer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBeer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBeer.setInheritsPopupMenu(true);
        btnBeer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnDrinks.setBackground(new java.awt.Color(80, 240, 144));
        btnDrinks.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnDrinks.setForeground(new java.awt.Color(0, 0, 0));
        btnDrinks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tragos.png"))); // NOI18N
        btnDrinks.setText("Tragos");
        btnDrinks.setBorder(null);
        btnDrinks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDrinks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDrinks.setInheritsPopupMenu(true);
        btnDrinks.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout barPanelLayout = new javax.swing.GroupLayout(barPanel);
        barPanel.setLayout(barPanelLayout);
        barPanelLayout.setHorizontalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnBeer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(489, Short.MAX_VALUE))
        );
        barPanelLayout.setVerticalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBeer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        categoriesTabbedPane.addTab("Bar", barPanel);

        othersPanel.setBackground(new java.awt.Color(21, 21, 21));
        othersPanel.setFont(new java.awt.Font("Iceland", 0, 18)); // NOI18N

        btnDesserts.setBackground(new java.awt.Color(115, 58, 236));
        btnDesserts.setFont(new java.awt.Font("Iceland", 1, 24)); // NOI18N
        btnDesserts.setForeground(new java.awt.Color(0, 0, 0));
        btnDesserts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/postres.png"))); // NOI18N
        btnDesserts.setText("Postres");
        btnDesserts.setBorder(null);
        btnDesserts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesserts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesserts.setInheritsPopupMenu(true);
        btnDesserts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout othersPanelLayout = new javax.swing.GroupLayout(othersPanel);
        othersPanel.setLayout(othersPanelLayout);
        othersPanelLayout.setHorizontalGroup(
            othersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(othersPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnDesserts, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(670, Short.MAX_VALUE))
        );
        othersPanelLayout.setVerticalGroup(
            othersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(othersPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnDesserts, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        categoriesTabbedPane.addTab("Otros", othersPanel);

        cartPanel.setBackground(new java.awt.Color(240, 240, 240));

        btnNext.setBackground(new java.awt.Color(66, 100, 250));
        btnNext.setFont(new java.awt.Font("Iceland", 1, 60)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Siguiente");
        btnNext.setBorder(null);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setEnabled(false);

        lblTitle.setFont(new java.awt.Font("Iceland", 1, 60)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("<html>\n<body style=\"text-align: center\">\nPLATOS ESCOGIDOS\n</body>\n</html>");

        tableDishes.setBackground(new java.awt.Color(240, 240, 240));
        tableDishes.setFont(new java.awt.Font("Iceland", 0, 30)); // NOI18N
        tableDishes.setForeground(new java.awt.Color(0, 0, 0));
        tableDishes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDishes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableDishes.setFocusable(false);
        tableDishes.setRowHeight(40);
        tableDishes.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tableDishes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableDishes.setShowGrid(false);
        tableDishes.getTableHeader().setResizingAllowed(false);
        tableDishes.getTableHeader().setReorderingAllowed(false);
        scrollPaneDishes.setViewportView(tableDishes);
        if (tableDishes.getColumnModel().getColumnCount() > 0) {
            tableDishes.getColumnModel().getColumn(0).setResizable(false);
            tableDishes.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableDishes.getColumnModel().getColumn(1).setResizable(false);
            tableDishes.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(scrollPaneDishes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneDishes)
                .addGap(35, 35, 35)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        productsPanel.setBackground(new java.awt.Color(45, 52, 63));

        javax.swing.GroupLayout productsPanelLayout = new javax.swing.GroupLayout(productsPanel);
        productsPanel.setLayout(productsPanelLayout);
        productsPanelLayout.setHorizontalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        productsPanelLayout.setVerticalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(productsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoriesTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addComponent(cartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(categoriesTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
            .addComponent(cartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel barPanel;
    public javax.swing.JButton btnAntojitos;
    public javax.swing.JButton btnBeer;
    public javax.swing.JButton btnCarta;
    public javax.swing.JButton btnColdDrinks;
    public javax.swing.JButton btnDesserts;
    public javax.swing.JButton btnDrinks;
    public javax.swing.JButton btnHotDrinks;
    public javax.swing.JButton btnNext;
    public javax.swing.JPanel cartPanel;
    public view.components.pos.TabbedPane categoriesTabbedPane;
    public javax.swing.JPanel drinkPanel;
    public javax.swing.JPanel foodPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    public javax.swing.JPanel othersPanel;
    public javax.swing.JPanel productsPanel;
    public javax.swing.JScrollPane scrollPaneDishes;
    public javax.swing.JTable tableDishes;
    // End of variables declaration//GEN-END:variables
}
