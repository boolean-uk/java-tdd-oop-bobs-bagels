package com.booleanuk.core.items;

import com.booleanuk.core.format.FirstLetterToUpperFormat;
import com.booleanuk.core.format.Format;

import java.util.*;

public abstract class Filling implements Item {
    private final String variant;
    private final double price;
    private final Format<String> format;

    public Filling(String variant, double price) {
        this(variant, price, new FirstLetterToUpperFormat());
    }

    public Filling(String variant, double price, Format<String> format) {
        this.variant = variant;
        this.price = price;
        this.format = format;
    }

    @Override
    public boolean isType(Category type) {
        return type == Category.FILLING;
    }

    @Override
    public String variant() {
        return format.result(this.variant);
    }

    @Override
    public double cost() {
        return this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Filling)) return false;

        Filling objItem = (Filling) obj;

        return this.variant().equals(objItem.variant()) && this.cost() == objItem.cost();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.variant(), this.cost());
    }
}
