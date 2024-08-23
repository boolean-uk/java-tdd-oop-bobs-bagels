package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    FillingTest(){

    }


    @Test
    public void getPriceTest(){
        Filling filling= new Filling("Egg");

        Assertions.assertEquals(0.12, filling.getPrice());

        Assertions.assertFalse(filling.canPurchase());

        Assertions.assertSame("FILE", filling.getSKU());
    }


}

