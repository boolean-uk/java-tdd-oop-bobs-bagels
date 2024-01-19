package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Inventory> basketList;
    private ArrayList<Inventory> inventoryList;
    private ArrayList<Bagel> bagelList;
    private int basketSize = 5;

    public Basket() {
        basketList = new ArrayList<>();
        bagelList = new ArrayList<>();
        inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        inventoryList.add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        inventoryList.add(new Inventory("BGLE", 0.49, "Bagel", "Everything"));
        inventoryList.add(new Inventory("BGLS", 0.49, "Bagel", "Sesame"));
        inventoryList.add(new Inventory("COFB", 0.99, "Coffee", "Black"));
        inventoryList.add(new Inventory("COFW", 1.19, "Coffee", "White"));
        inventoryList.add(new Inventory("COFC", 1.29, "Coffee", "Cappuccino"));
        inventoryList.add(new Inventory("COFL", 1.29, "Coffee", "Latte"));
        inventoryList.add(new Inventory("FILB", 0.12, "Filling", "Bacon"));
        inventoryList.add(new Inventory("FILE", 0.12, "Filling", "Egg"));
        inventoryList.add(new Inventory("FILC", 0.12, "Filling", "Cheese"));
        inventoryList.add(new Inventory("FILX", 0.12, "Filling", "Cream Cheese"));
        inventoryList.add(new Inventory("FILS", 0.12, "Filling", "Smoked Salmon"));
        inventoryList.add(new Inventory("FILH", 0.12, "Filling", "Ham"));
    }

    //User Story 1
    public boolean addBagelVariantToBasket(Bagel bagelVariant) {
        if (!bagelList.contains(bagelVariant)) {
            bagelList.add(bagelVariant);
            return true;
        }
        return false;
    }

    //User Story 2
    public boolean removeBagelVariantFromBasket(Bagel bagelVariant) {
        if (bagelList.contains(bagelVariant)) {
            bagelList.remove(bagelVariant);
            return true;
        }
        return false;
    }

    //User Story 3
    public String bagelBasketIsFull(int basketSize) {
        if (this.basketList.size() >= basketSize) {
            return "Basket is full!";
        }
        return "Basket is not full!";
    }

    //User story 4
    public String changeBasketCapacity(int newCapacity) {
        if (newCapacity > this.basketSize) {
            this.basketSize = newCapacity;
            return "Basket capacity is changed.";
        }
        return "Basket capacity is not changed.";
    }

    //User Story 5
    public String canRemoveItemInBasket(Inventory item) {
        if (basketList.contains(item)) {
            return "Item is in basket and can be removed.";
        }
        return "Item is not in basket and can not be removed.";
    }

    //User Story 6
    public double totalCostOfItems() {
        double totalCost = 0.00;
        for (Inventory item : basketList) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    //User Story 7
    public double returnCostOfBagel(Bagel bagelVariant) {
        for (Inventory item : inventoryList) {
            if (item.getName().equals("Bagel") && item.getVariant().equals(bagelVariant.getVariant())) {
                return item.getPrice();
            }
        }
        return 0.0;
    }

    //User Story 8
    public String chooseBagelFilling(Filling bagelFilling) {
        String sku = bagelFilling.getSku();
        for (Inventory item : inventoryList) {
            if (item.getSku().equals(sku)) {
                return item.getVariant();
            }
        }
        return "Filling type does not exist.";
    }


    //User Story 9
    public double costOfEachFilling(Filling bagelFilling) {
        String sku = bagelFilling.getSku();
        for (Inventory item : inventoryList) {
            if (item.getSku().equals(sku)) {
                return item.getPrice();
            }
        }
        return 0.0;
    }


    //User Story 10
    public boolean mustBeInInventory(String sku) {
        for (Inventory item : inventoryList) {
            if (item.getSku().equals(sku)) {
                return true;
            }
        }
        return false;
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

    public int getBasketSize() {
        return basketSize;
    }

    public void setBasketSize(int basketSize) {
        this.basketSize = basketSize;
    }
}
