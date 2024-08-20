package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class FillingTest {
    @Test
    public void findPriceForFillingTest(){
        /*
        As a customer,
        So I don't over-spend,
        I'd like to know the cost of each filling before I add it to my bagel order.
         */
        Item item = Menu.getFillingFromMenu("Filling", "Bacon");
        assert item != null;

        Assertions.assertEquals(0.12, (double) item.getPrice() /100);
    }
}
