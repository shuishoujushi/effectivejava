package com.charlie.effectjava.chapter6.i30;

/**
 * Created by charlie on 31/08/2017.
 */
public enum Operation {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    public static void main(String[] args) {
        String[] strs = new String[] {"2", "4"};
        double x = Double.parseDouble(strs[0]);
        double y = Double.parseDouble(strs[1]);

        for (Operation o : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, o, y, o.apply(x, y));
        }
    }
}
