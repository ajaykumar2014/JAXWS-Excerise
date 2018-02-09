package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.client.controllers"})
public class CalculatorSimulatorApp {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorSimulatorApp.class, args);

    }
}
