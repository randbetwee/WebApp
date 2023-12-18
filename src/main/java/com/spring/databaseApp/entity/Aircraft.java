package com.spring.databaseApp.entity;



public class Aircraft extends Vehicle{
    private String name;
    private String Type;
    private int	Crew;
    private String min_Speed;
    private String	Max_speed;
    private String	Wingspan;
    private String	Height;
    private String	Length;
    private String	Max_payload;
    private String	Empty_weight;
    private String	Max_weight;
    private String	Operator;
    private String	Commissioned;
    private String	Propulsion;


    public Aircraft() {
    }

    public void setAircraft(String name,String Type,int Crew,String min_Speed,
                                String max_speed,String wingspan,String height,
                                String length,String max_payload,String empty_weight,
                                String max_weight,String operator,String commision,String propulsion){
            this.name=name;
            this.Type=Type;
            this.Crew=Crew;
            this.min_Speed=min_Speed;
            this.Max_speed=max_speed;
            this.Wingspan=wingspan;
            this.Height=height;
            this.Length=length;
            this.Max_payload=max_payload;
            this.Empty_weight=empty_weight;
            this.Max_weight=max_weight;
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
    public String getMin_Speed() {
        return min_Speed;
    }
    public void setMin_Speed(String min_Speed) {
        this.min_Speed = min_Speed;
    }
    public String getMax_speed() {
        return Max_speed;
    }
    public void setMax_speed(String max_speed) {
        Max_speed = max_speed;
    }
    public String getWingspan() {
        return Wingspan;
    }
    public void setWingspan(String wingspan) {
        Wingspan = wingspan;
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
    public String getMax_payload() {
        return Max_payload;
    }
    public void setMax_payload(String max_payload) {
        Max_payload = max_payload;
    }
    public String getEmpty_weight() {
        return Empty_weight;
    }
    public void setEmpty_weight(String empty_weight) {
        Empty_weight = empty_weight;
    }
    public String getMax_weight() {
        return Max_weight;
    }
    public void setMax_weight(String max_weight) {
        Max_weight = max_weight;
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
