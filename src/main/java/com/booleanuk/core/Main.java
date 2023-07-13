package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int INITIAL_CAPACITY = 5;
    public static void main(String[] args) {
        Manager bob = new Manager(INITIAL_CAPACITY);
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Cheese", "Ham", "Tuna", "Salmon", "Cheese", "Cheese"));
        strings.remove("Cheese");

        System.out.println(strings);
    }
}
