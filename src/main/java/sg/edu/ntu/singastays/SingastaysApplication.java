package sg.edu.ntu.singastays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import sg.edu.ntu.singastays.config.DatabaseConfig;

@SpringBootApplication
public class SingastaysApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SingastaysApplication.class, args);
    }
}
