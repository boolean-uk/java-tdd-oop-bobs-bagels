package com.booleanuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bagel extends Item {
    private final List<Filling> fillings = new ArrayList<>();
    private final Inventory inventory;

    public Bagel(String variant, double price, Inventory inventory){
        super(variant, price);
        this.inventory = inventory;
    }

    @Override
    public double getPrice() {
        return super.getPrice() +
                this.fillings.stream().reduce(0.0, (sum, f) -> sum += f.getPrice(), Double::sum);
    }

    public boolean addFilling(Filling filling) {
        if (!inventory.contains(filling)) return false;

        this.fillings.add(filling);

        return true;
    }

    public List<Filling> getFillings() {
        return this.fillings;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.getFillings().containsAll(((Bagel) obj).getFillings());
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(this.fillings);
    }
}