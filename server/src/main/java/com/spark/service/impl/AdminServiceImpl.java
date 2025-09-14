package com.spark.service.impl;

import com.spark.mapper.AdminMapper;
import com.spark.service.AdminService;
import com.spark.constant.MessageConstant;
import com.spark.dto.AdminLoginDTO;
import com.spark.entity.Admin;
import com.spark.exception.AccountLockedException;
import com.spark.exception.AccountNotFoundException;
import com.spark.exception.PasswordNotMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin login(AdminLoginDTO adminLoginDTO) {
        Admin admin = adminMapper.getByUsername(adminLoginDTO.getUsername());

        if (admin == null) {
            throw new AccountNotFoundException(MessageConstant.ADMIN_NOT_EXIST);
        }

        if (admin.getPassword().equals(adminLoginDTO.getPassword())) {
            throw new PasswordNotMatchException(MessageConstant.PASSWORD_ERROR);
        }

        if (admin.getStatus() == 0) {
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }
        return admin;
    }
}
