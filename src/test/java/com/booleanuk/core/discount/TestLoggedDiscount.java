package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.discount.*;
import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Category;
import com.booleanuk.core.items.Coffee;
import com.booleanuk.core.receipt.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestLoggedDiscount {
    @Test
    public void testLoggedXItemsDiscount() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 2),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Onion", 0.49), 10)
        );

        Receipt r = new Receipt();
        Discount d = new LoggedXItemsDiscount(6, 2.49, r);
        Assertions.assertEquals(2 * 2.49, d.appliedOn(orders));

        System.out.println(r.receipt());
    }

    @Test
    public void testLoggedNoDiscount() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 2),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Onion", 0.49), 10)
        );

        Receipt r = new Receipt();
        Discount d = new LoggedNoDiscount(r);

        // expected = 2 * 0.99 + 6 * 0.49 + 10 * 0.49
        double expected =  2 * 0.99 + 6 * 0.49 + 10 * 0.49;
        Assertions.assertEquals(expected, d.appliedOn(orders));
        System.out.println(r.receipt());
    }

    @Test
    public void testLoggedOnePlusOneDiscount() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 4),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Plain", 0.39), 10),
                new Order(new Coffee("White", 1.29), 3)
        );

        Receipt r = new Receipt();
        Discount d = new LoggedOnePlusOneDiscount(1.25, Category.BAGEL, Category.COFFEE, r);

        double expected =  7 * 1.25;
        Assertions.assertEquals(expected, d.appliedOn(orders));
        System.out.println(r.receipt());
    }

    @Test
    public void testLoggedCombined() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 4),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Plain", 0.39), 10),
                new Order(new Coffee("White", 1.29), 3)
        );

        Receipt r = new Receipt();

        Discount d = new LoggedXItemsDiscount(6, 2.49, r);
        Discount d2 = new LoggedOnePlusOneDiscount(1.25, Category.BAGEL, Category.COFFEE, r);
        Discount d3 = new LoggedNoDiscount(r);

        double expected = 2 * 2.49 + 4 * 1.25 + 3 * 1.29;
        Assertions.assertEquals(expected, d.appliedOn(orders) + d2.appliedOn(orders) + d3.appliedOn(orders));

        System.out.println(r.receipt());
    }
}
