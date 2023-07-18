package model.dao.impl;

import model.dao.PaymentDao;
import model.db.DatabaseConnection;
import model.entity.Payment;
import model.utils.CodeGenerator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class PaymentDAOImpl implements PaymentDao {

    private final DatabaseConnection databaseConnection;

    public PaymentDAOImpl() {
        this.databaseConnection = new DatabaseConnection();
    }

    private String getLastPaymentId(){
        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM payment ORDER BY id DESC LIMIT 1");
            return resultSet.next() ? resultSet.getString("id") : null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void createPayment(Payment payment) {
        String paymentId = CodeGenerator.generatePaymentId(Objects.requireNonNull(getLastPaymentId()));
        try {
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement("INSERT INTO `payment` (id, status, method, transaction_number, order_id) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, paymentId);
            preparedStatement.setString(2, payment.getStatus().getName());
            preparedStatement.setString(3, payment.getMethod().getName());
            preparedStatement.setInt(4, payment.getTransactionNumber());
            preparedStatement.setString(5, payment.getOrder().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updatePayment(String id) {

    }

    @Override
    public void deletePayment(String id) {

    }

    @Override
    public void readPayment(String id) {

    }
}
