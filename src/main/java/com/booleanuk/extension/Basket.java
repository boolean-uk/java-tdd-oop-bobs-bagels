package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
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
        int bagelAmount = 0;
        int blackCoffeeAmount = 0;
        float total = 0;

        for (Item i : items){
            if (i.getSku().charAt(0) == 'B'){
                bagelAmount++;
            } else if (i.getSku().equals("COFB")){
                blackCoffeeAmount++;
            }
        }

        if (bagelAmount >= 12){
            total += 3.99f;
            bagelAmount -= 12;
        } else if (bagelAmount >= 6){
            total += 2.49f;
            bagelAmount -= 6;
        }

        while (bagelAmount > 0 && blackCoffeeAmount > 0){
            total += 1.25f;
            bagelAmount--;
            blackCoffeeAmount--;
        }

        for (int i = items.size() -1; i >= 0; i--){
            Item item = items.get(i);
            if (item.getSku().charAt(0) == 'B' && bagelAmount > 0){
                total += item.getPrice();
                bagelAmount--;
            }else if (item.getSku().charAt(0) == 'C' && !item.getSku().equals("COFB")){
                total += item.getPrice();
            } else if (item.getSku().charAt(0) == 'F'){
                total += item.getPrice();
            }
        }

        total += blackCoffeeAmount * 0.99f;

        total = Math.round(total * 100) / 100.0f;
        return total;
    }

    public String getReceipt(){
        HashMap<Item, Integer> amounts = new HashMap<>();
        for (Item i : items){
            if (!amounts.containsKey(i)){
                amounts.put(i, 1);
            } else {
                amounts.put(i, amounts.get(i) + 1);
            }
        }
        StringBuilder receipt = new StringBuilder();
        String title = String.format("%15s%-20s%5s", "", "Bobs Bagels", "");
        receipt.append("\n");
        receipt.append(title).append("\n");
        receipt.append("-".repeat(40));
        receipt.append("\n");
        for (Item key : amounts.keySet()){
            String item = String.format("%-20s%-10s%-10s",
                    key.getVariant() + " " + key.getName(), amounts.get(key), key.getPrice() * amounts.get(key));
            receipt.append(item).append("\n");
        }
        receipt.append("-".repeat(40));
        receipt.append("\n");
        String total = String.format("%-10s%20s%-10s", "Total", "", this.totalCost());
        receipt.append(total);
        receipt.append("\n");

        return receipt.toString();
    }
}
