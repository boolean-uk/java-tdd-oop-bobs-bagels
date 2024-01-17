package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    //String type;
    ArrayList<Bagel> bagels;

    HashMap<String, Integer> items;

    HashMap<String, Inventory> itemsFullyDetailed;

    HashMap<Bagel, Integer> bagelsWithCost;

    HashMap<String, Integer[]> itemsWithQuantity;


    int basketSize = 4;

    public Basket() {
        bagels = new ArrayList<>(5);
        items = new HashMap<>();
        itemsWithQuantity = new HashMap<>();
        itemsFullyDetailed = new HashMap<>();
        itemsFullyDetailed.put("BGLO", new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        itemsFullyDetailed.put("BGLP", new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        itemsFullyDetailed.put("BGLE", new Inventory("BGLE", 0.49, "Bagel", "Everything"));
        itemsFullyDetailed.put("BGLS", new Inventory("BGLS", 0.49, "Bagel", "Sesame"));
        itemsFullyDetailed.put("COFB", new Inventory("COFB", 0.99, "Coffee", "Black"));
        itemsFullyDetailed.put("COFW", new Inventory("COFW", 1.19, "Coffee", "White"));
        itemsFullyDetailed.put("COFC", new Inventory("COFC", 1.29, "Coffee", "Cappuccino"));
        itemsFullyDetailed.put("COFL", new Inventory("COFL", 1.29, "Coffee", "Latte"));
        itemsFullyDetailed.put("FILB", new Inventory("FILB", 0.12, "Filling", "Bacon"));
        itemsFullyDetailed.put("FILE", new Inventory("FILE", 0.12, "Filling", "Egg"));
        itemsFullyDetailed.put("FILC", new Inventory("FILC", 0.12, "Filling", "Cheese"));
        itemsFullyDetailed.put("FILX", new Inventory("FILX", 0.12, "Filling", "Cream Cheese"));
        itemsFullyDetailed.put("FILS", new Inventory("FILS", 0.12, "Filling", "Smoked Salmon"));
        itemsFullyDetailed.put("FILH", new Inventory("FILH", 0.12, "Filling", "Ham"));

        //User Story 3
        /*
        bagels.add("Chocolate");
        bagels.add("Vanilla");
        bagels.add("Banana"); */
    }

    //User Story 1
    public boolean addBagelTypeToBasket(Bagel bagelType) {
        if (this.bagels.contains(bagelType)) {
            return false;
        }
        this.bagels.add(bagelType);
        return true;
    }

    //User Story 2
    public boolean removeBagelTypeFromBasket(Bagel bagelType) {
        if (this.bagels.contains(bagelType)) {
            this.bagels.remove(bagelType);
            return true;
        }
        return false;
    }

    //User Story 3
    public String basketIsFull() {
        if (this.bagels.size() >= this.basketSize) {
            return "Basket is full!";
        }
        return "Basket is not full!";
    }

    //User story 4
    public String changeBasketCapacity(int newCapacity) {
        if(this.bagels.size() < newCapacity) {
            this.bagels = new ArrayList<>(newCapacity);
            return "Basket capacity changed!";
        } else if (this.bagels.size() <= newCapacity) {
            return "Basket capacity is not changed.";
        }
        return "Basket capacity is not changed.";

    }

    //User Story 5
    public String canRemoveItemInBasket(Bagel item) {
        if(this.bagels.contains(item)) {
            return "Item is in basket and can be removed.";
        }
        return "Item is not in basket and can't be removed.";
    }

    //User Story 6
    public void addItem(String item, int quantity, int costPerUnit) {
        itemsWithQuantity.put(item, new Integer[] { quantity, costPerUnit });
    }

    public double totalCostOfItems() {
        double totalCost = 0.00;
        for (Integer[] value : this.itemsWithQuantity.values()) {
            totalCost += value[0] * value[1]; // quantity * cost per unit
        }
        return totalCost;
    }

    //User Story 7
    public double returnCostOfBagel(Bagel bagelVariant) {
        String sku = bagelVariant.getSku();
        Inventory bagelType = itemsFullyDetailed.get(sku);
        return bagelType.getPrice();
    }

    //User Story 8
    public String chooseBagelFilling(Filling bagelFilling) {
        String sku = bagelFilling.getSku();
        Inventory fillingType = itemsFullyDetailed.get(sku);
        return fillingType.getVariant();
    }

    //User Story 9
    public double costOfEachFilling(Filling bagelFilling) {
        String sku = bagelFilling.getSku();
        Inventory fillingType = itemsFullyDetailed.get(sku);
        return fillingType.getPrice();
    }

    //User Story 10
    public boolean mustBeInInventory(String sku) {
        if(itemsFullyDetailed.containsKey(sku)) {
            return true;
        }
        return false;
    }
}
