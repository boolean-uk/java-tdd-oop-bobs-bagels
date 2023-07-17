package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bagel {
    private BigDecimal price;
    private List<Filling> fillings;

    private String variant;

    public Bagel(BigDecimal price, String variant) {
        this.price = price;
        this.variant = variant;
        this.fillings = new ArrayList<>();
    }

    public BigDecimal getPrice() {
        BigDecimal sum = this.price;
        for(Filling f : fillings) sum=sum.add(f.getPrice());
        return sum;
    }

    public void setFillings(List<Filling> fillings) {
        this.fillings = fillings;
    }

    public String getVariant() {
        return variant;
    }

    public List<Filling> getFillings() {
        return fillings;
    }
}
