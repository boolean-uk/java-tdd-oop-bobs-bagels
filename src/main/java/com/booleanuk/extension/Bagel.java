package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {
    private List<Filling> fillings;

    public Bagel(String sku, BigDecimal price, String variant) {
        super(sku, price, variant);
        this.fillings = new ArrayList<>();
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal sum = super.getPrice();
        for(Filling f : fillings) sum=sum.add(f.getPrice());
        return sum;
    }

    @Override
    public int getSize() {
        return 1 + fillings.size();
    }

    public void setFillings(List<Filling> fillings) {
        this.fillings = fillings;
    }

    public List<Filling> getFillings() {
        return fillings;
    }
}
