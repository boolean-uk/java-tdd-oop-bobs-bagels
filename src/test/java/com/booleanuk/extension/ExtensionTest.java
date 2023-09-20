package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionTest {

    //extension 1
    @Test
    void checkBasketAddMultiple() {
        Basket basket = new Basket(3);
        Bagel bagel = new Bagel("BGLO");
        bagel.addFilling(new Filling("FILB"));
        bagel.addFilling(new Filling("FILE"));
        Assertions.assertTrue(basket.addMultiple(bagel,3));
        Assertions.assertEquals(2.19d,basket.getTotalCost());
    }

    @Test
    void checkOnionBagelOffer() {
        Basket basket = new Basket(6);
        Bagel bagel = new Bagel("BGLO");
        basket.addMultiple(bagel,6);
        Assertions.assertEquals(2.49d,basket.getTotalCost());
        //Check if 8 bagels are added (One of them must be priced separately)
        Basket basket1 = new Basket(10);
        basket1.addMultiple(bagel,8);
        Assertions.assertEquals(3.47d,basket1.getTotalCost());
        //Check if 12 bagels are added
        Basket basket2 = new Basket(12);
        basket2.addMultiple(bagel,12);
        Assertions.assertEquals(4.98d,basket2.getTotalCost());
    }

    @Test
    void checkPlainBagelDiscount() {
        Basket basket1 = new Basket(12);
        Bagel bagel = new Bagel("BGLP");
        basket1.addMultiple(bagel,12);
        Assertions.assertEquals(3.99d,basket1.getTotalCost());
        // Check for 14 bagels
        Basket basket2 = new Basket(20);
        basket2.addMultiple(bagel,14);
        Assertions.assertEquals(4.77d,basket2.getTotalCost());
        // Check for 24 bagels
        Basket basket3 = new Basket(24);
        basket3.addMultiple(bagel,24);
        Assertions.assertEquals(7.98d,basket3.getTotalCost());
    }

    @Test
    void checkEverythingBagelDiscount() {
        Basket basket1 = new Basket(6);
        Bagel bagel = new Bagel("BGLE");
        basket1.addMultiple(bagel,6);
        Assertions.assertEquals(2.49d,basket1.getTotalCost());
        Basket basket2 = new Basket(12);
        basket2.addMultiple(bagel,12);
        Assertions.assertEquals(4.98d,basket2.getTotalCost());
    }

    @Test
    void checkCoffeeConstructor(){
        Coffee coffee = new Coffee("COFB");
        Assertions.assertEquals(0.99d,coffee.getCost());
        Assertions.assertEquals("Black",coffee.getVariant());
    }

    @Test
    void checkCoffeeAndBagelDiscount() {
        Basket basket = new Basket(3);
        Coffee coffee = new Coffee("COFB");
        Bagel bagel = new Bagel("BGLO");
        basket.add(coffee);
        basket.add(bagel);
        Assertions.assertEquals(1.25d,basket.getTotalCost());
        //Check for 3 bagels and 1 coffee
        Basket basket1 = new Basket(4);
        basket1.add(coffee);
        basket1.addMultiple(bagel,3);
        Assertions.assertEquals(2.23d,basket1.getTotalCost());
    }

    @Test
    void checkPrintReceipt(){
        Basket basket = new Basket(5);
        Bagel bagel1 = new Bagel("BGLO");
        Bagel bagel2 = new Bagel("BGLP");
        Coffee coffee = new Coffee("COFB");
        basket.add(bagel1);
        basket.add(bagel2);
        basket.add(coffee);
        Assertions.assertEquals("~~~ Bob's Bagels ~~~\n" +
                "--------------------\n" +
                "Onion Bagel    0.49$\n" +
                "Plain Bagel    0.39$\n" +
                "Black Coffee   0.99$\n" +
                "Total: 1.25",basket.printReceipt());
    }
}
