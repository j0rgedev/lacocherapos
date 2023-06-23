package controller.pos;

import model.models.Dish;
import view.components.modal.CustomModal;
import model.models.OrderDish;
import model.service.OrderInterface;
import model.service.OrderManager;
import view.components.modal.EditDishModalController;
import view.listeners.ModalListener;
import view.pos.OrderPanel;
import view.pos.PointOfSaleFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CartPanelController implements ActionListener, ModalListener {

    private final JFrame frame;
    private DefaultTableModel model;
    private final OrderPanel orderPanel;
    private boolean hasProductsInCart = false;
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
        OrderDish testDish = new OrderDish(new Dish("1", "Dish 1", 10, "1"), 1, "No notes");
        addDishToCart(testDish);
    }

    private void listeners() {
        orderPanel.btnNext.addActionListener(this);

        // Mouse listener when user double-clicks on any dish table row
        orderPanel.tableDishes.addMouseListener(new MouseAdapter() {
            private int startX;

            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
            }

            // Swipe left to delete dish
            @Override
            public void mouseReleased(MouseEvent e) {
                int endX = e.getX();
                int selectedRow = orderPanel.tableDishes.getSelectedRow();

                if (startX - endX > 100 && selectedRow != -1) {
                    // TODO: Add eliminate dish confirmation
                }
            }

            // Double click to edit dish
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    int selectedRow = orderPanel.tableDishes.getSelectedRow();
                    if (selectedRow != -1) {
                        CustomModal modal = new CustomModal();
                        EditDishModalController editDishModalController = new EditDishModalController(modal, frame, CartPanelController.this);
                        OrderDish orderDish = getSelectedDish(selectedRow);
                        editDishModalController.showModal();
                        editDishModalController.setOrderDish(orderDish);
                        orderPanel.tableDishes.clearSelection();
                    }
                }
            }
        });
    }


    /*
    * Main method to add a dish to the cart
    * @param orderDish: the dish to be added to the cart
    */
    public void addDishToCart(OrderDish orderDish) {
        if (!isDishAlreadyInCart(orderDish.getDish().getId())) {
            orderInterface.addDish(orderDish);
            refreshCart();
            updateNextButtonState();
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

    protected void updateNextButtonState() {
        hasProductsInCart = !orderInterface.getDishes().isEmpty();
        orderPanel.btnNext.setEnabled(hasProductsInCart);
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

    @Override
    public void onModalClose() {
        refreshCart();
    }
}
