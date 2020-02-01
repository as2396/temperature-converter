package com.example.temperature_converter;

public class ConvertTemp {
    public static double c2f(double celsius) { return (celsius * 9.0 / 5.0 + 32.0); }

    public static double f2c(double fahrenheit) {
        return ((fahrenheit - 32) * (5 / 9.0));
    }

    public static double c2k(double celsius) {
        return (celsius + 273.15);
    }

    public static double k2c(double kelvin) {
        return (kelvin - 273.15);
    }

    public static double f2k(double fahrenheit) {
        double temp = ConvertTemp.f2c(fahrenheit);
        return ConvertTemp.c2k(temp);
    }

    public static double k2f(double kelvin) {
        double temp = ConvertTemp.k2c(kelvin);
        return ConvertTemp.c2f(temp);
    }

    public static double r2c(double rankine){return (rankine-491.67)*5.0/9.0;}

    public static double c2r(double celsius){return celsius*9.0/5.0 +491.67;}

    public static double f2r(double fahrenheit){return fahrenheit + 459.67;}

    public static double k2r(double kelvin){return kelvin*1.8;}

    public static double r2f(double rankine){return rankine-459.67;}

    public static double r2k(double rankine){return rankine*5.0/9.0;}
}
