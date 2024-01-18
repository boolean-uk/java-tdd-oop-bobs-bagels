package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestProducts {
    @Test
    public void testProduct(){
        Product p1 = new Product("BGLO");
        Product p2 = new Product("BGLP");
        Product p3 = new Product("BGLE");
        Product p4 = new Product("BGLS");
        Product p5 = new Product("COFB");
        Product p6 = new Product("COFW");
        Product p7 = new Product("COFC");
        Product p8 = new Product("COFL");
        Product p9 = new Product("FILB");
        Product p10 = new Product("FILE");
        Product p11 = new Product("FILC");
        Product p12 = new Product("FILX");
        Product p13 = new Product("FILS");
        Product p14 = new Product("FILH");
        Product p14_ = new Product("FILH");

        Assertions.assertEquals(0.49, p1.price);
        Assertions.assertEquals(0.39, p2.price);
        Assertions.assertTrue(p3.equals("BGLE"));
        Assertions.assertEquals("Bagel", p4.type);
        Assertions.assertEquals("Black", p5.name);
        Assertions.assertTrue(p6.equals("COFW"));
        Assertions.assertEquals(1.29, p7.price);
        Assertions.assertEquals("Latte", p8.name);
        Assertions.assertEquals("Filling", p9.type);
        Assertions.assertEquals(0.12, p10.price);
        Assertions.assertTrue(p11.equals("FILC"));
        Assertions.assertEquals("Cream Cheese", p12.name);
        Assertions.assertEquals("Filling", p13.type);
        Assertions.assertTrue(p14.equals(p14_));
    }

    @Test
    public void testProductNotInMenu(){
        boolean errorThrown = false;

        try {
            Product p = new Product("HEHE");
        } catch (IllegalStateException e){
            errorThrown = true;
        }

        Assertions.assertTrue(errorThrown);
    }
}
