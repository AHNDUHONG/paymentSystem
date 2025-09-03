package com.tbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tbc")
@EnableJpaRepositories(basePackages = "com.tbc")
@EntityScan(basePackages = "com.tbc")
public class TbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(TbcApplication.class, args);
    }
}
