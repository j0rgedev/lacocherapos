package model.dao.impl;

import model.dao.ClientDAO;
import model.db.DatabaseConnection;
import model.models.Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAOImpl implements ClientDAO {

    private final DatabaseConnection databaseConnection;

    public ClientDAOImpl() {
        this.databaseConnection = new DatabaseConnection();
    }

    @Override
    public void createClient(Client client) {
        try {
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement("INSERT INTO client (dni, name, last_name) VALUES (?, ?, ?)");
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
