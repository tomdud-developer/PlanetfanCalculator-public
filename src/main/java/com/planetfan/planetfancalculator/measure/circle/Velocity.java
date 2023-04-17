package com.planetfan.planetfancalculator.measure.circle;

public class Velocity {
    Integer id;
    Double velocity;
    String velocityUnit;
    Double len;
    String lenUnit;


    public Velocity(Integer id, Double v, String vUnit, Double len, String lenUnit) {
        this.id = id;
        this.velocity = v;
        this.velocityUnit = vUnit;
        this.len = len;
        this.lenUnit = lenUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVelocity() {
        return velocity;
    }

    public void setVelocity(Double velocity) {
        this.velocity = velocity;
    }

    public String getVelocityUnit() {
        return velocityUnit;
    }

    public void setVelocityUnit(String velocityUnit) {
        this.velocityUnit = velocityUnit;
    }

    public Double getLen() {
        return len;
    }

    public void setLen(Double len) {
        this.len = len;
    }

    public String getLenUnit() {
        return lenUnit;
    }

    public void setLenUnit(String lenUnit) {
        this.lenUnit = lenUnit;
    }
}

