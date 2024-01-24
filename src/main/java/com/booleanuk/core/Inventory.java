package com.booleanuk.core;

import java.util.ArrayList;

public interface Inventory {
    void addProduct(Product product);
    void removeProduct(Product product);
    ArrayList<Product> getInventory();
    boolean inInventory(Product product);
}
