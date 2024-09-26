package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    void addShouldSucceed() {
        Inventory.reset();
        Basket basket = new Basket();
        Item item = new Item("BGLO");

        Inventory.getItems().add(item);

        Assertions.assertEquals(1, Basket.getCapacity());

        Assertions.assertTrue(Inventory.itemAvailable(item));

        Assertions.assertTrue(basket.add(item));

        Assertions.assertNotEquals(-1, basket.getProducts().indexOf(item));
    }
    @Test
    void addShouldFail() {
        Inventory.reset();
        Basket basket = new Basket();
        Item itemA = new Item("BGLO");

        Assertions.assertFalse(Inventory.itemAvailable(itemA));

        basket.add(itemA);

        Assertions.assertEquals(1, Basket.getCapacity());

        Item itemB = new Item("BGLO");
        Assertions.assertFalse(basket.add(itemB));

        Assertions.assertEquals(-1, basket.getProducts().indexOf(itemB));

        Assertions.assertEquals(NOTIFICATION.ITEMNOTAVAILABLE, basket.getNotification());
    }

    @Test
    void removeShouldSucceed() {
        Basket basket = new Basket();
        Item item = new Item("BGLO");

        Assertions.assertEquals(-1, basket.getProducts().indexOf(item));

        basket.add(item);

        Assertions.assertNotEquals(-1, basket.getProducts().indexOf(item));

        Assertions.assertTrue(basket.remove(item));

        Assertions.assertEquals(-1, basket.getProducts().indexOf(item));
    }
    @Test
    void removeShouldFail() {
        Basket basket = new Basket();
        Item item = new Item("BGLO");

        Assertions.assertEquals(-1, basket.getProducts().indexOf(item));

        Assertions.assertFalse(basket.remove(item));

        Assertions.assertEquals(-1, basket.getProducts().indexOf(item));

        Assertions.assertEquals(NOTIFICATION.ITEMNOTFOUND, basket.getNotification());
    }

    @Test
    void setCapacityShouldBe2() {
        Basket.setCapacity(1);

        Assertions.assertEquals(1, Basket.getCapacity());

        Assertions.assertTrue(Basket.setCapacity(2));

        Assertions.assertEquals(2, Basket.getCapacity());
    }
    @Test
    void setCapacityShouldNotBeMinus2() {
        Basket.setCapacity(1);

        Assertions.assertEquals(1, Basket.getCapacity());

        Assertions.assertFalse(Basket.setCapacity(-2));

        Assertions.assertEquals(1, Basket.getCapacity());
    }

    @Test
    void totalCostShouldBe148() {
        Basket.setCapacity(2);
        Inventory.getItems().add(new Item("BGLO"));
        Inventory.getItems().add(new Item("COFB"));

        Basket basket = new Basket();

        Assertions.assertEquals(0.0, basket.totalCost());

        basket.add(new Item("BGLO"));

        Assertions.assertEquals(0.49, basket.totalCost());

        basket.add(new Item("COFB"));

        Assertions.assertEquals(1.48, basket.totalCost());
    }
}
