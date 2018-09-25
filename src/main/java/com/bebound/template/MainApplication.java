package com.bebound.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class MainApplication {

    /**
     * The default port with Spring is 8080: please consider to modify it in a real project
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        Logger.getAnonymousLogger().info("SERVER IS LAUNCHED");
    }
}
