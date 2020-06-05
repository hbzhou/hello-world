package com.itsz.springboot.tdd.util;

public class MathUtil {
    public static double convertToDecimal(int i, int j) {
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return (double) i / (double) j;
    }

    public static boolean isEventNumber(int i) {
        return i % 2 == 0;
    }
}
