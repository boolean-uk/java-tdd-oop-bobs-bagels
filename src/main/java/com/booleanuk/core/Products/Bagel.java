package com.booleanuk.core.Products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Bagel extends Item implements Sellable, Fillable {
    private ArrayList<Filling> fillings;
    private BagelType variant;

    public Bagel(String SKU, BigDecimal price, String name, BagelType variant) {
        super(SKU, price, name);
        this.fillings = new ArrayList<>();
        this.variant = variant;
    }

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

    @Override
    public BagelType getVariant() {
        return variant;
    }

    @Override
    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }


    public boolean addFilling(Filling filling) {
        if (this.getFillings().size()<this.MAX_FILLINGS) {
            this.fillings.add(filling);
            return true;
        } else {
            System.out.printf("Cannot add more than %s fillings!\n",this.MAX_FILLINGS);
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bagel bagel = (Bagel) o;
        return Objects.equals(fillings, bagel.fillings) && Objects.equals(getSku(), bagel.getSku());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fillings, getSku());
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
