package model.dao.impl;

import model.dao.DishOrderDAO;
import model.dao.OrderDAO;
import model.db.DatabaseConnection;
import model.models.CartDish;
import model.models.Order;
import model.utils.CodeGenerator;

import java.sql.*;
import java.util.List;
import java.util.Objects;

public class OrderDAOImpl implements OrderDAO, DishOrderDAO {

    private final DatabaseConnection dbConnection;

    public OrderDAOImpl() {
        this.dbConnection = new DatabaseConnection();
    }

    private String getLastOrderId() {
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM orders ORDER BY id DESC LIMIT 1");
            return resultSet.next() ? resultSet.getString("id") : null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createOrder(Order order) {
        String orderId = CodeGenerator.generateOrderId(Objects.requireNonNull(getLastOrderId()));
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement("INSERT INTO orders (id, date, total_amount, paid, client_dni) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, orderId);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(order.getDate()));
            preparedStatement.setDouble(3, order.getTotalAmount());
            preparedStatement.setBoolean(4, false);
            preparedStatement.setString(5, order.getClient().getDni());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return orderId;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void readOrder() {

    }

    @Override
    public void updateOrder() {

    }

    @Override
    public void deleteOrder() {

    }

    @Override
    public void createDishOrder(List<CartDish> cartDishes, String orderId) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement("INSERT INTO dish_order (dish_id, quantity, unit_price, subtotal, notes, order_id) VALUES (?, ?, ?, ?, ?, ?)");
            for (CartDish cartDish : cartDishes) {
                preparedStatement.setString(1, cartDish.getDish().getId());
                preparedStatement.setDouble(2, cartDish.getQuantity());
                preparedStatement.setDouble(3, cartDish.getDish().getPrice());
                preparedStatement.setDouble(4, cartDish.getSubtotal());
                preparedStatement.setString(5, cartDish.getNotes());
                preparedStatement.setString(6, orderId);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
