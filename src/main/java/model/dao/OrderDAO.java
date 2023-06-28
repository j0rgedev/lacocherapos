package model.dao;

import model.models.Order;

public interface OrderDAO {
    public String createOrder(Order order);
    public void readOrder();
    public void updateOrder();
    public void deleteOrder();
}
