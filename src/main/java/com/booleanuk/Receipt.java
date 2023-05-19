package com.booleanuk;

import java.util.*;
import java.util.stream.Collectors;

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


    private Map<CountableItem, Double> costLists() {
        Map<CountableItem, Double> costs = new HashMap<>();

        if (size(bagels) == size(coffees)) {
            for (CountableBagel bagel : bagels)
                costs.put(bagel, 1.25 * size(bagels));
            return costs;
        }

        // stream= list just an objects which has an useful methods of collectors, you can think of an arraylist
        //what is an arraylist? can store some data and has useful methods.
        //this iterates though all the entrys

        int coffeeSize = size(coffees);
        List<CountableCoffee> sortedCoffees = coffees.stream()
                .sorted(Comparator.comparing(cf -> cf.getPrice())).collect(Collectors.toList());
        List<CountableBagel> sortedBagels = bagels.stream()
                .sorted(Comparator.comparing(cb -> cb.getPrice(), Comparator.reverseOrder())).collect(Collectors.toList());

        //in order to iterate through a map we need to convert it to a entrySet. A Map is no iterable
        for (CountableBagel cBagel : sortedBagels) {
            double sumBagels = 0;
            double sumBagelsCoffee = 0;
            int numberOfBagels = cBagel.getAmount();
            double bagelPrice = cBagel.getPrice();

            // calculate the dozens
            sumBagels += (numberOfBagels / 12) * 3.99;//discount for every 12 bagels of the same sort
            numberOfBagels = numberOfBagels % 12;

            // calculate half dozens
            sumBagels += (numberOfBagels / 6) * 2.49; // discount for 6 bagels of the same sort
            numberOfBagels = numberOfBagels % 6;

            if (numberOfBagels >= coffeeSize){
                numberOfBagels = numberOfBagels - coffeeSize;
                sumBagels += numberOfBagels * bagelPrice; // price of rest of bagels

                sumBagels += coffeeSize * 1.25; // bagel-coffee discount
                coffeeSize = 0;
            }  else {

                sumBagels += numberOfBagels * 1.25; // bagel-coffee discount
                coffeeSize = coffeeSize - numberOfBagels;
            }

            // save the cost of each bagel
            costs.put(cBagel, sumBagels);
        }

        for (CountableCoffee cf : sortedCoffees) {
            int minCount = Math.min(cf.getAmount(), coffeeSize);

            if (coffeeSize > 0) costs.put(cf, cf.getPrice() * minCount);

            coffeeSize -= minCount;
        }

        return costs;
    }

    public double discountedCost() {
        Map<CountableItem, Double> costs = costLists();

        double sum = 0.0;

        for (double price : costs.values()){
            sum += price;
        }

        return (int) (sum * 100) / 100.0; // keep only 2 decimals
    }

    public String asString() {
        Map<CountableItem, Double> costs = costLists();
        StringBuilder sb = new StringBuilder();

        costs.forEach((key, value) -> sb.append(key.toString() + " " + value + "\n"));

        return sb.toString();
    }
}
