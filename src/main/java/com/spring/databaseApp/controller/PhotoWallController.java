package com.spring.databaseApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.spring.databaseApp.service.exception.FileUploadFailed;
import com.spring.databaseApp.service.implement.PhotoWallService;
import com.spring.databaseApp.service.implement.VehicleService;
import com.spring.databaseApp.util.JsonResult;
import jakarta.servlet.http.HttpServletRequest;
import com.spring.databaseApp.entity.PhotoWall;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
public class PhotoWallController extends BaseController{
    @Autowired
    PhotoWallService photoWallService;

    @Autowired 
    VehicleService vehicleService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    static final String uploadPath="./Data/";
    static final String PathStrip="Data/";

     @RequestMapping("{vid}/photowall")              //打开某个飞机的照片墙
    public JsonResult<List<PhotoWall>> showPhotoWall(@PathVariable("vid") Integer vid){
        //List<PhotoWall> photowall=photoWallService.show_detail_valid(vid);
        List<PhotoWall> photowall=photoWallService.show_detail(vid);  //无需审核
        return new JsonResult<List<PhotoWall>>(200,photowall); 
    }

    @RequestMapping("admin/auditview")          //审核视角，专门给管理员审核未审核的图片
    public JsonResult<List<PhotoWall>> auditView() {
        
        List<PhotoWall> photowall=photoWallService.send_waiting_audit();
        return new JsonResult<List<PhotoWall>>(200,photowall);
    }
    

    @RequestMapping("admin/audit")        //审核图片
    public JsonResult<Void> AuditPhoto(int id,String address) {
       PhotoWall photo=new PhotoWall(id, address, false);
       photoWallService.audit(photo); 
        if(vehicleService.show_vehicle(id).getPicture().equals("0")){
            vehicleService.show_vehicle(id).setPicture(address);
        }
        return new JsonResult<Void>(200);
    }
    

    @PostMapping("/upload/photo")           //上传图片，自动标为未审核
    public JsonResult<String> upload_Photo(
                                    @RequestParam(value = "id") int vid,
                                    @RequestParam(value = "File") MultipartFile uploadFile,
                                    HttpServletRequest request) {

        String format = sdf.format(new Date());
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        // 对上传的文件重命名，避免文件重名
        String oldName = uploadFile.getOriginalFilename();
        try{
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        
            // 文件保存
            uploadFile.transferTo((new File(folder, newName)).getAbsoluteFile());

            // 返回上传文件的访问路径
            String filePath = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort()  +"/"+ PathStrip + format + newName;
            
            //将文件路径写入
            PhotoWall photo=new PhotoWall(vid, filePath, false);
            photoWallService.upload(photo);

            return new JsonResult<String>(200, filePath);
        } catch (IOException | NullPointerException e) {
            throw new FileUploadFailed("上传图片失败，检查文件名是否为空");
        }

    }
    
}
