package com.spring.databaseApp.entity;

import java.io.Serializable;


public class User implements Serializable{
    private int id;
	private String user_name;
	private boolean user_type;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public boolean isUser_type() {
        return user_type;
    }
    public void setUser_type(boolean user_type) {
        this.user_type = user_type;
    }
    
    
}
