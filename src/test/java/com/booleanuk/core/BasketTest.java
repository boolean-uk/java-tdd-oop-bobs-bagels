package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addBagel() {
        InventoryItem item = new InventoryItem();
        Basket theBasket = new Basket(item);

        Assertions.assertFalse(theBasket.addBagel("Onion", 1.6));
        Assertions.assertFalse(theBasket.addBagel("Sesame", 0));
        Assertions.assertTrue(theBasket.addBagel("Cranberry", 1.5));
    }

    @Test
    public void removeBagel() {
        InventoryItem item = new InventoryItem();
        Basket theBasket = new Basket(item);

        theBasket.addBagel("Oat", 1.6);
        theBasket.addBagel("Multigrain", 1.2);
        theBasket.addBagel("Egg", 0.8);

        Assertions.assertTrue(theBasket.removeBagel("Oat"));
        Assertions.assertFalse(theBasket.removeBagel("Blueberry"));
        Assertions.assertFalse(theBasket.removeBagel(""));
    }

    @Test
    public void setCapacity() {
        InventoryItem item = new InventoryItem();
        Basket theBasket = new Basket(item);

        Assertions.assertTrue(theBasket.setCapacity(3));

        theBasket.addBagel("Oat", 1.6);
        theBasket.addBagel("Multigrain", 1.2);
        theBasket.addBagel("Egg", 0.8);

        Assertions.assertFalse(theBasket.setCapacity(6));
    }

    @Test
    public void totalCost() {
        InventoryItem item = new InventoryItem();
        Basket theBasket = new Basket(item);

        Assertions.assertEquals(0, theBasket.totalCost(), 0.001);

        theBasket.addBagel("Oat", 1.6);
        theBasket.addBagel("Multigrain", 1.2);
        theBasket.addBagel("Egg", 0.8);

        Assertions.assertEquals(3.6, theBasket.totalCost(), 0.001);

        theBasket.addBagel("Blueberry", 1.4);
        Assertions.assertEquals(5, theBasket.totalCost(), 0.001);
    }

    @Test
    public void showBagelCost() {
        InventoryItem item = new InventoryItem();
        Basket theBasket = new Basket(item);

        Assertions.assertEquals(0.39, theBasket.showBagelCost("Plain"));
        Assertions.assertEquals(0, theBasket.showBagelCost("Blueberry"));
    }

    @Test
    public void addFilling() {
        InventoryItem item = new InventoryItem();
        Basket theBasket = new Basket(item);

        Assertions.assertFalse(theBasket.addFilling("Bacon", 1.4));
        Assertions.assertFalse(theBasket.addFilling("Egg", 0));
        Assertions.assertTrue(theBasket.addFilling("Sauce", 0.5));
    }

    @Test
    public void showFillingCost() {
        InventoryItem item = new InventoryItem();
        Basket theBasket = new Basket(item);

        Assertions.assertEquals(0.12, theBasket.showFillingCost("Bacon"));
        Assertions.assertEquals(0, theBasket.showFillingCost("Sauce"));
    }
}
