package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.format.Format;
import com.booleanuk.core.format.TwoDecimalFormat;
import com.booleanuk.core.receipt.Receipt;
import com.booleanuk.core.receipt.ReceiptItem;

import java.util.List;

public class LoggedXItemsDiscount implements Discount {
    private final int xItems;
    private final double discount;
    private final Receipt receipt;
    private final Format<Double> numberFormat;

    public LoggedXItemsDiscount(int xItems, double discount, Receipt receipt) {
        this(xItems, discount, receipt, new TwoDecimalFormat());
    }

    public LoggedXItemsDiscount(int xItems, double discount, Receipt receipt, Format<Double> numberFormat) {
        this.xItems = xItems;
        this.discount = discount;
        this.receipt = receipt;
        this.numberFormat = numberFormat;
    }

    @Override
    public double appliedOn(List<Order> orders) {
        double cost = 0;

        for (Order o : orders) {
            double oCost = o.amount() / xItems * discount;
            cost += oCost;
            int used = o.amount() - o.amount() % xItems;
            o.decreaseAmountBy(used);
            if (oCost != 0)
                this.receipt.add(new ReceiptItem(o.name(), used, oCost, o.itemCost()));
        }

        return numberFormat.result(cost);
    }
}