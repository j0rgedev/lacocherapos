package model.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderDish {
    private Dish dish;
    private int quantity;
    private String notes;
}
