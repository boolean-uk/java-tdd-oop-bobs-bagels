package com.booleanuk.extension.extension3;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
        setPrice(coffeeType.getPrice().add(bagelType.getPrice()));
    }

    private void checkIfProductIsBagel(ProductType productType){
        if (!bagelList.contains(productType))
            throw new IllegalStateException("This is not a bagel;");
    }

    public ProductType getBagelType(){
        return bagelType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(getBagelType(), other.getBagelType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBagelType());
    }

}
