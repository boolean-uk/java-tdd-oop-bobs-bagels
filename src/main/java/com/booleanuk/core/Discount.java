package com.booleanuk.core;

import java.util.HashMap;

public class Discount {
    HashMap<String, DiscountItem> discountMap;

    public Discount() {
        this.discountMap = new HashMap<>(){{
            put("BGL", new DiscountItem("Bagel", 2.49, 6));
            put("BGL", new DiscountItem("Bagel", 3.99, 12));
            put("BGL", new DiscountItem("Bagel", 2.49, 6));
            put("COF", new DiscountItem("Coffee", "Bagel", 1.25, 1));
        }};
    }
}
