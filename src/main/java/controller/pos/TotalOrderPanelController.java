package controller.pos;

import model.service.OrderInterface;
import model.service.OrderManager;
import view.pos.TotalOrderPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TotalOrderPanelController implements ActionListener {

    private final TotalOrderPanel totalOrderPanel;
    private final OrderInterface orderInterface = OrderManager.getInstance();

    public TotalOrderPanelController(TotalOrderPanel totalOrderPanel) {
        this.totalOrderPanel = totalOrderPanel;
    }

    public void init(){
        totalOrderPanel.btnPay.addActionListener(this);
        totalOrderPanel.btnEdit.addActionListener(this);
        totalOrderPanel.btnCancel.addActionListener(this);
        setAmounts();
    }

    private void setAmounts() {
        DecimalFormat decimalFormat = new DecimalFormat("S/00.00");

        double totalPrice = orderInterface.getTotal();
        double basePrice = orderInterface.getSubtotal();
        double igvPrice = orderInterface.getIgv();

        totalOrderPanel.lblBasePrice.setText(decimalFormat.format(basePrice));
        totalOrderPanel.lblIgvPrice.setText(decimalFormat.format(igvPrice));
        totalOrderPanel.lblTotalPrice.setText(decimalFormat.format(totalPrice));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
