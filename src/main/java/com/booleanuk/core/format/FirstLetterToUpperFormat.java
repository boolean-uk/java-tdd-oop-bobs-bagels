package com.booleanuk.core.format;

public class FirstLetterToUpperFormat implements Format<String> {
    @Override
    public String result(String s) {
        return Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
    }
}
