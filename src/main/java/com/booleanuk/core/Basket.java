package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.BasketItem;
import com.booleanuk.core.models.Coffee;
import com.booleanuk.core.models.Filling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    HashMap<BasketItem, Integer> shoppingBasket;//Sku,int, Sku/1bagel=onion,sku/3.[2 filings]
    //sku/4 bagel=everthing,[1fiolings],sku cof
//    HashMap<String,Filling>map =
    //bagelName(SKU)/Filling[]
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

        Bagel bagel0 = invetory.bagels.get(1);
        Bagel bagel1 = new Bagel("Plain", 0.39, "BGLP");
        bagel1.addFillings(new Filling[]{invetory.fillings.get(0)});
        Coffee coffee = invetory.coffees.get(0);

        basket.add(bagel0);
        basket.add(coffee);
        basket.add(bagel1);
//        basket.re
        System.out.println("basket = " + basket.getTotal());


    }


    boolean add(BasketItem item, int quantity) {
        if ((sizeOfBasket + quantity) > capacity) {
            return false;
        }
        if (shoppingBasket.containsKey(item)) {
            shoppingBasket.put(item, shoppingBasket.get(item) + quantity);
        } else {
            shoppingBasket.put(item, quantity);
        }
        sizeOfBasket += quantity;
        return true;
    }

    public boolean add(BasketItem item) {
        return add(item, 1);
    }

    boolean remove(BasketItem item, int quantity) {
        if (!shoppingBasket.containsKey(item)) {
            return false;
        }
        if (shoppingBasket.get(item) < quantity) {
            return false;
        } else if (shoppingBasket.get(item) == quantity) {
            shoppingBasket.remove(item);
        } else {
            shoppingBasket.put(item, shoppingBasket.get(item) - quantity);
        }
        sizeOfBasket -= quantity;
        return true;
    }

    boolean remove(BasketItem item) {
        return remove(item, 1);
    }

    boolean setCapacity(int newCap) {
        if (sizeOfBasket > newCap || newCap == 0) {
            return false;
        }
        this.capacity = newCap;
        return true;
    }

    double getTotal() {
        double totalPrice = 0.0;
        double totalPriceBagel = 0.0;
        double totalPriceCoffee = 0.0;
        int remainingBagelAfterDiscount = 0;
        int remainingCoffeeAfterDiscount = 0;
        HashMap<Bagel, Integer> mapBagel = new HashMap<>();
        HashMap<Coffee, Integer> mapCoffee = new HashMap<>();
        for (Map.Entry<BasketItem, Integer> itemEntry : shoppingBasket.entrySet()) {
            if (Bagel.class == itemEntry.getKey().getClass()) {
                mapBagel.put((Bagel) itemEntry.getKey(), itemEntry.getValue());
            } else {
                mapCoffee.put((Coffee) itemEntry.getKey(), itemEntry.getValue());
            }
        }
        for (Map.Entry<Bagel, Integer> bagelIntegerEntry : mapBagel.entrySet()) {
            double[] returingArrayFromBagel = getBagelPriceWithDiscount(bagelIntegerEntry.getKey(), bagelIntegerEntry.getValue());
            totalPriceBagel += returingArrayFromBagel[0];
            bagelIntegerEntry.setValue((int) returingArrayFromBagel[1]);
        }
        if (remainingBagelAfterDiscount != 0) {
            for (Map.Entry<Coffee, Integer> coffeeIntegerEntry : mapCoffee.entrySet()) {
                double[] returningArrayFromCoffee = getCoffeePriceWithDiscount(coffeeIntegerEntry.getKey(), coffeeIntegerEntry.getValue(), remainingBagelAfterDiscount);
                remainingBagelAfterDiscount = (int) returningArrayFromCoffee[2];
                coffeeIntegerEntry.setValue((int) returningArrayFromCoffee[1]);
                totalPriceCoffee += returningArrayFromCoffee[0];
            }
        }

        totalPrice = totalPriceBagel + totalPriceCoffee;
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        return totalPrice;
    }

    private double[] getCoffeePriceWithDiscount(Coffee coffee, int quantityOfCoffee, int quantityOfBagel) {
        double[] returningArray = {0.0, (double) quantityOfCoffee, (double) quantityOfBagel};
        while (quantityOfCoffee > 0 && quantityOfBagel > 0) {
            returningArray[0] += 1.25;
            returningArray[1] -= 1;
            returningArray[2] -= 1;
        }
        return returningArray;
    }

    private double getFillingsPrice(Bagel bagel, int quantity) {
        List<Filling> fillingsArray = bagel.getFillings();
        double priceOfFillings = 0.0;
        for (Filling filling : fillingsArray) {
            priceOfFillings += filling.getPrice();
        }
        return (priceOfFillings * quantity);
    }

    private double[] getBagelPriceWithDiscount(Bagel bagel, int quantity) {
        int[] returningArray = {0, 0, quantity};

        while (returningArray[2] >= 12) {
            returningArray[2] = returningArray[2] - 12;
            returningArray[0] += 1;
        }
        while (returningArray[2] >= 6) {
            returningArray[2] = returningArray[2] - 6;
            returningArray[1] += 1;
        }

        double price = (returningArray[0] * 3.99) + (returningArray[1] * 2.49) + getFillingsPrice(bagel, quantity);
        return new double[]{price, (double) returningArray[2]};
    }

    private double getBagelPriceWithoutDiscount(Bagel bagel, int quantity){

        return 0.0;
    }


}
