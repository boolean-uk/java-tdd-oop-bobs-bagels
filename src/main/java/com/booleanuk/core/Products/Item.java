package com.booleanuk.core.Products;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Item {
    protected String SKU;
    protected BigDecimal price;
    protected String name;


    public Item(String SKU, BigDecimal  price, String name) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;

    }

    protected Item(String sku) {
        this(sku, null, null);
    }


//    public Item(String name, String variant) {
//        this.name = name;
//        this.variant = variant;
//    }

    public String getSku() {
        return this.SKU;
    }

    public void setSku(String sku) {
        this.SKU = sku;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public boolean setName(String name) {
        if (name.isBlank()) {
            return false;
        }
        this.name = name;
        return true;
    }
// protected setters??
    // abstract methods - do we need different implementation?
//    public String getVariant() {
//        return this.variant;
//    }
//
//    public boolean setVariant(String variant) {
//        if (variant.isBlank()) {
//            return false;
//        }
//        this.variant = variant;
//        return true;
//    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(SKU, item.SKU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU);
    }


}
