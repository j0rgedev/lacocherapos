package controller.pos;

import model.service.OrderInterface;
import model.service.OrderManager;
import view.pos.PointOfSaleFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class AbstractController implements ActionListener {

    protected PointOfSaleFrame pointOfSaleFrm = PointOfSaleFrame.getInstance();
    protected OrderInterface orderInterface = OrderManager.getInstance();

    protected abstract void init();

    protected void changePanel(JPanel panel, AbstractController controller) {
        CardLayout cardLayout = (CardLayout) pointOfSaleFrm.mainPanel.getLayout();
        cardLayout.show(pointOfSaleFrm.mainPanel, panel.getName());
        controller.init();
    }

    protected void changeHeaderPanel(String title, boolean isMainHeader) {
        CardLayout cardLayout = (CardLayout) pointOfSaleFrm.topPanel.getLayout();
        String cardLayoutName = isMainHeader ? "mainHeader" : "secondaryHeader";
        cardLayout.show(pointOfSaleFrm.posHeader, cardLayoutName);
        pointOfSaleFrm.posSecondaryHeader.lblPaymentTitle.setText(title);
    }

}
