package com.spark.dto;

import lombok.Data;

@Data
public class AdminLoginDTO {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private Integer status;
}
