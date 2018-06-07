package com.wowcraft.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApp {

    public static void main(String[] args) {
        new SpringApplication(RestApp.class).run(args);
    }
}
