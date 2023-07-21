package view.listeners;

import model.entity.Dish;
import model.enums.DishAction;

public interface ModalListener {
    void onEditDishModalClose();
    void onClientInfoModalClose();
    void onDishActionModalClose(Dish dish, DishAction dishAction);
}
