package com.booleanuk.extension;

import java.util.*;
import java.util.stream.Collectors;

public class Receipt {

    public Map<Bagel, Integer> bagels;
    public Map<Coffee, Integer> coffees; //

    public List<Double> TotalCount;

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
            coffees.put(newEntry.getKey(), newEntry.getValue().intValue()+1);
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
                oldValue = coffees.put(newEntry.getKey(), newEntry.getValue().intValue() - 1);
            } else {
                oldValue = coffees.remove(newEntry.getKey());
            }
        }

        if (oldValue != -1){
            return true;

        } else {
            return false;
        }


    }

    public double discountedCost() {
        if (numberOfCoffees() == numberOfBagels())
            return 1.25*numberOfBagels();

        int coffeeSize = numberOfCoffees();
        // stream= list just an objects which has an useful methods of collectors, you can think of an arraylist
        //what is an arraylist? can store some data and has useful methods.
        //this iterates though all the entrys


        List<Double> BagelsCost = new ArrayList<Double>();
        List<Double> CoffeesCost = new ArrayList<Double>();
        double sumCoffees = 0;
        //in order to iterate through a map we need to convert it to a entrySet. A Map is no iterable
        for (Map.Entry<Bagel, Integer> entry : bagels.entrySet()) {
            double sumBagels = 0;
            double sumBagelsCoffee = 0;
            int numberOfBagels = entry.getValue();
            double bagelPrice = entry.getKey().getPrice();
            sumBagels += (numberOfBagels/12)*3.99;//discount for every 12 bagels of the same sort

            numberOfBagels = numberOfBagels % 12; // 11 % 12 = 11
            sumBagels += (numberOfBagels/6)*2.49; // discount for 6 bagels of the same sort

            numberOfBagels = numberOfBagels%6; // (11%6) = 5
            if (numberOfBagels > coffeeSize){
                numberOfBagels = (numberOfBagels - coffeeSize); //5 // 3 bagels and 1 coffee
                sumBagelsCoffee += coffeeSize*1.25;  // coffee and bagels together
                sumBagels += (numberOfBagels)*bagelPrice; // price of rest of bagels
                coffeeSize = 0;
                System.out.println("if");
            }  else {
                sumBagelsCoffee += numberOfBagels * 1.25;
                coffeeSize = coffeeSize - numberOfBagels;
            }
            BagelsCost.add(sumBagels);
            CoffeesCost.add(sumBagelsCoffee);
        }
       // for (int i = 0; i<coffeeSize; i++){
        //    sumCoffees += priceCoffees[i];  //price of rest of coffees
       // }
        double sum = 0.0;
        for (double price : BagelsCost) {
           sum += price;
        }
        for (double price : CoffeesCost){
           sum += price;
        }

        return (int) (sum * 100) / 100.0; // keep only 2 decimals
    }






}
