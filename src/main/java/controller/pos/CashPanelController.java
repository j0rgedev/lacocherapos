package controller.pos;

import model.enums.PanelType;
import view.pos.CashPanel;
import view.pos.PointOfSaleFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashPanelController extends AbstractController implements ActionListener {

    private final CashPanel cashPanel;
    private final TotalOrderPanelController totalOrderPanelController;

    public CashPanelController(PointOfSaleFrame pointOfSaleFrame, CashPanel cashPanel) {
        super(pointOfSaleFrame);
        this.cashPanel = cashPanel;
        this.totalOrderPanelController = new TotalOrderPanelController(pointOfSaleFrm, cashPanel.totalOrderPanel1, PanelType.CASH_PANEL);
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
