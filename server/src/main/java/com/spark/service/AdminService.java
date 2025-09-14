package com.spark.service;

import com.spark.dto.AdminLoginDTO;
import com.spark.entity.Admin;

public interface AdminService {
    public Admin login(AdminLoginDTO adminLoginDTO);
}
