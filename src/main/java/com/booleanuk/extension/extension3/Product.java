package com.booleanuk.extension.extension3;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Product {
    private BigDecimal price;

    public abstract ProductType getTypeOfProduct();

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void addToPrice(BigDecimal addToPrice) {
        price = price.add(addToPrice);
    }

    public BigDecimal getFillingPrice(){
        return BigDecimal.ZERO;
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
        return Objects.equals(getTypeOfProduct(), other.getTypeOfProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeOfProduct());
    }

    protected Object getBagelType() {
        return null;
    }
}
