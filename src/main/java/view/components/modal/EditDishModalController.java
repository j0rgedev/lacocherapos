package view.components.modal;

import model.entity.CartDish;
import view.listeners.ModalListener;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditDishModalController extends ModalController{

    private EditDishPanel editDishPanel;
    public CartDish cartDish;
    private static int quantity;


    public EditDishModalController(CustomModal customModal, JFrame jFrame, ModalListener modalListener) {
        super(customModal, jFrame, modalListener);
        editDishPanel = new EditDishPanel();
    }

    public void setOrderDish(CartDish cartDish) {
        this.cartDish = cartDish;
        // Set title, quantity and notes
        editDishPanel.lbTitle.setText(cartDish.getDish().getName());
        quantity = cartDish.getQuantity();
        editDishPanel.txtQuantity.setText(String.valueOf(quantity));
        if(cartDish.getNotes()!=null) editDishPanel.txtNotes.setText(cartDish.getNotes());

    }

    @Override
    public void showModal() {
        editDishPanel.btnDecrease.addActionListener(this);
        editDishPanel.btnIncrease.addActionListener(this);
        setupModal(editDishPanel, "icons/edit.svg");
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
            System.out.println("Decrease");
            if (quantity > 1) {
                quantity--;
                editDishPanel.txtQuantity.setText(String.valueOf(quantity));
            }
        }

        // Edit dish
        if(e.getSource()==customModal.btnEdit){
            cartDish.setQuantity(quantity);
            String notes = editDishPanel.txtNotes.getText();
            if(!notes.isEmpty()){
                cartDish.setNotes(notes);
            }
            orderInterface.updateDish(cartDish);
            modalListener.onEditDishModalClose();
            closeMessage();
        }

        if(e.getSource()==customModal.btnCancel){
            closeMessage();
        }
    }
}
