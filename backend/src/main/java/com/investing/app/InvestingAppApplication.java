package com.investing.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.investing.app.domain.*.mapper")
public class InvestingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestingAppApplication.class, args);
    }

}
