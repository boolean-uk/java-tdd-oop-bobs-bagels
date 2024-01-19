package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    ArrayList<Product> itemBasket;
    int capacity;
    Inventory inventory;

    public Basket(Inventory inventory,int capacity){
        this.capacity = capacity;
        this.itemBasket = new ArrayList<>();
        this.inventory = inventory;
    }

    public ArrayList<Product> getItemBasket() {
        return itemBasket;
    }
    public String currentBasketToString(){
        StringBuilder currentBasket = new StringBuilder();
        for (Product item: itemBasket){
            currentBasket.append(item.getSku()).append(": ").append(item.getType())
                    .append(" - ").append(item.getVariant()).append("           $")
                    .append(item.getPrice()).append("\n");
        }
        return currentBasket.toString();
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
        else if (!inventory.isInStock(item.getSku())){
            return "Out of Stock";
        }

        itemBasket.add(item);
        inventory.decreaseStock(item.getSku());
        return "Item has been added to your basket";
    }

    public void addBagelWithFilling(Bagel bagel, Filling filling){
        if (itemBasket.size() < capacity){
            addItem(bagel);
            addItem(filling);
        }
        else{
            System.out.println("Basket is full");
        }
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
