package db;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class DatabaseConnection extends DatabaseConfig {

    private Connection connection;

    public DatabaseConnection() {
        super();
    }

    public boolean getConnection() {
        try {
            connection =  DriverManager.getConnection(getUrl(), getUser(), getPassword());
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
