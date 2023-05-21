package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.items.Item;

import java.util.List;

public class NoDiscount implements Discount {
    @Override
    public double appliedOn(List<Order> orders) {
        return orders.stream().reduce(0.0, (sum, o) -> sum + o.cost(), Double::sum);
    }
}