package com.planetfan.planetfancalculator.measure.rectangle;

public class Data {
    int id;
    double col1;
    double col2;
    double col3;
    double col4;
    double col5;
    double col6;

    public Data(int id, double col1, double col2, double col3, double col4, double col5, double col6) {
        this.id = id;
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.col4 = col4;
        this.col5 = col5;
        this.col6 = col6;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCol1() {
        return col1;
    }

    public void setCol1(double col1) {
        this.col1 = col1;
    }

    public double getCol2() {
        return col2;
    }

    public void setCol2(double col2) {
        this.col2 = col2;
    }

    public double getCol3() {
        return col3;
    }

    public void setCol3(double col3) {
        this.col3 = col3;
    }

    public double getCol4() {
        return col4;
    }

    public void setCol4(double col4) {
        this.col4 = col4;
    }

    public double getCol5() {
        return col5;
    }

    public void setCol5(double col5) {
        this.col5 = col5;
    }

    public double getCol6() {
        return col6;
    }

    public void setCol6(double col6) {
        this.col6 = col6;
    }

    public double getSum() {
        return col1 + col2 + col3 + col4 + col5 + col6;
    }
}
