package com.booleanuk.core.basket;

import com.booleanuk.core.MaxCapacityException;
import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.InventoryItemException;
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

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basketItems = new LinkedHashMap <>();      // LinkedHashMap because I want the items in the order they were added to the basket
        this.maxCapacity = 20;
        this.size = 0;
        this.idCount = 1;
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
        String tmp = String.valueOf(itemId) + "0" + idExtension;
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
        if (item.getClass().getName() == Filling.class.getName() && item.getId() < 100) {
            throw new InvalidBasketItemException("Fillings can't be added alone. Must belong to a bagel.");
        }

        // Set id if no exception has been thrown
        item.setId(itemId);
        // Update size of basket
        this.size++;
        // Add item to basket
        this.basketItems.put(item.getId(), item);
    }

    /**
     * Add item to basket, auto creates ID.
     * @param item id
     */
    public void add(BasketItem item) {

        // Try catch maxCapacity
        // If item is bagel, check if we can add more basket items
        // OR doesn't filling counts as items maybe hmmm

        try {
            // If item is a Bagel, add all it's fillings to basket if they exist
            if (item.getClass().getName() == Bagel.class.getName()) {
                Bagel bagel = (Bagel) item;
                List<String> fillingSKUs = bagel.getLinkedFillingSKUs();

                this.addToBasket(createId(), item);

                if (!fillingSKUs.isEmpty()) {
                    List<Integer> fillingIds = bagel.getLinkedFillingIds();

                    int count = 1;
                    for (String f_SKU : fillingSKUs) {
                        int fillingId = createFillingId(String.valueOf(count));
                        this.addToBasket(fillingId, new BasketItem(f_SKU));
                        fillingIds.add(fillingId);
                        count++;
                    }
                }
            } else {
                this.addToBasket(createId(), item);
            }


        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
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

        PrintGenerator basket = new PrintBasketItems(this.inventory, this.basketItems);
        basket.print();
    }
}
