package com.booleanuk.core;

import java.util.*;

public class Bagel extends Product{
    private List<Filling> fillings;

    public Bagel(String SKU, Double price, String variant, List<Filling> fillings) {
        super(SKU, price, variant);
        this.fillings = fillings;
    }

    public List<Filling> getFillings() {
        return fillings;
    }

    public void setFillings(List<Filling> fillings) {
        this.fillings = fillings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bagel bagel = (Bagel) o;
        return Objects.equals(fillings, bagel.fillings) &&
                Objects.equals(SKU, bagel.SKU) &&
                Objects.equals(price, bagel.price) &&
                Objects.equals(variant, bagel.variant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fillings);
    }

    @Override
    public String toString() {
        return "Bagel{" +
                "fillings=" + fillings +
                ", SKU='" + SKU + '\'' +
                ", price=" + price +
                ", variant='" + variant + '\'' +
                '}';
    }
}
