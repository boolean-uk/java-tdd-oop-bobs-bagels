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
    public void  addToBasket(String item) throws Exception
    {
        if (listOfItemsInBasket.size()<capacity)
        {
            listOfItemsInBasket.add(item);
        }
        else throw new Exception("Basket is full");

    }
    public void removeFromBasket(String item){
        listOfItemsInBasket.remove(item);
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
