package model.service;

import model.models.OrderDish;

import java.util.List;

public interface OrderInterface {
    void addDish(OrderDish dish);
    void updateDish(OrderDish dish);
    void removeDish(OrderDish dish);
    OrderDish getDish(OrderDish dish);
    List<OrderDish> getDishes();
    double calculateSubtotal();
    void clearOrder();
}
