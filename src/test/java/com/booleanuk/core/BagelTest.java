package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BagelTest {
    @Test
    public void testBagel(){

        ArrayList<String> fillings = new ArrayList<>();
        fillings.add("Bacon");
        fillings.add("Cheese");
        Bagel bagel = new Bagel("Everything", fillings);


    }

}
