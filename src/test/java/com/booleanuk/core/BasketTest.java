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
        basket.removeItem(product);
        Assertions.assertFalse(basket.bagelBasket.contains(product));
    }
    @Test
    public void testBasketIsFull(){
        Basket basket =new Basket();
        Product product = new Product( "",5,"Bagel","");
        Product product2 = new Product( "",5,"Bagel2","");
        Product product3 = new Product( "",5,"Bagel3","");
        basket.addItem(product);
        basket.addItem(product2);
        basket.addItem(product3);
        basket.removeItem(product);
        Assertions.assertFalse(basket.bagelBasket.contains(product3));
    }


}
