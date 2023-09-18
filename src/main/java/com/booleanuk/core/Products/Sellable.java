package com.booleanuk.core.Products;

import java.math.BigDecimal;

public interface Sellable {
    public abstract BigDecimal calculateTotalPriceItem();
    // Either abstract method in Item or in Sellable interface
}
