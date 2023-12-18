package com.spring.databaseApp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.databaseApp.entity.Vehicle;
import com.spring.databaseApp.service.implement.VehicleService;
import com.spring.databaseApp.util.JsonResult;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
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

}
