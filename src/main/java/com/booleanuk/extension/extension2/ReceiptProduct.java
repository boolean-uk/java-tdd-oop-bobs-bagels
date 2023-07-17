package com.booleanuk.extension.extension2;

import java.math.BigDecimal;

public class ReceiptProduct {
    private String name;
    private int quantity;
    private BigDecimal price;

    public ReceiptProduct(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return String.format("%-18s %2d   £%.2f", name, quantity, price);
    }
}
