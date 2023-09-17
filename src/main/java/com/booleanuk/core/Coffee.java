package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.Objects;

public class Coffee extends Product implements Sellable{
    public Coffee(String sku, BigDecimal price, String name, String variant) {
        super(sku, price, name, variant);
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
}
