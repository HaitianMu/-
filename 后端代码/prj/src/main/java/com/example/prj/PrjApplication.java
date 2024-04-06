package com.example.prj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.prj.*.mapper")
public class PrjApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrjApplication.class, args);
    }

}
