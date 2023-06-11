package dao;

import model.Dish;

import java.util.List;

public interface DishDAO {
    List<Dish> getAllDishes();
    List<Dish> getDishesByCategory(String category);
}
