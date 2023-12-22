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
        
        userService.register("guan","Chong@246","1206697063@qq.com");
    }

    @Test
    void testLogin() {
        User user=userService.login(1, "ggg6296393");
        System.out.println(user);   
    }

    @Test
    void testChanging() {
        int user=userService.change_password("1206697063@qq.com", "ggg6296393");
        System.out.println(user);   
    }
}
