package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

//TODO: check upper vs lowercase
public class Store {
    private HashMap<Integer, Basket> baskets;
    private Inventory inventory;
    private int basketCapacity;

    public Store() {
        baskets = new HashMap<>();
        basketCapacity = 3;
        inventory = new Inventory();
    }

    public int createBasket() {
        Basket basket = new Basket();
        baskets.put(basket.hashCode(), basket);
        return basket.hashCode();
    }

    public HashMap<Integer,Basket> getBaskets() {
        return new HashMap<>(baskets);
    }

    public String addBagelToBasket(String bagel, int basketId) {
        if(!inventory.hasBagel(bagel)) {
            return "Bob's bagels doesn't have that bagel.";
        }
        Basket basket = baskets.get(basketId);

        if(basket.getNoOfBagels() >= basketCapacity) {
            return "You're basket is full!";
        }
        baskets.get(basketId).addBagel(bagel);
        return "Bagel added.";
    }

    public String addFillingToBagelInBasket(String filling, String bagel, int basketId) {
        if(!inventory.hasFilling(filling)) {
            return "Bob's bagels doesn't have that filling.";
        }
        return baskets.get(basketId).addFilling(filling, bagel);
    }

    public boolean updateBasketCapacity(int newCapacity) {
        for(Basket basket: baskets.values()) {
            if(basket.getNoOfBagels()> newCapacity) {
                return false;
            }
        }
        basketCapacity = newCapacity;
        return true;
    }

    public double getCostOfBagel(String bagel) {
        return inventory.getCostOfBagel(bagel);
    }

    public double getCostOfFilling(String filling) {
        return inventory.getCostOfFilling(filling);
    }

    public double getCostOfBasket(int basketId) {
        return inventory.getCostOfBasket(baskets.get(basketId));
    }

    public boolean removeBagelFromBasket(String bagel, ArrayList<String> fillings, int basketId) {
        return baskets.get(basketId).removeBagel(bagel, fillings);
    }

    public double getCostOfCoffee(String coffee) {
        return inventory.getCostOfCoffee(coffee);
    }

    //TODO: what do if nonexistent basketid
    public String addCoffeeToBasket(String coffee, int basketId) {
        if(!inventory.hasCoffee(coffee)) {
            return  "Bob's bagels doesn't have that coffee.";
        }
        baskets.get(basketId).addCoffee(coffee);
        return "Coffee added.";
    }

    public boolean removeCoffeeFromBasket(String coffee, int basketId) {
        return baskets.get(basketId).removeCoffee(coffee);
    }

    public Receipt createReceipt(int basketId) {
        return new Receipt();
    }
}
