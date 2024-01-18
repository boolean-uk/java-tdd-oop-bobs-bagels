package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private ArrayList<Product> basket;
    private int size;
     Inventory inventoryProduct;
    public Basket( Inventory inventoryProduct,int size ){
        this.basket = new ArrayList<>();
        this.size = size;
        this.inventoryProduct = inventoryProduct;
    }

    public boolean add(Bagel item) {
        if (isFull()) {
            return false;
        } else if (this.basket.contains(item)) {
            System.out.println(item + " already added!");
            return false;
        }
        this.basket.add(item);
        System.out.println(item + " added successfully!");
        return true;
    }
    public String remove(Bagel item){
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
        if( this.basket.size() >= size){
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
        return total;
    }
    public double getItemCost(Product item){
        return item.getPrice();
    }
    public String addingFillingWhenBagelInBasket( Filling filling) {
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


    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Basket myBasket = new Basket(inventory,2);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Filling filling1 = new Filling("FILB",0.12, "Filling", "Bacon");
        Filling filling2 = new Filling("FILC",0.12, "Filling", "Cheese");

        myBasket.add(bagel1);
        myBasket.add(bagel2);

        System.out.println(myBasket.addingFillingWhenBagelInBasket(filling1));
        System.out.println(myBasket.addingFillingWhenBagelInBasket(filling2));


    }







}
