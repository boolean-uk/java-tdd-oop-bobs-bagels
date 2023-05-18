package com.booleanuk;

import java.util.*;

public class Receipt {
    private List<CountableBagel> bagels;
    private List<CountableCoffee> coffees;

    public Receipt(){
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();
    }

    public List<CountableBagel> getBagels() {
        return bagels;
    }

    public List<CountableCoffee> getCoffees() {
        return coffees;
    }

    public int size(List<? extends CountableItem> items) {
        int count = 0;
        for (CountableItem ci : items){
            count += ci.getAmount();
        }

        return count;
    }

    public int numberOfItems(){
        return size(bagels) + size(coffees);
    }

    private CountableBagel exists(Bagel bagel) {
        for (CountableBagel cb : bagels) {
            if (cb.holds(bagel))
                return cb;
        }

        return null;
    }

    private CountableCoffee exists(Coffee coffee) {
        for (CountableCoffee cf : coffees) {
            if (cf.holds(coffee))
                return cf;
        }

        return null;
    }

    public void add(Bagel bagel) {
        CountableBagel b = exists(bagel);

        if (b != null)
            b.increaseAmount();
        else
            bagels.add(new CountableBagel(bagel, 1));
    }

    public void add(Coffee coffee) {
        CountableCoffee c = exists(coffee);

        if (c != null)
            c.increaseAmount();
        else
            coffees.add(new CountableCoffee(coffee, 1));
    }

    public boolean remove(Bagel bagel) {
        CountableBagel cb = exists(bagel);

        if (cb == null) return false;

        cb.decreaseAmount();

        if (cb.amountIsZero()) bagels.remove(cb);

        return true;
    }

    public boolean remove(Coffee coffee) {
        CountableCoffee cf = exists(coffee);

        if (cf == null) return false;

        cf.decreaseAmount();

        if (cf.amountIsZero()) coffees.remove(cf);

        return true;
    }


    private List<Double> costLists() {
        List<Double> bagelsCost = new ArrayList<>();
        List<Double> coffeesCost = new ArrayList<>();

        if (size(bagels) == size(coffees)) {
            bagelsCost.add(1.25 * size(bagels));
            return bagelsCost;
        }

        // stream= list just an objects which has an useful methods of collectors, you can think of an arraylist
        //what is an arraylist? can store some data and has useful methods.
        //this iterates though all the entrys

        int coffeeSize = size(coffees);
        List<CountableCoffee> sortedCoffees = coffees.stream()
                .sorted(Comparator.comparing(cf -> cf.getPrice())).toList();
        List<CountableBagel> sortedBagels = bagels.stream()
                .sorted(Comparator.comparing(cb -> cb.getPrice(), Comparator.reverseOrder())).toList();

        //in order to iterate through a map we need to convert it to a entrySet. A Map is no iterable
        for (CountableBagel cBagel : sortedBagels) {
            double sumBagels = 0;
            double sumBagelsCoffee = 0;
            int numberOfBagels = cBagel.getAmount();
            double bagelPrice = cBagel.getPrice();

            // calculate the dozens
            sumBagels += (numberOfBagels / 12) * 3.99;//discount for every 12 bagels of the same sort
            numberOfBagels = numberOfBagels % 12; // 11 % 12 = 11

            // calculate half dozens
            sumBagels += (numberOfBagels / 6) * 2.49; // discount for 6 bagels of the same sort
            numberOfBagels = numberOfBagels % 6; // (11%6) = 5

            if (numberOfBagels >= coffeeSize){
                numberOfBagels = numberOfBagels - coffeeSize; //5 // 3 bagels and 1 coffee
                sumBagels += numberOfBagels * bagelPrice; // price of rest of bagels

                sumBagelsCoffee += coffeeSize * 1.25;  // coffee and bagels together
                coffeeSize = 0;
            }  else {
                sumBagelsCoffee += numberOfBagels * 1.25;
                coffeeSize = coffeeSize - numberOfBagels;
            }

            // save the cost of each bagel
            bagelsCost.add(sumBagels);

            // save the cost of each coffee bagel combo
            coffeesCost.add(sumBagelsCoffee);
        }


        int i = 0;
        while (coffeeSize > 0) {
            CountableCoffee cf = sortedCoffees.get(i);
            int count = cf.getAmount();

            if (count > coffeeSize)
                coffeesCost.add(cf.getPrice() * coffeeSize);
            else
                coffeesCost.add(cf.getPrice() * count);

            coffeeSize -= count;
            i++;
        }

        // all the sums in a list
        List<Double> costList = new ArrayList<>();
        costList.addAll(bagelsCost);
        costList.addAll(coffeesCost);

        return costList;
    }

    public double discountedCost() {
        List<Double> costLists = costLists();

        double sum = 0.0;

        for (double price : costLists){
            sum += price;
        }

        return (int) (sum * 100) / 100.0; // keep only 2 decimals
    }

    public String asString() {
        List<Double> costLists = costLists();

        return "almost done";
    }
}
