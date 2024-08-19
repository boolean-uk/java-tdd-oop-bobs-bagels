package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class BasketTest {
    @Test
    public void testAddBagel(){
        Basket basket = new Basket();
         basket.addBagel("Poppy Seed", 2);
         basket.addBagel("Cinnamon",  3);
         basket.addBagel("Honey",  4);
         basket.addBagel("Cheese",  5);
         basket.addBagel("Garlic",  6);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("Poppy Seed", 2);
        expectedMap.put("Cinnamon",  3);
        expectedMap.put("Honey",  4);
        expectedMap.put("Cheese",  5);
        expectedMap.put("Garlic",  6);
        Assertions.assertEquals(expectedMap, basket.basketItems);
    }
    @Test
    public void testExceededBasketLimit(){
        Basket basket = new Basket();
        basket.setBasketLimit(3);
        Assertions.assertEquals(basket.exceededBasketLimit(basket.getBasketLimit(), 5), true);
        basket.setBasketLimit(10);
        Assertions.assertEquals(basket.exceededBasketLimit(basket.getBasketLimit(), 7), false);
    }
    @Test
    public void testRemoveBagel(){
        Basket basket = new Basket();
        basket.addBagel("Poppy Seed", 5);
        basket.removeBagel("Poppy Seed", 5);
        Assertions.assertEquals(basket.basketItems.containsKey("Poppy Seed"), false);
        basket.addBagel("Poppy Seed", 5);
        basket.removeBagel("Poppy Seed", 3);
        Assertions.assertEquals(basket.basketItems.containsKey("Poppy Seed"), true);
        Assertions.assertEquals(basket.basketItems.get("Poppy Seed"), 2);
    }
    @Test
    public void testGetFillingCost(){
        Basket basket = new Basket();
        double fillingCost = basket.getFillingCost("Bacon");
       Assertions.assertEquals(0.12, fillingCost );
    }
    @Test
    public void testIsFilling(){
        Basket basket = new Basket();
        boolean isFilling = basket.isFilling("Bacon");
        Assertions.assertEquals(true, isFilling);
    }



}
