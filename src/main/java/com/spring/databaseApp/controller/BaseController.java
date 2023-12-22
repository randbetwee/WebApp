package com.spring.databaseApp.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.databaseApp.service.exception.CategoryMatchFailure;
import com.spring.databaseApp.service.exception.DuplicatedEmail;
import com.spring.databaseApp.service.exception.DuplicatedName;
import com.spring.databaseApp.service.exception.InsertException;
import com.spring.databaseApp.service.exception.NationMatchFailure;
import com.spring.databaseApp.service.exception.FileUploadFailed;
import com.spring.databaseApp.service.exception.ServiceException;

import com.spring.databaseApp.service.exception.PasswordMatchFailure;
import com.spring.databaseApp.service.exception.UserNotFound;
import com.spring.databaseApp.util.JsonResult;

import jakarta.servlet.http.HttpSession;


public class BaseController {
    
    @ExceptionHandler({ServiceException.class})
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
        else if(exception instanceof DuplicatedName){
            result.setState(4002);
            result.setMessage("名字重复");
        }
        else if(exception instanceof CategoryMatchFailure){
            result.setState(5001);
            result.setMessage("找不到此类");
        }
        else if(exception instanceof NationMatchFailure){
             result.setState(5002);
            result.setMessage("找不到该国家");
        }
        else if(exception instanceof FileUploadFailed){
            result.setState(3000);
            result.setMessage("文件上传失败");
        }

        return result;
    }
    
    

    public final Integer getUidFromSession(HttpSession session) {
        //getAttribute返回的是Object对象,需要转换为字符串再转换为包装类
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    public final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

}
