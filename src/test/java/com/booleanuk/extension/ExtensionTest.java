package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionTest {

    //extension 1
    @Test
    void checkBasketAddMultiple() {
        Basket basket = new Basket(6);
        Bagel bagel = new Bagel("BGLO");
        bagel.addFilling(new Filling("FILB"));
        bagel.addFilling(new Filling("FILE"));
        Assertions.assertTrue(basket.addMultiple(bagel,6));
        Assertions.assertEquals(4.38d,basket.getTotalCost());
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
    }
}
