package com.booleanuk.core.basket;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.InventoryItemException;
import com.booleanuk.core.printgenerator.PrintBasketItems;
import com.booleanuk.core.printgenerator.PrintGenerator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {

    private Inventory inventory;
    private Map<Integer, BasketItem> basketItems;
    private int maxCapacity;
    private int idCount;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basketItems = new LinkedHashMap <>();      // LinkedHashMap because I want the items in the order they were added to the basket
        this.maxCapacity = 20;
        this.idCount = 1;
    }

    // Auto create ID
    private int createId() {

        int itemId = this.idCount;
        this.idCount += 1;
        return itemId;
    }

    /**
     * Add item to basket, auto creates ID.
     * @param item id
     */
    public void add(BasketItem item) {
        try {
            this.basketItems.put(createId(), item);
        } catch (InventoryItemException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<Integer, BasketItem> getAll() {
        return this.basketItems;
    }


    public void printBasket() {

        // TODO: Should I refactor? Feels like it's a poor solution regarding dependencies.
        // Check all PrintGenerator cases.

        PrintGenerator basket = new PrintBasketItems(this.inventory, this.basketItems);
        basket.print();
    }
}
