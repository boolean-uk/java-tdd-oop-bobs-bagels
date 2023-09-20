package com.booleanuk.core.Products;

import java.math.BigDecimal;
import java.util.Objects;

public class Coffee extends Item implements Sellable {
    public static final BigDecimal COFFEE_AND_BAGEL_DISCOUNT_PRICE = BigDecimal.valueOf(1.25);
    public static final BigDecimal COFFEE_AND_BAGEL_SAVINGS = BigDecimal.valueOf(0.13);
    private CoffeeType variant;
    public boolean bagelAdded;

    public Coffee(String SKU, BigDecimal price, String name, CoffeeType variant) {
        super(SKU, price, name);
        this.variant = variant;
        this.bagelAdded = false;
    }

    @Override
    public CoffeeType getVariant() {
        return variant;
    }

    public void setVariant(CoffeeType variant) {
        this.variant = variant;
    }

    public  boolean hasDiscount() {
        return this.getSku().equals("COFB");
    }

    public boolean isBagelAdded() {
        return bagelAdded;
    }

    public void setBagelAdded(boolean bagelAdded) {
        if (this.hasDiscount()) {
            this.bagelAdded = bagelAdded;
        }
    }


    @Override
    public String toString() {
        return String.format("%s %s%s", this.variant, this.name, this.isBagelAdded()? " with Bagel" : "");
    }

    @Override
    public BigDecimal calculateTotalPriceItem() {
        if (isBagelAdded()) {
            return COFFEE_AND_BAGEL_DISCOUNT_PRICE;
        }
        return this.getPrice();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Coffee coffee = (Coffee) o;
//        return bagelAdded == coffee.bagelAdded && variant == coffee.variant;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), variant, bagelAdded);
//    }
}
