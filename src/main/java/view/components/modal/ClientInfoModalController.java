package view.components.modal;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import model.dao.impl.ClientDAOImpl;
import model.dao.impl.OrderDAOImpl;
import model.entity.Client;
import model.entity.Order;
import view.components.spinner.SpinnerProgress;
import view.components.spinner.SpinnerProgressUI;
import view.listeners.ModalListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClientInfoModalController extends ModalController {

    private ClientInfoPanel clientInfoPanel;
    private String lastDniValue = "";
    private ScheduledExecutorService executorService;

    public ClientInfoModalController(CustomModal customModal, JFrame jFrame, ModalListener modalListener) {
        super(customModal, jFrame, modalListener);
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void showModal() {
        clientInfoPanel = new ClientInfoPanel();
        customModal.btnEdit.setEnabled(false);
        addTextListeners();
        clientDniTextListener();
        setupModal(clientInfoPanel, "icons/client.svg");
    }

    private void addTextListeners() {
        DocumentListener nameListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkTextFieldsAndEnableEditButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTextFieldsAndEnableEditButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkTextFieldsAndEnableEditButton();
            }
        };

        clientInfoPanel.txtNames.getDocument().addDocumentListener(nameListener);
        clientInfoPanel.txtLastNames.getDocument().addDocumentListener(nameListener);
    }

    private void clientDniTextListener(){
        clientInfoPanel.txtDni.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkDniAndFetchClient(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkDniAndFetchClient(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkDniAndFetchClient(e);
            }
        });
    }

    private void checkDniAndFetchClient(DocumentEvent e) {
        try {
            String dniText = e.getDocument().getText(0, e.getDocument().getLength());
            if (dniText.length() == 8 && !dniText.equals(lastDniValue)) {
                cancelPreviousSearch();
                SpinnerProgress spinnerProgress = new SpinnerProgress();
                spinnerProgress.setUI(new SpinnerProgressUI(4));
                spinnerProgress.setIndeterminate(true);
                clientInfoPanel.spinnerPanel.add(spinnerProgress, BorderLayout.CENTER);
                clientInfoPanel.spinnerPanel.revalidate();
                clientInfoPanel.spinnerPanel.repaint();

                executorService.schedule(() -> {
                    int dni = Integer.parseInt(dniText);
                    ClientDAOImpl clientDAO = new ClientDAOImpl();
                    Client client = clientDAO.getClientByDni(dni);
                    SwingUtilities.invokeLater(() -> {
                        clientInfoPanel.spinnerPanel.remove(spinnerProgress);
                        clientInfoPanel.spinnerPanel.revalidate();
                        clientInfoPanel.spinnerPanel.repaint();
                        if (client != null) {
                            clientInfoPanel.txtNames.setText(client.getName());
                            clientInfoPanel.txtLastNames.setText(client.getLastName());
                            customModal.btnEdit.setEnabled(true);
                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "No se encontró ningún cliente con el DNI " + dniText + ".\n"
                                            + "Por favor, ingrese los datos del cliente.",
                                    "Cliente no encontrado",
                                    JOptionPane.WARNING_MESSAGE,
                                    new FlatSVGIcon("icons/warning.svg", 20, 20)
                            );
                        }
                    });
                }, 500, TimeUnit.MILLISECONDS);
                lastDniValue = dniText;
            } else if (dniText.length() < 8) {
                cancelPreviousSearch();
                customModal.btnEdit.setEnabled(false);
                lastDniValue = "";
                clearClientInfo();
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void checkTextFieldsAndEnableEditButton() {
        String dni = clientInfoPanel.txtDni.getText().trim();
        String names = clientInfoPanel.txtNames.getText().trim();
        String lastNames = clientInfoPanel.txtLastNames.getText().trim();

        customModal.btnEdit.setEnabled(!names.isEmpty() && !lastNames.isEmpty() && dni.length() == 8);
    }

    private void clearClientInfo() {
        clientInfoPanel.txtNames.setText("");
        clientInfoPanel.txtLastNames.setText("");
    }

    private void cancelPreviousSearch() {
        executorService.shutdownNow();
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    protected void handleCustomModalAction(ActionEvent e) {
        if (e.getSource() == customModal.btnEdit) {
            customModal.btnEdit.setEnabled(false);
            clientInfoPanel.txtDni.setEditable(false);
            clientInfoPanel.txtNames.setEditable(false);
            clientInfoPanel.txtLastNames.setEditable(false);

            Client client = new Client(
                    Integer.parseInt(clientInfoPanel.txtDni.getText()),
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
        }
    }
}
