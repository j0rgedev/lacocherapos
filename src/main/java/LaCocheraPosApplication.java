import db.DatabaseConnection;

public class LaCocheraPosApplication {

        public static void main(String[] args) {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            if (databaseConnection.getConnection()) {
                System.out.println("Connection successful");
            } else {
                System.out.println("Connection failed");
            }
        }
}
