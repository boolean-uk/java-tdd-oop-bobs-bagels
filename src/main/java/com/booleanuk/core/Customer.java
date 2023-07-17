package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    Basket basket;
    private Inventory inventory = Inventory.getInstance();

    public Customer() {
        basket = new Basket();
    }

    public boolean addToBasket(InventoryItem item)  {
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
            itemsInBasket+=""+i+" " +basket.getListOfItemsInBasket().get(i).toString();
        }
        return itemsInBasket;
    }
    public String checkBasketWithQuantity()
    {
        String itemsInBasket = new String();
        Map<InventoryItem,Integer> quantities = calculateQuantity();
        for (InventoryItem i : quantities.keySet())
        {
            String fullName = i.getFullName();
            int howManySpaces = 23-fullName.length();
            itemsInBasket+= fullName;
            for(int j = 0; j < howManySpaces; j++){
                itemsInBasket += " ";
            }
            int quantity = quantities.get(i);
            itemsInBasket+="" + quantity;
            itemsInBasket += quantity<10 ? "   " : "  ";
            itemsInBasket += "£" + (double)i.getPrice()/100;
            itemsInBasket += "\n";
        }
        return itemsInBasket;
    }

    public Map<InventoryItem, Integer> calculateQuantity()
    {
        Map<InventoryItem,Integer> quantities = new HashMap<>();
        for (InventoryItem i : basket.getListOfItemsInBasket())
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
        return (double) basket.getTotalCost()/100;
    }
    public double getTotalDiscount() {return (double) (basket.getCostWithoutDiscount()-basket.getTotalCost())/100;}
    public boolean removeFromBasket(int i)
    {
        return (basket.removeFromBasket(i));
    }

}
