package com.booleanuk.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> basket;
    private int capacity;
     Inventory inventoryProduct;

    public Basket( int capacity ){
        this.basket = new ArrayList<>();
        this.capacity = capacity;
        this.inventoryProduct = new Inventory();
    }

    public boolean addItem(Bagel item) {
        if (isFull() || item.getQuantity() > this.capacity) {
            return false;
        }
        else if(!isItemInInventory(item)){
            System.out.println("Product is not in our inventory!");
            return false;
        }
        this.basket.add(item);
        System.out.println(item + " added successfully!");
        return true;
    }

    public String remove(Product item){
        if(this.basket.isEmpty()){
            return "Basket is empty";
        }
        if(!this.basket.contains(item)){
            return item + " is not in the basket!";
        }
        this.basket.remove(item);
        return item +" removed from basket";
    }


    public boolean isFull(){
        if( this.basket.size() >= this.capacity){
            System.out.println("Basket is full");
            return true;
        }
        return false;

    }

    public String changeCapacity(int newCapacity){
        this.basket.ensureCapacity(newCapacity);
        return "Basket size is updated to " + newCapacity;
    }


    public double getTotalCost(){
        double total = 0.0;

        for(Product item : basket){
           total+= item.getPrice();
        }
        BigDecimal roundedTotal = BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP);
        return roundedTotal.doubleValue();
    }

    public double getItemCost(Bagel item){
        return item.getPrice();
    }

    public String addingFillingWhenBagelInBasket( Product filling) {
        boolean bagelInBasket = false;
        for(Product item : this.basket){
            if(item instanceof Bagel){
                bagelInBasket = true;
                break;
            }
        }
        if(bagelInBasket){
            this.basket.add(filling);
            return filling + " is added";
        }else {
            return "Please select a bagel before adding filling";
        }
    }

    public double getFillingCost(Filling item){
        return item.getPrice();
    }

    public boolean isItemInInventory(Product item) {
       return inventoryProduct.getInventoryItem().contains(item);
    }


}
