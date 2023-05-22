package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.receipt.Receipt;
import com.booleanuk.core.receipt.ReceiptItem;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Offer {
    private List<Discount> discounts;

    public Offer(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public double discountedCost(List<Order> orders) {
        List<Order> sortedOrders = orders.stream().sorted(Comparator.comparing(Order::amount)).collect(Collectors.toList());
        return this.discounts.stream()
                .reduce(0.0, (sum, d) -> sum + d.appliedOn(sortedOrders), Double::sum);
    }

    public double discountedCost(List<Order> orders, Receipt receipt) {
        List<Order> sortedOrders = orders.stream().sorted(Comparator.comparing(Order::amount)).collect(Collectors.toList());
        double cost = this.discounts.stream()
                .reduce(0.0, (sum, d) -> sum + d.appliedOn(sortedOrders), Double::sum);

        receipt.add(new ReceiptItem("total", 0, cost));

        return cost;
    }
}
