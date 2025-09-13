package com.spark.admin.interceptor;

import com.spark.constant.JwtClaimsConstant;
import com.spark.properties.JwtProperties;
import com.spark.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class JwtAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader(jwtProperties.getAdminTokenName());
        try {
            log.info("jwt校验: {}", token);
            Claims claims = JwtUtil.parseJwt(jwtProperties.getAdminSecretKey(), token);

            Long adminId = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
            log.info("当前管理员用户Id: {}", adminId);

            return true;
        } catch (Exception ex) {
            response.setStatus(401);
            return false;
        }
    }
}
