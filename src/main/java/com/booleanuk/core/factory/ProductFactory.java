package com.booleanuk.core.factory;

import com.booleanuk.core.Product;
import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.CoffeeType;
import com.booleanuk.core.enums.FillingType;
import com.booleanuk.core.enums.SKU;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.inherited.Coffee;
import com.booleanuk.core.inherited.Filling;
import com.booleanuk.core.interfaces.ProductInterface;

public class ProductFactory implements ProductInterface {

    public Product addBagel(BagelType variant) {
        String name = "Bagel";

        switch (variant) {
            case ONION -> {
                return new Bagel(name, 0.49, SKU.BGLO, variant);
            }
            case PLAIN -> {
                return new Bagel(name, 0.39, SKU.BGLP, variant);
            }
            case EVERYTHING -> {
                return new Bagel(name, 0.49, SKU.BGLE, variant);
            }
            case SESAME -> {
                return new Bagel(name, 0.49, SKU.BGLS, variant);
            }
            default -> throw new IllegalArgumentException("Invalid bagel type!");
        }
    }

    public Product addCoffee(CoffeeType variant) {
        String name = "Coffee";

        switch (variant) {
            case BLACK -> {
                return new Coffee(name, 0.99, SKU.COFB, variant);
            }
            case WHITE -> {
                return new Coffee(name, 1.19, SKU.COFW, variant);
            }
            case CAPUCCINO -> {
                return new Coffee(name, 1.29, SKU.COFC, variant);
            }
            case LATTE -> {
                return new Coffee(name, 1.29, SKU.COFL, variant);
            }
            default -> throw new IllegalArgumentException("Invalid coffee type!");
        }
    }

    public Product addFilling(FillingType variant) {
        String name = "Filling";
        double price = 0.12f;

        switch (variant) {
            case BACON -> {
                return new Filling(name, price, SKU.FILB, variant);
            }
            case EGG -> {
                return new Filling(name, price, SKU.FILE, variant);
            }
            case CHEESE -> {
                return new Filling(name, price, SKU.FILC, variant);
            }
            case CREAM_CHEESE -> {
                return new Filling(name, price, SKU.FILX, variant);
            }
            case SMOKED_SALMON -> {
                return new Filling(name, price, SKU.FILS, variant);
            }
            case HAM -> {
                return new Filling(name, price, SKU.FILH, variant);
            }
            default -> throw new IllegalArgumentException("Invalid filling type");
        }
    }
}
