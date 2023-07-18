package model.dao;

import model.models.Order;

public interface OrderDAO {
    // CRUD
    String createOrder(Order order);
    void readOrder();
    void updateOrder();
    void deleteOrder();

    // Other methods

}
