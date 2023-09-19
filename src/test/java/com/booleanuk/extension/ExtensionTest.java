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
}
