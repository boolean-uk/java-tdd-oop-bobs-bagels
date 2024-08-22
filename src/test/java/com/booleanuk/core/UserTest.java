package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    // User story 1
    @Test
    public void addBagelTest() {
        Order order = new Order();
        Bagel bagel = new Bagel("Plain");
        Assertions.assertTrue(order.addItem(bagel));

        Basket basket = new Basket(10);
        Assertions.assertTrue(basket.add(order));
        Assertions.assertTrue(basket.getNumItems() == 1);


    }
    // User story 2
    @Test
    public void removeBagelTest() {
        Order order = new Order();
        Bagel bagel = new Bagel("Plain");
        Assertions.assertTrue(order.addItem(bagel));

        Basket basket = new Basket(10);
        basket.add(order);

        Assertions.assertTrue(basket.remove(bagel, 1));
        Assertions.assertTrue(basket.getNumItems() == 0);


    }
    // User story 3
    @Test
    public void checkCapacityTest() {
        Order order = new Order();
        Bagel bagel = new Bagel("Plain");
        Bagel bagel0 = new Bagel("Sesame");
        Bagel bagel1 = new Bagel("Onion");
        Bagel bagel2 = new Bagel("Everything");
        order.addItem(bagel);
        order.addItem(bagel1);
        order.addItem(bagel2);


        Assertions.assertTrue(order.addItem(bagel0));
        Basket basket = new Basket(3);


        Assertions.assertFalse(basket.add(order));


    }


    //User story 4
    @Test
    public void increaseCapacityTest() {
        Order order = new Order();
        Bagel bagel = new Bagel("Plain");
        Bagel bagel0 = new Bagel("Sesame");
        Bagel bagel1 = new Bagel("Onion");
        Bagel bagel2 = new Bagel("Everything");
        order.addItem(bagel);
        order.addItem(bagel1);
        order.addItem(bagel2);


        Assertions.assertTrue(order.addItem(bagel0));
        Basket basket = new Basket(3);
        basket.incCapacity(1);


        Assertions.assertTrue(basket.add(order));
    }

    // User story 5
    @Test
    public void removeNothingTest() {
        Order order = new Order();
        Bagel bagel = new Bagel("Plain");
        Bagel bagel0 = new Bagel("Sesame");
        Bagel bagel1 = new Bagel("Onion");
        Bagel bagel2 = new Bagel("Everything");
        order.addItem(bagel);
        order.addItem(bagel1);
        order.addItem(bagel2);
        order.addItem(bagel2);
        Basket basket = new Basket(3);
        basket.incCapacity(1);
        basket.add(order);




        Assertions.assertFalse(basket.checkCapacity());
        Assertions.assertFalse(basket.remove(bagel0, 1));
        Assertions.assertFalse(basket.checkCapacity());

    }

    // User story 6
    @Test
    public void totalTest() {
        Order order = new Order();
        Bagel bagel = new Bagel("Plain");
        bagel.addFilling(new Filling("Ham"));
        bagel.addFilling(new Filling("Cheese"));
        Bagel bagel0 = new Bagel("Sesame");
        Bagel bagel1 = new Bagel("Onion");
        bagel1.addFilling(new Filling("Smoked Salmon"));
        bagel1.addFilling(new Filling("Cream cheese"));
        Bagel bagel2 = new Bagel("Everything");
        Coffee coffee = new Coffee("Black");
        order.addItem(bagel);
        order.addItem(bagel0);
        order.addItem(bagel1);
        order.addItem(bagel2);
        order.addItem(coffee);
        Basket basket = new Basket(5);
        basket.add(order);


        Assertions.assertEquals(0.39+3 * 0.49 + 4 * 0.12 + 0.99, basket.getTotal());
    }

    // User story 7+8
    @Test
    public void bagelPriceTest() {
        Bagel bagel = new Bagel("Plain");
        bagel.addFilling(new Filling("Ham"));
        bagel.addFilling(new Filling("Cheese"));

        Assertions.assertEquals(0.39 + 2 * 0.12, bagel.getPrice());


    }

    // User story 9
    @Test
    public void fillingPriceTest() {
        Filling filling = new Filling("Cheese");

        Assertions.assertEquals(0.12, filling.getPrice());


    }

    //User story 10
    @Test
    public void existenceTest() {


        Bagel bagel = new Bagel("Holeless");
        Assertions.assertNull(bagel.getPrice());

        Filling filling = new Filling("Jam");
        Assertions.assertNull(filling.getPrice());

        Order order = new Order();
        Filling filling0 = new Filling("Cheese");

        order.addItem(filling0);
        Assertions.assertEquals(0.0, order.getTotal());


    }
}

