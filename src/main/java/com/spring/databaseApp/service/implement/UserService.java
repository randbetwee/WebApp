package com.spring.databaseApp.service.implement;

import com.spring.databaseApp.mapper.UserMapper;
import com.spring.databaseApp.service.exception.InsertException;
import com.spring.databaseApp.service.exception.PasswordMatchFailure;
import com.spring.databaseApp.service.exception.UserNotFound;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import com.spring.databaseApp.entity.*;

//业务层的功能，管理数据的存储方式


@Service
public class UserService {
    

    @Autowired
    private UserMapper user_mapper;

    
    
    public UserService() {
    }


    public int register(String name,String password,String email){
        User user=new User();
        user.setUser_type(true);
        user.setUser_name(name);
        user.setEmail(email);
        user.setSalt(UUID.randomUUID().toString().toUpperCase());
        user.setPassword(getMD5Password(password, user.getSalt()));
        int count=user_mapper.insert(user);
        if(count==1)return user.getId();
        else{ 
            throw new InsertException("插入产生未知错误");
        }
    }

    public User login(int userID ,String password){
        User user=user_mapper.find_by_id(userID);
        if(user==null){
            throw new UserNotFound("用户信息不存在");
        }
        
        String correctPassword=user.getPassword();
        String salt=user.getSalt();
        String md5Form=getMD5Password(password, salt);
        if(!md5Form.equals(correctPassword)){
            throw new PasswordMatchFailure("密码错误");
        }
        
        //将当前用户返回是为了上层可以对该用户信息进行调用
        return user;
    }


    private String getMD5Password(String password,String salt) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }


}
