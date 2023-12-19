package com.spring.databaseApp.service.implement;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.databaseApp.entity.Comment;
import com.spring.databaseApp.entity.Vehicle;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    CommentService commentService;
    
    @Test
    void testComment() {
        Comment comment =new Comment();
        comment.setUserID(1);
        comment.setVehicleID(555);
        comment.setContent("very good");
        comment.setPoint(4);
        commentService.comment(comment);
    }

    @Test
    void testShowTheCommentField() {
        List<Comment> a=commentService.showTheCommentField(538);
        System.out.println(a);
    }

    @Test
    void testShowTheRank() {
        List<Vehicle> a=commentService.showTheRank();
        System.out.println(a);
    }
}
