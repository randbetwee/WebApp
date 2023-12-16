package com.spring.databaseApp.service.implement;

import com.spring.databaseApp.mapper.UserMapper;
import com.spring.databaseApp.service.exception.InsertException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import com.spring.databaseApp.entity.*;

//业务层的功能，管理数据的存储方式

@Transactional
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

    private String getMD5Password(String password,String salt) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }


}
