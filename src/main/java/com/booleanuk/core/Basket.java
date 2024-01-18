package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    public int capacity;
    public ArrayList<Item> inventoryList;
    public ArrayList<String> basketList;

    public Basket(){
        this.inventoryList = new ArrayList<>();
        this.basketList = new ArrayList<>();
        this.capacity = 3;
        inventoryList.add(new Item("BGLO", 0.49d, "Bagel", "Onion"));
        inventoryList.add(new Item("BGLP", 0.39d, "Bagel", "Plain"));
        inventoryList.add(new Item("BGLE", 0.49d, "Bagel", "Everything"));
        inventoryList.add(new Item("BGLS", 0.49d, "Bagel", "Sesame"));
        inventoryList.add(new Item("COFB", 0.99d, "Coffee", "Black"));
        inventoryList.add(new Item("COFW", 1.19d, "Coffee", "White"));
        inventoryList.add(new Item("COFC", 1.29d, "Coffee", "Cappuccino"));
        inventoryList.add(new Item("COFL", 1.29d, "Coffee", "Latte"));
        inventoryList.add(new Item("FILB", 0.12d, "Filling", "Bacon"));
        inventoryList.add(new Item("FILE", 0.12d, "Filling", "Egg"));
        inventoryList.add(new Item("FILC", 0.12d, "Filling", "Cheese"));
        inventoryList.add(new Item("FILX", 0.12d, "Filling", "Cream Cheese"));
        inventoryList.add(new Item("FILS", 0.12d, "Filling", "Smoked Salmon"));
        inventoryList.add(new Item("FILH", 0.12d, "Filling", "Ham"));
    }

    public boolean add(String itemSKU){
        for (int i = 0; i < inventoryList.size(); i++) {
            if(basketList.size() < capacity){
                if(itemSKU.equals(inventoryList.get(i).getSku())){
                    basketList.add(inventoryList.get(i).getSku()
//                            + " "
//                            + inventoryList.get(i).getName()
//                            + " "
//                            + inventoryList.get(i).getVariant()
                              );
                    return true;
                }
            }
        }
        System.out.println(basketList);
        return false;
    }

    public boolean remove(String itemSKU) {

        if(basketList.contains(itemSKU)){
            basketList.remove(itemSKU);
            return true;
        }
        return false;
    }

    public double totalCost() {
        double totalPrice = 0;
        for (int i = 0; i < basketList.size(); i++) {
            for (int j = 0; j < inventoryList.size(); j++) {
                if (basketList.get(i).equals(inventoryList.get(j).getSku())){
                     totalPrice += inventoryList.get(j).getPrice();
                    System.out.println(totalPrice);

                }
            }

        }
        return totalPrice;
    }

    public static void main(String[] args) {
        Basket basket = new Basket();

        System.out.println(basket.inventoryList.get(1).getPrice());
        System.out.println("tester ------------------");
        basket.add("COFB"); //0.99
        basket.add("BGLO"); //0.49
        basket.add("BGLP"); //0.39, total 1.87
        //basket.add("COFW");
        //basket.remove("COFB");
        basket.totalCost();
        //System.out.println(basket.basketList);
    }
    }
