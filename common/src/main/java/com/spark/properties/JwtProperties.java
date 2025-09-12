package com.spark.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spark.jwt")
public class JwtProperties {
    private String adminSecretKey;
    private String adminTtl;
    private String adminTokenName;
}
