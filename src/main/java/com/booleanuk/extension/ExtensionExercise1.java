package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.ArrayList;

public class ExtensionExercise1 {

    private ArrayList<Inventory> basketList;
    private ArrayList<Inventory> inventoryList;

    public ExtensionExercise1() {
        basketList = new ArrayList<>(5);
        inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        inventoryList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        inventoryList.add(new Inventory("BGLE", 0.49, "Bagel", "Everything"));
        inventoryList.add(new Inventory("COFB", 0.99, "Coffee", "Black"));
    }

    public double returnItemsWithDiscount() {
        double price = 0.0;
        for (Inventory items : basketList) {
            if (basketList.contains("BGLO") && basketList.size() == 6) {
                price += 2.49;
            }
            else if (basketList.contains("BGLP") && basketList.size() == 12) {
                price += 3.99;
            }
            else if (basketList.contains("BGLE") && basketList.size() == 6) {
                price += 2.49;
            }
            else if ((basketList.contains("COFB") && basketList.contains("BGLO") && basketList.size() == 2) ||
                    (basketList.contains("COFB") && basketList.contains("BGLP")) && basketList.size() == 2||
                    (basketList.contains("COFB") && basketList.contains("BGLE")) && basketList.size() == 2) {
                price += 1.25;
            }
        }
        return price;
    }

    public ArrayList<Inventory> getBasketList() {
        return basketList;
    }

    public void setBasketList(ArrayList<Inventory> basketList) {
        this.basketList = basketList;
    }

    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
