package com.booleanuk.extension.extension;

import java.util.ArrayList;
import java.util.List;

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

    public void addItem(Item item) {
        if (inventory.isItemAvailable(item.getSku())) {
            if (listOfBasket.size() < capacity) {
                listOfBasket.add(item);
                System.out.println("Added " + item.getName() + " to the basket. Price: " + item.getPrice());
                if (item instanceof Bagel) {
                    Bagel bagel = (Bagel) item;
                    Filling filling = bagel.getFilling();
                    if (filling != null) {
                        System.out.println("Added filling: " + filling.getName() + " | Price: " + filling.getPrice());
                    }
                }

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

    public List<Item> getListOfBasket(){
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
        System.out.println("Total cost calculated: " + totalCost);
        return totalCost;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
