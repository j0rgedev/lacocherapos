package model.service;

import model.models.Dish;
import model.models.OrderDish;

import java.util.List;

public interface OrderInterface {
    void addDish(OrderDish dish);
    void removeDish(Dish dish);
    OrderDish getDish(Dish dish);
    List<OrderDish> getDishes();
    double calculateSubtotal();
    void clearOrder();
}
