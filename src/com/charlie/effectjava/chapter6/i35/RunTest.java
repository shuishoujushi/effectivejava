package com.charlie.effectjava.chapter6.i35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by charlie on 04/09/2017.
 */

// Program to process marker annotations
public class RunTest {
    private static void testStaticMethod(String className) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(className);
        for (Method m : testClass.getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception e) {
                    System.out.println("INVALID @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }

    private static void testExceptionMethod(String className) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(className);
        for (Method m : testClass.getMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }

                    if (passed == oldPassed) {
                        System.out.println(m + " failed: " + exc);
                    }
                } catch (Exception e) {
                    System.out.println("INVALID @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }

    public static void main(String[] args) throws Exception {
        testStaticMethod("com.charlie.effectjava.chapter6.i35.Sample");
        System.out.println("------------------------------------------");
        testExceptionMethod("com.charlie.effectjava.chapter6.i35.Sample2");
    }
}
