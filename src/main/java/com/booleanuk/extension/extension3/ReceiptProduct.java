package com.booleanuk.extension.extension3;

import java.math.BigDecimal;

public class ReceiptProduct {
    private String name;
    private int quantity;
    private BigDecimal price;

    private BigDecimal discount;


    public ReceiptProduct(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = BigDecimal.ZERO;
    }

    public ReceiptProduct(String name, int quantity, BigDecimal price, BigDecimal discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
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

    public void setDiscount(){

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-18s %2d   £%.2f", name, quantity, price));
        if (discount.compareTo(BigDecimal.ZERO) > 0){
            stringBuilder.append("\n");
            stringBuilder.append(String.format("%-18s %s £%.2f %s"," ","(-", discount,")"));
        }
        return stringBuilder.toString();
    }
}
