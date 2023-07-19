package model.dao.impl;

import model.dao.DishOrderDAO;
import model.dao.OrderDAO;
import model.db.DatabaseConnection;
import model.dto.DashboardDTOS;
import model.entity.CartDish;
import model.entity.Order;
import model.utils.CodeGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDAOImpl implements OrderDAO, DishOrderDAO {

    private final DatabaseConnection dbConnection;
    private final static String LAST_ORDER_ID = "SELECT id FROM orders ORDER BY id DESC LIMIT 1";
    private final static String CREATE_ORDER = "INSERT INTO orders (id, date, total_amount, paid, client_dni) VALUES (?, ?, ?, ?, ?)";
    private final static String CREATE_DISH_ORDER = "INSERT INTO dish_order (dish_id, quantity, unit_price, subtotal, notes, order_id) VALUES (?, ?, ?, ?, ?, ?)";
    private final static String GET_ORDERS_TOTAL_AMOUNT_FOR_TODAY = "SELECT SUM(total_amount) from orders WHERE DAY(date) = DAY(now())";
    private final static String GET_ORDERS_QUANTITY_FOR_TODAY = "SELECT COUNT(*) from orders WHERE DAY(date) = DAY(now())";
    private final static String GET_ORDERS_QUANTITY_BY_PAYMENT_METHOD = "SELECT o.id AS Id, DATE_FORMAT(o.date, '%Y-%m') AS Mes, o.paid AS Pagado, p.method as Metodo FROM orders o LEFT JOIN payment p ON o.id = p.order_id WHERE o.date >= DATE_SUB(CURRENT_DATE(), INTERVAL 6 MONTH)";
    private final static String GET_DISHES_QUANTITY_BY_CATEGORY = """
            SELECT DATE_FORMAT(o.date, '%Y-%m') as month,
                   c.id                         AS category_id,
                   c.name                       AS category_name,
                   SUM(do.quantity)             AS total_quantity
            FROM category c
                     JOIN dish d ON c.id = d.category_id
                     JOIN dish_order do ON d.id = do.dish_id
                     JOIN orders o ON do.order_id = o.id
            WHERE o.date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)
            GROUP BY month, category_id""";

    public OrderDAOImpl() {
        this.dbConnection = new DatabaseConnection();
    }

    private String getLastOrderId() {
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(LAST_ORDER_ID);
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
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(CREATE_ORDER);
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
    public double getOrdersTotalAmountForToday() {
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ORDERS_TOTAL_AMOUNT_FOR_TODAY);
            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int getOrdersQuantityForToday() {
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ORDERS_QUANTITY_FOR_TODAY);
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<DashboardDTOS.OrdersByPaymentMethod> getOrdersQuantityByPaymentMethod() {
        try {
            List<DashboardDTOS.OrdersByPaymentMethod> ordersByPaymentMethodList = new ArrayList<>();
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ORDERS_QUANTITY_BY_PAYMENT_METHOD);
            while (resultSet.next()) {
                DashboardDTOS.OrdersByPaymentMethod ordersByPaymentMethod = new DashboardDTOS.OrdersByPaymentMethod(
                        resultSet.getString("Id"),
                        resultSet.getString("Mes"),
                        resultSet.getBoolean("Pagado"),
                        resultSet.getString("Metodo")
                );
                ordersByPaymentMethodList.add(ordersByPaymentMethod);
            }
            statement.close();
            return ordersByPaymentMethodList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DashboardDTOS.DishesByCategory> getDishesQuantityByCategory() {
        try {
            List<DashboardDTOS.DishesByCategory> dishesByCategoryList = new ArrayList<>();
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_DISHES_QUANTITY_BY_CATEGORY);
            while (resultSet.next()) {
                DashboardDTOS.DishesByCategory dishesByCategory = new DashboardDTOS.DishesByCategory(
                        resultSet.getString("month"),
                        resultSet.getString("category_id"),
                        resultSet.getString("category_name"),
                        resultSet.getInt("total_quantity")
                );
                dishesByCategoryList.add(dishesByCategory);
            }
            statement.close();
            return dishesByCategoryList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void createDishOrder(List<CartDish> cartDishes, String orderId) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(CREATE_DISH_ORDER);
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
