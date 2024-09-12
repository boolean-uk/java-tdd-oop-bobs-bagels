package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
public class BagelShopTests {

    @Test
    public void testBagelBasket() {
        BagelBasket basket = new BagelBasket(2);

        // Test adding bagels to the basket
        assertTrue(basket.addBasketItem(new Bagel("Plain", new ArrayList<>())));
        assertTrue(basket.addBasketItem(new Bagel("Filled", List.of(new Fillings("Cream Cheese", 1)))));

        // Test trying to add more items than basket capacity
        assertFalse(basket.addBasketItem(new Bagel("Seeded", new ArrayList<>())));
        assertFalse(basket.addBasketItem(new Product("BGLO", 0.49, "Bagel", "Onion")));

        // Test removing a bagel from the basket
        assertTrue(basket.removeBasketItem(new Bagel("Plain", new ArrayList<>())));
        assertFalse(basket.removeBasketItem(new Bagel("NonExistent", new ArrayList<>())));

        // Test changing basket capacity
        assertTrue(basket.changeBasketCapacity(3));
    }
    @Test
    public void testBagelOrder() {
        Bagel plainBagel = new Bagel("Plain", new ArrayList<>());
        Fillings creamCheese = new Fillings("Cream Cheese", 1);
        Product blackCoffee = new Product("COFB", 0.99, "Coffee", "Black");

        // Test creating a bagel order with fillings and a product
        BagelOrder order = new BagelOrder(List.of(plainBagel, creamCheese, blackCoffee));

        // Test getting the total cost of the bagel order
        assertEquals(plainBagel.getCost() + creamCheese.getCost() + blackCoffee.getCost(), order.getTotalCost());
    }
    @Test
    public void testBagelInventory() {
        Product onionBagel = new Product("BGLO", 0.49, "Bagel", "Onion");
        Product baconFilling = new Product("FILB", 0.12, "Filling", "Bacon");

        List<Product> availableProducts = List.of(onionBagel, baconFilling);
        BagelInventory inventory = new BagelInventory(availableProducts);

        // Test checking if products are in stock
        assertTrue(inventory.isInStock(onionBagel));
        assertTrue(inventory.isInStock(baconFilling));


    }
}
