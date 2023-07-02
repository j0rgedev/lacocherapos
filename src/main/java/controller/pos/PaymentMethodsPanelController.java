package controller.pos;

import view.pos.CashPanel;
import view.pos.PaymentMethodsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentMethodsPanelController extends AbstractController implements ActionListener {

    private final PaymentMethodsPanel paymentMethodsPanel;

    public PaymentMethodsPanelController(PaymentMethodsPanel paymentMethodsPanel) {
        this.paymentMethodsPanel = paymentMethodsPanel;
    }

    @Override
    protected void init(){
        paymentMethodsPanel.btnCash.addActionListener(this);
        paymentMethodsPanel.btnCard.addActionListener(this);
        paymentMethodsPanel.btnYape.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==paymentMethodsPanel.btnCash) {
            CashPanel cashPanel = pointOfSaleFrm.cashPanel1;
            CashPanelController cashPanelController = new CashPanelController(cashPanel);
            changePanel(cashPanel, cashPanelController);
        }
    }
}
