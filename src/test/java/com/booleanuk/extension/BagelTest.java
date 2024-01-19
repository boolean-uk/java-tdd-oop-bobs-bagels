package com.booleanuk.extension;

import com.booleanuk.extension.Bagel;
import com.booleanuk.extension.Basket;
import com.booleanuk.extension.Filling;
import com.booleanuk.extension.Inventory;
import com.booleanuk.extension.Item;
import com.booleanuk.extension.Shop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BagelTest {

    /*Extension 1 tests*/
    /* Test use case 1*/
    @Test
    public void testGettingAValidDiscount(){
        Inventory.resetInstance();
        Basket basket = new Basket(30);
        basket.addItem("BGLP", 16);
        Assertions.assertEquals(5.55, basket.getTotalCost());
    }
    @Test
    public void testGettingAValidDiscount6PlainBagels(){
        Basket basket = new Basket(30);
        basket.addItem("BGLP", 6);
        Assertions.assertEquals(2.34, basket.getTotalCost());

    }
    @Test
    public void testGettingDiscountsOnBigOrder(){
        Basket basket = new Basket(40);
        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 12);
        basket.addItem("BGLE", 6);
        basket.addItem("COFB", 3);
        Assertions.assertEquals(10.43, basket.getTotalCost());
    }

    @Test
    public void testGettingBagelAndCoffeeDiscount(){
        Basket basket = new Basket(20);
        basket.addItem("COFB", 1);
        basket.addItem("BGLO", 1);
        Assertions.assertEquals(1.25, basket.getTotalCost());
    }

}
