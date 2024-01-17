package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {


    private ArrayList<Item> itemList = new ArrayList<>();

    public Basket() {

    }

    public boolean addItemToBasket(Bagel bagel) {
        itemList.add(bagel);
        return true;
    }

    public ArrayList<Item> getItemList() {
        return new ArrayList<>(itemList);
    }
}
