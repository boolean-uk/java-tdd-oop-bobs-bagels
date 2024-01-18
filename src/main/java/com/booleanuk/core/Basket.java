package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    ArrayList<Product> itemBasket;
    int capacity;

    public ArrayList<Product> getItemBasket() {
        return itemBasket;
    }

    public Basket(int capacity){
        this.capacity = capacity;
        this.itemBasket = new ArrayList<>();
    }

    public boolean basketIsFull(){
        return itemBasket.size() >= changeCapacity(capacity);
    }

    public String addItem(Product item){
        if (item == null && itemBasket.isEmpty()){
            return "Basket is empty";
        }
        else if (basketIsFull()){
            return "Can't add anymore, basket is full";
        }
        itemBasket.add(item);
        return "Item has been added to your basket";
    }

    public String removeItem(Product item){
        if (!itemBasket.contains(item)){
            return "Can not remove non-existing item.";
        }
        itemBasket.remove(item);
        return "Item has been removed from your basket";
    }

    public int changeCapacity(int newCapacity){
        this.capacity = newCapacity;
        return newCapacity;
    }

    public double calculateTotalCost(){
        double totalCost = 0;
        for (Product item : itemBasket){
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}
