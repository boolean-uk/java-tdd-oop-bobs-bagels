package com.booleanuk.extension.extension2;

import java.math.BigDecimal;

public class CoffeeBagel extends Product {
    private ProductType coffeeType;
    private ProductType coffeeBagleType;
    private Bagel bagel;

    public CoffeeBagel(ProductType coffeeType, Bagel bagel) {
        this.coffeeBagleType = ProductType.CBD;
        this.coffeeType = coffeeType;
        this.bagel = bagel;
        updatePrice();
    }

    @Override
    public ProductType getTypeOfProduct() {
        return coffeeType;
    }

    @Override
    public BigDecimal getFillingPrice(){
        return bagel.getFillingPrice();
    }

    private void updatePrice(){
        setPrice(coffeeBagleType.getPrice());
    }

}
