package com.booleanuk.extension;

public class Filling extends AbstractItem implements CalculateDiscount {
    public Filling(Sku sku, double price, double saving, int quantity, String name, String variant)
    {
        super(sku,  price,  saving, quantity,  name, variant);
    }
    @Override
    public void display() {

    }

    @Override
    public double calculateDiscount() {
        return 0;
    }
}
