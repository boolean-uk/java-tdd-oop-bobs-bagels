package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public static int capacity;
    private Inventory inventory = Inventory.getInstance();

    public Basket(){
        capacity = 2; //starting size of the basket
    }

    private List<String> listOfItemsInBasket = new ArrayList<String>();

    public List<String> getListOfItemsInBasket()
    {
        return listOfItemsInBasket;
    }
    public void  addToBasket(String bagel) throws Exception
    {
        if (listOfItemsInBasket.size()<capacity)
        {
            listOfItemsInBasket.add(bagel);
        }
        else throw new Exception("Basket is full");

    }
    public void removeFromBasket(String bagel){
        listOfItemsInBasket.remove(bagel);
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
            for(InventoryItem i : inventory.getList()){
                if (item.equals(i.sku)){
                    cost += i.price;
                }
            }
        }
        return cost;
    }

}
