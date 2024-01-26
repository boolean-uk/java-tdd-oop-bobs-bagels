package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

   //  private HashMap<Bagel, Integer> products;
    private ArrayList<Product> products;
    private static int maxSize;

    public Basket(){

        this.products = new ArrayList<>();
        maxSize = 10;
    }

    public boolean add(Product product){

        //If the product is not in inventory
        if(!Inventory.isValidProduct(product) || product.getName().equals("Filling")){
            return false;
        }

        //If basket is full
        if(isBasketFull()){
            return false;
        }
        //Add bagel
        this.products.add(product);

        return true;
    }

    public boolean remove(Product product){
        if (products.contains(product)){
            products.remove(product);
            return true;
        }
        return false;
    }

    public boolean addFillings(Bagel bagel,  ArrayList<Filling> fillings){
        if(products.contains(bagel)){
            return bagel.addFillings(fillings);
        }
        return false;
    }

    public static boolean setMaxSize(int max){
        if(max < 0){
            return false;
        }
        maxSize = max;
        return true;
    }

    public static int getMaxSize() {
        return maxSize;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getCostOfBasket(){
        double total = 0;

        for (Product product: products){
            total += getCostOfProduct(product);
        }
        return total;
    }

    public double getCostOfProduct(Product product){
        double price = 0;
        if (product.getName().equals("Bagel")){
            price = product.getPrice();
            for(Filling filling : product.getFillings()){
                price += filling.getPrice();
            }
        }else {
            price = product.getPrice();
        }
        return price;
    }
    protected void clearBasket(){
        this.products.clear();
    }

    private boolean isBasketFull(){
        return (this.products.size()) >= maxSize;
    }

}
