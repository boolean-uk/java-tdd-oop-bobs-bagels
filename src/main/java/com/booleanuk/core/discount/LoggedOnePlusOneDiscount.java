package com.booleanuk.core.discount;

import com.booleanuk.core.basket.Order;
import com.booleanuk.core.format.Format;
import com.booleanuk.core.format.TwoDecimalFormat;
import com.booleanuk.core.items.Category;
import com.booleanuk.core.receipt.Receipt;
import com.booleanuk.core.receipt.ReceiptItem;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LoggedOnePlusOneDiscount implements Discount {
    private final Category typeOne;
    private final Category typeTwo;
    private final double discount;
    private final Receipt receipt;
    private final Format<Double> numberFormat;

    public LoggedOnePlusOneDiscount(double discount, Category typeOne, Category typeTwo, Receipt receipt) {
        this(discount, typeOne, typeTwo, receipt, new TwoDecimalFormat());
    }

    public LoggedOnePlusOneDiscount(double discount, Category typeOne, Category typeTwo, Receipt receipt, Format<Double> numberFormat) {
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.discount = discount;
        this.receipt = receipt;
        this.numberFormat = numberFormat;
    }

    @Override
    public double appliedOn(List<Order> orders) {
        List<Order> ordersOne = orders.stream()
                .filter(o -> o.amount() != 0)
                .filter(o -> o.itemIsType(typeOne))
                .collect(Collectors.toList());

        List<Order> ordersTwo = orders.stream()
                .filter(o -> o.amount() != 0)
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
                double currentCost = discount * o2.amount();
                receipt.add(new ReceiptItem(o1.name() + " - " + o2.name(), o2.amount(), currentCost, o1.itemCost() + o2.itemCost()));
                cost += currentCost;
                o1.decreaseAmountBy(o2.amount());
                o2.decreaseAmountBy(o2.amount());
                if (orderTwoIt.hasNext())
                    o2 = orderTwoIt.next();
                else
                    done = true;

                if (o1.amount() == 0) {
                    if(orderOneIt.hasNext())
                        o1 = orderOneIt.next();
                    else
                        done = true;
                }
            } else {
                double currentCost = discount * o1.amount();
                cost += currentCost;
                receipt.add(new ReceiptItem(o1.name() + " - " + o2.name(), o1.amount(), currentCost, o1.itemCost() + o2.itemCost()));
                o2.decreaseAmountBy(o1.amount());
                o1.decreaseAmountBy(o1.amount());
                if (orderOneIt.hasNext())
                    o1 = orderOneIt.next();
                else
                    done = true;
                if (o2.amount() == 0) {
                    if(orderTwoIt.hasNext())
                        o2 = orderTwoIt.next();
                    else
                        done = true;
                }
            }
        }

        return numberFormat.result(cost);
    }
}