package com.spring.databaseApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.databaseApp.service.exception.InsertException;
import com.spring.databaseApp.service.implement.UserService;
import com.spring.databaseApp.util.JsonResult;

@RestController
@RequestMapping("users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("reg") 
    public JsonResult<Void> reg(String user,String password,String email){
        
        JsonResult<Void> result =new JsonResult<>();
        try{
            userService.register(user,password,email);
            result.setState(200);
            result.setMessage("注册成功");
        } catch(InsertException ex){
            result.setState(4000);
            result.setMessage("插入出现异常");
        }

        return result;
    }

}
