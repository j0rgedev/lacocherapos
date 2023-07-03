package view.components.modal;

import model.dao.impl.ClientDAOImpl;
import model.dao.impl.OrderDAOImpl;
import model.models.Client;
import model.models.Order;
import view.listeners.ModalListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientInfoModalController extends ModalController {

    private ClientInfoPanel clientInfoPanel;

    public ClientInfoModalController(CustomModal customModal, JFrame jFrame, ModalListener modalListener) {
        super(customModal, jFrame, modalListener);
    }

    @Override
    public void showModal() {
        clientInfoPanel = new ClientInfoPanel();
        setupModal(clientInfoPanel);
    }

    @Override
    protected void handleCustomModalAction(ActionEvent e) {
        if (e.getSource() == customModal.btnEdit) {
            customModal.btnEdit.setEnabled(false);
            clientInfoPanel.txtDni.setEditable(false);
            clientInfoPanel.txtNames.setEditable(false);
            clientInfoPanel.txtLastNames.setEditable(false);

            Client client = new Client(
                    clientInfoPanel.txtDni.getText(),
                    clientInfoPanel.txtNames.getText(),
                    clientInfoPanel.txtLastNames.getText()
            );

            Order order = new Order(
                    LocalDateTime.now(),
                    orderInterface.getTotal(),
                    client
            );

            OrderDAOImpl orderDAO = new OrderDAOImpl();
            ClientDAOImpl clientDAO = new ClientDAOImpl();

            ExecutorService executorService = Executors.newSingleThreadExecutor();

            Timer timer = new Timer(500, new ActionListener() {
                private int dotsCount = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    dotsCount = (dotsCount + 1) % 4;
                    customModal.btnEdit.setText("GUARDANDO" + ".".repeat(Math.max(0, dotsCount)));
                }
            });
            timer.start();

            executorService.submit(() -> {
                clientDAO.createClient(client);
                String orderId = orderDAO.createOrder(order);
                order.setId(orderId);
                orderInterface.setOrder(order);
                orderDAO.createDishOrder(orderInterface.getDishes(), orderId);

                SwingUtilities.invokeLater(() -> {
                    timer.stop();
                    customModal.btnEdit.setText("GUARDANDO...");
                    closeMessage();
                    modalListener.onClientInfoModalClose();
                });
            });
            executorService.shutdown();
        }

        if (e.getSource() == customModal.btnCancel) {
            closeMessage();
            modalListener.onClientInfoModalClose();
        }
    }
}
