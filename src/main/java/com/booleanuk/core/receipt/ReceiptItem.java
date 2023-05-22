package com.booleanuk.core.receipt;

import com.booleanuk.core.format.Format;
import com.booleanuk.core.format.TwoDecimalFormat;

public class ReceiptItem {
    private final String name;
    private final int amount;
    private final double value;
    private final double originalCost;
    private final Format<Double> numberFormat;

    public ReceiptItem(String name, int amount, double value) {
        this(name, amount, value, 0, new TwoDecimalFormat());
    }

    public ReceiptItem(String name, int amount, double value, double originalCost) {
        this(name, amount, value, originalCost, new TwoDecimalFormat());
    }

    public ReceiptItem(String name, int amount, double value, double originalCost, Format<Double> numberFormat) {
        this.name = name;
        this.amount = amount;
        this.value = value;
        this.originalCost = originalCost;
        this.numberFormat = numberFormat;
    }

    public ReceiptItem updated(int amount, double value) {
        return new ReceiptItem(name, this.amount + amount, this.value + value, originalCost);
    }

    public ReceiptItem updated(ReceiptItem receiptItem) {
        return receiptItem.updated(amount, value);
    }

    public String asString() {
        return String.format("%" + -20 + "s" + "%" + -10 + "s" + "%" + 10 + "s" + "$",
                name, (amount == 0 ? "" : amount), cost());
    }

    public String asDetailedString() {
        double totalCost = amount == 0 ?
                originalCost : originalCost();
        return this.asString() + "\n" + String.format( "%" + 40 + "s" + "$)", "(" + numberFormat.result(value - totalCost));
    }

    public double cost() {
        return numberFormat.result(this.value);
    }

    public double originalCost() {
        return numberFormat.result(this.amount * originalCost);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof ReceiptItem objReceiptItem)) return false;

        return this.name.equals(objReceiptItem.name);
    }
}
