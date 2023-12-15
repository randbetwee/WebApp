package com.spring.databaseApp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.databaseApp.entity.User;

@SpringBootTest
public class userMapperTest {
    @Autowired
    private UserMapper testmapper;

    @Test
    public void test_mapper(){
        User user = new User();
        user.setId(1);
        user.setUser_name("Luo");
        user.setUser_type(false);
        Integer rows=testmapper.insert(user);
        System.out.println(rows);

    }
}
