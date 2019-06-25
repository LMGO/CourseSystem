package com.wanderpoet.experiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ExperimentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperimentApplication.class, args);
    }

}
