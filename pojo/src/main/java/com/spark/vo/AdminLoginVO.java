package com.spark.vo;

import com.spark.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminLoginVO {
    private Long id;

    private String username;

    private String phone;

    private String token;
}
