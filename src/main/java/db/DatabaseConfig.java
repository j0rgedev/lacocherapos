package db;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class DatabaseConfig {
    private final String url = Dotenv.load().get("DB_URL");
    private final String user = Dotenv.load().get("DB_USER");
    private final String password = Dotenv.load().get("DB_PASSWORD");
}
