package service;

import model.Dish;
import model.OrderDish;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements OrderInterface {
    private static OrderManager instance;
    private final List<OrderDish> orderDishes;

    private OrderManager() {
        orderDishes = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    @Override
    public void addDish(OrderDish orderDish) {
        orderDishes.add(orderDish);
    }

    @Override
    public void removeDish(Dish dish) {
        orderDishes.removeIf(orderDish -> orderDish.getDish().getId().equals(dish.getId()));
    }

    @Override
    public List<OrderDish> getDishes() {
        return orderDishes;
    }

    @Override
    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (OrderDish orderDish : orderDishes) {
            subtotal += orderDish.getDish().getPrice() * orderDish.getQuantity();
        }
        return subtotal;
    }

    @Override
    public void clearOrder() {
        orderDishes.clear();
    }
}
