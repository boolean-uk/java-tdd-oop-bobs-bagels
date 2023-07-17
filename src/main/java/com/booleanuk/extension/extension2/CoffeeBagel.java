package com.booleanuk.extension.extension2;

import java.math.BigDecimal;
import java.util.List;

public class CoffeeBagel extends Product {

    private static final List<ProductType> bagelList = List.of(
            ProductType.BGLE,
            ProductType.BGLO,
            ProductType.BGLP,
            ProductType.BGLS
    );
    private ProductType coffeeType;
    private ProductType coffeeBagleType;
    private ProductType bagelType;

    public CoffeeBagel(ProductType bagelType) {
        checkIfProductIsBagel(bagelType);
        this.coffeeBagleType = ProductType.CBD;
        this.coffeeType = ProductType.COFB;
        this.bagelType = bagelType;
        updatePrice();
    }

    @Override
    public ProductType getTypeOfProduct() {
        return coffeeBagleType;
    }

    private void updatePrice(){
        setPrice(coffeeBagleType.getPrice());
    }

    private void checkIfProductIsBagel(ProductType productType){
        if (!bagelList.contains(productType))
            throw new IllegalStateException("This is not a bagel;");
    }

}
