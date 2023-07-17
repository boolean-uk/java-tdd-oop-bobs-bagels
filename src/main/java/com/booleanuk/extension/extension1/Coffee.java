package com.booleanuk.extension.extension1;

import java.util.List;

public class Coffee extends Product{
    private static final List<ProductType> cofeeList = List.of(
            ProductType.COFB,
            ProductType.COFW,
            ProductType.COFC,
            ProductType.COFL
    );

    private ProductType coffeeType;

    public Coffee(ProductType coffeeType) {
        checkIfProductIsCoffee(coffeeType);
        this.coffeeType = coffeeType;
        updatePrice();
    }

    private void updatePrice(){
        setPrice(coffeeType.getPrice());
    }

    private void checkIfProductIsCoffee(ProductType productType){
        if (!cofeeList.contains(productType))
            throw new IllegalStateException("This is not a bagel;");
    }

    @Override
    public ProductType getTypeOfProduct() {
        return coffeeType;
    }
}
