package com.charlie.effectjava.chapter6.i30;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by charlie on 31/08/2017.
 */
public class EnumUtil {

    // to support enum.valueOf(String)
    // implementing a fromString method on a enum type
    private static final Map<String, Operation> stringToEnum = new HashMap<>();

    // initialize map from constant name to enum constant
    static {
        for (Operation o : Operation.values()) {
            stringToEnum.put(o.toString(), o);
        }
    }

    // return Operations for String, or null if String is invalid
    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}
