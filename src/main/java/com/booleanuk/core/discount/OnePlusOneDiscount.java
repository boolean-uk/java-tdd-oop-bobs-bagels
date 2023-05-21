package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.items.Category;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class OnePlusOneDiscount implements Discount {
    private final Category typeOne;
    private final Category typeTwo;
    private final double discount;
    public OnePlusOneDiscount(double discount, Category typeOne, Category typeTwo) {
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.discount = discount;
    }

    @Override
    public double appliedOn(List<Order> orders) {
        List<Order> ordersOne = orders.stream()
                .filter(o -> o.itemIsType(typeOne))
                .collect(Collectors.toList());

        List<Order> ordersTwo = orders.stream()
                .filter(o -> o.itemIsType(typeTwo))
                .collect(Collectors.toList());

        if (ordersOne.size() == 0 || ordersTwo.size() == 0)
            return 0.0;

        Iterator<Order> orderOneIt = ordersOne.listIterator();
        Iterator<Order> orderTwoIt = ordersTwo.listIterator();

        double cost = 0.0;
        boolean done = false;
        Order o1 = orderOneIt.next();
        Order o2 = orderTwoIt.next();

        while(!done) {
            if (o1.amount() >= o2.amount()) {
                cost += discount * o2.amount();
                o1.decreaseAmountBy(o2.amount());
                o2.decreaseAmountBy(o2.amount());
                if (orderTwoIt.hasNext())
                    o2 = orderTwoIt.next();
                else
                    done = true;
            } else {
                cost += discount * o1.amount();
                o2.decreaseAmountBy(o1.amount());
                o1.decreaseAmountBy(o1.amount());
                if (orderOneIt.hasNext())
                    o1 = orderOneIt.next();
                else
                    done = true;
            }
        }

        return cost;
    }
}