package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class BasketTest {

    @Test
    public void testcreateBasketItem(){
        Basket basket = new Basket();
       // ArrayList<String> fillings = new ArrayList<>(Arrays.asList("FILB", "FILS", "BGLP"));
        ArrayList<String> fillings = new ArrayList<>(Arrays.asList("FILB", "FILS"));
        BasketItem item = basket.createBasketItem("BGLO",fillings );
        System.out.println(item.getPrice());
        Assertions.assertEquals(0.73, item.getPrice());
        BasketItem doesntExist = basket.createBasketItem("BGBG");
        Assertions.assertEquals(null, doesntExist);
        ArrayList<String> fillingDoesntExist = new ArrayList<>(Arrays.asList("FILB", "FILS"));
        doesntExist = basket.createBasketItem("BGLO",fillingDoesntExist );
        Assertions.assertEquals(null, doesntExist);
    }


    @Test
    public void testaddBasketItem(){
        Basket basket = new Basket();
        ArrayList<String> fillings = new ArrayList<>(Arrays.asList("FILB", "FILS"));
        BasketItem item = basket.createBasketItem("BGLO",fillings );
        basket.addBasketItem(item);
        System.out.println(basket.getBasketItems().get(0));
        Assertions.assertEquals(0.73, basket.getBasketItems().get(0).getPrice());
        item = basket.createBasketItem("BGLO");
        basket.addBasketItem(item);
        Assertions.assertEquals(0.49, basket.getBasketItems().get(1).getPrice());

    }

    @Test
    public void testGetBasketPrice(){
        Basket basket = new Basket();
        ArrayList<String> fillings = new ArrayList<>(Arrays.asList("FILB", "FILS"));
        BasketItem item = basket.createBasketItem("BGLO",fillings );
        basket.addBasketItem(item);
        System.out.println(basket.getBasketItems().get(0));
        item = basket.createBasketItem("BGLO");
        basket.addBasketItem(item);
        Assertions.assertEquals(1.22, basket.getBasketPrice());
    }

    @Test
    public void testremoveBasketItem(){
        Basket basket = new Basket();
        ArrayList<String> fillings = new ArrayList<>(Arrays.asList("FILB", "FILS"));
        BasketItem item = basket.createBasketItem("BGLO",fillings );
        basket.addBasketItem(item);
        Assertions.assertEquals(0.73, basket.getBasketPrice());
        basket.removeBasketItem(1);
        Assertions.assertEquals(0.0, basket.getBasketPrice());

    }

    @Test
    public void testgetItemCost(){
        Basket basket = new Basket();
        Assertions.assertEquals(0.49, basket.getInventoryItemCost("BGLO"));
    }
    @Test
    public void testgetBasketItemCost(){
        Basket basket = new Basket();
        ArrayList<String> fillings = new ArrayList<>(Arrays.asList("FILB", "FILS"));
        BasketItem item = basket.createBasketItem("BGLO",fillings );
        Assertions.assertEquals(0.73, basket.getBasketItemCost(item));
    }


    /*@Test
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
        Assertions.assertEquals(expectedMap, basket.getBasketItems());
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
        Assertions.assertEquals(basket.getBasketItems().containsKey("Poppy Seed"), false);
        basket.addBagel("Poppy Seed", 5);
        basket.removeBagel("Poppy Seed", 3);
        Assertions.assertEquals(basket.getBasketItems().containsKey("Poppy Seed"), true);
        Assertions.assertEquals(basket.getBasketItems().get("Poppy Seed"), 2);
    }
    @Test
    public void testUserRequestFillingCost(){
        Basket basket = new Basket();
        basket.userRequestFillingPrice("FILC");

    }


    @Test
    public void testAddFillingToBasket(){
        Basket basket = new Basket();
        basket.addFillingToBasket("FILC", 5);
        Assertions.assertEquals(5, basket.getBasketItems().get("FILC"));
    }

    @Test
    public void testUserRequestBagelCost(){
        Basket basket = new Basket();
        basket.userRequestBagelCost("BGLE");

    }


/*
    @Test
    public void testBasketFunction(){
        Basket basket = new Basket();
        basket.userRequestBagelCost("BGLE");

    }
*/
}
