package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReceiptTest {
    private Inventory inventory;
    private Basket basket;
    private Bagel bagel;
    private Coffee coffee;
    private Filling filling;

    @BeforeEach
    void setUp(){
        inventory = new Inventory();
        basket = new Basket(inventory,5);
        bagel = new Bagel("BGLO", "Onion", 0.49);
        coffee = new Coffee("COFB","Black", 0.99);
        filling = new Filling("FILE","Egg",0.12);
        inventory.addToMenu(bagel,10);
        inventory.addToMenu(coffee,15);
        inventory.addToMenu(filling,20);
    }


    @Test
    public void testTotalItemCost(){
        Receipt receipt = new Receipt();
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(coffee);
        basket.addItem(filling);
        Assertions.assertEquals(1.47, receipt.calculateTotalItemCost(basket,bagel));
        Assertions.assertEquals(0.99, receipt.calculateTotalItemCost(basket,coffee));
    }
    @Test
    public void testReceiptGenerator(){
        Receipt receipt = new Receipt();
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(coffee);
        basket.addItem(filling);
        basket.addItem(filling);
        receipt.generateReceipt(basket);
    }

    @Test
    public void test2ReceiptGenerator(){
        Receipt receipt = new Receipt();
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(bagel);
        receipt.generateReceipt(basket);
    }
}
