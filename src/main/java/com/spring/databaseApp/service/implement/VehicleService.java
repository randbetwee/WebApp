package com.spring.databaseApp.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.spring.databaseApp.entity.Aircraft;
import com.spring.databaseApp.entity.Vehicle;
import com.spring.databaseApp.mapper.VehicleMapper;
import com.spring.databaseApp.service.exception.CategoryMatchFailure;
import com.spring.databaseApp.service.exception.DuplicatedName;
import com.spring.databaseApp.service.exception.InsertException;
import com.spring.databaseApp.service.exception.NationMatchFailure;

@Service
public class VehicleService {
    @Autowired
    private VehicleMapper vechicleMapper;

    public VehicleService(){

    }


    //增
    public String  Upload_Aircraft(Aircraft air){
        String temp=air.getName();
        Aircraft find_air=vechicleMapper.find_by_name(temp);
        if(find_air!=null){
            throw new DuplicatedName("名字已被占用");
        }
        
        int count=vechicleMapper.insertAircraft(air);
        if(count!=0)return temp;
        else{
            throw new InsertException("上传飞机失败");
        }
    }

    public String Upload_Vehicle(Vehicle vec){
        String cate=vec.getCatag();
        List<String> categ=vechicleMapper.find_all_category();
        if(!categ.contains(cate)){
            throw new CategoryMatchFailure("找不到该类");
        }
        String nat=vec.getNation();
        List<String> nation=vechicleMapper.find_all_nation();
        if(!nation.contains(nat)){
            throw new NationMatchFailure("找不到该国家");
        }
        vechicleMapper.insertVehicle(vec);
        String name=new String();
        if(vec instanceof Aircraft){
            name=Upload_Aircraft((Aircraft)vec);
        }   
        else{
            name="-1";
            throw new InsertException("上传载具失败");
        }
        return name;
    }

    //查
    public List<Vehicle> Search_by_Category(String Category){
        List<String> categ=vechicleMapper.find_all_category();
        if(!categ.contains(Category)){
            throw new CategoryMatchFailure("找不到该类");
        }
        List<String> vec=vechicleMapper.find_by_cate(Category);
        List<Vehicle> air=new ArrayList<Vehicle>();
        for(String v:vec){
            air.add(vechicleMapper.find_by_name(v));
        }
        return air;
    }

    public List<Vehicle> Search_by_Nation(String nation){
        List<String> temp=vechicleMapper.find_all_nation();
        if(!temp.contains(nation)){
            throw new NationMatchFailure("找不到该国家");
        }
        List<Vehicle> list=vechicleMapper.find_by_nation(nation);
        return list;
    }

    public List<Vehicle> show_all(){
        List<Vehicle> list=vechicleMapper.find_all_Vehicles();
        return list;
    }

    public Vehicle show_vehicle(int id){
        Vehicle vec=vechicleMapper.find_by_id(id);
        return vec;
    }

    public Vehicle show_vechicle_detail(int id){
        Vehicle vec=vechicleMapper.find_by_id(id);
        String cat=vec.getCatag();
        switch(cat){
            case "aircraft":
                return vechicleMapper.find_by_name(vec.getName());
            
            default:
                throw new CategoryMatchFailure("搜索不到该项的类别");

        }
    }

    
    //删
    

    //改

}
