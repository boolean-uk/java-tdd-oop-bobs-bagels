package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Basket {
    private final List<Bagel> bagels;

    public Basket() {
        this.bagels = new ArrayList<>();
    }

    public boolean addItem(Bagel bagel) {
        return bagels.add(bagel);
    }

    public boolean removeItem(UUID id) {
        Bagel bagel = bagels.stream()
                .filter(b -> b.getId()
                .equals(id))
                .findFirst().get();
        return bagels.remove(bagel);
    }
}
