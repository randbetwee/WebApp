package com.spring.databaseApp.service.implement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.spring.databaseApp.entity.Aircraft;
import com.spring.databaseApp.entity.Vehicle;

import java.io.*;

@SpringBootTest
public class VehicleServiceTest {
    @Autowired
    VehicleService vService;
    
    @Test
    void testUpload_Aircraft() {
        List<Vehicle> a=vService.show_all();
        System.out.println(a);
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
            if(i>0){
                Aircraft vec=new Aircraft();
                vec.setVehicle(row[15],0,row[14],row[0]);
                vec.setAircraft(row[0], row[1],Integer.parseInt(row[2]), 
                    row[3], row[4], row[5], row[6], row[7], 
                    row[8], row[9], row[10], row[11], row[12], row[13]);
                vService.Upload_Vehicle(vec);
            }
            
            i++;
        }
        
        
        }catch(IOException|CsvException e){
            e.printStackTrace();
        }
    }


}
