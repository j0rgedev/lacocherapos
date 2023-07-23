package controller.pos;

import model.enums.PanelType;
import model.enums.PaymentMethods;
import view.listeners.PayButtonListener;
import view.pos.CardPanel;
import view.pos.PointOfSaleFrame;
import view.pos.TotalOrderPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardPanelController extends AbstractController implements PayButtonListener {

    private final CardPanel cardPanel;
    private final TotalOrderPanelController totalOrderPanelController;

    public CardPanelController(PointOfSaleFrame pointOfSaleFrame, CardPanel cardPanel) {
        super(pointOfSaleFrame);
        this.cardPanel = cardPanel;
        this.totalOrderPanelController = new TotalOrderPanelController(
                pointOfSaleFrm,
                cardPanel.totalOrderPanel1,
                PanelType.CARD_PANEL,
                this
        );
    }

    @Override
    protected void init() {
        totalOrderPanelController.init();
        totalOrderPanelController.setMainButtonText("Procesar");
    }

    private void initProgressBar(){
        cardPanel.progressBar.setForeground(new Color(76,135,200));
        Timer timer = new Timer(10, new ActionListener() {
            int progressValue = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (progressValue < 100) {
                    progressValue++;
                    cardPanel.progressBar.setValue(progressValue);
                } else {
                    ((Timer) e.getSource()).stop();
                    totalOrderPanelController.generatePayment(PaymentMethods.CARD);
                }
            }
        });

        timer.start();
    }

    @Override
    public void onPayButtonClicked() {
        initProgressBar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
