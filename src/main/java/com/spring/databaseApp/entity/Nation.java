package com.spring.databaseApp.entity;

import java.io.Serializable;

public class Nation implements Serializable{
    private String nation_name;

    public String getNation_name() {
        return nation_name;
    }

    public void setNation_name(String nation_name) {
        this.nation_name = nation_name;
    }
}
