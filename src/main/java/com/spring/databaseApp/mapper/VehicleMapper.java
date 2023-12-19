package com.spring.databaseApp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.spring.databaseApp.entity.Aircraft;
import com.spring.databaseApp.entity.Category;
import com.spring.databaseApp.entity.Nation;
import com.spring.databaseApp.entity.Vehicle;

@Mapper
public interface VehicleMapper {

    Integer insertVehicle(Vehicle vec);

    Integer insertAircraft(Aircraft air);
    
    Integer insertNation(Nation nation);

    Integer insertCateg(Category cate);

    @Select("select * from aircraft")
    public List<Aircraft> find_all_Aircrafts();

    @Select("select * from vehicle")
    public List<Vehicle> find_all_Vehicles();

    @Select("select type from category")
    public List<String> find_all_category();

    @Select("select nation_name from nation")
    public List<String> find_all_nation();

    @Select("select * from vehicle where nation=#{nation}")
    public List<Vehicle> find_by_nation(String nation);

    @Select("select * from vehicle where id=#{id}")
    public Vehicle find_by_id(int id);

    public List<String> find_by_cate(String cate);

    public Aircraft find_by_name(String name);
}

