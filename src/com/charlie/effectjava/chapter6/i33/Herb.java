package com.charlie.effectjava.chapter6.i33;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by charlie on 04/09/2017.
 */


// Using an EnumMap to associate data with an enum, do not use ordinal
public class Herb {
    public enum Type {ANNUAL, PERENNIAL, BIENNIAL};

    private final String name;
    private final Type type;

    Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<Type, Set<Herb>>(Herb.Type.class);
        for (Herb.Type t : Herb.Type.values()) {
            herbsByType.put(t, new HashSet<>());
        }

        Herb herb0 = new Herb("FirstHerb", Type.ANNUAL);
        Herb[] garden = new Herb[]{herb0};
        for (Herb h : garden) {
            herbsByType.get(h.type).add(h);
        }

        System.out.println(herbsByType);
    }
}
