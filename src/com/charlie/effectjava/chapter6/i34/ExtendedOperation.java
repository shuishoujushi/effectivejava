package com.charlie.effectjava.chapter6.i34;

/**
 * Created by charlie on 04/09/2017.
 */
public enum ExtendedOperation implements Operation {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;
    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (Operation op : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        /*for (ExtendedOperation eOp : ExtendedOperation.values()) {
            System.out.printf("%f %s %f = %f%n", x, eOp, y, eOp.apply(x, y));
        }*/
        test(ExtendedOperation.class, x, y);
    }
}
