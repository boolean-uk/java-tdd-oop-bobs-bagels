package com.booleanuk.core.inventory;

import com.booleanuk.core.PriceCalculator;
import com.booleanuk.core.ProductName;
import com.booleanuk.core.SKUCalculator;

public class InventoryItem {

    // TODO: should I change this to protected?
    // TODO should I change this to abstract? Check if possible.

    private String SKU;
    private float price;
    private ProductName name;
    private Enum variant;

    private SKUCalculator skuCalculator;
    private PriceCalculator priceCalculator;

    public InventoryItem(float price, Enum variant) {

        this.price = price;
        this.name = setName();
        this.variant = variant;

        this.skuCalculator = new SKUCalculator();
        this.SKU = setSKU();

        this.priceCalculator = new PriceCalculator();

    }

    public String getSKU() {
        return SKU;
    }

    public String setSKU() {
        return skuCalculator.getSKU(name, variant);
    }

    public double getPrice() {
        return priceCalculator.round(price, 2);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductName getName() {
        return name;
    }

    public ProductName setName() {
        return ProductName.DEFAULT;
    }

    public Enum getVariant() {
        return variant;
    }

    public void setVariant(Enum variant) {
        this.variant = variant;
    }
}
