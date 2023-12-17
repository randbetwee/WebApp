package com.spring.databaseApp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    public UserController a;
    @Test
    public void testLogin() {
       
        a.reg("testuser1","6296393","456@qq.com");
    }

    @Test
    void testReg() {
        //a.login(1, "Chong@246");
    }
}
