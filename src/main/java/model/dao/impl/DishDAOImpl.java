package model.dao.impl;

import model.dao.DishDAO;
import model.db.DatabaseConnection;
import model.models.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDAOImpl implements DishDAO {

    private final DatabaseConnection dbConnection;
    private final static String GET_ALL_DISHES = "SELECT * FROM dish";
    private final static String GET_DISHES_BY_CATEGORY = "SELECT * FROM dish WHERE category_id = ?";

    public DishDAOImpl() {
        dbConnection = new DatabaseConnection();
    }

    @Override
    public List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_DISHES);
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setId(resultSet.getString("id"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getDouble("price"));
                dish.setCategory_id(resultSet.getString("category_id"));
                dishes.add(dish);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dishes;
    }

    @Override
    public List<Dish> getDishesByCategory(String id) {
        List<Dish> dishes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(GET_DISHES_BY_CATEGORY);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setId(resultSet.getString("id"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getDouble("price"));
                dishes.add(dish);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dishes;
    }
}
