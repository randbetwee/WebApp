package com.spring.databaseApp.entity;



public class Aircraft extends Vehicle{
    private String name;
    private String Type;
    private int	Crew;
    private String min_speed;
    private String	max_speed;
    private String	wing_span;
    private String	Height;
    private String	Length;
    private String	max_payload;
    private String	empty_weight;
    private String	max_weight;
    private String	Operator;
    private String	Commissioned;
    private String	Propulsion;


    public Aircraft() {
    }

    public void setAircraft(String name,String Type,int Crew,String min_speed,
                                String max_speed,String wingspan,String height,
                                String length,String max_payload,String empty_weight,
                                String max_weight,String operator,String commision,String propulsion){
            this.name=name;
            this.Type=Type;
            this.Crew=Crew;
            this.min_speed=min_speed;
            this.max_speed=max_speed;
            this.wing_span=wingspan;
            this.Height=height;
            this.Length=length;
            this.max_payload=max_payload;
            this.empty_weight=empty_weight;
            this.max_weight=max_weight;
            this.Operator=operator;
            this.Commissioned=commision;
            this.Propulsion=propulsion;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    public int getCrew() {
        return Crew;
    }
    public void setCrew(int crew) {
        Crew = crew;
    }
    public String getmin_speed() {
        return min_speed;
    }
    public void setmin_speed(String min_speed) {
        this.min_speed = min_speed;
    }
    public String getmax_speed() {
        return max_speed;
    }
    public void setmax_speed(String max_speed) {
        max_speed = max_speed;
    }
    public String getwing_span() {
        return wing_span;
    }
    public void setwing_span(String wingspan) {
        wing_span = wingspan;
    }
    public String getHeight() {
        return Height;
    }
    public void setHeight(String height) {
        Height = height;
    }
    public String getLength() {
        return Length;
    }
    public void setLength(String length) {
        Length = length;
    }
    public String getmax_payload() {
        return max_payload;
    }
    public void setmax_payload(String max_payload) {
        max_payload = max_payload;
    }
    public String getempty_weight() {
        return empty_weight;
    }
    public void setempty_weight(String empty_weight) {
        empty_weight = empty_weight;
    }
    public String getmax_weight() {
        return max_weight;
    }
    public void setmax_weight(String max_weight) {
        max_weight = max_weight;
    }
    public String getOperator() {
        return Operator;
    }
    public void setOperator(String operator) {
        Operator = operator;
    }
    public String getCommissioned() {
        return Commissioned;
    }
    public void setCommissioned(String commissioned) {
        Commissioned = commissioned;
    }
    public String getPropulsion() {
        return Propulsion;
    }
    public void setPropulsion(String propulsion) {
        Propulsion = propulsion;
    }

}
