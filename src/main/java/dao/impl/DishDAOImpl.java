package dao.impl;

import dao.DishDAO;
import db.DatabaseConnection;
import model.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDAOImpl implements DishDAO {

    private final DatabaseConnection dbConnection;

    public DishDAOImpl() {
        dbConnection = new DatabaseConnection();
    }

    @Override
    public List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dish");
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
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement("SELECT * FROM dish WHERE category_id = ?");
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
