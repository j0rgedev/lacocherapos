package model.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class CartDish {
    private Dish dish;
    private int quantity;
    private double subtotal;
    private String notes;

    public CartDish(@NonNull Dish dish, int quantity, String notes) {
        this.dish = dish;
        this.quantity = quantity;
        this.notes = notes;
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        subtotal = dish.getPrice() * quantity;
    }

}
