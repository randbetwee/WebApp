package com.spring.databaseApp.entity;

import java.io.Serializable;

public class Category implements Serializable{
    private String type;
    private int count;


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    
}
