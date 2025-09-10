package com.spark.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@Slf4j
public class SparkApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparkApplication.class, args);
        log.info("server start");
    }
}
