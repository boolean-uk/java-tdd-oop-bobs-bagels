package com.booleanuk.core.format;

public class FirstLetterToUpperFormat implements Format {
    @Override
    public String text(String s) {
        return Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
    }
}
