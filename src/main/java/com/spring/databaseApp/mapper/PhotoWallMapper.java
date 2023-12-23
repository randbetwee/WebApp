package com.spring.databaseApp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import com.spring.databaseApp.entity.PhotoWall;

@Mapper
public interface PhotoWallMapper {
    
    int insertPhoto(PhotoWall photo);

    int deletePhoto(int id,String address);

    @Select("select * from photowall where id=#{id}")
    List<PhotoWall> select_by_id(int id);

    @Select("select * from photowall where id=#{id} and valid=true")
    List<PhotoWall> select_by_id_valid(int id);

    @Select("select * from photowall where valid=#{b}")
    List<PhotoWall> select_by_valid(boolean b);

    @Select("select * from photowall where id=#{id} and address=#{addr}")
    PhotoWall select_by_key(int id,String addr);

    int update_valid(PhotoWall photo);
}
