package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.items.Item;

import java.util.List;

public class XItemsDiscount implements Discount {
    private final int xItems;
    private final double discount;
    public XItemsDiscount(int xItems, double discount) {
        this.xItems = xItems;
        this.discount = discount;
    }

    @Override
    public double appliedOn(List<Order> orders) {
        double cost = 0;

        for (Order o : orders) {
            cost += o.amount() / xItems * discount;
            o.decreaseAmountBy(o.amount() - o.amount() % xItems);
        }

        return cost;
    }
}