package com.spring.databaseApp.controller;

import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.databaseApp.service.exception.DuplicatedEmail;
import com.spring.databaseApp.service.exception.InsertException;
import com.spring.databaseApp.service.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.databaseApp.service.exception.InsertException;
import com.spring.databaseApp.service.exception.ServiceException;
import com.spring.databaseApp.service.exception.PasswordMatchFailure;
import com.spring.databaseApp.service.exception.UserNotFound;
import com.spring.databaseApp.util.JsonResult;

@RestController
@RequestMapping("error")
public class BaseController {
    
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handler(Throwable exception){
        JsonResult<Void> result=new JsonResult<Void>(exception);
        
        if(exception instanceof InsertException){
            result.setState(4000);
            result.setMessage("插入异常");
        }else if (exception instanceof UserNotFound){
            result.setState(5000);
            result.setMessage("找不到该用户");
        }
        else if(exception instanceof PasswordMatchFailure){
            result.setState(6000);
            result.setMessage("密码错误");
        }
        else if(exception instanceof DuplicatedEmail){
            result.setState(4001);
            result.setMessage("邮箱重复");
        }

        return result;
    }
    
}
