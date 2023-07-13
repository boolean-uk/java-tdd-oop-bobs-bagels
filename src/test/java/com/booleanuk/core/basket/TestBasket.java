package com.booleanuk.core.basket;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.basket.Order;
import com.booleanuk.core.discount.*;
import com.booleanuk.core.items.*;

import com.booleanuk.core.receipt.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestBasket {
    Basket basket = new Basket(100);
    @Test
    public void testAddItem() {
        Coffee c = new Coffee("Black", 0.99);
        Assertions.assertTrue(basket.add(c));

        Bagel b = new Bagel("Onion", 0.49);
        b.add(new BagelFilling("Egg", 0.12));
        Assertions.assertTrue(basket.add(b));

        Assertions.assertEquals(1.6, basket.cost());
    }

    @Test
    public void testRemoveItem() {
        // add items
        Bagel bagel = new Bagel("Onion", 0.49);
        bagel.add(new BagelFilling("Egg", 0.12));

        basket.add(new Coffee("Black", 0.99));
        basket.add(bagel);

        // coffee is not in the basket
        Coffee c = new Coffee("White", 0.99);
        Assertions.assertFalse(basket.remove(c));

        // coffee is in the basket
        Coffee c2 = new Coffee("Black", 0.99);
        Assertions.assertTrue(basket.remove(c2));

        // coffee was removed
        Assertions.assertEquals(0.61, basket.cost());

        // bagel in the basket has a filling
        Bagel b = new Bagel("Onion", 0.49);
        Assertions.assertFalse(basket.remove(b));

        // bagel is the same as in the basket
        b.add(new BagelFilling("Egg", 0.12));
        Assertions.assertTrue(basket.remove(b));

        // basket is empty
        Assertions.assertEquals(0.00, basket.cost());
    }

    @Test
    public void testCapacity() {
        boolean r = basket.updateCapacity(1);
        Assertions.assertTrue(r);

        // add a coffee
        Assertions.assertTrue(basket.add(new Coffee("Black", 0.99)));

        // fails because capacity is 1
        Assertions.assertFalse(basket.add(new Coffee("Black", 0.99)));

        // cant update capacity to a lower value than the number of items in the basket
        Assertions.assertFalse(basket.updateCapacity(0));

        // update capacity to 2
        Assertions.assertTrue(basket.updateCapacity(2));

        // succeeds because capacity is 2
        Assertions.assertTrue(basket.add(new Coffee("Black", 0.99)));
    }

    @Test
    public void testCost() {
        List<Order> orders = List.of(
                new Order(new Bagel("Onion", 0.49), 1),
                new Order(new Coffee("White", 1.19), 2),
                new Order(new Coffee("Black", 0.99), 1),
                new Order(new Bagel("Plain", 0.39), 9)
        );

        Offer offer = new Offer(List.of(
                new XItemsDiscount(12, 3.99),
                new XItemsDiscount(6, 2.49),
                new OnePlusOneDiscount(1.25, Category.BAGEL, Category.COFFEE),
                new NoDiscount()
        ));

        Basket b1 = new Basket(100, offer);
        b1.add(new Bagel("Onion", 0.49));
        b1.add(new Coffee("White", 1.19));
        b1.add(new Coffee("White", 1.19));
        b1.add(new Coffee("Black", 0.99));

        for (int i = 0; i < 10; i++) {
            b1.add(new Bagel("Plain", 0.39));
        }


        // 2.49 + 3.75 + 0.49
        Assertions.assertEquals(2.49 + 3.75 + 0.39, offer.discountedCost(orders));
    }

    @Test
    public void testReceipt() {
        List<Order> orders = List.of(
                new Order(new Bagel("Onion", 0.49), 1),
                new Order(new Coffee("White", 1.19), 2),
                new Order(new Coffee("Black", 0.99), 1),
                new Order(new Bagel("Plain", 0.39), 9)
        );

        Receipt receipt = new Receipt();

        Offer offer = new Offer(List.of(
                new LoggedXItemsDiscount(12, 3.99, receipt),
                new LoggedXItemsDiscount(6, 2.49, receipt),
                new LoggedOnePlusOneDiscount(1.25, Category.BAGEL, Category.COFFEE, receipt),
                new LoggedNoDiscount(receipt)
        ));

        Basket b1 = new Basket(100, new BobsInventory(), offer, receipt);
        b1.add(new Bagel("Onion", 0.49));
        b1.add(new Coffee("White", 1.19));
        b1.add(new Coffee("White", 1.19));
        b1.add(new Coffee("Black", 0.99));

        for (int i = 0; i < 10; i++) {
            b1.add(new Bagel("Plain", 0.39));
        }

        // 2.49 + 3.75 + 0.49
        Assertions.assertEquals(6.63, offer.discountedCost(orders));
        System.out.println(b1.receipt());
        System.out.println(b1.detailedReceipt());
    }
}
