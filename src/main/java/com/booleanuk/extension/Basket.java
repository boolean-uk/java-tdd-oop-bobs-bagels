package com.booleanuk.extension;

import java.util.*;

public class Basket {
    private final ArrayList<Bagel> bagels;
    private final ArrayList<Coffee> coffees;
    private final Inventory inventory;
    private int capacity;

    public Basket(ArrayList<Bagel> bagels, ArrayList<Coffee> coffees, int capacity) {
        this.bagels = bagels;
        this.capacity = capacity;
        this.coffees = coffees;
        this.inventory = new Inventory();
    }

    public Basket(int capacity, Inventory inventory) {
        this.capacity = capacity;
        this.inventory = inventory;
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();
    }

    private boolean canAddToCart() {
        return (bagels.size() + coffees.size()) < capacity;
    }

    public boolean add(Bagel bagel){
        if (!inventory.contains(bagel)) return false;

        if (!canAddToCart()) return false;

        bagels.add(bagel);
        return true;
    }

    public boolean add(Coffee coffee){
        if (!inventory.contains(coffee)) return false;

        if (!canAddToCart()) return false;

        coffees.add(coffee);
        return true;
    }

    public boolean remove(Bagel bagel){
        for (Bagel b : this.bagels) {
            if (b.getVariant().equals(bagel.getVariant()) && b.getFillings().containsAll(bagel.getFillings())) {
                this.bagels.remove(b);
                return true;
            }
        }

        return false;
    }

    public boolean remove(Coffee coffee){
        for(Coffee c : this.coffees){
            if(c.getVariant().equals(coffee.getVariant())){
                this.coffees.remove(c);
                return true;
            }
        }

        return false;
    }

    public boolean updateCapacity(int capacity){
        if(bagels.size() + coffees.size() >= capacity) return false;

        this.capacity = capacity;

        return true;
    }

    private double CoffeeBagelComboPrice() {
        return 1.25 * bagels.size();
    }

    public double discountedCost() {
        if (bagels.size() == coffees.size())
            return CoffeeBagelComboPrice();

        HashMap<String, ArrayList<Double>> bagelTypes = new HashMap<>();

        for (Bagel b : bagels) {
            ArrayList<Double> l = bagelTypes.getOrDefault(b.getVariant(), new ArrayList<>());
            l.add(b.getPrice());

            bagelTypes.put(b.getVariant(), l);
        }


        double sum = 0.0;
        int coffeeSize = coffees.size();
        double[] priceCoffees = new double[coffeeSize];

        for (int i = 0; i < coffeeSize; i++ ) {
            priceCoffees[i] = coffees.get(i).getPrice();
        }
        Arrays.sort(priceCoffees);


        List<ArrayList<Double>> sortedBagels = bagelTypes.values().stream().sorted(Comparator.comparing(l -> l.get(0), Comparator.reverseOrder())).toList();
        // stream= list just an objects which has an useful methods of collectors, you can think of an arraylist
        //what is an arraylist? can store some data and has useful methods.


        for (ArrayList<Double> priceList : sortedBagels) {
            sum += (priceList.size()/12)*3.99;
            int rest = priceList.size() % 12; // 11 % 12 = 11
            sum += (rest/6)*2.49; // (11/6) = 1*2.49 = 2.49
            int rest2 = rest%6; // (11%6) = 5
            if (rest2 > coffeeSize){
                int rest3 = (rest2 - coffeeSize); //5 // 3 bagels and 1 coffee
                sum += coffeeSize*1.25;
                sum += (rest3)*priceList.get(0);
                coffeeSize = 0;
            } else {


                sum += rest2 * 1.25;
                coffeeSize = coffeeSize - rest2;
                //int rest_of_coffees = coffees.size() -rest2;
            }
        }
        for (int i = 0; i<coffeeSize; i++){
            sum += priceCoffees[i];
        }

        return (int) (sum * 100) / 100.0; // keep only 2 decimals
    }
}
