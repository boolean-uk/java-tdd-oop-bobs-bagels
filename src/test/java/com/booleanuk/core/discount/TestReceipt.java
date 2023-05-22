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

public class TestReceipt {
    @Test
    public void testReceipt() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 4),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Onion", 0.49), 10),
                new Order(new Coffee("Black", 0.99), 3)
        );

        Receipt r = new Receipt();

        List<Discount> discounts = List.of(
                new LoggedXItemsDiscount(6, 2.49, r),
                new LoggedOnePlusOneDiscount(1.25, Category.BAGEL, Category.COFFEE, r),
                new LoggedNoDiscount(r)
        );

        Offer offer = new Offer(discounts);

        // expected = 2 * 2.49 + 4 * 1.25 + 3 * 0.99;
        double expected = 12.95;
        Assertions.assertEquals(expected, offer.discountedCost(orders, r));

        System.out.println(r.receipt());
    }
}
