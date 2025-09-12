package com.spark.admin.controller;

import com.spark.admin.service.AdminService;
import com.spark.dto.AdminLoginDTO;
import com.spark.entity.Admin;
import com.spark.result.Result;
import com.spark.vo.AdminLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
@Slf4j
@Api(tags = "管理端用户接口")
public class UserController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<AdminLoginVO> userLogin(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("管理端用户登录: {}", adminLoginDTO);
        Admin admin = adminService.login(adminLoginDTO);

        AdminLoginVO adminLoginVO = new AdminLoginVO();
        return Result.success(adminLoginVO);
    }
}
