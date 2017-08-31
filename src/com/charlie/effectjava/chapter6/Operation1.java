package com.charlie.effectjava.chapter6;

/**
 * Created by charlie on 31/08/2017.
 */
public enum Operation1 {
    PLUS, MINUS, TIMES, DIVIDE;

    double apply(double x, double y) {
        switch (this) {
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }
}
