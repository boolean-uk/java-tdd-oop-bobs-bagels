package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Basket {
    private ArrayList<Item> items = new ArrayList<>();
    private int capacity = 10;
    private boolean isFull;
    private Inventory inventory = new Inventory();

    public Basket(Inventory inventory){
        this.isFull = false;
        this.inventory = inventory;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public boolean getIsFull(){
        return isFull;
    }

    public int getCapacity(){
        return capacity;
    }

    public void checkCapacity(){
        if (items.size() == capacity){
            isFull = true;
            return;
        }
        isFull = false;
    }

    public boolean containsItem(String itemSku){
        for (Item item : items){
            if (item.getSku().equals(itemSku)){
                return true;
            }
        }
        return false;
    }

    public void addItem(String itemSku){
        checkCapacity();
        if (isFull){
            System.out.println("Your basket is full, cant add item!");
            return;
        }
        if (inventory.getItemStock(itemSku) == 0){
            System.out.println("No stock left for chosen item!");
            return;
        }
        Item item = new Item(itemSku);
        System.out.println(item.getVariant() + " " + item.getName() + " price: $" + item.getPrice());
        System.out.println("Do you want to add " + item.getVariant()
                + " " + item.getName() +" to the basket? (yes/no): ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().trim().toLowerCase();

        if (userInput.equals("yes")) {
            items.add(item);
            inventory.removeStockItem(itemSku, 1);
            System.out.println(item.getVariant() + " " + item.getName() + " added to the basket.");
        } else {
            System.out.println(item.getVariant() + " " + item.getName() + " not added to the basket.");
        }
    }

    public void removeItem(String itemSku){
        for (Item item : items){
            if (item.getSku().equals(itemSku)){
                items.remove(item);
                inventory.addStockItem(itemSku, 1);
                return;
            }
        }
        System.out.println("This item does not exist in the basket!");
    }

    public void changeCapacity(int newCap){
        this.capacity = newCap;
    }

    public float totalCost(){
        float total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        return total;
    }
}
