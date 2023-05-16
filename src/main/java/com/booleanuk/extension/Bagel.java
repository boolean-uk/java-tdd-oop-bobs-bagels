package com.booleanuk.extension;

import java.util.ArrayList;

public class Bagel extends AbstractItem implements CalculateDiscount {
    private ArrayList<Filling> fillings;

    public Bagel(Sku sku, double price, double saving, int quantity, String name, String variant)
    {
        super(sku,  price,  saving, quantity,  name, variant);
        this.fillings = new ArrayList<>();
    }
    @Override
    public void display() {

    }

    public ArrayList<Filling> getFillings() {
        return fillings;
    }

    @Override
    public double calculateDiscount() {
        return 0;
    }
}
