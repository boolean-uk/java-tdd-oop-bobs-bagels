package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Bagel> bagels;

    public Basket() {
        this.bagels = new ArrayList<>();
    }

    public boolean add(Bagel bagel) {
        return bagels.add(bagel);
    }
}
