package com.booleanuk.core;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static AtomicInteger count;
    private int id;
    private String name;
    private Basket inventory;

    public Customer(String name) {
        count = new AtomicInteger(0);
        this.id = count.incrementAndGet();
        this.name = name;
        this.inventory = new Basket();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Basket getInventory() {
        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculateCostBeforeOrder() {
        return -1;
    }

    public Basket chooseFilling(String sku) {
        return this.inventory;
    }

    public boolean order(String sku) {
        return false;
    }

    public boolean deleteItems(String sku) {
        return false;
    }
}
