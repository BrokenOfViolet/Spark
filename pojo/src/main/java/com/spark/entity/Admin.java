package com.spark.entity;

import lombok.Data;

@Data
public class Admin {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private Integer status;

    private String create_time;

    private String update_time;

    private Long create_user;

    private Long update_user;
}
