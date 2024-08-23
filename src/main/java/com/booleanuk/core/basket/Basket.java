package com.booleanuk.core.basket;

import com.booleanuk.core.PriceCalculator;
import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.InventoryItem;
import com.booleanuk.core.printgenerator.PrintBasketItems;
import com.booleanuk.core.printgenerator.PrintGenerator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private Inventory inventory;
    private Map<Integer, BasketItem> basketItems;
    private int maxCapacity;
    private int size;
    private int idCount;
    private float totalCost;
    private PriceCalculator priceCalculator;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basketItems = new LinkedHashMap <>();      // LinkedHashMap because I want the items in the order they were added to the basket
        this.maxCapacity = 20;
        this.size = 0;
        this.idCount = 1;
        this.totalCost = 0.0f;
        this.priceCalculator = new PriceCalculator();   // Should maybe have dependency injection instead.
    }

    // Auto create ID
    private int createId() {

        int itemId = this.idCount;
        this.idCount += 1;
        return itemId;
    }

    private int createFillingId(String idExtension) {
        //TODO: How to make default variable like in python

        // TODO: Should check if idExtension is valid

        // TODO: Could use int input instead of String

        // Store variable id for previous bagel
        int itemId = this.idCount - 1;

        // Add id extension for filling
        String tmp = itemId + "0" + idExtension;
        return Integer.parseInt(tmp);
    }



    protected void addToBasket(int itemId, BasketItem item) {
        // Validate input
        if (this.getSize() == maxCapacity) {
            throw new MaxCapacityException("Basket is full, can't add more items.");
        }

        // TODO: Add exception for when id already exist

        // Fillings can not be added as an item itself
        // Fillings that belongs to a bagel have id's over 100
        if (item.getClass().getName().equals(Filling.class.getName()) && item.getId() < 100) {
            throw new InvalidBasketItemException("Fillings can't be added alone. Must belong to a bagel.");
        }

        // Set id if no exception has been thrown
        item.setId(itemId);
        // Update size of basket
        this.size++;
        // Add item to basket
        this.basketItems.put(item.getId(), item);
    }

    protected void removeFromBasket(int itemId) {
        if (basketItems.get(itemId) == null) {
            throw new InvalidBasketItemException("Basket item with ID #" + itemId + ", doesn't exist. Can't remove from basket.");
        }
        this.basketItems.remove(itemId);
    }

    // TODO: Check where get item functionality is used and replace with this function
    // This exception is trown both here and in the above method, how to reduce duplication in best way?
    protected BasketItem getBasketItem(int itemId) {
        BasketItem item = this.basketItems.get(itemId);
        if (item == null) {
            throw new InvalidBasketItemException("Basket item with ID #" + itemId + ", doesn't exist. Can't remove from basket.");
        }
        return item;
    }

    /**
     * Add item to basket, auto creates ID.
     * @param item id
     */
    public void add(BasketItem item) {

        try {

            // TODO: Duplication of id with different variables? Simplify?
            //  Could I use some inheritance/polymorphism?

            // Class names
            String thisItemClass = item.getClass().getName();
            String BagelClass = Bagel.class.getName();

            // Add fillings if it is a Bagel
            if (thisItemClass.equals(BagelClass)) {
                Bagel bagel = (Bagel) item;
                List<String> fillingSKUs = bagel.getLinkedFillingSKUs();

                int bagelId = createId();
                this.addToBasket(bagelId, item);
                item.setId(bagelId);

                // Add fillings and save the filling ids' to the bagel
                if (!fillingSKUs.isEmpty()) {
                    List<Integer> fillingIds = bagel.getLinkedFillingIds();

                    int count = 1;
                    for (String f_SKU : fillingSKUs) {
                        int fillingId = createFillingId(String.valueOf(count));

                        BasketItem filling = new Filling(f_SKU);
                        filling.setId(fillingId);

                        this.addToBasket(fillingId, filling);
                        fillingIds.add(fillingId);

                        count++;
                    }
                }
            } else {
                int generalId = createId();
                this.addToBasket(generalId, item);
            }

        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void remove(int itemId) {

        try {
            BasketItem item = this.getBasketItem(itemId);

            // Class names
            String thisItemClass = item.getClass().getName();
            String BagelClass = Bagel.class.getName();

            // Remove fillings if it is a Bagel
            if (thisItemClass.equals(BagelClass)) {

                Bagel bagel = (Bagel) item;
                List<Integer> fillingIds = bagel.getLinkedFillingIds();

                // Remove all fillings
                for (int f_id : fillingIds) {
                    this.removeFromBasket(f_id);
                }
            }
            this.removeFromBasket(itemId);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<Integer, BasketItem> getAll() {
        return this.basketItems;
    }

    public int getSize() {
        return size;
    }

    public void printBasket() {

        // TODO: Should I refactor? Feels like it's a poor solution regarding dependencies.
        // Check all PrintGenerator cases.

        PrintGenerator basket = new PrintBasketItems(this.inventory, this.basketItems, this.getTotalCost());
        basket.print();
    }

    // TODO: I only use this for the test. Should I keep it or change the test?
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    // TODO: Should I do a get/setfunctions on maxCapacity or is this ok?
    public void changeMaxCapacity(int newMaxCapacity) {
        this.maxCapacity = newMaxCapacity;
    }

    public double getTotalCost() {
        // TODO Changed to double, this may be unnecessary now

        // TODO: Is it bad performance to loop like this?
        // Should I instead keep track on the price everytime an item is added or removed?

        float total = 0;
        for (BasketItem item : this.basketItems.values()) {
            InventoryItem inventoryItem = inventory.getItem(item.getSKU());
            total += inventoryItem.getPrice();
        }
        return priceCalculator.round(total, 2);
    }
}
