package com.mrms.recoversystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.mrms.recoversystem.mapper")
@SpringBootApplication
public class RecoversystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecoversystemApplication.class, args);
    }

}

