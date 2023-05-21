package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.receipt.Receipt;
import com.booleanuk.core.receipt.ReceiptItem;

import java.util.List;

public class LoggedNoDiscount implements Discount {
    private Receipt receipt;

    public LoggedNoDiscount(Receipt receipt) {
        this.receipt = receipt;
    }
    @Override
    public double appliedOn(List<Order> orders) {
        return orders.stream().filter(o -> o.amount() != 0)
                .reduce(0.0, (sum, o) -> {
                    sum += o.cost();
                    receipt.add(new ReceiptItem(o.name(), o.amount(), o.cost()));
                    return sum;
                }, Double::sum);
    }
}