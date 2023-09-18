package com.booleanuk.core.Products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Bagel extends Product implements Sellable, Fillable {
    private ArrayList<Filling> fillings;
    private BagelType variant;
    public Bagel(String SKU, BigDecimal price, String name,BagelType variant ) {
        super(SKU, price, name);
        this.fillings = new ArrayList<>();
        this.variant = variant;
    }

    public Bagel(String SKU) {
        super(SKU);
    }



    // implement filling functionality


    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }

    public void setFillings(ArrayList<Filling> fillings) {
        this.fillings = fillings;
    }

    public boolean setVariant(BagelType newVariant) {

        if (Arrays.asList(BagelType.values()).contains(newVariant)) {
            this.variant = newVariant;
            return true;
        } else {
            return false;
        }
    }


    public BagelType getVariant() {
        return variant;
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
        return String.format("%s %s", this.variant, this.name);
    }

    @Override
    public BigDecimal calculateTotalPriceItem() {
        BigDecimal fillingsPriceSum = fillings.stream()
                .map(Filling::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return this.getPrice().add(fillingsPriceSum);
    }
}
