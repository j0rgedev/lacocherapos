package controller.pos;

import model.service.OrderInterface;
import model.service.OrderManager;
import view.pos.OrderConfirmationPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationPanelController implements ActionListener {

    private final OrderConfirmationPanel orderConfirmationPanel;
    private final TotalOrderPanelController totalOrderPanelController;
    private final OrderInterface orderInterface = OrderManager.getInstance();
    private DefaultTableModel tableModel;

    public ConfirmationPanelController(OrderConfirmationPanel orderConfirmationPanel) {
        this.orderConfirmationPanel = orderConfirmationPanel;
        this.totalOrderPanelController = new TotalOrderPanelController(orderConfirmationPanel.totalOrderPanel1);
    }

    public void init() {
        tableModel = (DefaultTableModel) orderConfirmationPanel.orderTable.getModel();

        // Align table content to left
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        orderConfirmationPanel.orderTable.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
        orderConfirmationPanel.orderTable.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        orderConfirmationPanel.orderTable.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        orderConfirmationPanel.orderTable.getColumnModel().getColumn(3).setCellRenderer(leftRenderer);

        showOrder();
        totalOrderPanelController.init();
    }

    private void showOrder() {
        // Client info
        String fullName = orderInterface.getOrder().getClient().getName() + " " + orderInterface.getOrder().getClient().getLastName();
        orderConfirmationPanel.lblClientInfo.setText("Cliente: " + fullName);

        // Order table
        for (int i = 0; i < orderInterface.getDishes().size(); i++) {
            tableModel.addRow(new Object[]{
                    orderInterface.getDishes().get(i).getQuantity(),
                    orderInterface.getDishes().get(i).getDish().getName(),
                    orderInterface.getDishes().get(i).getNotes(),
                    orderInterface.getDishes().get(i).getSubtotal()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
