package model.db;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;

public class DatabaseConfig {
    
    private static final String NAME = Dotenv.load().get("DB_NAME");
    private static final String HOST = Dotenv.load().get("DB_HOST");
    
    @Getter
    private static String url = "jdbc:mysql://"+HOST+"/"+NAME+"?sslMode=VERIFY_IDENTITY";
    @Getter
    private static String user = Dotenv.load().get("DB_USERNAME");
    @Getter
    private static String password = Dotenv.load().get("DB_PASSWORD");
    
}
