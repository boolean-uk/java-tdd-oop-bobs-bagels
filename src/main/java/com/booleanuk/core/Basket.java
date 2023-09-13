package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    int size;
    ArrayList<Foods> basketList;
    public Basket(int size) {
        this.size=size;
        basketList = new ArrayList<>();
    }

    public boolean add(Foods item) {
        this.basketList.add(item);
        return true;
    }

    public Boolean remove(String sku) {
        for (Foods food:basketList) {
            if (food.getSku().equals(sku)){
                basketList.remove(food);
                return true;
            }
        }
        return false;
    }
}
