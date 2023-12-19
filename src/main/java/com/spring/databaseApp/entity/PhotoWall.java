package com.spring.databaseApp.entity;

import java.io.Serializable;

public class PhotoWall implements Serializable{
    
    private int id;
    private String address;
    private boolean valid;
    
    public PhotoWall(int id,String address,boolean valid){
        this.id=id;
        this.address=address;
        this.valid=valid;
    }
    
    public void setPhoto(int id,String address,boolean valid){
        this.id=id;
        this.address=address;
        this.valid=valid;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isValid() {
        return valid;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    

}
