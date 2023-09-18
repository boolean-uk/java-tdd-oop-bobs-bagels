package com.booleanuk.core;

import com.booleanuk.core.Products.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    @Test
    public void testAddToBasketSuccessful() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
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
    public void testAddToBasketFailed() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
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
    public void testRemoveFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Item bagelItem2 = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);

        assertTrue(basket.addToBasket(bagelItem, 2));
        assertEquals(1, basket.getItemsMap().size());
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
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
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
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
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
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Bagel bagelItem2 = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);
        assertEquals(BigDecimal.ZERO, basket.getTotalCost());
        assertTrue(basket.addToBasket(bagelItem, 2));
        assertTrue(basket.addToBasket(bagelItem2, 2));
        assertEquals(new BigDecimal("1.76"), basket.getTotalCost());
    }

    @Test
    public void testGetItemCost() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Bagel bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Bagel bagelItem2 = new Bagel("BGLP", new BigDecimal("0.39"), "Bagel", BagelType.Plain);
        Filling filling1 = new Filling("FILB", new BigDecimal("0.12"), "Filling", FillingType.Bacon);
        Filling filling2 = new Filling("FILC", new BigDecimal("0.12"), "Filling", FillingType.Cheese);
        bagelItem.addFilling(filling1);
        bagelItem2.addFilling(filling2);
        assertTrue(basket.addToBasket(bagelItem, 2));
        assertTrue(basket.addToBasket(bagelItem2, 2));
        assertEquals(new BigDecimal("0.61"), basket.getItemCost(bagelItem));
        assertEquals(new BigDecimal("0.51"), basket.getItemCost(bagelItem2));

    }

    @Test
    public void testAddFilling() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
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
}
