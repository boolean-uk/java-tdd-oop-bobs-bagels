package com.booleanuk.core;

public class Order {
    public String itemUUID;
    public int amount;

    public Order() {}
    public Order(String uuid, int amount) {
        this.amount = amount;
        this.itemUUID = uuid;
    }

    public boolean equals(Order other) {
        return itemUUID.equals(other.itemUUID);
    }
}
