package model.dao.impl;

import model.dao.ClientDAO;
import model.db.DatabaseConnection;
import model.entity.Client;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAOImpl implements ClientDAO {

    private final DatabaseConnection databaseConnection;
    private final static String CREATE_CLIENT = "INSERT INTO client (dni, name, last_name) VALUES (?, ?, ?)";
    private final static String GET_CLIENT_BY_DNI = "SELECT * FROM client WHERE dni = ?";

    public ClientDAOImpl() {
        this.databaseConnection = new DatabaseConnection();
    }

    // Constructor for testing purposes
    public ClientDAOImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void createClient(Client client) {
        try {
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(CREATE_CLIENT);
            preparedStatement.setInt(1, client.getDni());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Client getClientByDni(int dni) {
        Client client = null;
        try {
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(GET_CLIENT_BY_DNI);
            preparedStatement.setInt(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client = new Client(
                        resultSet.getInt("dni"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return client;
    }
}
