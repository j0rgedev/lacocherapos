package model.service;

import model.models.CartDish;
import model.models.Order;

import java.util.List;

public interface OrderInterface {
    void addDish(CartDish dish);
    void updateDish(CartDish dish);
    void removeDish(CartDish dish);
    CartDish getDish(CartDish dish);
    List<CartDish> getDishes();
    double getSubtotal();
    double getTotal();
    double getIgv();
    void setOrder(Order order);
    Order getOrder();
    void clearOrder();
}
