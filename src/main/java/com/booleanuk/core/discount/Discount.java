package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;

import java.util.List;

public interface Discount {
    double appliedOn(List<Order> orders);
}
