package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {

   Map<String, Integer> basketItems = new HashMap<>();
   private int basketLimit = 20;
   int basketTotal = 0;
    public void addBagel (String bagelName, int quantity){
        if(!exceededBasketLimit(getBasketLimit(),basketTotal+quantity )){
            if(basketItems.containsKey(bagelName)){
                basketItems.put(bagelName, basketItems.get(bagelName)+quantity);
                basketTotal = basketItems.values().stream().reduce(0, Integer::sum);
            }else{
                basketItems.put(bagelName, quantity);
                basketTotal = basketItems.values().stream().reduce(0, Integer::sum);
            }
        }else {
            int limitExceededBy = (basketTotal + quantity) - getBasketLimit();
            System.out.println("The quantity of bagels you are adding to your basket exceeds the basket limit by " + limitExceededBy +". Please reduce the quantity of bagels by this amount.");
        }
    }

    public boolean exceededBasketLimit(int basketLimit, int basketTotalAfterAddBagel){
        return basketTotalAfterAddBagel > basketLimit;
    }

    public int getBasketLimit() {
        return basketLimit;
    }

    public void setBasketLimit(int basketLimit) {
        this.basketLimit = basketLimit;
    }

    public void removeBagel(String bagelName, int quantity){
        if(!basketItems.containsKey(bagelName)){
            System.out.println("This bagel isn't in your basket.");
        }
        else{
            if(basketItems.get(bagelName) <= quantity){
                basketItems.remove(bagelName);
            }else{
                int newQuantity = basketItems.get(bagelName) - quantity;
                basketItems.put(bagelName, newQuantity );
            }
        }
    }
}
