package com.example.handandbrainchess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class HandandbrainchessApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandandbrainchessApplication.class, args);
    }

}
