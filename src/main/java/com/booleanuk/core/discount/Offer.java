package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.format.Format;
import com.booleanuk.core.format.TwoDecimalFormat;
import com.booleanuk.core.receipt.Receipt;
import com.booleanuk.core.receipt.ReceiptItem;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Offer {
    private final List<Discount> discounts;
    private final Format<Double> numberFormat;

    public Offer(List<Discount> discounts) {
        this(discounts, new TwoDecimalFormat());
    }

    public Offer(List<Discount> discounts, Format<Double> numberFormat) {
        this.discounts = discounts;
        this.numberFormat = numberFormat;
    }

    public double discountedCost(List<Order> orders) {
        List<Order> sortedOrders = orders.stream().sorted(Comparator.comparing(Order::amount)).collect(Collectors.toList());
        return numberFormat.result(this.discounts.stream()
                .reduce(0.0, (sum, d) -> sum + d.appliedOn(sortedOrders), Double::sum));
    }
}
