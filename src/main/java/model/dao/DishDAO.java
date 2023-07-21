package model.dao;

import model.entity.Dish;

import java.util.List;

public interface DishDAO {
    void createDish(Dish dish);
    void updateDish(Dish dish);
    void deleteDish(String dishId);

    List<Dish> getAllDishes();
    List<Dish> getDishesByCategory(String category);
}
