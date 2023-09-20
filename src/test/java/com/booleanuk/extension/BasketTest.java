package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BasketTest {

    private Basket basket;
    private Inventory inventory;
    private HashMap<String, Filling> fillingInventory;

    @BeforeEach
    public void setUp() {
        basket = new Basket(20);
        inventory = new Inventory();
        fillingInventory = new HashMap<>();

        inventory.addProduct(new Bagel("Plain", 0.39, "BGLP"));
        inventory.addProduct(new Bagel("Onion", 0.49, "BGLO"));
        inventory.addProduct(new Bagel("Sesame", 0.49, "BGLS"));

        fillingInventory.put("Cheese", new Filling("Cheese", 0.12, "FILC"));

        inventory.addSpecialOffer(new SpecialOffer("BGLP", 12, 3.99));
        inventory.addSpecialOffer(new SpecialOffer("BGLO", 6, 2.49));
    }

    @Test
    public void testSpecialOffer1() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(10);

        Product bagelO = new Product("Onion", 0.49, "BGLO");
        SpecialOffer offer = new SpecialOffer("BGLO", 6, 2.49);

        inventory.addProduct(bagelO);
        inventory.addSpecialOffer(offer);

        for(int i = 0; i < 6; i++) {
            basket.addProduct(bagelO);
        }

        double total = basket.getTotalCost(inventory);
        Assertions.assertEquals(2.49, total);
    }

    @Test
    public void testSpecialOffer2() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(20);
        Product bagelP = new Product("Plain", 0.39, "BGLP");
        SpecialOffer offer = new SpecialOffer("BGLP", 12, 3.99);

        inventory.addProduct(bagelP);
        inventory.addSpecialOffer(offer);

        for(int i = 0; i < 12; i++) {
            basket.addProduct(bagelP);
        }

        double total = basket.getTotalCost(inventory);
        Assertions.assertEquals(3.99, total);
    }

    @Test
    public void testBasketWithSpecialOffers() {
        for (int i = 0; i < 12; i++) {
            basket.addProduct(new Bagel("Plain", 0.39, "BGLP"));
        }
        basket.addProduct(new Bagel("Onion", 0.49, "BGLO"));
        basket.addProduct(new Bagel("Sesame", 0.49, "BGLS"));

        double totalCost = basket.getTotalCost(inventory);

        Assertions.assertEquals(4.97, totalCost, 0.001);
    }
}
