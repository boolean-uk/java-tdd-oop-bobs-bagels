package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    @Test
    public void checkIfBagelIsAdded(){
        Basket basket =new Basket();
        Product product = new Product( "",5,"Bagel","");
        basket.addItem(product);
        Assertions.assertTrue(basket.bagelBasket.contains(product));
        Assertions.assertEquals("Bagel",basket.bagelBasket.get(0).getName());

    }
    @Test
    public void RemovingBagel(){
        Basket basket =new Basket();
        Product product = new Product( "",5,"Bagel","");
        basket.addItem(product);
        Assertions.assertFalse(basket.bagelBasket.contains(product));
    }


}
