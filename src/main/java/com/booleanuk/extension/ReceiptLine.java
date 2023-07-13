package com.booleanuk.extension;

import com.booleanuk.core.Item;

import java.math.BigDecimal;

public class ReceiptLine {
    private final Item item;
    private final BigDecimal quantity;
    private final BigDecimal price;
//    private double discount;

    public ReceiptLine(Item item, BigDecimal quantity, BigDecimal price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
//        this.discount = discount;
    }

    public Item getItem() {
        return item;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
