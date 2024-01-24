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


}
