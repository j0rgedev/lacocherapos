package model.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDish {
    private Dish dish;
    private int quantity;
    private String notes;
}
