package com.booleanuk.core;

import java.util.List;

public class Customer {
    Basket basket;
    private Inventory inventory = Inventory.getInstance();

    public Customer() {
        basket = new Basket();
    }

    public boolean addToBasket(String item)  {
        return basket.addToBasket(item);
    }
    public Basket getBasket()
    {
        return basket;
    }
    public String checkBasket()
    {
        String itemsInBasket = new String();
        for (int i=0; i < basket.getListOfItemsInBasket().size();i++)
        {
            itemsInBasket+=""+i+" " +inventory.getItemBySku(basket.getListOfItemsInBasket().get(i));
        }
        return itemsInBasket;
    }
    public double getTotalCost()
    {
        return basket.getTotalCost();
    }
    public boolean removeFromBasket(String sku)
    {
        return (basket.removeFromBasket(sku));
    }
    public String getSkuByIndex(int i)
    {
        return basket.getListOfItemsInBasket().get(i);
    }
}
