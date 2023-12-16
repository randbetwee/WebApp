package com.spring.databaseApp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import com.spring.databaseApp.entity.User;

@SpringBootTest
public class userMapperTest {
    @Autowired
    private UserMapper testmapper;

    @Test
    public void test_mapper(){
        User user = new User();
        user.setId(0);
        user.setEmail("1206697063@qq.com");
        user.setSalt(UUID.randomUUID().toString().toUpperCase());
        String password="Chong@246";
        user.setPassword(getMD5Password(password, user.getSalt()));
        user.setUser_name("Guan");
        user.setUser_type(false);
        Integer rows=testmapper.insert(user);
        System.out.println(rows);

    }

    private String getMD5Password(String password,String salt) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
