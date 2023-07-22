package controller.pos;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import model.enums.PanelType;
import view.pos.CashPanel;
import view.pos.PointOfSaleFrame;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashPanelController extends AbstractController implements ActionListener {

    private final CashPanel cashPanel;
    private final TotalOrderPanelController totalOrderPanelController;
    private double change;
    private boolean isChangeEnough;
    private final static int MAX_AMOUNT = 1000;

    public CashPanelController(PointOfSaleFrame pointOfSaleFrame, CashPanel cashPanel) {
        super(pointOfSaleFrame);
        this.cashPanel = cashPanel;
        this.totalOrderPanelController = new TotalOrderPanelController(pointOfSaleFrm, cashPanel.totalOrderPanel1, PanelType.CASH_PANEL);
    }

    @Override
    protected void init() {
        totalOrderPanelController.init();
        totalOrderPanelController.setMainButtonText("Procesar");
        totalOrderPanelController.setMainButtonEnabled(false);

        // Listeners
        cashPanel.btnTenSoles.addActionListener(this);
        cashPanel.btnTwentySoles.addActionListener(this);
        cashPanel.btnFiftySoles.addActionListener(this);
        cashPanel.btnHundredSoles.addActionListener(this);
        customAmountListener();
    }

    private void customAmountListener(){
        cashPanel.txtAmount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInput(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInput(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInput(e);
            }

            private void validateInput(DocumentEvent e){
                try {
                    String amount = e.getDocument().getText(0, e.getDocument().getLength());
                    if (amount.isEmpty()){
                        isChangeEnough = false;
                        setChangeAmount();
                    } else if (Double.parseDouble(amount) <= MAX_AMOUNT){
                        change = calculateChange(Double.parseDouble(amount));
                        setChangeAmount();
                    } else if (Double.parseDouble(amount) > MAX_AMOUNT){
                        isChangeEnough = false;
                        setChangeAmount();
                    }
                } catch (BadLocationException badLocationException){
                    isChangeEnough = false;
                    setChangeAmount();
                }
            }
        });
    }

    private double calculateChange(double cash) {
        double total = orderInterface.getTotal();
        if (cash >= total) {
            this.isChangeEnough = true;
            return cash - total;
        } else {
            this.isChangeEnough = false;
            return 0;
        }
    }

    private void setChangeAmount() {
        if (isChangeEnough) {
            totalOrderPanelController.setMainButtonEnabled(true);
            cashPanel.lblChangeAmount.setText("S/" + change);
        } else {
            totalOrderPanelController.setMainButtonEnabled(false);
            cashPanel.lblChangeAmount.setText("------");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cashPanel.btnTenSoles) {
            this.change = calculateChange(10);
            setChangeAmount();
        }
        if (e.getSource() == cashPanel.btnTwentySoles) {
            this.change = calculateChange(20);
            setChangeAmount();
        }
        if (e.getSource() == cashPanel.btnFiftySoles) {
            this.change = calculateChange(50);
            setChangeAmount();
        }
        if (e.getSource() == cashPanel.btnHundredSoles) {
            this.change = calculateChange(100);
            setChangeAmount();
        }
    }
}
