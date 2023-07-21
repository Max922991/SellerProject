package com.example.sellerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
public class SellerProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerProjectApplication.class, args);
    }

}
