package com.booleanuk.extension;
import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountTest {
    private Basket basket;
    private Inventory inventory;
    private Bagel plain;
    private Bagel everything;
    private Bagel onion;
    private Coffee coffee;
    private Discount discount;

    @BeforeEach
    void setUp(){
        discount = new Discount(basket);
        inventory = new Inventory();
        basket = new Basket(inventory, 8);
        this.plain = new Bagel("BGLP","Plain",0.39);
        this.everything = new Bagel("BGLE","Everything",0.49);
        this.onion = new Bagel("BGLO","Onion",0.49);
        this.coffee = new Coffee("COFB","Black",0.99);
        inventory.addToMenu(plain,15);
        inventory.addToMenu(everything,14);
        inventory.addToMenu(onion,14);
        inventory.addToMenu(coffee,14);
    }

    @Test
    public void testNoDiscount(){
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(everything);
        Assertions.assertEquals(1.66, discount.calculateTotalCostWithDiscount(basket));
    }
    @Test
    public void testDiscountSixBagels(){
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        Assertions.assertEquals(2.49, discount.calculateTotalCostWithDiscount(basket));
    }

    @Test
    public void testDiscountTwelveBagels(){
        basket.changeCapacity(12);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        Assertions.assertEquals(3.99, discount.calculateTotalCostWithDiscount(basket));
    }

    @Test
    public void testDiscountWithVariatyOfBagels(){
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(everything);
        basket.addItem(onion);
        Assertions.assertEquals(3.47, discount.calculateTotalCostWithDiscount(basket));
    }
/*
    @Test
    public void testCostOfVariatyOfBagels(){
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(plain);
        basket.addItem(onion);
        basket.addItem(everything);
        basket.addItem(onion);
        Assertions.assertEquals(2.64, discount.calculateTotalCostWithDiscount(basket));
    }


 */
}
