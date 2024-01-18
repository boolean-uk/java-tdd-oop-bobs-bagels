package com.booleanuk.core.models.item;

import com.booleanuk.core.models.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Objects;

@Getter
public class Bagel extends Item {
    ArrayList<Filling> filling;

    public Bagel(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
        this.filling = new ArrayList<>();
    }

    public Bagel(Bagel another) {
        super(another);
        this.filling = new ArrayList<>(another.filling);
    }

    public boolean addFilling(Filling filling) {
        return this.filling.add(filling);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bagel bagel = (Bagel) o;
        return Objects.equals(filling, bagel.filling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), filling);
    }

    @Override
    public String toString() {
        return "Bagel(" +
                "id=" + System.identityHashCode(this) +
                ", SKU=" + getSKU() +
                ", price=" + getPrice() +
                ", name=" + getName() +
                ", variant=" + getVariant() +
                ", filling=" + filling +
                ")";
    }
}
