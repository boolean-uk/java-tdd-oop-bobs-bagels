package com.booleanuk.core;
public interface InventoryManagement {
    void addInventoryItem(Inventory item);
    boolean removeInventoryItem(String SKU);
    Inventory findItemBySKU(String SKU);
}

