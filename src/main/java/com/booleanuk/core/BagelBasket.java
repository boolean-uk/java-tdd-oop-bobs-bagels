package com.booleanuk.core;
import java.util.ArrayList;
import java.util.List;
public class BagelBasket {
    private List<BasketItem> items;
    private int capacity;

    public BagelBasket(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }
    public boolean addBasketItem(BasketItem item) {
        return false;
    }
    public boolean removeBasketItem(BasketItem item){return false;}

    public boolean isBasketFull() {return false;}
    public boolean changeBasketCapacity(int newCapacity) {return false;}

}
