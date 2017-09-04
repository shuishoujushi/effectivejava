package com.charlie.effectjava.chapter6.i35;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by charlie on 04/09/2017.
 * Indicates that the annotated method is a test method
 * Use only parameterless static methods
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
