package com.spring.databaseApp.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.databaseApp.entity.Comment;

@Mapper
public interface CommentMapper {
    
    int insertContent(Comment comment);

    int deleteComment(int vID,int uID);

    List<Comment> selectbyID(int vID);

    @Select("select * from comment where id=#{vID} and userID=#{uID}")
    Comment selectbyUser(int vID,int uID);

    int changeComment(int vID,int uID,String content,int point);

    Integer mean(int vID);

    //返回只有id和point有意义
    List<Integer> rank();
    
}
