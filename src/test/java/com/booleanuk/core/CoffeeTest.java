package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    CoffeeTest(){

    }

    @Test
    public void getCoffeePriceTest(){
        Coffee black=new Coffee("Black");
        Assertions.assertEquals(0.99, black);
    }
}
