package com.spark.vo;

import com.spark.entity.Admin;
import lombok.Data;

@Data
public class AdminLoginVO {
    private String token;

    private Admin admin;
}
