package com.charlie.effectjava.chapter6.i31;

/**
 * Created by charlie on 04/09/2017.
 */
public enum Ensemble {
    // don't use ordinal to derive an associate value

    SOLO(1),
    DUET(2),
    TRIO(3),
    QUARTET(4),
    QUINTET(5),
    SEXTET(6),
    SEPTET(7),
    OCTET(8),
    DOUBLE_QUARTET(8),
    NONET(9),
    DECTET(10),
    TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int getNumberOfMusicians() {
        return this.numberOfMusicians;
    }
}
