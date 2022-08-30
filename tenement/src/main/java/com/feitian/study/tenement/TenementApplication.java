package com.feitian.study.tenement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.feitian.study.tenement.dao")
public class TenementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenementApplication.class, args);
    }

}
