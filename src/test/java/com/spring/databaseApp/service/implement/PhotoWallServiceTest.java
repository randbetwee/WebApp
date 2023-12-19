package com.spring.databaseApp.service.implement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import com.spring.databaseApp.entity.PhotoWall;

@SpringBootTest
public class PhotoWallServiceTest {
    @Autowired
    PhotoWallService photoWallService;
    
    @Test
    void testAudit() {
        List<PhotoWall> photo=photoWallService.send_waiting_audit();
        PhotoWall pw=photo.get(0);
        photoWallService.audit(pw);
    }

    @Test
    void testSend_waiting_audit() {
        List<PhotoWall> photo=photoWallService.send_waiting_audit();
        System.out.println(photo);
    }

    @Test
    void testShow_detail() {
        
    }

    @Test
    void testUpload() {
        PhotoWall photo=new PhotoWall(538, "www.bing.com", false);
        photoWallService.upload(photo);
    }
}
