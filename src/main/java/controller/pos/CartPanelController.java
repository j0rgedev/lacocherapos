package controller.pos;

import components.modal.CustomModalController;
import components.modal.CustomModal;
import model.OrderDish;
import service.OrderInterface;
import service.OrderManager;
import view.pos.OrderPanel;
import view.pos.PointOfSaleFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CartPanelController implements ActionListener {

    private final JFrame frame;
    private DefaultTableModel model;
    private final OrderPanel orderPanel;
    private final OrderInterface orderInterface = OrderManager.getInstance();

    public CartPanelController(PointOfSaleFrame frame) {
        this.frame = frame;
        this.orderPanel = frame.orderPanel;
    }

    public void init() {
        listeners();
        model = (DefaultTableModel) orderPanel.tableDishes.getModel();
    }

    private void listeners() {
        orderPanel.btnNext.addActionListener(this);

        // Mouse listener when user double-clicks on any dish table row
        orderPanel.tableDishes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    int selectedRow = orderPanel.tableDishes.getSelectedRow();
                    if (selectedRow != -1) {
                        CustomModal modal = new CustomModal();
                        CustomModalController customModalController = new CustomModalController(modal, frame);
                        customModalController.showMessage();
                    }
                }
            }
        });
    }

    public void addDish(OrderDish orderDish) {
        if (!isDishAlreadyInCart(orderDish.getDish().getName())) {
            orderInterface.addDish(orderDish);
            addDishToCart();
        }
    }

    private boolean isDishAlreadyInCart(String dishName) {
        List<OrderDish> orderDishes = orderInterface.getDishes();
        for (OrderDish orderDish : orderDishes) {
            if (orderDish.getDish().getName().equals(dishName)) {
                return true; // Dish is already in cart
            }
        }
        return false; // Dish is not in cart
    }

    private void addDishToCart() {
        model.setRowCount(0);
        List<OrderDish> orderDishes = orderInterface.getDishes();
        for (OrderDish orderDish : orderDishes) {
            model.addRow(new Object[]{orderDish.getQuantity(), orderDish.getDish().getName()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
