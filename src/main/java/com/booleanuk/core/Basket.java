package com.booleanuk.core;

import java.util.HashMap;

public class Basket {


    private HashMap<Product, Integer> basket = new HashMap<>();

    private static final Inventory inventory  = new Inventory();
    private int capacity = 5;


    public Basket() {

    }

    public HashMap<Product, Integer> getBasket() {
        return basket;
    }

    public boolean add(Product product, int quantity) {
        int freeSpace = capacity - productsInBasket();
        if (inventory.isInTheIventory(product)) {
            if (freeSpace < quantity) {
                System.out.println("Your basket does not have capacity!");
                return false;
            }


            basket.put(product, quantity);
            return true;
        }
        System.out.println("not added to basket");
        return false;
    }

    public boolean removeProduct(Product product, int quantity) {
        if(checkSanity(product)){
            if(basket.get(product) > quantity){
                basket.replace(product,basket.get(product)-1 );
                return  true;
            }else{
                basket.remove(product);
                return true;
            }
        }
        System.out.println("Are you ok?");
        return false;
    }

    public void changeCapacity(int capacity) {
        setCapacity(capacity);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Product product :
               basket.keySet()) {
            if(basket.containsKey(product)) {
                totalCost = totalCost + (product.getPrice() * basket.get(product));
            }
        }

        return totalCost;
    }


   private boolean checkSanity(Product product){
        return  basket.containsKey(product);
    }


    private int productsInBasket(){
        int productsInBasket = 0;
        for (Product product :
                basket.keySet()) {
            if(basket.containsKey(product)) {
               productsInBasket+=basket.get(product);
            }

        }

        return productsInBasket;
    }


    private boolean isInTheInvetory() {
        return false;
    }




}
