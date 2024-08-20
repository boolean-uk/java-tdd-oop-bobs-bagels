package com.booleanuk.core.products.bagels;

import com.booleanuk.core.products.fillings.Filling;
import com.booleanuk.core.products.Product;

public abstract class Bagel extends Product {

    private Filling currentFilling;

    public Bagel(String SKU, double price) {
        super(SKU, price);
        this.currentFilling = null;
    }

    public Filling getFilling() {
        return this.currentFilling;
    }

    public void setFilling(Filling newFilling) {
        this.currentFilling = newFilling;
    }

    @Override
    public double getPrice() {
        if (this.currentFilling == null) return super.getPrice();
        else return super.getPrice() + this.currentFilling.getPrice();
    }

}
