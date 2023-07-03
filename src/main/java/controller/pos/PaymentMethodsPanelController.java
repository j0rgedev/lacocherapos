package controller.pos;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import view.pos.CashPanel;
import view.pos.PaymentMethodsPanel;
import view.pos.PointOfSaleFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentMethodsPanelController extends AbstractController implements ActionListener {

    private final PaymentMethodsPanel paymentMethodsPanel;

    public PaymentMethodsPanelController(PointOfSaleFrame pointOfSaleFrame, PaymentMethodsPanel paymentMethodsPanel) {
        super(pointOfSaleFrame);
        this.paymentMethodsPanel = paymentMethodsPanel;
    }

    @Override
    protected void init(){

        int width = (int) (paymentMethodsPanel.btnCash.getWidth() / 1.5);
        int height = (int) (paymentMethodsPanel.btnCash.getHeight() / 1.5);
        FlatSVGIcon cashIcon = new FlatSVGIcon("icons/cash.svg", width, height);
        FlatSVGIcon cardIcon = new FlatSVGIcon("icons/card.svg", width, height);
        FlatSVGIcon ewalletIcon = new FlatSVGIcon("icons/ewallet.svg", width, height);
        paymentMethodsPanel.btnCash.setIcon(cashIcon);
        paymentMethodsPanel.btnCard.setIcon(cardIcon);
        paymentMethodsPanel.btnYape.setIcon(ewalletIcon);

        paymentMethodsPanel.btnCash.addActionListener(this);
        paymentMethodsPanel.btnCard.addActionListener(this);
        paymentMethodsPanel.btnYape.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==paymentMethodsPanel.btnCash) {
            CashPanel cashPanel = pointOfSaleFrm.cashPanel1;
            CashPanelController cashPanelController = new CashPanelController(pointOfSaleFrm, cashPanel);
            changePanel(cashPanel, cashPanelController);
            changeHeaderPanel("PAGO EN EFECTIVO", false);
        }
    }
}
