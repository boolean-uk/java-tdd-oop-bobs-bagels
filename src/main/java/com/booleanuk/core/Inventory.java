package com.booleanuk.core;

import java.util.ArrayList;

public interface Inventory {
    ArrayList<Item> getInventoryList();

    void setInventoryList(ArrayList<Item> inventoryList);

    void stockInventory();

    double getPrice(Item order);
}
