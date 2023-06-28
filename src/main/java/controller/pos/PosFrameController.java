package controller.pos;

import java.awt.*;

import model.models.Client;
import model.models.Order;
import model.service.OrderInterface;
import model.service.OrderManager;
import view.components.modal.ClientInfoModalController;
import view.components.modal.CustomModal;
import view.listeners.ModalListener;
import view.pos.PointOfSaleFrame;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class PosFrameController implements ActionListener, ModalListener {

    private final PointOfSaleFrame pointOfSaleFrm;
    private CartPanelController cartPanelController;
    private final OrderInterface orderInterface = OrderManager.getInstance();

    public PosFrameController(PointOfSaleFrame puntoVenta) {
        this.pointOfSaleFrm = puntoVenta;
    }

    public void init(){
        frameConfig();
        showTime();
        pointOfSaleFrm.orderPanel.btnNext.addActionListener(this);
    }

    private void showTime() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String fecha = now.format(dateFormatter);
                String hora = now.format(timeFormatter);
                pointOfSaleFrm.posHeader.lblTime.setText(fecha + " " + hora);
                pointOfSaleFrm.posSecondaryHeader.lblTime.setText(fecha + " " + hora);
            }
        }, 0, 1000);
    }
    
    private void frameConfig(){
        pointOfSaleFrm.getContentPane().setBackground(Color.BLACK);
        // Initial panel: OrderPanel
        cartPanelController = new CartPanelController(pointOfSaleFrm);
        cartPanelController.init();
        OrderPanelController orderPanelController = new OrderPanelController(pointOfSaleFrm, cartPanelController);
        orderPanelController.init();
    }

    private void orderConfirmationPanelConfig(){
        changeHeaderPanel("CONFIRMACIÓN DE ORDEN");

        // Change panel
        pointOfSaleFrm.orderConfirmationPanel.setVisible(true);
        pointOfSaleFrm.orderPanel.setVisible(false);
        ConfirmationPanelController confirmationPanelController = new ConfirmationPanelController(pointOfSaleFrm.orderConfirmationPanel);
        confirmationPanelController.init();

        // Table header configuration
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(null);
        renderer.setForeground(new Color(176,176,176));
        renderer.setBackground(new Color(45,52,63));
        pointOfSaleFrm.orderConfirmationPanel.orderTable.getTableHeader().setDefaultRenderer(renderer);
        pointOfSaleFrm.orderConfirmationPanel.orderTable.getTableHeader().setPreferredSize(new Dimension(0, 50));
    }

    private void changeHeaderPanel(String panelTitle){
        pointOfSaleFrm.posHeader.setVisible(false);
        pointOfSaleFrm.posSecondaryHeader.setVisible(true);
        pointOfSaleFrm.posSecondaryHeader.lblPaymentTitle.setText(panelTitle);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == pointOfSaleFrm.orderPanel.btnNext){
//            CustomModal modal = new CustomModal();
//            ClientInfoModalController clientInfoModalController = new ClientInfoModalController(modal, pointOfSaleFrm, this);
//            clientInfoModalController.showModal();
            orderConfirmationPanelConfig();
        }
    }

    @Override
    public void onModalClose() {
        orderConfirmationPanelConfig();
    }
}
