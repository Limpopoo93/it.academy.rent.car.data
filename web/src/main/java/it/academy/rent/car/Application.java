package it.academy.rent.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "it.academy.rent.car")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
