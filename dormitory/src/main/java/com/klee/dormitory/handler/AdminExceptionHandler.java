package com.klee.dormitory.handler;

import com.klee.dormitory.exception.AdminAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminExceptionHandler {

    //拦截登陆异常
    @ExceptionHandler(value = AdminAuthorizeException.class)
    public String handleAuthorizeException(){
        return "login";
    }
}
