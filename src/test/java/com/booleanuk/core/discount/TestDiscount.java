package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.discount.Discount;
import com.booleanuk.core.discount.NoDiscount;
import com.booleanuk.core.discount.OnePlusOneDiscount;
import com.booleanuk.core.discount.XItemsDiscount;
import com.booleanuk.core.format.Format;
import com.booleanuk.core.format.TwoDecimalFormat;
import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Category;
import com.booleanuk.core.items.Coffee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDiscount {
    @Test
    public void testXItemsDiscount() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 2),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Onion", 0.49), 10)
        );

        Discount d = new XItemsDiscount(6, 2.49);
        Assertions.assertEquals(2 * 2.49, d.appliedOn(orders));
    }

    @Test
    public void testNoDiscount() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 2),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Onion", 0.49), 10)
        );

        Discount d = new NoDiscount();

        // expected = 2 * 0.99 + 6 * 0.49 + 10 * 0.49
        double expected =  2 * 0.99 + 6 * 0.49 + 10 * 0.49;
        Assertions.assertEquals(expected, d.appliedOn(orders));
    }

    @Test
    public void testOnePlusOneDiscount() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 4),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Onion", 0.49), 10),
                new Order(new Coffee("Black", 0.99), 3)
        );

        Discount d = new OnePlusOneDiscount(1.25, Category.BAGEL, Category.COFFEE);

        double expected =  7 * 1.25;
        Assertions.assertEquals(expected, d.appliedOn(orders));
    }

    @Test
    public void testCombined() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 4),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Onion", 0.49), 10),
                new Order(new Coffee("Black", 0.99), 3)
        );

        Discount d = new XItemsDiscount(6, 2.49);
        Discount d2 = new OnePlusOneDiscount(1.25, Category.BAGEL, Category.COFFEE);
        Discount d3 = new NoDiscount();

        Format<Double> f = new TwoDecimalFormat();

        double expected = 2 * 2.49 + 4 * 1.25 + 3 * 0.99;
        Assertions.assertEquals(expected, f.result(d.appliedOn(orders) + d2.appliedOn(orders) + d3.appliedOn(orders)));
    }
}
