package com.spring.databaseApp.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.spring.databaseApp.entity.Comment;
import com.spring.databaseApp.entity.Vehicle;
import com.spring.databaseApp.mapper.CommentMapper;
import com.spring.databaseApp.mapper.UserMapper;
import com.spring.databaseApp.mapper.VehicleMapper;
import com.spring.databaseApp.service.exception.UserNotFound;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    VehicleMapper vehicleMapper;
    @Autowired
    UserMapper userMapper;

    public CommentService(){}

    public int comment(Comment comment){
        int vID=comment.getVehicleID();
        int uID=comment.getUserID();
        if(vehicleMapper.find_by_id(vID)==null){
            throw new UserNotFound("找不到该载具");
        }

        if(userMapper.find_by_id(uID)==null){
            throw new UserNotFound("找不到用户");
        }

        if(comment.getContent()==null){
            throw new UserNotFound("不允许空评论内容");
        }

        if(commentMapper.selectbyUser(vID,uID)==null){
        return commentMapper.insertContent(comment);
        }
        else{
            return change(vID,uID,comment.getContent(),comment.getPoint());
        }
    }

    public int change(int vID,int uID,String content,int Point){
        return commentMapper.changeComment(vID, uID,content,Point);
    }


    public int delete(int vID,int uID){
        return commentMapper.deleteComment(vID, uID);
    }

    public List<Comment> showTheCommentField(int vID){
        return commentMapper.selectbyID(vID);
    }

    public List<Vehicle> showTheRank(){
        List<Integer> co_rank=commentMapper.rank();
        List<Vehicle> ve_rank=new ArrayList<>();
        for(Integer i:co_rank){
            ve_rank.add(vehicleMapper.find_by_id(i.intValue()));
        }
        return ve_rank;
    }
}
