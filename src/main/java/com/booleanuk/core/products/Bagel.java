package com.booleanuk.core.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bagel extends Product {

    private List<Filling> fillings = new ArrayList<>(0);
    private BagelVariant variant;

    public Bagel(String SKU, BigDecimal price) {
        super(SKU, price);

    }

    public Bagel(String SKU, BigDecimal price, BagelVariant variant) {
        super(SKU, price);

        this.variant = variant;
    }

    public BigDecimal getPrice() {
        return super.getPrice();
    }

    public BigDecimal getPriceWithFilling() {
        BigDecimal fillingsPrice = BigDecimal.ZERO;
        for (Filling filling : fillings) {
            fillingsPrice = fillingsPrice.add(filling.getPrice());
        }
        return super.getPrice().add(fillingsPrice);
    }

    public BagelVariant getVariant() {
        return variant;
    }

    public void setVariant(BagelVariant variant) {
        this.variant = variant;
    }

    public List<Filling> getFillings() {
        return fillings;
    }

    public void setFillings(List<Filling> fillings) {
        this.fillings = fillings;
    }

    public void addFilling(Filling filling) {
        fillings.add(filling);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bagel bagel = (Bagel) o;
        return Objects.equals(fillings, bagel.fillings) && variant == bagel.variant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fillings, variant);
    }

    @Override
    public String toString() {
        return variant + " Bagel";
    }
}
