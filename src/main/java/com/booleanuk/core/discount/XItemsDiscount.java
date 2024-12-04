package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.format.Format;
import com.booleanuk.core.format.TwoDecimalFormat;

import java.util.List;

public class XItemsDiscount implements Discount {
    private final int xItems;
    private final double discount;
    private final Format<Double> numberFormat;

    public XItemsDiscount(int xItems, double discount) {
        this(xItems, discount, new TwoDecimalFormat());
    }

    public XItemsDiscount(int xItems, double discount, Format<Double> numberFormat) {
        this.xItems = xItems;
        this.discount = discount;
        this.numberFormat = numberFormat;
    }


        @Override
    public double appliedOn(List<Order> orders) {
        double cost = 0;

        for (Order o : orders) {
            cost += o.amount() / xItems * discount;
            o.decreaseAmountBy(o.amount() - o.amount() % xItems);
        }

        return numberFormat.result(cost);
    }
}