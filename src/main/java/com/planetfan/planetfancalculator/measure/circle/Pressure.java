package com.planetfan.planetfancalculator.measure.circle;

public class Pressure {
    Integer id;
    Double pressure;
    String pressureUnit;
    Double len;
    String lenUnit;


    public Pressure(Integer id, Double pressure, String pressureUnit, Double len, String lenUnit) {
        this.id = id;
        this.pressure = pressure;
        this.pressureUnit = pressureUnit;
        this.len = len;
        this.lenUnit = lenUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(String pressureUnit) {
        this.pressureUnit = pressureUnit;
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
