package ru.tkachenko.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Created by Dmitry Tkachenko on 19.04.18
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }
}
