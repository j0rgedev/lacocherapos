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

    // Method to initialize the cart panel
    // YOU'D BETTER CALL THIS METHOD TO INITIALIZE THE CART PANEL
    public void init() {
        listeners();
        model = (DefaultTableModel) orderPanel.tableDishes.getModel();
        model.addRow(new Object[]{"1", "Hamburguesa de pollo"});
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
                        OrderDish orderDish = getSelectedDish(selectedRow);
                    }
                }
            }
        });
    }

    /*
    * Main method to add a dish to the cart
    * @param orderDish: the dish to be added to the cart
    */
    public void addDish(OrderDish orderDish) {
        if (!isDishAlreadyInCart(orderDish.getDish().getId())) {
            orderInterface.addDish(orderDish);
            refreshCart();
        }
    }

    // Method to check if a dish is already in the cart
    private boolean isDishAlreadyInCart(String dishId) {
        List<OrderDish> orderDishes = orderInterface.getDishes();
        for (OrderDish orderDish : orderDishes) {
            if (orderDish.getDish().getId().equals(dishId)) {
                return true; // Dish is already in cart
            }
        }
        return false; // Dish is not in cart
    }

    // Method to refresh the dishes table
    private void refreshCart() {
        model.setRowCount(0);
        List<OrderDish> orderDishes = orderInterface.getDishes();
        for (OrderDish orderDish : orderDishes) {
            model.addRow(new Object[]{orderDish.getQuantity(), orderDish.getDish().getName()});
        }
    }

    // Method to get the selected dish from the dishes table
    private OrderDish getSelectedDish(int selectedRow) {
        List<OrderDish> orderDishes = orderInterface.getDishes();
        if(selectedRow >= 0 && selectedRow < orderDishes.size()) {
            return orderDishes.get(selectedRow);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
