package model.dao.impl;

import model.dao.UserDAO;
import model.db.DatabaseConnection;
import model.entity.User;
import model.enums.Roles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    DatabaseConnection dbConnection;
    private static final String GET_USER = "SELECT * FROM user WHERE id = ?";

    public UserDAOImpl() {
        this.dbConnection = new DatabaseConnection();
    }

    @Override
    public User getUser(String userId) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(GET_USER);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String roleId = resultSet.getString("role");
                Roles role = Roles.valueOf(roleId.toUpperCase());

                return new User(
                        resultSet.getString("id"),
                        resultSet.getString("names"),
                        resultSet.getString("last_names"),
                        resultSet.getString("password"),
                        resultSet.getString("salt"),
                        role
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
