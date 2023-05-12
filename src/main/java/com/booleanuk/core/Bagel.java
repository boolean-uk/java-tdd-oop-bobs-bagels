package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel {
    private final String variant;
    private final double price;
    private final List<Filling> fillings;

    public Bagel(String variant, double price, List<Filling> fillings){
        this.variant = variant;
        this.price = price;
        this.fillings = fillings;
    }

    public Bagel(String variant, double price){
        this.variant = variant;
        this.price = price;
        this.fillings = new ArrayList<>();
    }

    public String getVariant(){
        return this.variant;
    }

    public double getPrice(){
        return this.price +
                this.fillings.stream().reduce(0.0, (sum, f) -> sum += f.getPrice(), Double::sum);
    }

    public Filling addFilling(Filling filling){
        this.fillings.add(filling);

        return this.fillings.get(fillings.size() - 1);
    }
}
