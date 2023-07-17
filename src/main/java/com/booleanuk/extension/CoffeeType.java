package com.booleanuk.extension;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public enum CoffeeType implements IItemType {
    COFB("COFB", 0.99, "Black"),
    COFW("COFW", 1.19, "White"),
    COFL("COFL", 1.29, "Latte"),
    COFC("COFC", 1.29, "Cappuccino");

    CoffeeType(String sku, double price, String variant) {
        this.sku = sku;
        this.price = price;
        this.variant = variant;
    }
    public double getPrice() {
        return price;
    }
    public String getVariant() {
        return variant;
    }
    public String getSku() {
        return sku;
    }
    public final String sku;
    private final double price;
    private final String variant;
    public static CoffeeType order() {
        Scanner input = new Scanner(System.in);
        for (;;) {
            System.out.println("""
                    Available bagels:
                    COFB - black(£0.99),
                    COFW - white(£1.19),
                    COFL - latte(£1.29),
                    COFC - cappuccino(£1.29).
                    Type cancel to exit""");
            String choice = input.next();
            if(choice.equalsIgnoreCase("cancel"))
                return null;
            for(CoffeeType coffeeType : CoffeeType.values()) {
                if(coffeeType.getSku().equals(choice))
                    return coffeeType;
            }
        }
    }
}
