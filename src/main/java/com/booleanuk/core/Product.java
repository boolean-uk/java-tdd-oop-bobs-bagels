package com.booleanuk.core;

import java.math.BigDecimal;

public class Product {
    private BigDecimal price;

    public void setPrice(BigDecimal price){
        this.price = price;
    };

    public BigDecimal getPrice() {
        return price;
    }


    public void addToPrice(BigDecimal addToPrice) {
        // TODO
    }
}
