package com.booleanuk.core;

import java.util.ArrayList;

public class Order {

    Inventory bagel1 = new Inventory("BGLO", "Bagel", "Onion", 0.49);
    Inventory bagel2 = new Inventory("BGLP", "Bagel", "Plain", 0.39);
    Inventory bagel3 = new Inventory("BGLE", "Bagel", "Everything", 0.49);
    Inventory bagel4 = new Inventory("BGLS", "Bagel", "Sesame", 0.49);
    Inventory coffee1 = new Inventory("COFB", "Bagel", "Onion", 0.99);
    Inventory coffee2 = new Inventory("COFW", "Bagel", "Onion", 1.19);
    Inventory coffee3 = new Inventory("COFC", "Bagel", "Onion", 1.29);
    Inventory coffee4 = new Inventory("COFL", "Bagel", "Onion", 1.29);
    Inventory fill1 = new Inventory("FILB", "Filling", "Bacon", 0.12);
    Inventory fill2 = new Inventory("FILE", "Filling", "Egg", 0.12);
    Inventory fill3 = new Inventory("FILC", "Filling", "Cheese", 0.12);
    Inventory fill4 = new Inventory("FILX", "Filling", "Cream Cheese", 0.12);
    Inventory fill5 = new Inventory("FILS", "Filling", "Smoked Salmon", 0.12);
    Inventory fill6 = new Inventory("FILH", "Filling", "Ham", 0.12);
    ArrayList<Bagel> bagelList;
    ArrayList<Coffee> coffeeList;
    ArrayList<Filling> fillingList;
    ArrayList<Inventory> inventoryList;
    ArrayList<Inventory> basketList;


    int capacity = 10;

    public Order(){
        this.inventoryList = new ArrayList<>();
        this.basketList = new ArrayList<>(capacity);
        initialize();

    }

    public void initialize() {
        inventoryList.add(bagel1);
        inventoryList.add(bagel2);
        inventoryList.add(bagel3);
        inventoryList.add(bagel4);
        inventoryList.add(coffee1);
        inventoryList.add(coffee2);
        inventoryList.add(coffee3);
        inventoryList.add(coffee4);
        inventoryList.add(fill1);
        inventoryList.add(fill2);
        inventoryList.add(fill3);
        inventoryList.add(fill4);
        inventoryList.add(fill5);
        inventoryList.add(fill6);
    }


    public boolean add(String SKU, String itemType, String bagelName, double bagelPrice) {


        for (Inventory inventory : inventoryList) {
            if (inventory.getSku().equals(SKU) && inventory.getItemType().equals(itemType) && inventory.getName().equals(bagelName) && inventory.getPrice() == bagelPrice) {
                Inventory bagel10 = new Inventory(SKU, itemType, bagelName, bagelPrice);
                basketList.add(bagel10);
                return true;

            }
        }
        return false;
    }
	public boolean remove(String SKU, String itemType, String bagelName, double bagelPrice) {

        for (Inventory inventory : basketList) {
            if (inventory.getSku().equals(SKU) && inventory.getItemType().equals(itemType) && inventory.getName().equals(bagelName) && inventory.getPrice() == bagelPrice) {
                basketList.remove(inventory);
                return true;

            }
        }


        return false;
    }
	public boolean isBasketFull() {

        return basketList.size() > capacity;
    }
	public int updateBasket(int amount) {


            if (amount > basketList.size()) {
                capacity = amount;
            }


            return capacity;
    }
	public String canItemBeRemoved(String name) {



        for (Inventory basket : basketList) {

            String checkName = basket.getName();

            if (checkName.equals(name)) {
                return "The item can be removed.";
            }

        }
            return "The item is not in the basket!";



    }

	public double totalCost() {

        double cost = 0;
        for (Inventory basket : basketList) {
            cost += basket.getPrice();


        }


        return cost;
    }
	public double getCost(String bagelName) {
        for (Inventory basket : inventoryList) {
            if (basket.getName().equals(bagelName)) {

               return basket.getPrice();

            }

        }
        return 0;
    }
	public double chooseFilling(String fillingName) {

        return 0;
    }
	public double getFillingCost(String fillingName) {

        return 0;
    }





}
