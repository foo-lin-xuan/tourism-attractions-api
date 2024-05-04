package sg.edu.ntu.singastays.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Value("${DATABASE_USERNAME}")
    private String databaseUsername;

    @Value("${DATABASE_PASSWORD}")
    private String databasePassword;

    public void setupDatabaseConnection() {
        // Use databaseUrl, databaseUsername, and databasePassword to configure your database connection
    }
}
