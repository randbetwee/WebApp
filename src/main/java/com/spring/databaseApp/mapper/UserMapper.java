package com.spring.databaseApp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.databaseApp.entity.*;
import java.util.*;

@Mapper
public interface UserMapper {
    Integer insert(User userdata);

    User find_by_username(String name);

    User find_by_id(int id);

    @Select("select * from app_user")
    public List<User> find_all(); 

    int count();
}
