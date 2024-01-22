package com.booleanuk.core;

import java.util.ArrayList;

public class Item {

    //TODO : make into interface??
    private String name;

    public Item(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase() ;
    }

    public String getName() {
        return name;
    }

    public boolean containsOtherItems() {
        return false;
    }

    public ArrayList<Item> getContainedItems() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Item)) {
            return false;
        }
        Item other = (Item) obj;
//        if(this.sku != null) {
//            return this.sku.equals(other.sku);
//        }
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
