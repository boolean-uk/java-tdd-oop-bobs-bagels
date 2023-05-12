package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Filling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    HashMap<Bagel, Integer> shoppingBasket;
    int capacity;
    int sizeOfBasket;

    public Basket() {
        shoppingBasket = new HashMap<>();
        capacity = 3;
        sizeOfBasket = 0;

    }

    public static void main(String[] args) {
        Basket basket = new Basket();
        Invetory invetory = new Invetory();
        basket.setCapacity(50);
        Bagel bagel = invetory.bagels.get(1);
        basket.add(bagel, 16);
        basket.remove(bagel, 5);
//        basket.remove(bagel,1);


    }


    boolean add(Bagel bagel, int quantity) {
        if ((sizeOfBasket + quantity) > capacity) {
            return false;
        }
        if (shoppingBasket.containsKey(bagel)) {
            shoppingBasket.put(bagel, shoppingBasket.get(bagel) + quantity);
        } else {
            shoppingBasket.put(bagel, quantity);
        }
        sizeOfBasket += quantity;
        return true;
    }
    public boolean add(Bagel bagel) {
        return add(bagel,1);
    }
    boolean remove(Bagel bagel, int quantity) {
        if (!shoppingBasket.containsKey(bagel)) {
            return false;
        }
        if (shoppingBasket.get(bagel) < quantity) {
            return false;
        } else if (shoppingBasket.get(bagel) == quantity) {
            shoppingBasket.remove(bagel);
        } else {
            shoppingBasket.put(bagel, shoppingBasket.get(bagel) - quantity);
        }
        sizeOfBasket -= quantity;
        return true;
    }
    boolean remove(Bagel bagel) {
        return remove(bagel,1);
    }
    boolean setCapacity(int newCap) {
        if (sizeOfBasket > newCap || newCap == 0) {
            return false;
        }
        this.capacity = newCap;
        return true;
    }
    double getTotal(){
        double totalPrice = 0.0;
        for (Map.Entry<Bagel, Integer> bagelIntegerEntry : shoppingBasket.entrySet()) {
            Bagel bagel =bagelIntegerEntry.getKey();
            int quantity = bagelIntegerEntry.getValue();
            totalPrice+=getPriceWithDiscount(bagel,quantity);
        }
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        return totalPrice;
    }
    private double getFillingsPrice(Bagel bagel, int quantity) {
        List<Filling> fillingsArray = bagel.getFillings();
        double priceOfFillings = 0.0;
        for (Filling filling : fillingsArray) {
            priceOfFillings += filling.getPrice();
        }
        return (priceOfFillings * quantity);
    }
    private double getPriceWithDiscount(Bagel bagel, int quantity) {
        int[] returningArray = {0, 0, quantity};

        while (returningArray[2] >= 12) {
            returningArray[2] = returningArray[2] - 12;
            returningArray[0] += 1;
        }
        while (returningArray[2] >= 6) {
            returningArray[2] = returningArray[2] - 6;
            returningArray[1] += 1;
        }
        double price = (returningArray[0] * 3.99) + (returningArray[1] * 2.49) + (returningArray[2] * bagel.getPrice()) + getFillingsPrice(bagel, quantity);
        return price;
    }


}
