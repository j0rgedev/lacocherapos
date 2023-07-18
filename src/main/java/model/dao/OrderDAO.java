package model.dao;

import model.dto.DashboardDTOS;
import model.entity.Order;

import java.util.List;

public interface OrderDAO {
    // CRUD
    String createOrder(Order order);
    void readOrder();
    void updateOrder();
    void deleteOrder();

    // Other methods
    double getOrdersTotalAmountForToday();
    int getOrdersQuantityForToday();
    List<DashboardDTOS.OrdersByPaymentMethod> getOrdersQuantityByPaymentMethod();
}
