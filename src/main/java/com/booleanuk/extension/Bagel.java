package com.booleanuk.extension;

import com.booleanuk.extension.types.BagelType;
import com.booleanuk.extension.types.FillingType;

import java.util.Objects;

public class Bagel extends Item {
    private BagelType bagelType;
    private FillingType fillingType;

    public Bagel(BagelType bagelType, FillingType fillingType) {
        this.bagelType = bagelType;
        this.fillingType = fillingType;
        this.price = bagelType.getPrice() + fillingType.getPrice();
    }

    public BagelType getBagelType() {
        return bagelType;
    }

    public FillingType getFillingType() {
        return fillingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bagel bagel)) return false;
        return bagelType == bagel.bagelType && fillingType == bagel.fillingType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bagelType, fillingType);
    }

    @Override
    public String toString() {
        return bagelType + " with " + fillingType;
    }
}
