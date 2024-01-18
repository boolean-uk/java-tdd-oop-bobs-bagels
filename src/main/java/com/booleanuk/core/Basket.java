package com.booleanuk.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {
    private HashMap<String, Integer> basketMap;
    private Inventory inventory;
    private int capacity;

    public Basket() {
        this.basketMap = new HashMap<>();
        this.inventory = new Inventory();
        this.setCapacity(5);
    }

    public HashMap<String, Integer> getBasketMap() {
        return basketMap;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            return true;
        }
        return false;
    }

    public String add(String sku) {
        if (this.basketMap.values().stream()
                .mapToInt(Integer::valueOf)
                .sum() >= this.capacity) {
            return "Basket is full";
        }
        if (this.basketMap.containsKey(sku)) {
            this.basketMap.put(sku, this.basketMap.get(sku)+1);
            return "Product added to basket";
        } else {
            for (Product product : inventory.getProducts()) {
                if (sku.equals(product.getSku())) {
                    this.basketMap.put(sku, 1);
                    return "Product added to basket";
                }
            }
        }
        return "Product not found";
    }

    public String remove(String sku) {
        if (this.basketMap.containsKey(sku)) {
            if (this.basketMap.get(sku) == 1) {
                this.basketMap.remove(sku);
            } else {
                this.basketMap.put(sku, this.basketMap.get(sku)-1);
            }
            return "Product removed from basket";
        }
        return "Product is not in basket";
    }

    public double totalCost() {
        double cost = 0;
        for(Map.Entry<String, Integer> entry: this.basketMap.entrySet()) {
                    cost += this.inventory.getProductCost(entry.getKey())*entry.getValue();
        }
        return cost;
    }

    public String addFilling(String sku) {
        //List<String> bagelSku = this.inventory.getProducts().stream().filter(x -> x.getName().equals("Bagel")).map(Product::getSku).toList();
        if (Collections.disjoint(this.basketMap.keySet(), this.inventory.getProducts().stream().filter(x -> x.getName().equals("Bagel")).map(Product::getSku).toList())) {
            return "You need to add a bagel to your basket";
        }
        for(Product product: this.inventory.getProducts()) {
            if(sku.equals(product.getSku())) {
                if (product.getName().equals("Filling")) {
                    String addMessage = this.add(sku);
                    if(addMessage.equals("Product added to basket")) {
                        return "Filling added";
                    } else {
                        return addMessage;
                    }
                } else {
                    return "Product needs to be a filling";
                }
            }
        }
        return "Filling was not found";
    }
}
