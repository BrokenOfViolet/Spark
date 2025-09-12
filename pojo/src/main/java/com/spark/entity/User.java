package com.spark.entity;

import lombok.Data;

@Data
public class User {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String avatar;

    private Long registration_date;

    private Integer status;
}
