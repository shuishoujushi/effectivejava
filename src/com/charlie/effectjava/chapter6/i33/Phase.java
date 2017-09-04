package com.charlie.effectjava.chapter6.i33;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by charlie on 04/09/2017.
 */

// Using a nested EnumMap to associate data with enum pairs
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase src;
        private final Phase dest;

        Transition(Phase src, Phase dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Initialize the phase transition map
    private static final Map<Phase, Map<Phase, Transition>> m = new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);

    static {
        for (Phase p : Phase.values()) {
            m.put(p, new EnumMap<Phase, Transition>(Phase.class));
        }

        for (Transition trans : Transition.values()) {
            m.get(trans.src).put(trans.dest, trans);
        }
    }

    public static Transition from(Phase src, Phase dest) {
        return m.get(src).get(dest);
    }

    public static void main(String[] args) {
        System.out.println(m);
    }
}
