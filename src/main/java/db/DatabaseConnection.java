package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {}

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(
                    DatabaseConfig.getUrl(),
                    DatabaseConfig.getUser(),
                    DatabaseConfig.getPassword()
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
