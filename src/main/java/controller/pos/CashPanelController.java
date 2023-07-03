package controller.pos;

import model.enums.PanelType;
import view.pos.CashPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashPanelController extends AbstractController implements ActionListener {

    private final CashPanel cashPanel;
    private final TotalOrderPanelController totalOrderPanelController;

    public CashPanelController(CashPanel cashPanel) {
        this.cashPanel = cashPanel;
        this.totalOrderPanelController = new TotalOrderPanelController(cashPanel.totalOrderPanel1, PanelType.CASH_PANEL);
    }

    @Override
    protected void init(){
        totalOrderPanelController.init();
        totalOrderPanelController.setMainButtonText("Procesar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
