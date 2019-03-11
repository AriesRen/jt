package com.renhj.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config/spring-druid.xml")
public class ShiroDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class, args);
    }
}
