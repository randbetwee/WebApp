package com.spring.databaseApp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.databaseApp.entity.Vehicle;
import com.spring.databaseApp.service.exception.UserNotFound;
import com.spring.databaseApp.service.implement.VehicleService;
import com.spring.databaseApp.util.JsonResult;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
public class VehicleController extends BaseController {
    @Autowired
    VehicleService vehicleService;

    @RequestMapping("")
    public JsonResult<List<Vehicle>> first_page(){
        List<Vehicle> vec=vehicleService.show_all();
        JsonResult<List<Vehicle>> result=new JsonResult<List<Vehicle>>(200, vec);
        return result;
    }

    @RequestMapping("upload/vehicle")
    public JsonResult<Void> upload(Vehicle vec){
        vehicleService.Upload_Vehicle(vec);
        return new JsonResult<Void>(200);
    }

    @RequestMapping("{vid}")
    public JsonResult<Vehicle> detail_page(@PathVariable("vid") Integer vid) {
        Vehicle vec=vehicleService.show_vechicle_detail(vid);
        if(vec==null){
            throw new UserNotFound("找不到该载具详细信息");
        }
        Vehicle temp=vehicleService.show_vehicle(vid);
        vec.setVehicle(temp.getCatag(), temp.getId(), temp.getNation(), temp.getName(), temp.getPicture());
        return new JsonResult<Vehicle>(200,vec);
    }
    
    @RequestMapping("/type/{cate}")
    public JsonResult<List<Vehicle>> search_by_cate(@PathVariable("cate") String cate){
        List<Vehicle> vec=vehicleService.Search_by_Category(cate);
        JsonResult<List<Vehicle>> result=new JsonResult<List<Vehicle>>(200, vec);
        return result;
    }

    @RequestMapping("/nation/{Nat}")
    public JsonResult<List<Vehicle>> search_by_nat(@PathVariable("Nat") String Nat){
        List<Vehicle> vec=vehicleService.Search_by_Nation(Nat);
        JsonResult<List<Vehicle>> result=new JsonResult<List<Vehicle>>(200, vec);
        return result;
    }
}
