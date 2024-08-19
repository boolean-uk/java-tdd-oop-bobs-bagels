package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    public ArrayList<Item> listOfBasket;
    public int capacity;
    private Inventory inventory;


    public Basket(int capacity, Inventory inventory) {
        this.listOfBasket = new ArrayList<>();
        this.capacity = capacity;
        this.inventory = inventory;

    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addBagel(Item item) {
        if (inventory.isItemAvailable(item.getSku())) {
            if (listOfBasket.size() < capacity) {
                listOfBasket.add(item);
                System.out.println("Added " + item.getName() + " to the basket. Price: " + item.getPrice());
            } else {
                System.out.println("Basket is full! Cannot add more items.");
            }
        } else {
            System.out.println("Item with SKU " + item.getSku() + " is not available in the inventory.");
        }
    }


    public String removeBagel(Item item) {
        if (listOfBasket.contains(item)) {
            listOfBasket.remove(item);
            return "The bagel was successfully removed";
        } else {
            return "The bagel does not exist in the basket";
        }
    }

    public ArrayList<Item> getListOfBasket(){
        return listOfBasket;

    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Item item : listOfBasket) {
            totalCost += item.getPrice();


            if (item instanceof Bagel) {
                Bagel bagel = (Bagel) item;
                Filling filling = bagel.getFilling();
                if (filling != null) {
                    totalCost += filling.getPrice();
                }
            }
        }
        return totalCost;
    }




}


