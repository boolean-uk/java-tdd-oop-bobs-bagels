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
        Assertions.assertEquals(0.73, item.getPrice());
        BasketItem doesntExist = basket.createBasketItem("BGBG");
        Assertions.assertEquals(null, doesntExist);
        ArrayList<String> fillingDoesntExist = new ArrayList<>(Arrays.asList("FILZ", "FILT"));
        doesntExist = basket.createBasketItem("BGLO",   fillingDoesntExist);
        Assertions.assertEquals(new ArrayList<>(), doesntExist.getAddOns());
    }


    @Test
    public void testaddBasketItem(){
        Basket basket = new Basket();
        ArrayList<String> fillings = new ArrayList<>(Arrays.asList("FILB", "FILS"));
        BasketItem item = basket.createBasketItem("BGLO",fillings );
        //System.out.println(item);
        basket.addBasketItem(item);
        System.out.println(basket.getBasketItems());
        Assertions.assertEquals(0.73, basket.getBasketItems().get(1).getPrice());
        item = basket.createBasketItem("BGLO");
        basket.addBasketItem(item);
        Assertions.assertEquals(0.49, basket.getBasketItems().get(2).getPrice());

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
       basket.getInventoryItemCost("BGLO");
    }

    @Test
    public void testgetBasketItemCost(){
        Basket basket = new Basket();
        ArrayList<String> fillings = new ArrayList<>(Arrays.asList("FILB", "FILS"));
        BasketItem item = basket.createBasketItem("BGLO",fillings );
        Assertions.assertEquals(0.73, basket.getBasketItemCost(item));
        basket.addBasketItem(item);
        Assertions.assertEquals(0.73, basket.getBasketItemCost(1));
    }
    @Test
    public void testPrintReceipt(){
        Inventory inventory = new Inventory();
        DiscountCalculator discountCalc = new DiscountCalculator(inventory);
        Basket basket = new Basket();
        basket.setBasketLimit(100);
        BasketItem item = basket.createBasketItem("BGLO"); // 0.49
        for (int i = 0; i < 12; i++) {
            basket.addBasketItem(item);
        }
        item = basket.createBasketItem("BGLP"); // 0.39
        for (int i = 0; i < 0; i++) {
            basket.addBasketItem(item);
        }
        item = basket.createBasketItem("COFB"); // Black coffee
        for (int i = 0; i < 9; i++) {
            basket.addBasketItem(item);
        }

        basket.printReceipt();
    }


}
