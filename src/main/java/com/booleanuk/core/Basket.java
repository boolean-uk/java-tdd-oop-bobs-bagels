package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {


    private ArrayList<Item> itemList = new ArrayList<>();

    public Basket() {

    }

    public boolean addItemToBasket(Item item) {
        itemList.add(item);
        return true;
    }

    public ArrayList<Item> getItemList() {
        return new ArrayList<>(itemList);
    }

    public boolean removeItemFromBasket(String plain) {
        return true;
    }
}
