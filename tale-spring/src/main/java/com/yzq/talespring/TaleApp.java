package com.yzq.talespring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yzq.talespring.mapper")
public class TaleApp {

    public static void main(String[] args) {
        SpringApplication.run(TaleApp.class, args);
    }

}
