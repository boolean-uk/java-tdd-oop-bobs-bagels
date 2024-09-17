package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.format.Format;
import com.booleanuk.core.format.TwoDecimalFormat;
import com.booleanuk.core.receipt.Receipt;
import com.booleanuk.core.receipt.ReceiptItem;

import java.util.List;

public class LoggedNoDiscount implements Discount {
    private final Receipt receipt;
    private final Format<Double> numberFormat;

    public LoggedNoDiscount(Receipt receipt) {
        this(receipt, new TwoDecimalFormat());
    }

    public LoggedNoDiscount(Receipt receipt, Format<Double> numberFormat) {
        this.receipt = receipt;
        this.numberFormat = numberFormat;
    }

    @Override
    public double appliedOn(List<Order> orders) {
        double cost = orders.stream().filter(o -> o.amount() != 0)
                .reduce(0.0, (sum, o) -> {
                    sum += o.cost();
                    receipt.add(new ReceiptItem(o.name(), o.amount(), o.cost(), o.itemCost()));
                    return sum;
                }, Double::sum);

        return numberFormat.result(cost);
    }
}