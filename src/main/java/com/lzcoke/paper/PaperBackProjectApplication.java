package com.lzcoke.paper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzcoke.paper.mapper")
public class PaperBackProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperBackProjectApplication.class, args);
    }

}
