package com.booleanuk.extension;

public class Coffee extends AbstractItem implements CalculateDiscount {
    public Coffee(Sku sku, double price, double saving, int quantity, String name, String variant)
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
