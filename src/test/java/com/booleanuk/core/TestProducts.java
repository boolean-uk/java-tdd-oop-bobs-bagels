package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestProducts {
    @Test
    public void testProduct(){
        Product p1 = new Bagel("BGLO");
        Product p2 = new Bagel("BGLP");
        Product p3 = new Bagel("BGLE");
        Product p4 = new Bagel("BGLS");
        Product p5 = new Coffee("COFB");
        Product p6 = new Coffee("COFW");
        Product p7 = new Coffee("COFC");
        Product p8 = new Coffee("COFL");
        Product p9 = new Filling("FILB");
        Product p10 = new Filling("FILE");
        Product p11 = new Filling("FILC");
        Product p12 = new Filling("FILX");
        Product p13 = new Filling("FILS");
        Product p14 = new Filling("FILH");
        Product p14_ = new Filling("FILH");

        Assertions.assertEquals(0.49, p1.getPrice());
        Assertions.assertEquals(0.39, p2.getPrice());
        Assertions.assertEquals("BGLE", p3.getSKU());
        Assertions.assertEquals("Bagel", p4.getType());
        Assertions.assertEquals("Black", p5.getName());
        Assertions.assertEquals("COFW", p6.getSKU());
        Assertions.assertEquals(1.29, p7.getPrice());
        Assertions.assertEquals("Latte", p8.getName());
        Assertions.assertEquals("Filling", p9.getType());
        Assertions.assertEquals(0.12, p10.getPrice());
        Assertions.assertEquals("FILC", p11.getSKU());
        Assertions.assertEquals("Cream Cheese", p12.getName());
        Assertions.assertEquals("Filling", p13.getType());
        Assertions.assertEquals("Ham", p14.getName());
        Assertions.assertTrue(p14.equals(p14_));
    }

    @Test
    public void testProductNotInMenu(){
        boolean errorThrown = false;

        try {
            new Bagel("HEHE");
        } catch (IllegalArgumentException e){
            errorThrown = true;
        }

        Assertions.assertTrue(errorThrown);
    }
}
