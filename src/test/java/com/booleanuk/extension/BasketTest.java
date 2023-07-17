package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketTest {
    private static Basket basket;

    @BeforeAll
    public static void SetUp(){
        Inventory.createInventory();
    }
    @BeforeEach
    public void cleanUp(){
        basket = new Basket(5);
    }


    @Test
    public void totalPriceShouldCalculateCorrectly1(){
        basket.add("Bagel","Onion");
        basket.add("Coffee","Black");
        basket.add("Coffee","Black");
        Assertions.assertEquals(BigDecimal.valueOf(2.47), basket.totalPrice());
    }
    @Test
    public void totalPriceShouldCalculateCorrectly2(){
        basket.add("Bagel","Plain");
        basket.add("Coffee","Black");
        basket.add("Coffee","Black");
        Assertions.assertEquals(BigDecimal.valueOf(2.24), basket.totalPrice());
    }

    @Test
    public void totalPriceShouldCalculateCorrectly3(){
        basket.changeCapacity(16);
        for (int i = 0; i < 16; i++) {
            basket.add("Bagel", "Plain");
        }
        Assertions.assertEquals(BigDecimal.valueOf(5.55), basket.totalPrice());
    }
    @Test
    public void totalPriceShouldCalculateCorrectly4(){
        basket.changeCapacity(23);
        for (int i = 0; i < 12; i++) {
            basket.add("Bagel", "Plain");
        }
        for (int i = 0; i < 6; i++) {
            basket.add("Bagel", "Everything");
        }
        basket.add("Bagel", "Onion");
        basket.add("Bagel", "Onion");

        Assertions.assertEquals(BigDecimal.valueOf(7.46), basket.totalPrice());
    }
    @Test
    public void totalPriceShouldCalculateCorrectly5(){
        basket.changeCapacity(23);
        for (int i = 0; i < 12; i++) {
            basket.add("Bagel", "Plain");
        }
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");

        Assertions.assertEquals(BigDecimal.valueOf(7.26), basket.totalPrice());
    }

    @Test
    public void totalPriceShouldCalculateCorrectly6(){
        basket.changeCapacity(23);
        for (int i = 0; i < 12; i++) {
            basket.add("Bagel", "Plain");
        }
        for (int i = 0; i < 6; i++) {
            basket.add("Bagel", "Everything");
        }
        basket.add("Bagel", "Onion");
        basket.add("Bagel", "Onion");
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");

        Assertions.assertEquals(BigDecimal.valueOf(10.73), basket.totalPrice());
    }


    @Test
    public void receiptTest(){
        basket.changeCapacity(50);
        for (int i = 0; i < 15; i++) {
            basket.add("Bagel", "Plain");
        }
        for (int i = 0; i < 6; i++) {
            basket.add("Bagel", "Everything");
        }
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");
        basket.add("Bagel", "Onion");
        basket.add("Filling", "Bacon");
        Receipt receipt = basket.mapShoppingListToReceipt();
        System.out.println(receipt);
        Assertions.assertEquals(new BigDecimal("1.53"), receipt.getSavedMoney());
    }
}

