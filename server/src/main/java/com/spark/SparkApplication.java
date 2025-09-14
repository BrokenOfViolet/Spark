package com.spark;

import com.spark.properties.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties(JwtProperties.class)
@EnableCaching
@Slf4j
public class SparkApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparkApplication.class, args);
        log.info("server start");
    }
}
