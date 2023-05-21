package com.booleanuk.core.basket.discount;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.basket.Order;
import com.booleanuk.core.discount.*;
import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Category;
import com.booleanuk.core.items.Coffee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestOffer {
    @Test
    public void testDiscountedCost() {
        List<Order> orders = List.of(
                new Order(new Coffee("Black", 0.99), 4),
                new Order(new Bagel("Onion", 0.49), 6),
                new Order(new Bagel("Onion", 0.49), 10),
                new Order(new Coffee("Black", 0.99), 3)
        );

        List<Discount> discounts = List.of(
                new XItemsDiscount(6, 2.49),
                new OnePlusOneDiscount(1.25, Category.BAGEL, Category.COFFEE),
                new NoDiscount()
        );

        Offer offer = new Offer(discounts);

        double expected = 2 * 2.49 + 4 * 1.25 + 3 * 0.99;
        Assertions.assertEquals(expected, offer.discountedCost(orders));
    }
}
