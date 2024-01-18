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

    public boolean addItem(String itemSKU){
        //Checks if input exist in inventory
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
                    //System.out.println(totalPrice);

                }
            }

        }
        return totalPrice;
    }

    public String changeCapacity (int capacity) {
        ArrayList <String> newList = new ArrayList<>();
        this.capacity = capacity;

        for (int i = 0; i < basketList.size() ; i++) {
            if(i >= capacity){
                break;
            }
            newList.add(basketList.get(i));
        }

        //Does not remove filling if added before change
        for (int i = 0; i < basketList.size() ; i++) {
            if (basketList.get(i).startsWith("FIL")){
                System.out.println(basketList.get(i));
            newList.add(basketList.get(i));}
        }

        basketList = newList;
        return basketList.toString();
    }

    public double checkPrice(String itemSKU) {
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getSku().equals(itemSKU)){
                return inventoryList.get(i).getPrice();
            }
        }
        return 0;
    }

    public boolean addFilling(String itemSKU, String fillingSKU){
        //Checks if input exist in inventory
        for (int i = 0; i < inventoryList.size(); i++) {
            if(itemSKU.equals(inventoryList.get(i).getSku())){
                //ignores capacity of basket
                basketList.add(fillingSKU);
                return true;

                //future problem, when using changeCapacity, it deletes the filling
                //know the reason, hard to come up with solution based on what I have
            }

        }
        return false;
    }



    public static void main(String[] args) {
        Basket basket = new Basket();

        System.out.println("tester ------------------");
        basket.addItem("COFB"); //0.99
        basket.addItem("BGLO"); //0.49
        basket.addItem("BGLP"); //0.39, total 1.87
        System.out.println(basket.basketList);

        System.out.println(basket.totalCost());
        basket.addFilling("BGLO","FILE");
        //basket.add("COFW");
        //basket.remove("COFB");
        //basket.totalCost();
        System.out.println(basket.basketList);

        System.out.println(basket.changeCapacity(1));
        System.out.println(basket.totalCost());

    }
    }
