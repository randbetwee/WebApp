package com.spring.databaseApp.entity;

import java.io.Serializable;

public class Vehicle implements Serializable{
    private String catag ;
	private int id;
	private String nation;
    private String name;


    

    public Vehicle() {
    }


    public void setVehicle(String catag,int id,String nation,String name){
        this.catag=catag;
        this.id=id;
        this.nation=nation;
        this.name=name;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCatag() {
        return catag;
    }
    public void setCatag(String catag) {
        this.catag = catag;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    
}
