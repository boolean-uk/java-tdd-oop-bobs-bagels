package com.booleanuk.core;

import java.util.HashMap;
import java.util.UUID;

public class Order {

    public HashMap<String, Integer> basket = new HashMap<>();
    private UUID id;

    public Order(UUID id){
        this.id = id;
    }
}
