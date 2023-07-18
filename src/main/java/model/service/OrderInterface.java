package model.service;

import model.entity.CartDish;
import model.entity.Order;

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
