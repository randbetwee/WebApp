package com.spring.databaseApp.mapper;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.spring.databaseApp.entity.Aircraft;
import com.spring.databaseApp.entity.Category;

@SpringBootTest
public class VehicleMapperTest {
    @Autowired
    VehicleMapper vec_map;
    
    @Test
    void testFind_all_Aircrafts() {
        vec_map.find_all_Aircrafts();
    }

    @Test
    void testFind_all_Vehicles() {

    }

    @Test
    void testFind_by_cate() {

    }

     @Test
    void testUpload_Vehicle() {
        String csvFilePath = "../dataFetcher/China_aircraft.csv";

        try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvFilePath)).build()){
            // 读取所有行
        List<String[]> allData = csvReader.readAll();

            // 遍历行
        int i=0;
        for (String[] row : allData) {
                // 遍历列
            if(i>1){
                Aircraft vec=new Aircraft();
                //vec.setVehicle(row[15],0,row[14],row[0]);
                vec.setAircraft(row[0], row[1],Integer.parseInt(row[2]), 
                    row[3], row[4], row[5], row[6], row[7], 
                    row[8], row[9], row[10], row[11], row[12], row[13]);
                vec_map.insertAircraft(vec);
            }
            
            i++;
        }
        
        
        }catch(IOException|CsvException e){
            e.printStackTrace();
        }
    }

    @Test
    void testInsertCateg() {
        Category cat=new Category();
        cat.setCount(0);
        cat.setType("spaceship");
        vec_map.insertCateg(cat);
    }

    @Test
    void testInsertNation() {

    }

    @Test
    void testInsertVehicle() {

    }
}
