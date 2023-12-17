package com.spring.databaseApp.service.implement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.spring.databaseApp.entity.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    
    @Test
    void testRegister() {
        
        userService.register("user001","6296393","169@qq.com");
    }

    @Test
    void testLogin() {
        User user=userService.login(1, "Chong@246");
        System.out.println(user);   
    }
}
