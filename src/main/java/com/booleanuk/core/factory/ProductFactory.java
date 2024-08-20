package com.booleanuk.core.factory;

import com.booleanuk.core.Product;
import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.CoffeeType;
import com.booleanuk.core.enums.FillingType;
import com.booleanuk.core.enums.SKU;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.inherited.Coffee;
import com.booleanuk.core.inherited.Filling;
import com.booleanuk.core.interfaces.MenuCategory;
import com.booleanuk.core.interfaces.ProductInterface;

import static com.booleanuk.core.enums.BagelType.*;
import static com.booleanuk.core.enums.CoffeeType.*;
import static com.booleanuk.core.enums.FillingType.*;

public class ProductFactory implements ProductInterface {

    public Product getProduct(MenuCategory variant) {
        String bagelName = "Bagel";
        String coffeeName = "Coffee";
        String fillingName = "Filling";
        double fillingPrice = 0.12;

        switch (variant) {
            case ONION -> {
                return new Bagel(bagelName, 0.49, SKU.BGLO, (BagelType) variant);
            }
            case PLAIN -> {
                return new Bagel(bagelName, 0.39, SKU.BGLP, (BagelType) variant);
            }
            case EVERYTHING -> {
                return new Bagel(bagelName, 0.49, SKU.BGLE, (BagelType) variant);
            }
            case SESAME -> {
                return new Bagel(bagelName, 0.49, SKU.BGLS, (BagelType) variant);
            }
            case BLACK -> {
                return new Coffee(coffeeName, 0.99, SKU.COFB, (CoffeeType) variant);
            }
            case WHITE -> {
                return new Coffee(coffeeName, 1.19, SKU.COFW, (CoffeeType) variant);
            }
            case CAPUCCINO -> {
                return new Coffee(coffeeName, 1.29, SKU.COFC, (CoffeeType) variant);
            }
            case LATTE -> {
                return new Coffee(coffeeName, 1.29, SKU.COFL, (CoffeeType) variant);
            }
            case BACON -> {
                return new Filling(fillingName, fillingPrice, SKU.FILB, (FillingType) variant);
            }
            case EGG -> {
                return new Filling(fillingName, fillingPrice, SKU.FILE, (FillingType) variant);
            }
            case CHEESE -> {
                return new Filling(fillingName, fillingPrice, SKU.FILC, (FillingType) variant);
            }
            case CREAM_CHEESE -> {
                return new Filling(fillingName, fillingPrice, SKU.FILX, (FillingType) variant);
            }
            case SMOKED_SALMON -> {
                return new Filling(fillingName, fillingPrice, SKU.FILS, (FillingType) variant);
            }
            case HAM -> {
                return new Filling(fillingName, fillingPrice, SKU.FILH, (FillingType) variant);
            }
            default -> throw new IllegalArgumentException("Invalid product type!");
        }
    }
}
