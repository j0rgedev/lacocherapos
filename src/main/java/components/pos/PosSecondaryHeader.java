package components.pos;

public class PosSecondaryHeader extends javax.swing.JPanel {

    public PosSecondaryHeader() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTime = new javax.swing.JLabel();
        lblPaymentTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(45, 52, 63));

        lblTime.setFont(new java.awt.Font("Iceland", 0, 26)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTime.setText("12/12/12 00:00:00");

        lblPaymentTitle.setFont(new java.awt.Font("Iceland", 0, 32)); // NOI18N
        lblPaymentTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblPaymentTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPaymentTitle.setText("MÉTODO DE PAGO ESCOGIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblPaymentTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(lblTime)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblPaymentTitle;
    public javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
