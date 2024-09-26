package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> items;

    public Inventory(){
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    //I'd like to know the cost of a bagel before I add it to my basket.
    //I'd like to know the cost of each filling before I add it to my bagel order.
    public double getPriceOfParticularItem(String variant) {
        Item item = items.stream()
                .filter(i -> i.getVariant().equals(variant))
                .findFirst()
                .get();

        return item.getPrice();
    }


    //I want customers to only be able to order things that we stock in our inventory.
    public boolean checkIfItemIsInInventory(Item item){
        if(!items.contains(item))
            throw new RuntimeException("This item is not in Bob's inventory");
        return true;
    }
}
