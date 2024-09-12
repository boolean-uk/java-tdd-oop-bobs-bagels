package com.booleanuk.extension;

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

    public double getPriceOfParticularItem(String variant) {
        Item bagel = items.stream()
                .filter(item -> item.getVariant().equals(variant))
                .findFirst()
                .get();

        return bagel.getPrice();
    }

    public double getPriceOfParticularFilling(String variant) {
        Item filling = items.stream()
                .filter(item -> item.getVariant().equals(variant))
                .findFirst()
                .get();

        return filling.getPrice();
    }

    public boolean checkIfItemIsInInventory(Item item){
        if(!items.contains(item))
            throw new RuntimeException("This item is not in Bob's inventory");
        return true;
    }
}
