package com.spring.databaseApp.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.spring.databaseApp.entity.PhotoWall;
import com.spring.databaseApp.entity.Vehicle;
import com.spring.databaseApp.mapper.PhotoWallMapper;
import com.spring.databaseApp.mapper.VehicleMapper;
import com.spring.databaseApp.service.exception.UserNotFound;

@Service
public class PhotoWallService {
    @Autowired
    PhotoWallMapper photoWallMapper;
    @Autowired
    VehicleMapper vehicleMapper;

    public int upload(PhotoWall photo){
        int vid=photo.getId();
        Vehicle temp_v=vehicleMapper.find_by_id(vid);
        if(temp_v==null){
            throw new UserNotFound("插入图片没有该对应载具id");
        }
        photo.setValid(false);
        return photoWallMapper.insertPhoto(photo);
    }

    public List<PhotoWall> send_waiting_audit(){
        List<PhotoWall> list=photoWallMapper.select_by_valid(false);
        return list;
    }

    public int audit(PhotoWall photo){
        int id=photo.getId();
        String addr=photo.getAddress();
        PhotoWall temp=photoWallMapper.select_by_key(id,addr);
        if(temp==null){
            throw new UserNotFound("找不到图片");
        }
        photo.setValid(true);
        return photoWallMapper.update_valid(photo);
    }

    public int delete(PhotoWall photo){
        int id=photo.getId();
        String addr=photo.getAddress();
        PhotoWall temp=photoWallMapper.select_by_key(id,addr);
        if(temp==null){
            throw new UserNotFound("找不到图片");
        }
        return photoWallMapper.deletePhoto(id, addr);
    }

    public List<PhotoWall> show_detail(int id){
        Vehicle temp_v=vehicleMapper.find_by_id(id);
        if(temp_v==null){
            throw new UserNotFound("找不到该载具");
        }
        return photoWallMapper.select_by_id_valid(id);
    }
}
