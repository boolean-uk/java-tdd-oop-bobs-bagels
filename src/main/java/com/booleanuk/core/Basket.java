package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> inventory;
    private ArrayList<Product> basketContent;
    private int basketSize;
    private double totalPrice;

    public Basket(){
        this.inventory = new ArrayList<>();
        this.basketContent = new ArrayList<>();
        this.basketSize = 3;
        this.totalPrice = 0;
        inventory.add(new Bagel("BGLO", 0.49d, "Bagel", "Onion"));
        inventory.add(new Bagel("BGLP", 0.39d, "Bagel", "Plain"));
        inventory.add(new Bagel("BGLE", 0.49d, "Bagel", "Everything"));
        inventory.add(new Bagel("BGLS", 0.49d, "Bagel", "Sesame"));
        inventory.add(new Coffee("COFB", 0.99d, "Coffee", "Black"));
        inventory.add(new Coffee("COFW", 1.19d, "Coffee", "White"));
        inventory.add(new Coffee("COFC", 1.29d, "Coffee", "Cappuccino"));
        inventory.add(new Coffee("COFL", 1.29d, "Coffee", "Latte"));
        inventory.add(new Filling("FILB", 0.12d, "Filling", "Bacon"));
        inventory.add(new Filling("FILE", 0.12d, "Filling", "Egg"));
        inventory.add(new Filling("FILC", 0.12d, "Filling", "Cheese"));
        inventory.add(new Filling("FILX", 0.12d, "Filling", "Cream Cheese"));
        inventory.add(new Filling("FILS", 0.12d, "Filling", "Smoked Salmon"));
        inventory.add(new Filling("FILH", 0.12d, "Filling", "Ham"));
    }

    public Boolean addItem(String SKU){
        if(basketContent.size() >= basketSize){
            System.out.println("Basket full, cannot add more");
            return false;
        }

        for (Product p: inventory){
            if (p.getSKU().equals(SKU)){ //Found product in inv, add to basket
                if (!(p instanceof Filling)){
                    basketContent.add(p);
                    totalPrice += p.getPrice();

                    return true;
                }else{
                    System.out.println("Cannot buy filling on it's own, add it to a bagel dummy");
                    return false;
                }
            }
        }

        System.out.println("Couldn't find item in inventory");
        return false;
    }

    public Boolean removeItem(String SKU){
        for (Product p: basketContent){
            if(p.getSKU().equals(SKU)){
                basketContent.remove(p);
                totalPrice -= p.getPrice();
                return true;
            }
        }

        System.out.println("Couldn't find the item in the basket");
        return false;
    }

    public int changeBasketSize(int newSize){
        setBasketSize(newSize);
        return newSize;
    }

    private int getBasketSize(){
        return this.basketSize;
    }

    private void setBasketSize(int newSize){
        this.basketSize = newSize;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
