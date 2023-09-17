package com.booleanuk.core.Products;

import java.math.BigDecimal;

public class Coffee extends Product implements Sellable {
    private CoffeeType variant;


    public Coffee(String SKU, BigDecimal price, String name, CoffeeType variant) {
        super(SKU, price, name);
        this.variant = variant;
    }

    public CoffeeType getVariant() {
        return variant;
    }

    public void setVariant(CoffeeType variant) {
        this.variant = variant;
    }

    @Override
    public double calculateTotalPrice(int quantity) {
        return 0;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false; // Check SKU equality from the parent class
//        Coffee coffee = (Coffee) o;
//        // Add additional equality checks specific to Coffee
//        return true; // Customize this as needed
//    }
//
//    @Override
//    public int hashCode() {
//        // Customize the hash code generation for Coffee
//        return Objects.hash(super.hashCode(), /* Add additional attributes for Coffee */);
//    }

    @Override
    public String toString() {
        return String.format("%s %s", this.variant, this.name);
    }
}
