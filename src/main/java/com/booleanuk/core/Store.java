package com.booleanuk.core;

import java.util.HashMap;
import java.util.UUID;

public class Store {
    private int capacity = 10;
    Product[] inventory = new Product[12];
    HashMap<String,Order> orders;

    Store() {


    }

    public void updateCapacity(int capacity) {
        this.capacity += capacity;

    }

    public int getCapacity() {
        return capacity;
    }

    public void addOrder(Order order) {
       String uuid = generateId();
       orders.put(uuid, order);

    }

    private String generateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
