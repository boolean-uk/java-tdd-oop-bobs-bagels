package com.booleanuk.core;

import java.util.HashMap;

public class Discount {
    HashMap<String, DiscountItem> discountMap;

    public Discount() {
        this.discountMap = new HashMap<>(){{
            put("BGL6", new DiscountItem("Bagel","", 2.49, 6));
            put("BGL12", new DiscountItem("Bagel","",  3.99, 12));
            put("COF", new DiscountItem("Coffee", "", 1.25, 1));
        }};
    }
}
