package model.dao;

import model.models.Dish;

import java.util.List;

public interface DishDAO {
    List<Dish> getAllDishes();
    List<Dish> getDishesByCategory(String category);
}
