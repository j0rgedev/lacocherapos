package model.dao.impl;

import model.dao.DishDAO;
import model.db.DatabaseConnection;
import model.dto.DashboardDTOS;
import model.entity.Dish;
import model.utils.CodeGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DishDAOImpl implements DishDAO {

    private final DatabaseConnection dbConnection;
    private final static String GET_ALL_DISHES = "SELECT * FROM dish ORDER BY category_id,id";
    private final static String GET_DISHES_BY_CATEGORY = "SELECT * FROM dish WHERE category_id = ?";
    private final static String GET_LAST_DISH_ID = "SELECT id FROM dish ORDER BY id DESC LIMIT 1";
    private final static String CREATE_DISH = "INSERT INTO dish (id, name, price, category_id) VALUES (?, ?, ?, ?)";
    private final static String UPDATE_DISH = "UPDATE dish SET name = ?, price = ?, category_id = ? WHERE id = ?";
    private final static String DELETE_DISH = "DELETE FROM dish WHERE id = ?";
    private final static String GET_TOP_FIVE_DISHES = """
            SELECT d.name AS name, SUM(quantity) AS total
            FROM dish_order do
            INNER JOIN dish d on do.dish_id = d.id
            GROUP BY dish_id
            ORDER BY total DESC
            LIMIT 5""";
    private final static String GET_TOP_FIVE_DISHES_BY_CATEGORY = """
            SELECT d.name AS name, SUM(quantity) AS total
            FROM dish_order do
            INNER JOIN dish d on do.dish_id = d.id
            WHERE d.category_id = ?
            GROUP BY dish_id
            ORDER BY total DESC
            LIMIT 5""";

    private final static String GET_TOP_FIVE_DISHES_BY_MONTH = """
            SELECT d.name AS name, SUM(quantity) AS total
            FROM dish_order do INNER JOIN dish d on do.dish_id = d.id
            INNER JOIN orders o on do.order_id = o.id
            WHERE MONTH(o.date) = ?
            GROUP BY dish_id
            ORDER BY total DESC
            LIMIT 5""";

    public DishDAOImpl() {
        dbConnection = new DatabaseConnection();
    }

    private String getLastDishId(){
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_LAST_DISH_ID);
            if (resultSet.next()) {
                return resultSet.getString("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void createDish(Dish dish) {
        String newId = CodeGenerator.generateDishId(Objects.requireNonNull(getLastDishId()));
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(CREATE_DISH);
            preparedStatement.setString(1, newId);
            preparedStatement.setString(2, dish.getName());
            preparedStatement.setDouble(3, dish.getPrice());
            preparedStatement.setString(4, dish.getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateDish(Dish dish) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(UPDATE_DISH);
            preparedStatement.setString(1, dish.getName());
            preparedStatement.setDouble(2, dish.getPrice());
            preparedStatement.setString(3, dish.getCategory_id());
            preparedStatement.setString(4, dish.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDish(String dishId) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(DELETE_DISH);
            preparedStatement.setString(1, dishId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

    @Override
    public List<DashboardDTOS.TopFiveDishes> getTopFiveDishes() {
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_TOP_FIVE_DISHES);
            List<DashboardDTOS.TopFiveDishes> topFiveDishes = new ArrayList<>();
            while (resultSet.next()) {
                DashboardDTOS.TopFiveDishes topFiveDish = new DashboardDTOS.TopFiveDishes(
                        resultSet.getString("name"),
                        resultSet.getInt("total")
                );
                topFiveDishes.add(topFiveDish);
            }
            return topFiveDishes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<DashboardDTOS.TopFiveDishes> getTopFiveDishesByCategory(String categoryId) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(GET_TOP_FIVE_DISHES_BY_CATEGORY);
            preparedStatement.setString(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DashboardDTOS.TopFiveDishes> topFiveDishesByCategory = new ArrayList<>();
            while (resultSet.next()) {
                DashboardDTOS.TopFiveDishes topFiveDish = new DashboardDTOS.TopFiveDishes(
                        resultSet.getString("name"),
                        resultSet.getInt("total")
                );
                topFiveDishesByCategory.add(topFiveDish);
            }
            return topFiveDishesByCategory;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<DashboardDTOS.TopFiveDishes> getTopFiveDishesByMonth(int month) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(GET_TOP_FIVE_DISHES_BY_MONTH);
            preparedStatement.setInt(1, month);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DashboardDTOS.TopFiveDishes> topFiveDishesByMonth = new ArrayList<>();
            while (resultSet.next()) {
                DashboardDTOS.TopFiveDishes topFiveDish = new DashboardDTOS.TopFiveDishes(
                        resultSet.getString("name"),
                        resultSet.getInt("total")
                );
                topFiveDishesByMonth.add(topFiveDish);
            }
            return topFiveDishesByMonth;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
