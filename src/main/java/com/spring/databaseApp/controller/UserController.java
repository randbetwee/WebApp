package com.spring.databaseApp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.databaseApp.service.implement.UserService;
import com.spring.databaseApp.util.JsonResult;
import com.spring.databaseApp.entity.User;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    
    @Autowired
    private UserService userService;

    @RequestMapping("reg") 
    public JsonResult<Void> reg(String user,String password,String email){
       
        userService.register(user, password, email);
        return new JsonResult<Void>(200);
    }

    @RequestMapping("login")
    public JsonResult<User> login(int UserID,String password,HttpSession session){
        User user=userService.login(UserID, password);
        session.setAttribute("id",user.getId());
        session.setAttribute("username",user.getUser_name());
        session.setAttribute("type",user.isUser_type());
        return new JsonResult<User>(200, user);
    }

    

}
