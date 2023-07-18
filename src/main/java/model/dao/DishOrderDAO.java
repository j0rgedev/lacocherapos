package model.dao;

import model.entity.CartDish;

import java.util.List;

public interface DishOrderDAO {
    void createDishOrder(List<CartDish> cartDishes, String orderId);
//    List<CartDish> getDishesFromOrder(int orderId);
//    void deleteDishOrder(int dishId, int orderId);
//    void deleteDishesFromOrder(int dishId);
}
