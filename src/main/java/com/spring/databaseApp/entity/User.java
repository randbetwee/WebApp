package com.spring.databaseApp.entity;

import java.io.Serializable;


public class User implements Serializable{
    private int id;
	private String user_name;
	private boolean user_type;  //0为管理员，1为普通用户
    private String password;
    private String salt;
    private String email;
    
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
    
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
