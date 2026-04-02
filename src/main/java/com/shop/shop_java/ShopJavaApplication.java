package com.shop.shop_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.shop.shop_java.mapper")
public class ShopJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopJavaApplication.class, args);
        System.out.println("Shop Java Backend Started Successfully!");
    }

}
