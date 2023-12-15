package com.spring.databaseApp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.databaseApp.entity.*;;

@Mapper
public interface UserMapper {
    Integer insert(User userdata);


    User find_by_username(String name);


}
