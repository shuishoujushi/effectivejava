package com.charlie.effectjava.chapter6.i35;

/**
 * Created by charlie on 04/09/2017.
 */
// Program containing marker annotations
public class Sample {

    @Test
    public static void m1() {} // should pass

    public static void m2() {}

    @Test
    public static void m3() { // should fail
        throw new RuntimeException("Boom");
    }

    public static void m4() {}

    @Test
    public void m5() {} // invalid use: nonstatic method

    public static void m6() {}

    @Test
    public static void m7() { // should fail
        throw new RuntimeException("Crash");
    }

    public static void m8() {}
}
