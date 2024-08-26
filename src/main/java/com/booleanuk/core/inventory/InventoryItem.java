package com.booleanuk.core.inventory;

import com.booleanuk.core.calculators.PriceCalculator;
import com.booleanuk.core.enums.ProductName;
import com.booleanuk.core.calculators.SKUCalculator;

public class InventoryItem {

    // TODO: should I change this to protected?
    // TODO should I change this to abstract? Check if possible.
    // TODO: Change 'float price' to double? Or keep float as it takes up less memory?

    private final String SKU;
    private float price;
    private final ProductName name;
    private Enum variant;

    private final SKUCalculator skuCalculator;
    private final PriceCalculator priceCalculator;

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

    protected String setSKU() {
        return skuCalculator.getSKU(name, variant);
    }

    public double getPrice() {
        return priceCalculator.round(price, 2);
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    public ProductName getName() {
        return name;
    }

    protected ProductName setName() {
        return ProductName.DEFAULT;
    }

    public Enum getVariant() {
        return variant;
    }

    protected void setVariant(Enum variant) {
        this.variant = variant;
    }
}
