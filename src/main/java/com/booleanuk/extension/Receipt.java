package com.booleanuk.extension;

import java.util.*;
import java.util.stream.Collectors;

public class Receipt {
    public Map<Bagel, Integer> bagels;
    public Map<Coffee, Integer> coffees;

    public Receipt(){
        this.bagels = new HashMap<>();
        this.coffees = new HashMap<>();
    }

    public int numberOfCoffees(){
        int count = 0;
        for (int value : coffees.values()){
            count += value;
        }
        return count;
    }

    public int numberOfBagels(){
        int count = 0;
       for (int value : bagels.values()){
           count += value;
       }
       return count;
    }

    public int numberOfItems(){
        return numberOfCoffees()+numberOfBagels();
    }

    public void add(Bagel bagel){ //(Onion,1+1), (onion, 1+1), (Onion, 1+1)
        Map.Entry<Bagel, Integer> newEntry = null;
        for (Map.Entry<Bagel, Integer> entry: bagels.entrySet()){
            if(entry.getKey().getVariant().equals(bagel.getVariant())){
                newEntry = entry;
            }
        }

        if (newEntry != null){
            bagels.put(newEntry.getKey(), newEntry.getValue().intValue()+1);
        } else {
            bagels.put(bagel,1);
        }
    }
    public boolean remove(Bagel bagel){ //(Onion,1+1), (onion, 1+1), (Onion, 1+1)
        Map.Entry<Bagel, Integer> newEntry = null;
        for (Map.Entry<Bagel, Integer> entry: bagels.entrySet()){
            if(entry.getKey().getVariant().equals(bagel.getVariant()) && entry.getKey().getFillings().containsAll(bagel.getFillings())){
                newEntry = entry;
            }
        }

        int oldValue = -1;

        if (newEntry != null){
            if(newEntry.getValue() > 1) {
                oldValue = bagels.put(newEntry.getKey(), newEntry.getValue().intValue() - 1);
            } else {
                oldValue = bagels.remove(newEntry.getKey());
            }
        }

        if (oldValue != -1){
            return true;

        } else {
            return false;
        }
    }

    public void add(Coffee coffee){ //(Onion,1+1), (onion, 1+1), (Onion, 1+1)
        Map.Entry<Coffee, Integer> newEntry = null;
        for (Map.Entry<Coffee, Integer> entry: coffees.entrySet()){
            if(entry.getKey().getVariant().equals(coffee.getVariant())){
                newEntry = entry;
            }
        }

        if (newEntry != null){
            coffees.put(newEntry.getKey(), newEntry.getValue() +1);
        } else {
            coffees.put(coffee,1);
        }
    }

    public boolean remove(Coffee coffee){ //(Onion,1+1), (onion, 1+1), (Onion, 1+1)
        Map.Entry<Coffee, Integer> newEntry = null;
        for (Map.Entry<Coffee, Integer> entry: coffees.entrySet()){
            if(entry.getKey().getVariant().equals(coffee.getVariant())){
                newEntry = entry;
            }

        }

        int oldValue = -1;

        if (newEntry != null){
            if(newEntry.getValue() > 1) {
                oldValue = coffees.put(newEntry.getKey(), newEntry.getValue() - 1);
            } else {
                oldValue = coffees.remove(newEntry.getKey());
            }
        }

        return oldValue != -1;
    }

    private List<Double> costLists() {
        List<Double> bagelsCost = new ArrayList<>();
        List<Double> coffeesCost = new ArrayList<>();

        if (numberOfCoffees() == numberOfBagels()) {
            bagelsCost.add(1.25 * numberOfBagels());
            return bagelsCost;
        }

        // stream= list just an objects which has an useful methods of collectors, you can think of an arraylist
        //what is an arraylist? can store some data and has useful methods.
        //this iterates though all the entrys

        int coffeeSize = numberOfCoffees();

        //in order to iterate through a map we need to convert it to a entrySet. A Map is no iterable
        for (Map.Entry<Bagel, Integer> entry : bagels.entrySet()) {
            double sumBagels = 0;
            double sumBagelsCoffee = 0;
            int numberOfBagels = entry.getValue();
            double bagelPrice = entry.getKey().getPrice();

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

        List<Coffee> coffeeList = coffees.keySet().stream()
                .sorted(Comparator.comparing(e -> e.getPrice())).toList();

        int i = 0;
        while (coffeeSize > 0) {
            Coffee c = coffeeList.get(i);
            int count = coffees.get(c);
            coffeesCost.add(c.getPrice() * count);

            coffeeSize -= count;
            i++;
        }

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
