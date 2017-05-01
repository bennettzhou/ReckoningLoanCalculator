package net.superhero.loancalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the entry point into the Spring boot based Loan Calculator
 */
@SpringBootApplication
public class LoanCalculatorApp {

    /**
     * Wire Spring Boot with this Application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(LoanCalculatorApp.class, args);
    }
}
