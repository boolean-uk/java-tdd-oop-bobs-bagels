package com.booleanuk.core;

import com.booleanuk.core.interfaces.MenuCategory;

public class ReceiptItem {
    private MenuCategory variant;
    private String name;
    private Integer quantity;
    private Double priceSum;

    public ReceiptItem(MenuCategory variant, String name, Integer quantity, Double priceSum) {
        this.variant = variant;
        this.name = name;
        this.quantity = quantity;
        this.priceSum = quantity == 6 ? 2.49 : quantity == 12 ? 3.99 : priceSum;
    }

    public MenuCategory getVariant() {
        return variant;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPriceSum() {
        return priceSum;
    }
}
