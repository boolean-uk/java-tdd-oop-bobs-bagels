package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculatorTest {

    @Test
    public void testcalculateDiscountAmounts(){
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

        Map<String, Double> discountMap = new HashMap<>();
        if(discountCalc.calculateDiscountAmounts1(basket.getBasketItems()).get("discountTotal") > discountCalc.calculateDiscountAmounts2(basket.getBasketItems()).get("discountTotal")){
            discountMap = discountCalc.calculateDiscountAmounts1(basket.getBasketItems());
            System.out.println("DISCOUNT1");
        }
        else{
            discountMap = discountCalc.calculateDiscountAmounts2(basket.getBasketItems());
            System.out.println("DISCOUNT2");
        }

        System.out.println(discountMap);
        /*System.out.println(discountCalc.getDiscount6BagelsAmount());
        System.out.println(discountCalc.getDiscountCoffeeBagelAmount());*/
        System.out.println("Total pre-discount: "+basket.getBasketPrice());
        System.out.println("Total post-discount: "+ (basket.getBasketPrice() - discountMap.get("discountTotal")));
       // Assertions.assertEquals(23.46, Math.round((basket.getBasketPrice() - discount1 - discount2 - discount3) * 100.0) / 100.0);

    }

}
