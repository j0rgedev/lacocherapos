package controller.pos;

import model.service.OrderInterface;
import model.service.OrderManager;
import view.pos.PointOfSaleFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class AbstractController implements ActionListener {

    protected PointOfSaleFrame pointOfSaleFrm;
    protected OrderInterface orderInterface = OrderManager.getInstance();

    public AbstractController(PointOfSaleFrame pointOfSaleFrm) {
        this.pointOfSaleFrm = pointOfSaleFrm;
    }

    protected abstract void init();

    protected void changePanel(JPanel panel, AbstractController controller) {
        CardLayout cardLayout = (CardLayout) pointOfSaleFrm.mainPanel.getLayout();
        cardLayout.show(pointOfSaleFrm.mainPanel, panel.getName());
        controller.init();
    }

    protected void changeHeaderPanel(String title) {
        CardLayout cardLayout = (CardLayout) pointOfSaleFrm.topPanel.getLayout();
        String cardLayoutName = "secondaryHeader";
        cardLayout.show(pointOfSaleFrm.topPanel, cardLayoutName);
        pointOfSaleFrm.posSecondaryHeader.lblPaymentTitle.setText(title);
    }

}
