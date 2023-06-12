package service;

import model.Dish;
import model.OrderDish;

import java.util.List;

public interface OrderInterface {
    void addDish(OrderDish dish);
    void removeDish(Dish dish);
    List<OrderDish> getDishes();
    double calculateSubtotal();
    void clearOrder();
}
