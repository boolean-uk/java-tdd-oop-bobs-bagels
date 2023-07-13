package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public static int capacity = 2; //default size of the basket
    private Inventory inventory = Inventory.getInstance();

    private List<String> listOfItemsInBasket = new ArrayList<String>();

    public List<String> getListOfItemsInBasket()
    {
        return listOfItemsInBasket;
    }
    public boolean  addToBasket(String item)
    {
        if (listOfItemsInBasket.size()<capacity)
        {
            listOfItemsInBasket.add(item);
            return true;
        }
        else
            return false;


    }
    public boolean removeFromBasket(String item){
        if (listOfItemsInBasket.contains(item))
        {
            listOfItemsInBasket.remove(item);
            return true;
        }
    return false;
    }

    public static void setBasketCapacity(int capacity) {
        Basket.capacity = capacity;
    }

    public static int getCapacity() {
        return capacity;
    }

    public double getTotalCost() {
        double cost =0;
        for(String item: listOfItemsInBasket)
        {
            cost += inventory.getPriceBySku(item);
        }
        return cost;
    }

}
