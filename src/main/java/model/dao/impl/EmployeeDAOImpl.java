package model.dao.impl;

import model.dao.EmployeeDAO;
import model.db.DatabaseConnection;
import model.entity.Employee;
import model.enums.Roles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    DatabaseConnection dbConnection;
    private static final String GET_USER = "SELECT * FROM user WHERE id = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM user";
    private static final String SAVE_USER = "INSERT INTO user (id, names, last_names, password, salt, role) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String EDIT_USER = "UPDATE user SET names = ?, last_names = ?, password = ?, salt = ?, role = ? WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM user WHERE id = ?";
    private static final String GET_LAST_USER_ID = "SELECT id FROM user ORDER BY id DESC LIMIT 1";

    public EmployeeDAOImpl() {
        this.dbConnection = new DatabaseConnection();
    }

    public String getLastUserId(){
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(GET_LAST_USER_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Employee getUser(String userId) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(GET_USER);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String roleId = resultSet.getString("role");
                Roles role = Roles.valueOf(roleId.toUpperCase());

                return new Employee(
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

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String roleId = resultSet.getString("role");
                Roles role = Roles.valueOf(roleId.toUpperCase());

                Employee employee = new Employee();
                employee.setId(resultSet.getString("id"));
                employee.setNames(resultSet.getString("names"));
                employee.setLastNames(resultSet.getString("last_names"));
                employee.setPassword(resultSet.getString("password"));
                employee.setSalt(resultSet.getString("salt"));
                employee.setRole(role);
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    @Override
    public void save(Employee employee) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(SAVE_USER);
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getNames());
            preparedStatement.setString(3, employee.getLastNames());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getSalt());
            preparedStatement.setString(6, employee.getRole().toString().toLowerCase());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Employee employee) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(EDIT_USER);
            preparedStatement.setString(1, employee.getNames());
            preparedStatement.setString(2, employee.getLastNames());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setString(4, employee.getSalt());
            preparedStatement.setString(5, employee.getRole().toString().toLowerCase());
            preparedStatement.setString(6, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Employee employee) {
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(DELETE_USER);
            preparedStatement.setString(1, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
