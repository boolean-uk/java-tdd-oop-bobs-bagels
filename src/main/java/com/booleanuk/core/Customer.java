package com.booleanuk.core;

import java.util.List;

public class Customer {
    Basket basket;
    private Inventory inventory = Inventory.getInstance();

    public Customer() {
        basket = new Basket();
    }

    public void addToBasket(String item) throws Exception {
        basket.addToBasket(item);
    }
    public Basket getBasket()
    {
        return basket;
    }
    public String checkBasket()
    {
        String itemsInBasket = new String();
        for (String item: basket.getListOfItemsInBasket())
        {
            itemsInBasket+=inventory.getItemBySku(item);
        }
        return itemsInBasket;
    }

}
