package com.tbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.tbc.payments",
                "com.tbc.point"
        }
)
public class TbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(TbcApplication.class, args);
    }
}