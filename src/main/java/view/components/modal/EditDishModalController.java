package view.components.modal;

import model.models.OrderDish;
import model.service.OrderInterface;
import model.service.OrderManager;
import view.listeners.ModalListener;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditDishModalController extends ModalController{

    private EditDishPanel editDishPanel;
    private OrderDish orderDish;
    private static int quantity;

    private final OrderInterface orderInterface = OrderManager.getInstance();

    public EditDishModalController(CustomModal customModal, JFrame jFrame, ModalListener modalListener) {
        super(customModal, jFrame, modalListener);
    }

    public void setOrderDish(OrderDish orderDish) {
        this.orderDish = orderDish;
        // Set title, quantity and notes
        editDishPanel.lbTitle.setText(orderDish.getDish().getName());
        quantity = orderDish.getQuantity();
        editDishPanel.txtQuantity.setText(String.valueOf(quantity));
        if(orderDish.getNotes()!=null){
            editDishPanel.txtNotes.setText(orderDish.getNotes());
        }
    }

    @Override
    public void showModal() {
        setupModal();
        editDishPanel = new EditDishPanel();
        customModal.containerPanel.setPreferredSize(editDishPanel.getPreferredSize());
        customModal.containerPanel.add(editDishPanel);
        customModal.pack();
        // Custom listeners
        editDishPanel.btnDecrease.addActionListener(this);
        editDishPanel.btnIncrease.addActionListener(this);
    }

    @Override
    protected void handleCustomModalAction(ActionEvent e) {
        // Increase quantity
        if (e.getSource() == editDishPanel.btnIncrease) {
            quantity++;
            editDishPanel.txtQuantity.setText(String.valueOf(quantity));
        }

        // Decrease quantity
        if (e.getSource() == editDishPanel.btnDecrease){
            if (quantity > 1) {
                quantity--;
                editDishPanel.txtQuantity.setText(String.valueOf(quantity));
            }
        }

        // Edit dish
        if(e.getSource()==customModal.btnEdit){
            orderDish.setQuantity(quantity);
            String notes = editDishPanel.txtNotes.getText();
            if(!notes.isEmpty()){
                orderDish.setNotes(notes);
            }
            orderInterface.updateDish(orderDish);
            closeMessage();
        }
    }
}
