package com.planetfan.planetfancalculator.calculators;

public class Mass {

    public static double sheet(double s, double d, double h, double density) {
        return s * d * h * density / 1000 / 1000 / 1000;
    }

    public static double rod(double s, double d, double density) {
        return Math.PI * Math.pow(s, 2) / 4 * d * density / 1000 / 1000 / 1000;
    }

    public static double tube(double s, double c, double d, double density) {
        return ((Math.PI * Math.pow(s, 2) / 4) -  (Math.PI * Math.pow(s - 2*c, 2) / 4)) * d * density / 1000 / 1000 / 1000;
    }

    public static double squareProfile(double hs, double d, double c, double density) {
        return ( (hs * hs) - (Math.pow(hs - 2*c, 2)) ) * d * density / 1000 / 1000 / 1000;
    }

    public static double rectangleProfile(double h, double s, double d, double c, double density) {
        return ( (h * s) - ((h-2*c) * (s-2*c))) * d * density / 1000 / 1000 / 1000;
    }


    public static double angleProfile(double h, double s, double c, double d, double densisty) {
        return ( h + s - 0.6*c ) * c * d * densisty /1000/1000/1000;
    }

    public static double tee(double h, double s, double c, double d, double densisty) {
        return (h + s + s - 2 * c) * c * d /1000/1000/1000 * densisty;
    }
}
