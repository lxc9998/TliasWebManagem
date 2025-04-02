package com.lhx.exception;

import com.lhx.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕获路径不存在异常
    @ExceptionHandler(NoResourceFoundException.class)
    public Result handleNoResourceFound() {
        return Result.error("请求路径不存在");
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        // 如果service层中有类似SQL异常没有捕获的,在全局异常处理器中兜底捕获并处理
        if(e.getCause() instanceof SQLIntegrityConstraintViolationException){
            log.error("发生SQL异常:", e);
            // 最好能够在service逻辑层转成业务异常处理，再由下面的全局异常处理器进行处理
        }
        // 给后端看的
        log.error("发生异常", e);
        // 给前端看的
        return Result.error("操作失败,请联系管理员进行处理。");
    }

    // 自定义业务异常全局处理
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        // 如果是业务异常就直接返回给前端异常的错误信息
        return Result.error(e.getMessage());
    }
}

