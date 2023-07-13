package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

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
    public String checkBasketWithQuantity()
    {
        String itemsInBasket = new String();
        Map<String,Integer> quantities = calculateQuantity();
        for (String i : quantities.keySet())
        {
            String fullName = inventory.getFullNameBySku(i);
            int howManySpaces = 23-fullName.length();
            itemsInBasket+= fullName; //inventory.getItemBySku(basket.getListOfItemsInBasket().get(i));
            for(int j = 0; j < howManySpaces; j++){
                itemsInBasket += " ";
            }
            int quantity = quantities.get(i);
            itemsInBasket+="" + quantity;
            itemsInBasket += quantity<10 ? "   " : "  ";
            itemsInBasket += "£" + inventory.getPriceBySku(i);
            itemsInBasket += "\n";
        }
        return itemsInBasket;
    }

    public Map<String, Integer> calculateQuantity()
    {
        Map<String,Integer> quantities = new HashMap<>();
        for (String i : basket.getListOfItemsInBasket())
        {
            if(quantities.containsKey(i)){
                int value = quantities.get(i) + 1;
                quantities.put(i,value);
            } else {
                quantities.put(i,1);
            }
        }
        return quantities;
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
