package model.service;

import lombok.Getter;
import lombok.Setter;
import model.models.CartDish;
import model.models.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderManager implements OrderInterface {
    private static OrderManager instance;
    private final List<CartDish> cartDishes;
    private Order order;

    private OrderManager() {
        cartDishes = new ArrayList<>();
        order = new Order();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    @Override
    public void addDish(CartDish cartDish) {
        cartDishes.add(cartDish);
    }

    @Override
    public void updateDish(CartDish dish) {
        cartDishes.stream()
                .filter(orderDish -> orderDish.getDish().getId().equals(dish.getDish().getId()))
                .findFirst()
                .ifPresent(orderDish -> {
                    orderDish.setQuantity(dish.getQuantity());
                    orderDish.setNotes(dish.getNotes());
                });
    }

    @Override
    public void removeDish(CartDish dish) {
        cartDishes.removeIf(orderDish -> orderDish.getDish().getId().equals(dish.getDish().getId()));
    }

    @Override
    public CartDish getDish(CartDish dish) {
        return cartDishes.stream()
                .filter(orderDish -> orderDish.getDish().getId().equals(dish.getDish().getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CartDish> getDishes() {
        return cartDishes;
    }

    @Override
    public double getTotal() {
        double subtotal = 0.0;
        for (CartDish cartDish : cartDishes) {
            subtotal += cartDish.getDish().getPrice() * cartDish.getQuantity();
        }
        return subtotal;
    }

    @Override
    public double getSubtotal() {
        return getTotal() - getIgv();
    }

    @Override
    public double getIgv() {
        return getTotal() * 0.18;
    }

    @Override
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public void clearOrder() {
        cartDishes.clear();
    }
}
