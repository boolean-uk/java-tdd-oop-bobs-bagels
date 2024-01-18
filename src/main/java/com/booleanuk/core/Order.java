package com.booleanuk.core;

import java.util.ArrayList;

public class Order {

    Bagel bagel1 = new Bagel("BGLO", "Bagel", "Onion", 0.49);
    Bagel bagel2 = new Bagel("BGLP", "Bagel", "Plain", 0.39);
    Bagel bagel3 = new Bagel("BGLE", "Bagel", "Everything", 0.49);
    Bagel bagel4 = new Bagel("BGLS", "Bagel", "Sesame", 0.49);
    Coffee coffee1 = new Coffee("COFB", "Bagel", "Onion", 0.99);
    Coffee coffee2 = new Coffee("COFW", "Bagel", "Onion", 1.19);
    Coffee coffee3 = new Coffee("COFC", "Bagel", "Onion", 1.29);
    Coffee coffee4 = new Coffee("COFL", "Bagel", "Onion", 1.29);
    Filling fill1 = new Filling("FILB", "Filling", "Bacon", 0.12);
    Filling fill2 = new Filling("FILE", "Filling", "Egg", 0.12);
    Filling fill3 = new Filling("FILC", "Filling", "Cheese", 0.12);
    Filling fill4 = new Filling("FILX", "Filling", "Cream Cheese", 0.12);
    Filling fill5 = new Filling("FILS", "Filling", "Smoked Salmon", 0.12);
    Filling fill6 = new Filling("FILH", "Filling", "Ham", 0.12);
    ArrayList<Bagel> bagelList;
    ArrayList<Coffee> coffeeList;
    ArrayList<Filling> fillingList;
    int capacity = 10;

    public Order(){
        this.bagelList = new ArrayList<>(capacity);
        this.coffeeList = new ArrayList<>(capacity);
        this.fillingList = new ArrayList<>(capacity);
        initialize();

    }

    public void initialize() {
        bagelList.add(bagel1);
        bagelList.add(bagel2);
        bagelList.add(bagel3);
        bagelList.add(bagel4);
        coffeeList.add(coffee1);
        coffeeList.add(coffee2);
        coffeeList.add(coffee3);
        coffeeList.add(coffee4);
        fillingList.add(fill1);
        fillingList.add(fill2);
        fillingList.add(fill3);
        fillingList.add(fill4);
        fillingList.add(fill5);
        fillingList.add(fill6);
    }


    public boolean add(String sku) {



        return false;
    }
	public boolean remove(String sku) {

        return false;
    }
	public boolean isBasketFull() {

        return false;
    }
	public int updateBasket(int amount) {

        return 0;
    }
	public String canItemBeRemoved(String name) {



        return "";
    }

	public double totalCost() {

        return 0.00;
    }
	public double getCost(String bagelName) {

        return 0;
    }
	public double chooseFilling(String fillingName) {

        return 0;
    }
	public double getFillingCost(String fillingName) {

        return 0;
    }





}
