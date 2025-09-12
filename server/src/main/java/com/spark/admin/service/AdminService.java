package com.spark.admin.service;

import com.spark.dto.AdminLoginDTO;
import com.spark.entity.Admin;

public interface AdminService {
    public Admin login(AdminLoginDTO adminLoginDTO);
}
