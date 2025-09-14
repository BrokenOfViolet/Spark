package com.spark.controller.admin;

import com.spark.service.AdminService;
import com.spark.constant.JwtClaimsConstant;
import com.spark.dto.AdminLoginDTO;
import com.spark.entity.Admin;
import com.spark.properties.JwtProperties;
import com.spark.result.Result;
import com.spark.utils.JwtUtil;
import com.spark.vo.AdminLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/admin/user")
@Slf4j
@Api(tags = "管理端用户接口")
public class UserController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<AdminLoginVO> userLogin(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("管理端用户登录: {}", adminLoginDTO);
        Admin admin = adminService.login(adminLoginDTO);

        HashMap<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, admin.getId());

        String token = JwtUtil.createJwt(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );

        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .phone(admin.getPhone())
                .token(token)
                .build();
        return Result.success(adminLoginVO);
    }
}
