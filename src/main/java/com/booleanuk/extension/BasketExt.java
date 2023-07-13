package com.booleanuk.extension;

import java.util.ArrayList;

public class BasketExt {

    private ArrayList<CoffeeExt> coffeesInBasket;
    private ArrayList<BagelExt> bagelsInBasket;
    private ArrayList<FillingExt> fillingInBasket;

    private int capacity;


    public BasketExt() {
        this.coffeesInBasket = new ArrayList<>();
        this.bagelsInBasket = new ArrayList<>();
        this.fillingInBasket = new ArrayList<>();
        capacity = 5;
    }


    public void add(BagelExt bagelExt) {
        bagelsInBasket.add(bagelExt);
    }

    public void add(CoffeeExt coffeeExt) {
        coffeesInBasket.add(coffeeExt);
    }

    public void add(FillingExt fillingExt) {
        fillingInBasket.add(fillingExt);
    }


    public ArrayList<CoffeeExt> getCoffeesInBasket() {
        return coffeesInBasket;
    }

    public ArrayList<BagelExt> getBagelsInBasket() {
        return bagelsInBasket;
    }

    public ArrayList<FillingExt> getFillingInBasket() {
        return fillingInBasket;
    }

    public void remove(BagelExt bagelExt) {
        bagelsInBasket.remove(bagelExt);
    }

    public void remove(FillingExt fillingExt) {
        fillingInBasket.remove(fillingExt);
    }

    public void remove(CoffeeExt coffeeExt) {
        coffeesInBasket.remove(coffeeExt);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getTotalCostBagel() {
        double totalCost = 0;

        for (BagelExt bagel :
                bagelsInBasket) {
            totalCost += bagel.getPrice();

        }
        return totalCost;
    }

    public double getTotalCostFillings() {
        double totalCost = 0;

        for (FillingExt fillingExt :
                fillingInBasket) {
            totalCost += fillingExt.getPrice();
        }
        return totalCost;

    }

    public double getTotalCostCoffee() {
        double totalCost = 0;

        for (CoffeeExt coffeeExt :
                coffeesInBasket) {
            totalCost += coffeeExt.getPrice();
        }
        return totalCost;
    }

}