package controller.pos;

import model.dao.impl.PaymentDAOImpl;
import model.enums.PanelType;
import model.enums.PaymentMethods;
import model.enums.PaymentStatus;
import model.models.Order;
import model.models.Payment;
import model.utils.CodeGenerator;
import view.pos.FinishedOrderPanel;
import view.pos.PaymentMethodsPanel;
import view.pos.TotalOrderPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TotalOrderPanelController extends AbstractController implements ActionListener {

    private final TotalOrderPanel totalOrderPanel;
    private final PanelType panelType;

    public TotalOrderPanelController(TotalOrderPanel totalOrderPanel, PanelType panelType) {
        this.totalOrderPanel = totalOrderPanel;
        this.panelType = panelType;
    }

    @Override
    protected void init(){
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

    public void setMainButtonText(String text){
        totalOrderPanel.btnPay.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == totalOrderPanel.btnPay){
            if(panelType == PanelType.CONFIRMATION_PANEL){
                PaymentMethodsPanel paymentMethodsPanel = pointOfSaleFrm.paymentMethodsPanel1;
                PaymentMethodsPanelController paymentMethodsPanelController = new PaymentMethodsPanelController(paymentMethodsPanel);
                changePanel(paymentMethodsPanel, paymentMethodsPanelController);
                changeHeaderPanel("MÉTODOS DE PAGO", false);
            }
            else if(panelType == PanelType.CASH_PANEL){
                totalOrderPanel.btnPay.setEnabled(false);
                totalOrderPanel.btnEdit.setEnabled(false);

                PaymentDAOImpl paymentDAO = new PaymentDAOImpl();

                PaymentMethods paymentMethods = PaymentMethods.CASH;
                PaymentStatus paymentStatus = PaymentStatus.PAID;
                int transactionNumber = CodeGenerator.generateTransactionNumber();
                Order order = orderInterface.getOrder();
                Payment payment = new Payment(null, paymentStatus, paymentMethods, transactionNumber, order);

                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Timer timer = new Timer(500, new ActionListener() {
                    private int dotsCount = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dotsCount = (dotsCount + 1) % 4;
                        totalOrderPanel.btnPay.setText("Procesando" + ".".repeat(Math.max(0, dotsCount)));
                    }
                });
                timer.start();

                executorService.submit(() -> {
                    paymentDAO.createPayment(payment);
                    SwingUtilities.invokeLater(() -> {
                        timer.stop();
                        totalOrderPanel.btnPay.setText("Procesando...");
                        FinishedOrderPanel finishedOrderPanel = pointOfSaleFrm.finishedOrderPanel1;
                        FinishedOrderPanelController finishedOrderPanelController = new FinishedOrderPanelController(finishedOrderPanel);
                        changePanel(finishedOrderPanel, finishedOrderPanelController);
                        changeHeaderPanel("PEDIDO FINALIZADO", false);
                    });
                });

                executorService.shutdown();
            }
        }
    }
}
