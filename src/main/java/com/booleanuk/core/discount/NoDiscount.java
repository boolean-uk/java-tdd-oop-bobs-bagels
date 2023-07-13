package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.format.Format;
import com.booleanuk.core.format.TwoDecimalFormat;
import com.booleanuk.core.items.Item;
import com.booleanuk.core.receipt.Receipt;

import java.util.List;

public class NoDiscount implements Discount {
    private final Format<Double> numberFormat;

    public NoDiscount() {
        this(new TwoDecimalFormat());
    }

    public NoDiscount(Format<Double> numberFormat) {
        this.numberFormat = numberFormat;
    }

    @Override
    public double appliedOn(List<Order> orders) {
        return orders.stream().reduce(0.0, (sum, o) -> sum + o.cost(), Double::sum);
    }
}