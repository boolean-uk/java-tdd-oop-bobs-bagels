package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bagel extends Item {

    private final Map<String, Integer> fillings;

    public Bagel(String name, String sKU) {
        super(name, sKU);
        this.fillings = new HashMap<>();
    }

    public Set<String> getFillings() {
        return this.fillings.keySet();
    }

    public int getFillingAmount(String filling) {
        return this.fillings.getOrDefault(filling, 0);
    }

    public void addFilling(String filling) {
        if (this.fillings.containsKey(filling)) {
            int newAmount = this.fillings.get(filling) + 1;
            this.fillings.replace(filling, newAmount);
        } else {
            this.fillings.put(filling, 1);
        }
    }
}
