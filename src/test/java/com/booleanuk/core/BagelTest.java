package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    BagelTest(){

    }


    @Test
    public void bagelPriceTest(){
        Bagel bagel=new Bagel("Plain");
        Assertions.assertEquals(0.49, bagel.getPrice());
        Bagel bagel0=new Bagel("Plain");
        bagel0.addFilling(new Filling("Egg"));
        bagel0.addFilling(new Filling("Egg"));
        Assertions.assertEquals(0.49+0.12, bagel0.getPrice());
        Assertions.assertTrue(bagel0.addFilling(new Filling("Bacon")));
        Assertions.assertTrue(bagel0.addFilling(new Filling("Cheese")));
        Assertions.assertEquals(0.49+0.12+0.12+0.12, bagel0.getPrice());
    }
}
