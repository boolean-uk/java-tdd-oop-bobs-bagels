package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    void addShouldSucceed() {
        Inventory.reset();
        Basket basket = new Basket();
        Bagel bagel = new Bagel(BAGELTYPE.ONION);

        Inventory.bagels.add(bagel);

        Assertions.assertEquals(1, Basket.capacity);

        Assertions.assertTrue(Inventory.bagelAvailable(bagel.getType()));

        Assertions.assertTrue(basket.add(bagel));

        Assertions.assertNotEquals(-1, basket.items.indexOf(bagel));
    }
    @Test
    void addShouldFail() {
        Inventory.reset();
        Basket basket = new Basket();
        Bagel bagelA = new Bagel(BAGELTYPE.ONION);

        Assertions.assertFalse(Inventory.bagelAvailable(bagelA.getType()));

        basket.add(bagelA);

        Assertions.assertEquals(1, Basket.capacity);

        Bagel bagelB = new Bagel(BAGELTYPE.ONION);
        Assertions.assertFalse(basket.add(bagelB));

        Assertions.assertEquals(-1, basket.items.indexOf(bagelB));
    }

    @Test
    void removeShouldSucceed() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(BAGELTYPE.ONION);

        Assertions.assertEquals(-1, basket.items.indexOf(bagel));

        basket.add(bagel);

        Assertions.assertNotEquals(-1, basket.items.indexOf(bagel));

        Assertions.assertTrue(basket.remove(bagel));

        Assertions.assertEquals(-1, basket.items.indexOf(bagel));
    }
    @Test
    void removeShouldFail() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(BAGELTYPE.ONION);

        Assertions.assertEquals(-1, basket.items.indexOf(bagel));

        Assertions.assertFalse(basket.remove(bagel));

        Assertions.assertEquals(-1, basket.items.indexOf(bagel));

        Assertions.assertEquals(NOTIFICATION.ITEMNOTFOUND, basket.notification);
    }

    @Test
    void setCapacityShouldBe2() {
        Basket.setCapacity(1);

        Assertions.assertEquals(1, Basket.capacity);

        Assertions.assertTrue(Basket.setCapacity(2));

        Assertions.assertEquals(2, Basket.capacity);
    }
    @Test
    void setCapacityShouldNotBeMinus2() {
        Basket.setCapacity(1);

        Assertions.assertEquals(1, Basket.capacity);

        Assertions.assertFalse(Basket.setCapacity(-2));

        Assertions.assertEquals(1, Basket.capacity);
    }

    @Test
    void totalCostShouldBe148() {
        Basket.setCapacity(2);
        Inventory.bagels.add(new Bagel(BAGELTYPE.ONION));
        Inventory.coffees.add(new Coffee(COFFEETYPE.BLACK));

        Basket basket = new Basket();

        Assertions.assertEquals(0.0, basket.totalCost());

        basket.add(new Bagel(BAGELTYPE.ONION));

        Assertions.assertEquals(0.49, basket.totalCost());

        basket.add(new Coffee(COFFEETYPE.BLACK));

        Assertions.assertEquals(1.48, basket.totalCost());
    }
}
