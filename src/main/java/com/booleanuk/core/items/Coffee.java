package com.booleanuk.core.items;


public class Coffee extends FillableProduct<CoffeeFilling> {
    public Coffee(String variant, double price) {
        super(variant, price);
    }

    @Override
    public boolean isType(Category type) {
        return type == Category.COFFEE;
    }
}
