package com.spark.admin.handler;

import com.spark.exception.BaseException;
import com.spark.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex) {
        log.info("异常信息: {}", ex.getMessage());
        return Result.error(ex.getMessage());
    }
}
