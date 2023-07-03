package controller.pos;

import model.enums.PanelType;
import view.pos.OrderConfirmationPanel;
import view.pos.PointOfSaleFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationPanelController extends AbstractController implements ActionListener {

    private final OrderConfirmationPanel orderConfirmationPanel;
    private final TotalOrderPanelController totalOrderPanelController;
    private DefaultTableModel tableModel;

    public ConfirmationPanelController(PointOfSaleFrame pointOfSaleFrame,OrderConfirmationPanel orderConfirmationPanel) {
        super(pointOfSaleFrame);
        this.orderConfirmationPanel = orderConfirmationPanel;
        this.totalOrderPanelController = new TotalOrderPanelController(pointOfSaleFrm, orderConfirmationPanel.totalOrderPanel1, PanelType.CONFIRMATION_PANEL);
    }

    @Override
    protected void init() {
        tableModel = (DefaultTableModel) orderConfirmationPanel.orderTable.getModel();

        // Table header configuration
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(null);
        renderer.setForeground(new Color(176, 176, 176));
        renderer.setBackground(new Color(45, 52, 63));
        orderConfirmationPanel.orderTable.getTableHeader().setDefaultRenderer(renderer);
        orderConfirmationPanel.orderTable.getTableHeader().setPreferredSize(new Dimension(0, 50));

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
