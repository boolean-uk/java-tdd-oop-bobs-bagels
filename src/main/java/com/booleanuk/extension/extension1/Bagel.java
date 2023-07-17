package com.booleanuk.extension.extension1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product{
    private static final List<ProductType> bagelList = List.of(
            ProductType.BGLE,
            ProductType.BGLO,
            ProductType.BGLP,
            ProductType.BGLS
    );
    private ProductType bagelType;
    private BigDecimal fillingPrices = BigDecimal.ZERO;
    private ArrayList<FillingType> fillingTypes = new ArrayList<>();

    public Bagel(ProductType bagelType) {
        checkIfProductIsBagel(bagelType);
        this.bagelType = bagelType;
        updatePrice();
    }

    public void addFilling(FillingType fillingType){
        fillingTypes.add(fillingType);
        fillingPrices = fillingPrices.add(fillingType.getPrice());
    }

    private void updatePrice(){
        setPrice(bagelType.getPrice());
    }

    private void checkIfProductIsBagel(ProductType productType){
        if (!bagelList.contains(productType))
            throw new IllegalStateException("This is not a bagel;");
    }

    @Override
    public ProductType getTypeOfProduct() {
        return bagelType;
    }

    @Override
    public BigDecimal getFillingPrice(){
        return fillingPrices;
    }
}
