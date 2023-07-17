package com.booleanuk.extension;

import java.math.BigDecimal;

public class Inventory {

    public static Product getProduct(String sku) {
        return switch (sku) {
            case "BGLO" -> new Bagel("BGLO", BigDecimal.valueOf(0.49), "Onion");
            case "BGLP" -> new Bagel("BGLP", BigDecimal.valueOf(0.39), "Plain");
            case "BGLE" -> new Bagel("BGLE", BigDecimal.valueOf(0.49), "Everything");
            case "BGLS" -> new Bagel("BGLS", BigDecimal.valueOf(0.49), "Sesame");
            case "COFB" -> new Coffee("COFB", BigDecimal.valueOf(0.99), "Black");
            case "COFW" -> new Coffee("COFW", BigDecimal.valueOf(1.19), "White");
            case "COFC" -> new Coffee("COFC", BigDecimal.valueOf(1.29), "Capuccino");
            case "COFL" -> new Coffee("COFL", BigDecimal.valueOf(1.29), "Latte");
            case "FILB" -> new Filling("FILB", BigDecimal.valueOf(0.12), "Bacon");
            case "FILE" -> new Filling("FILE", BigDecimal.valueOf(0.12), "Egg");
            case "FILC" -> new Filling("FILC", BigDecimal.valueOf(0.12), "Cheese");
            case "FILX" -> new Filling("FILX", BigDecimal.valueOf(0.12), "Cream Cheese");
            case "FILS" -> new Filling("FILS", BigDecimal.valueOf(0.12), "Smoked Salmon");
            case "FILH" -> new Filling("FILH", BigDecimal.valueOf(0.12), "Ham");
            default -> throw new IllegalArgumentException("No such product");
        };
    }
}
