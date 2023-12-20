package com.spring.databaseApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.databaseApp.entity.Comment;
import com.spring.databaseApp.entity.Vehicle;
import com.spring.databaseApp.service.implement.CommentService;
import com.spring.databaseApp.util.JsonResult;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CommentController extends BaseController{
    @Autowired
    private CommentService commentService;

    @RequestMapping("/rank")         //发送排行榜
    public JsonResult<List<Vehicle>> sendRank() {
        List<Vehicle> rank=commentService.showTheRank();
        return new JsonResult<List<Vehicle>>(200,rank);
    }
    
    
    @RequestMapping("{vid}/commentpage")     //打开某个飞机的评论区
    public JsonResult<List<Comment>> showComment(@PathVariable("vid") Integer vid){
        List<Comment> comment=commentService.showTheCommentField(vid);
        return new JsonResult<List<Comment>>(200,comment); 
    }
    

    
    @RequestMapping("{vid}/comment")         //接受某个飞机的评论区
    public JsonResult<Void> commentrequest(Comment c,HttpServletRequest request){
        Object a=request.getSession().getAttribute("id");
        c.setUserID(Integer.parseInt(a.toString()));
        commentService.comment(c);
        return new JsonResult<Void>(200); 
    }
    

}
