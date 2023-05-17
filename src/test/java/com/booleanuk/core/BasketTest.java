package com.booleanuk.core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BasketTest {

    Basket basket = new Basket();
    Bagel bagel = new Bagel(BAGELTYPE.PLAIN);
    Coffee coffee = new Coffee(COFFEETYPE.BLACK);
    Filling filling = new Filling(FILLINGTYPE.BACON);
    Bagel bagelWithFilling = new Bagel(BAGELTYPE.PLAIN);


    @Test
    void testGetSetCapacity() {
        Assertions.assertEquals(3, basket.getCapacity());
        basket.setCapacity(10);
        Assertions.assertEquals(10, basket.getCapacity());
        Assertions.assertFalse(basket.setCapacity(0));
        // make bagel availiable
        BobsInvetory.add(bagel);
        basket.add(bagel, 2);
        Assertions.assertFalse(basket.setCapacity(1));
        BobsInvetory.resetBagelsAndCoffee();
    }

    @Test
    void testAdd() {
        BobsInvetory.add(bagel);
        Assertions.assertTrue(basket.add(bagel, 3));
        Assertions.assertFalse(basket.add(bagel, 1));
        int position = basket.getItems().indexOf(bagel);
        Assertions.assertEquals(bagel, basket.getItems().get(position));
        Assertions.assertEquals(3, basket.getQuantity().get(position));
    }

    @Test
    void testRemove() {
        testAdd();
        int position = basket.getItems().indexOf(bagel);
        System.out.println(position);
        Assertions.assertFalse(basket.remove(bagel, 4));
        Assertions.assertFalse(basket.remove(coffee, 1));
        Assertions.assertTrue(basket.remove(bagel, 2));
        Assertions.assertEquals(1, basket.getQuantity().get(position));
        Assertions.assertTrue(basket.remove(bagel, 1));
        Assertions.assertEquals(0, basket.getItems().size());
        BobsInvetory.resetBagelsAndCoffee();
    }

    @Test
    void testTotal() {
        BobsInvetory.add(bagel);
        BobsInvetory.add(bagelWithFilling);
        BobsInvetory.add(coffee);
        BobsInvetory.add(filling);
        bagelWithFilling.setFillings(filling);
        basket.setCapacity(100);
        basket.add(bagel, 5);
        Assertions.assertEquals(1.95, basket.getTotalWithDiscount());
        basket.add(bagelWithFilling, 1);
        Assertions.assertEquals(2.46, basket.getTotalWithDiscount());
        basket.add(bagel, 1);
        Assertions.assertEquals(3.0, basket.getTotalWithDiscount());
        basket.add(coffee,1);
        Assertions.assertEquals(3.86, basket.getTotalWithDiscount());
        basket.add(coffee,1);
        Assertions.assertEquals(4.85, basket.getTotalWithDiscount());
        basket.remove(coffee,2);
        basket.remove(bagel,6);
        basket.remove(bagelWithFilling,1);
        Assertions.assertEquals(0.0, basket.getTotalWithDiscount());
        basket.add(bagel,12);
        Assertions.assertEquals(3.99, basket.getTotalWithDiscount());
    }


}
