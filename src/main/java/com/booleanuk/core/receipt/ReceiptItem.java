package com.booleanuk.core.receipt;

import com.booleanuk.core.items.Item;

public class ReceiptItem {
    private final String name;
    private int amount;
    private double value;

    public ReceiptItem(String name, int amount, double value) {
        this.name = name;
        this.amount = amount;
        this.value = value;
    }

    public ReceiptItem updated(int amount, double value) {
        return new ReceiptItem(name, this.amount + amount, this.value + value);
    }

    public ReceiptItem updated(ReceiptItem receiptItem) {
        return receiptItem.updated(amount, value);
    }

    public String asString() {
        return name + " || "+ amount + " || " + value + "$";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof ReceiptItem objReceiptItem)) return false;

        return this.name.equals(objReceiptItem.name);
    }
}
