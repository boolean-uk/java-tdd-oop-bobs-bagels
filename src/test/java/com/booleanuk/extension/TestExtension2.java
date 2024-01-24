package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestExtension2 {

    //This is tested in main
    @Test
    public void testShouldSeeSimpleReceipt(){
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addFilling("Egg","Yes");
        basket.addProductToBasket("Coffee","Black","Yes");
        basket.addFilling("Egg","Yes");
        //Assertions.assertEquals("",basket.makeSimpleReceipt());
    }
}
