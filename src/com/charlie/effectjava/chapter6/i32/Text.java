package com.charlie.effectjava.chapter6.i32;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by charlie on 04/09/2017.
 */

// using EnumSet rather than bit fields
public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH};

    public void applyStyles(Set<Style> styles) {

    }

    public static void main(String[] args) {
        Text t = new Text();
        t.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
