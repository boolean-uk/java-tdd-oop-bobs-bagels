package com.booleanuk.core;

import java.util.Objects;

public class BaconBagel implements Bagel {
    private final String SKU = "FILBL";


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bagel that = (Bagel) o;
        return Objects.equals(SKU, that.sku());
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU);
    }
    @Override
    public String sku() {
        return SKU;
    }
}
