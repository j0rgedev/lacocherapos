package model.dao.impl;

import model.dao.ClientDAO;
import model.db.DatabaseConnection;
import model.entity.Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAOImpl implements ClientDAO {

    private final DatabaseConnection databaseConnection;
    private final static String CREATE_CLIENT = "INSERT INTO client (dni, name, last_name) VALUES (?, ?, ?)";

    public ClientDAOImpl() {
        this.databaseConnection = new DatabaseConnection();
    }

    @Override
    public void createClient(Client client) {
        try {
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(CREATE_CLIENT);
            preparedStatement.setString(1, client.getDni());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
