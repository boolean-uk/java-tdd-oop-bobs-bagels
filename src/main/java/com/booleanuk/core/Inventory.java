package com.booleanuk.core;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Inventory {


    private Map<String, Double> fillings;
    private Map<String, Double> coffees;
    private Map<String, Double> bagels;

    public Inventory() {
        this.fillings = Map.of("FILB", 0.12,"FILE", 0.12,"FILC", 0.12,"FILX", 0.12,"FILS", 0.12,"FILH", 0.12);
        this.coffees = Map.of("COFB", 0.99,"COFW", 1.19,"COFC", 1.29,"COFL", 1.29);
        this.bagels = Map.of("BGLO", 0.49,"BGLP", 0.39,"BGLE", 0.49);

    }


    public Map<String, Double> getFillings() {
        return this.fillings;
    }

    public Map<String, Double> getCoffees() {
        return this.coffees;
    }

    public Map<String, Double> getBagels() {
        return this.bagels;
    }

    public Map<String, Double> getInventoryMap() {
        return Stream.of(this.getBagels().entrySet(), this.getCoffees().entrySet(), this.getFillings().entrySet())
                .flatMap(Set::stream)
                .collect((toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }
}
