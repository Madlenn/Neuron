package com.company;
/**
 * Klasa Sigmoid posiada dwie metody zwracające
 * *wyniki funkcji
 * wartość pochodnej
 *
 * @author MS
 */

import java.lang.Math;

public class Sigmoid {
    public static double f(double x) {
        double ex = Math.exp(-x);
        return 1 / (1 + ex);
    }

    public static double der(double x) {

        return x * (1 - x);
    }

}
