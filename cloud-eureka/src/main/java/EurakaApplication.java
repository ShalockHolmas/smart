import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
public class EurakaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurakaApplication.class, args);
    }
}
