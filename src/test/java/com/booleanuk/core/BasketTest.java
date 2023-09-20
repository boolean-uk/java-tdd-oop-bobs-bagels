package com.booleanuk.core;

import com.booleanuk.core.Products.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    @Test
    public void testAddToBasketSuccessful() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket( 5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 1));
        assertEquals(1, basket.getItemsMap().size());
        assertTrue(basket.getItemsMap().containsKey(bagelItem));
        assertTrue(basket.addToBasket(bagelItem, 1));
        assertEquals(2, basket.getItemsMap().get(bagelItem));
        Bagel bagelItem2 = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Filling filling = new Filling("FILC", new BigDecimal("0.12"), "Filling", FillingType.Cheese);

        bagelItem2.addFilling(filling);
        assertTrue(basket.addToBasket(bagelItem2, 1));
        assertEquals(2, basket.getItemsMap().size());
        assertEquals(1, basket.getItemsMap().get(bagelItem2));


    }
    @Test
    public void testAddToBasketIncreaseQuantity() {
        Basket basket = new Basket(5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 2)); // Add 2 items
        assertEquals(2, basket.getBasketSize());
        assertEquals(2, basket.getItemsMap().get(bagelItem));

        assertTrue(basket.addToBasket(bagelItem, 3)); // Add 3 more items of the same type
        assertEquals(5, basket.getBasketSize()); // Quantity increased to 5
        assertEquals(5, basket.getItemsMap().get(bagelItem));
    }
    @Test
    public void testAddToBasketWhenEmpty() {
        Basket basket = new Basket(5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 2));

        assertEquals(2, basket.getBasketSize());
        assertTrue(basket.getItemsMap().containsKey(bagelItem));
        assertEquals(2, basket.getItemsMap().get(bagelItem));
    }
    @Test
    public void testAddToBasketWhenNearlyFull() {
        Basket basket = new Basket(3);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 2));
        assertFalse(basket.addToBasket(bagelItem, 2));
        assertTrue(basket.addToBasket(bagelItem, 1));

        assertEquals(3, basket.getBasketSize());
        assertTrue(basket.getItemsMap().containsKey(bagelItem));
        assertEquals(3, basket.getItemsMap().get(bagelItem));
    }
    @Test
    public void testAddToBasketWhenExactlyFull() {
        Basket basket = new Basket(3);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 2));
        assertTrue(basket.addToBasket(bagelItem, 1));

        assertFalse(basket.addToBasket(bagelItem, 1));

        assertEquals(3, basket.getBasketSize());
        assertTrue(basket.getItemsMap().containsKey(bagelItem));
        assertEquals(3, basket.getItemsMap().get(bagelItem));
    }

    @Test
    public void testAddToBasketFailed() {
        Basket basket = new Basket( 2);
        Bagel bagelItem = new Bagel("BGLG", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertFalse(basket.addToBasket(bagelItem, 1));
        assertEquals(0, basket.getItemsMap().size());
        Bagel bagelItem1 = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Bagel bagelItem2 = new Bagel("BGLS", new BigDecimal("0.49"), "Bagel", BagelType.Sesame);
        assertTrue(basket.addToBasket(bagelItem1, 2));
        assertFalse(basket.addToBasket(bagelItem2,1));
    }

    // test add to basket -> product already exists -> increase quantity
    @Test
    public void testRemoveFromBasketWithSingleItem() {
        Basket basket = new Basket(5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 1));

        assertTrue(basket.removeFromBasket(bagelItem, 1)); // Removing the only item in the basket

        assertEquals(0, basket.getBasketSize());
        assertFalse(basket.getItemsMap().containsKey(bagelItem));
    }
    @Test
    public void testRemoveFromBasket() {
        Basket basket = new Basket( 5);
        Item bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Item bagelItem2 = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);

        assertTrue(basket.addToBasket(bagelItem, 2));
        assertEquals(1, basket.getItemsMap().size());
        assertEquals(2, basket.getBasketSize());

        assertFalse(basket.removeFromBasket(bagelItem2, 1));
        assertEquals(1, basket.getItemsMap().size());
        assertTrue(basket.removeFromBasket(bagelItem, 1));
        assertEquals(1, basket.getItemsMap().size());
        assertEquals(1, basket.getItemsMap().get(bagelItem));
        assertTrue(basket.removeFromBasket(bagelItem, 1));
        assertEquals(0, basket.getItemsMap().size());

    }


    @Test
    public void testCheckingWhetherBasketIsFull() {
        Basket basket = new Basket( 2);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        assertTrue(basket.addToBasket(bagelItem, 1));
        assertFalse(basket.isFull());
        assertEquals(1,basket.getRemainingCapacity());
        Bagel bagelItem2 = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);
        assertTrue(basket.addToBasket(bagelItem2, 1));
        assertTrue(basket.isFull());
    }

    @Test
    public void testSettingCapacity() {
        Basket basket = new Basket( 2);
        assertEquals(2, basket.getCapacity());
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 2));
        assertTrue(basket.setCapacity(5));
        assertEquals(5, basket.getCapacity());
        Bagel bagelItem2 = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);
        assertTrue(basket.addToBasket(bagelItem2, 2));
        assertFalse(basket.setCapacity(3));
        assertEquals(5, basket.getCapacity());

    }

    @Test
    public void testGetTotalCost() {
        Basket basket = new Basket( 5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Bagel bagelItem2 = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);
        assertEquals(BigDecimal.ZERO, basket.calculateTotalCost());
        assertTrue(basket.addToBasket(bagelItem, 2));
        assertTrue(basket.addToBasket(bagelItem2, 2));
        assertEquals(new BigDecimal("1.76"), basket.calculateTotalCost());
    }


    @Test
    public void testAddFilling() {
        Basket basket = new Basket( 5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Filling filling1 = new Filling("FILB", new BigDecimal("0.12"), "Filling", FillingType.Bacon);
        Filling filling2 = new Filling("FILC", new BigDecimal("0.12"), "Filling", FillingType.Cheese);
        bagelItem.addFilling(filling1);
        bagelItem.addFilling(filling2);
        assertTrue(basket.addToBasket(bagelItem, 1));
        Map<Item, Integer> itemsMap = basket.getItemsMap();

        boolean bagelItemWithFillingsFound = false;
        for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
            Item item = entry.getKey();
            Integer quantity = entry.getValue();

            if (item.equals(bagelItem) && quantity == 1) {
                Bagel bagelInMap = (Bagel) item;
                if (bagelInMap.getFillings().contains(filling1) &&
                        bagelInMap.getFillings().contains(filling2)) {
                    bagelItemWithFillingsFound = true;
                    break;
                }
            }
        }

        assertTrue(bagelItemWithFillingsFound);
    }
    @Test
    public void testAddingMultipleFillingsToSameBagelItemPrice() {
        Basket basket = new Basket(10);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Filling filling1 = new Filling("FILC", new BigDecimal("0.12"), "Filling", FillingType.Cheese);
        Filling filling2 = new Filling("FILB", new BigDecimal("0.12"), "Filling", FillingType.Bacon);

        bagelItem.addFilling(filling1);
        bagelItem.addFilling(filling2);

        assertTrue(basket.addToBasket(bagelItem, 2));

        // Bagels with multiple fillings cost (0.49 + 0.12 + 0.12) * 2 = 1.46
        assertEquals(new BigDecimal("1.46"), basket.calculateTotalCost());
    }
//    @Test
//    public void testTotalCostWithBagelsAndFillings() {
//        Basket basket = new Basket(10);
//        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
//        Filling filling1 = new Filling("FILC", new BigDecimal("0.12"), "Filling", FillingType.Cheese);
//        Filling filling2 = new Filling("FILB", new BigDecimal("0.12"), "Filling", FillingType.Bacon);
//
//        bagelItem.addFilling(filling1);
//        bagelItem.addFilling(filling2);
//
//        assertTrue(basket.addToBasket(bagelItem, 3)); // Add 3 Bagels with fillings
//
//        // Bagels with fillings cost (0.49 + 0.12 + 0.15) * 3 = 1.52 * 3 = 4.56
//        assertEquals(new BigDecimal("4.56"), basket.calculateTotalCost());
//    }

    @Test
    public void testAddingItemsWithInvalidQuantities() {
        Basket basket = new Basket(10);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertFalse(basket.addToBasket(bagelItem, 0)); // Try to add with zero quantity
        assertEquals(0, basket.getBasketSize());

        assertFalse(basket.addToBasket(bagelItem, -1)); // Try to add with negative quantity
        assertEquals(0, basket.getBasketSize());
    }
    @Test
    public void testAddingFillingsToDifferentBagelItems() {
        Basket basket = new Basket(10);
        Bagel bagelWithFillings = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Bagel bagelWithoutFillings = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);
        Filling filling1 = new Filling("FILC", new BigDecimal("0.12"), "Filling", FillingType.Cheese);
        Filling filling2 = new Filling("FILB", new BigDecimal("0.15"), "Filling", FillingType.Bacon);

        bagelWithFillings.addFilling(filling1);
        bagelWithFillings.addFilling(filling2);

        assertTrue(basket.addToBasket(bagelWithFillings, 2)); // Add 2 Bagels with fillings
        assertTrue(basket.addToBasket(bagelWithoutFillings, 2)); // Add 2 Bagels without fillings

        // Bagels with fillings cost (0.49 + 0.12 + 0.15) * 2 = 1.52 * 2 = 3.04
        // Bagels without fillings cost 0.39 * 2 = 0.78
        // Total cost should be 3.04 + 0.78 = 3.82
        assertEquals(new BigDecimal("3.82"), basket.calculateTotalCost());
    }
    @Test
    public void testTotalCostWithDifferentItems() {
        Basket basket = new Basket(10);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Coffee coffeeItem = new Coffee("CFOB", new BigDecimal("1.99"), "Coffee", CoffeeType.Black);

        assertTrue(basket.addToBasket(bagelItem, 2)); // Add 2 Bagels
        assertTrue(basket.addToBasket(coffeeItem, 3)); // Add 3 Coffees

        // Bagels cost 0.49 * 2 = 0.98, Coffees cost 1.99 * 3 = 5.97
        // Total cost should be 0.98 + 5.97 = 6.95
        assertEquals(new BigDecimal("6.95"), basket.calculateTotalCost());
    }
    @Test
    public void testTotalCostWithDiscounts() {
        Basket basket = new Basket(10);
        Bagel discountBagel = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);
        Bagel nonDiscountBagel = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(discountBagel, 12)); // 12 Plain Bagels with discount
        assertTrue(basket.addToBasket(nonDiscountBagel, 6)); // 6 Onion Bagels without discount

        // Discounted Bagels cost 3.99, Non-discounted Bagels cost 0.49 * 6 = 2.94
        // Total cost should be 3.99 + 2.94 = 6.93
        assertEquals(new BigDecimal("6.93"), basket.calculateTotalCost());
    }
    @Test
    public void testTotalCostWithDifferentTypes() {
        Basket basket = new Basket(10);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Coffee coffeeItem = new Coffee("CFOB", new BigDecimal("1.99"), "Coffee", CoffeeType.Black);

        assertTrue(basket.addToBasket(bagelItem, 2)); // Add 2 Bagels
        assertTrue(basket.addToBasket(coffeeItem, 3)); // Add 3 Coffees

        // Bagels cost 0.49 * 2 = 0.98, Coffees cost 1.99 * 3 = 5.97
        // Total cost should be 0.98 + 5.97 = 6.95
        assertEquals(new BigDecimal("6.95"), basket.calculateTotalCost());
    }
    @Test
    public void testChangingCapacityAfterAddingItems() {
        Basket basket = new Basket(5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 2)); // Add 2 items
        assertEquals(2, basket.getBasketSize());

        assertTrue(basket.setCapacity(10)); // Increase capacity to 10
        assertEquals(10, basket.getCapacity());

        assertTrue(basket.addToBasket(bagelItem, 6)); // Add 6 more items
        assertEquals(8, basket.getBasketSize()); // Total items should be 8
    }
    @Test
    public void testSettingCapacityToLessThanCurrentItems() {
        Basket basket = new Basket(10);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        assertTrue(basket.addToBasket(bagelItem, 8)); // Add 8 items
        assertEquals(8, basket.getBasketSize());

        assertFalse(basket.setCapacity(5)); // Try to set capacity to less than current items
        assertEquals(8, basket.getCapacity()); // Capacity should remain unchanged
    }
    @Test
    public void testToStringForEmptyBasket() {
        Basket basket = new Basket(10);

        String expected = "Your basket's capacity is 0/10.\nYou have no items in your basket yet.";
        assertEquals(expected, basket.toString());
    }
    @Test
    public void testToStringForNonEmptyBasket() {
        Basket basket = new Basket(10);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Coffee coffeeItem = new Coffee("COFC", new BigDecimal("1.29"), "Coffee",CoffeeType.Cappuccino);

        basket.addToBasket(bagelItem, 2);
        basket.addToBasket(coffeeItem, 1);

        String expected = "Your basket's capacity is 3/10.\nYour products:\n" +
                "0. Onion Bagel x 2 pcs x € 0.49 = € 0.98\n" +
                "1. Coffee Cappuccino x 1 pcs x € 1.29 = € 1.29\n";

        assertEquals(expected, basket.toString());
    }
}
