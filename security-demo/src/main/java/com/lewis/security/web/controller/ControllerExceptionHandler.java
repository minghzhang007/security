package com.lewis.security.web.controller;

import com.lewis.security.exception.UserNotException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/10.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = UserNotException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotException(UserNotException ex){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",ex.getId());
        map.put("message",ex.getMessage());
        return map;
    }
}
