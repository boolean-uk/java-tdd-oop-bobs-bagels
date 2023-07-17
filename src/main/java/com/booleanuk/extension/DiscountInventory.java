package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DiscountInventory {
    private static final Set<Discount> discounts = new HashSet<>();

    static {
        discounts.add(new Discount("BGLO", BigDecimal.valueOf(0.49), 6));
        discounts.add(new Discount("BGLP", BigDecimal.valueOf(3.99), 12));
        discounts.add(new Discount("BGLE", BigDecimal.valueOf(2.49), 6));
        discounts.add(new Discount("COFB", BigDecimal.valueOf(1.25), 1));
    }

    public static Discount searchDiscount(String SKU) {
        for (Discount discount : discounts) {
            if (discount.SKU().equals(SKU)) {
                return (new Discount(discount.SKU(), discount.price(), discount.quantity()));
            }
        }
        return null;
    }
}
