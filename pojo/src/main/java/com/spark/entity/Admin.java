package com.spark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private Integer status;

    private LocalDateTime create_time;

    private LocalDateTime update_time;

    private Long create_user;

    private Long update_user;
}
