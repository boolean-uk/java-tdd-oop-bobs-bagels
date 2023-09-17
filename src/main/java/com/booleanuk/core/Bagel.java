package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Bagel extends Product implements Sellable, Fillable {
    private ArrayList<Filling> fillings;

    public Bagel(String sku, BigDecimal price, String name, String variant) {
        super(sku, price, name, variant);
        this.fillings = new ArrayList<>();
    }

    public Bagel(String sku) {
        super(sku);
    }

    @Override
    public double calculateTotalPrice(int quantity) {
        return 0;
    }

    // implement filling functionality


    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal fillingsPrice = BigDecimal.ZERO;
        for (Filling filling : this.fillings) {
            fillingsPrice = fillingsPrice.add(filling.getPrice());
        }
        return this.getPrice().add(fillingsPrice);
    }

    @Override
    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }

//    public boolean addFillingBySku(String sku, Inventory inventory) {
//        Item filling = inventory.getItemBySku(sku);
//        return filling != null && this.fillings.add((Filling) filling);
//    }
    public void addFilling(Filling filling) {
        fillings.add(filling);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bagel bagel = (Bagel) o;
        return Objects.equals(fillings, bagel.fillings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fillings);
    }

    @Override
    public String toString() {
        return String.format("%s Bagel", this.variant);
    }
}
