package com.booleanuk.core;

import com.booleanuk.core.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    HashMap<BasketItem, Integer> shoppingBasket;
    HashMap<Bagel, Integer> bagelBasket;
    ArrayList<BagelExt> newBagelBasket;
    ArrayList<CoffeelExt> newCoffeeBasket;


    HashMap<Coffee, Integer> coffeeBasket;

    int capacity;
    int sizeOfBasket;

    public Basket() {
        shoppingBasket = new HashMap<>();
        bagelBasket = new HashMap<>();
        coffeeBasket = new HashMap<>();
        newBagelBasket = new ArrayList<>();
        newCoffeeBasket = new ArrayList<>();

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

    boolean add(BagelExt item, int quantity) {
        if ((sizeOfBasket + quantity) > capacity) {
            return false;
        }
        if (newBagelBasket.contains(item)) {
            int index = newBagelBasket.indexOf(item);
            newBagelBasket.get(index).setQuantity(newBagelBasket.get(index).getQuantity() + quantity);
        } else {
            item.setQuantity(quantity);
            newBagelBasket.add(item);
        }
        sizeOfBasket += quantity;
        return true;
    }

    boolean add(CoffeelExt item, int quantity) {
        if ((sizeOfBasket + quantity) > capacity) {
            return false;
        }
        if (newCoffeeBasket.contains(item)) {
            int index = newCoffeeBasket.indexOf(item);
            newCoffeeBasket.get(index).setQuantity(newCoffeeBasket.get(index).getQuantity() + quantity);
        } else {
            item.setQuantity(quantity);
            newCoffeeBasket.add(item);
        }
        sizeOfBasket += quantity;
        return true;
    }

    double getTotalOfBagelsExt() {
        double total = 0.0;
        ArrayList<BagelExt> afterTotalBagelBasket = (ArrayList<BagelExt>) newBagelBasket.clone();
        ArrayList<CoffeelExt> afterTotalCoffeeBasket = (ArrayList<CoffeelExt>) newCoffeeBasket.clone();
        // For discount 6/12 bagels
        for (BagelExt bagelExt : afterTotalBagelBasket) {
            int qua12 = 0;
            int qua6 = 0;
            int quantity = bagelExt.getQuantity();
            while (quantity >= 12) {
                quantity = quantity - 12;
                qua12 += 1;
            }
            while (quantity >= 6) {
                quantity = quantity - 6;
                qua6 += 1;
            }
            bagelExt.setQuantity(quantity); //Some times can be 0!!!
            double price = (qua12 * 3.99) + (qua6 * 2.49);
            total += price;
        }

        // For discount coffee+bagel
        int smallerLength = (afterTotalBagelBasket.size() >= afterTotalCoffeeBasket.size()) ? afterTotalCoffeeBasket.size() : afterTotalBagelBasket.size();
        for (int i = 0; i < smallerLength; i++) {
            double price = 0.0;
            int coffeeQuantity = afterTotalCoffeeBasket.get(i).getQuantity();
            int bagelQuantity = afterTotalBagelBasket.get(i).getQuantity();
            if (bagelQuantity >= coffeeQuantity) {
                price = 1.25 * coffeeQuantity;
                afterTotalBagelBasket.get(i).setQuantity(bagelQuantity - coffeeQuantity);
                afterTotalCoffeeBasket.get(i).setQuantity(0);
            } else {
                price = 1.25 * bagelQuantity;
                afterTotalBagelBasket.get(i).setQuantity(0);
                afterTotalCoffeeBasket.get(i).setQuantity(coffeeQuantity - bagelQuantity);
            }
            total += price;

        }

        // after Discount bagel
        for (BagelExt bagelExt : afterTotalBagelBasket) {
            int quantity = bagelExt.getQuantity();
            double price = bagelExt.getPrice()*quantity;
            total+=price;
        }
        // after Discount coffee
        for (CoffeelExt coffeelExt : afterTotalCoffeeBasket) {
            int quantity =coffeelExt.getQuantity();
            double price =coffeelExt.getPrice()*quantity;
            total+=price;
        }

        return total;
    }


    boolean add(Bagel item, int quantity) {
        if ((sizeOfBasket + quantity) > capacity) {
            return false;
        }
        if (bagelBasket.containsKey(item)) {
            bagelBasket.put(item, bagelBasket.get(item) + quantity);
        } else {
            bagelBasket.put(item, quantity);
        }
        sizeOfBasket += quantity;
        return true;
    }

    boolean add(Coffee item, int quantity) {
        if ((sizeOfBasket + quantity) > capacity) {
            return false;
        }
        if (coffeeBasket.containsKey(item)) {
            coffeeBasket.put(item, coffeeBasket.get(item) + quantity);
        } else {
            coffeeBasket.put(item, quantity);
        }
        sizeOfBasket += quantity;
        return true;
    }

    public boolean add(BasketItem item) {
        if (item.getClass() == Bagel.class) {
            return add((Bagel) item, 1);
        }
        return add((Coffee) item, 1);
    }

    boolean remove(Bagel item, int quantity) {
        if (!bagelBasket.containsKey(item)) {
            return false;
        }
        if (bagelBasket.get(item) < quantity) {
            return false;
        } else if (bagelBasket.get(item) == quantity) {
            bagelBasket.remove(item);
        } else {
            bagelBasket.put(item, bagelBasket.get(item) - quantity);
        }
        sizeOfBasket -= quantity;
        return true;
    }

    boolean remove(Coffee item, int quantity) {
        if (!coffeeBasket.containsKey(item)) {
            return false;
        }
        if (coffeeBasket.get(item) < quantity) {
            return false;
        } else if (coffeeBasket.get(item) == quantity) {
            coffeeBasket.remove(item);
        } else {
            coffeeBasket.put(item, coffeeBasket.get(item) - quantity);
        }
        sizeOfBasket -= quantity;
        return true;
    }

    boolean remove(BasketItem item) {
        if (item.getClass() == Bagel.class) {
            return remove((Bagel) item, 1);
        }
        return remove((Coffee) item, 1);
    }

    boolean setCapacity(int newCap) {
        if (sizeOfBasket > newCap || newCap == 0) {
            return false;
        }
        this.capacity = newCap;
        return true;
    }

    double getTotal() {
        double priceOfBagel = 0.0;
        double priceOfCoffee = 0.0;
        for (Map.Entry<Bagel, Integer> bagels : bagelBasket.entrySet()) {

        }
        return priceOfCoffee + priceOfBagel;
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

    private double getBagelPriceWithoutDiscount(Bagel bagel, int quantity) {

        return 0.0;
    }


}
