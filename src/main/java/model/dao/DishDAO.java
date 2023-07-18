package model.dao;

import model.entity.Dish;

import java.util.List;

public interface DishDAO {
    List<Dish> getAllDishes();
    List<Dish> getDishesByCategory(String category);
}
