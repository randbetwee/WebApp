package com.spring.databaseApp.entity;

import java.io.Serializable;

public class Comment implements Serializable{
    int vehicleID;
    int userID;
    int point;   //打分
    String content;
    
    public Comment() {
    }

     public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setComment(int vID,int uID,String c){
        this.vehicleID=vID;
        this.userID=uID;
        this.content=c;
    }

    public int getVehicleID() {
        return vehicleID;
    }
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
}
