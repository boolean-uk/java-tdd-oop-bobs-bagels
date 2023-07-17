package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class CoffeeTest {
    @Test
    public void testCoffeeGetSKU(){
        Coffee coffee = new Coffee("COFB",0.99, "Black");
        String sku = coffee.getSKU();
        Assertions.assertEquals("COFB", sku);
    }
    @Test
    public void testCoffeeGetPrice(){
        Coffee coffee = new Coffee("COFB",1.29, "Capuccino");
        double price = coffee.getPrice();
        Assertions.assertEquals(1.29, price, 0.01);
    }
    @Test
    public void testCoffeeGetVriant(){
        Coffee coffee = new Coffee("COFB",0.99, "Black");
        String variant = coffee.getVariant();
        Assertions.assertEquals("Black", variant);
    }

}
