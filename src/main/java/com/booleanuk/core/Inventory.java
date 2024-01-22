package com.booleanuk.core;

import java.util.ArrayList;

public interface Inventory {
    public void addProduct(Product product);
    public void removeProduct(Product product);
    public ArrayList<Product> getInventory();
    public boolean inInventory(Product product);
}
