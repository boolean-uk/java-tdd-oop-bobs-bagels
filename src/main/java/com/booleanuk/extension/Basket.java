package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Basket {

    private ArrayList<Product> products;
    private static int maxSize;
    double totalPrice;

    public Basket(){
        this.products = new ArrayList<>();
        this.totalPrice = 0;
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

    protected boolean addFillings(Bagel bagel, ArrayList<Filling> fillings){
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

        //Clone basket to be able to remove from copy
        ArrayList<Product> temporaryProducts = this.products;

        //Add all fillings first where discounts does not apply.
        for (Product product: temporaryProducts){
            if (product.getName().equals("Bagel")){
                for (Filling filling : product.getFillings()){
                    totalPrice += getCostOfProduct(filling);
                }
            }
        }

        ArrayList<Product> restOfProducts = calculateDiscounts(temporaryProducts);

        for (Product product : restOfProducts){
            totalPrice += getCostOfProduct(product);
        }

        return totalPrice;
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

    private ArrayList<Product> calculateDiscounts(ArrayList<Product> temporaryProducts){

        //Initilise map for keeping track of qantity of each product
        HashMap<String, Integer> qtyMap = new HashMap<>();

        //Initialise map to store what's being removed
        HashMap<String, Integer> removeMap = new HashMap<>();

        //Clone basket to be able to remove from basket


        //Add all products to a map.

        for (Product product : temporaryProducts) {
            if (!qtyMap.containsKey(product.getId())) {
                qtyMap.put(product.getId(), 1);
            } else {
                int currentAmount = qtyMap.get(product.getId());
                qtyMap.put(product.getId(), currentAmount + 1);
            }
        }

        for (String id : qtyMap.keySet()){
            if(id.contains("BGL")){
                int amount = qtyMap.get(id);
                while (amount>= 12){
                   amount -= 12;
                   totalPrice += 3.99;
                   removeMap.put(id, 12);                 }
                while (amount >= 6){
                    amount -= 6;
                    totalPrice += 2.49;
                    removeMap.put(id, 6);
                }
            }
        }

        for (String removedProductId : removeMap.keySet()){
            int amount = removeMap.get(removedProductId);
            Iterator<Product> iterator = temporaryProducts.iterator();
            while (iterator.hasNext() && amount > 0) {
                Product product = iterator.next();
                if (removedProductId.equals(product.getId())) {
                    iterator.remove();
                    amount--;
                }
            }
        }

        return temporaryProducts;
    }


    protected void clearBasket(){
        this.products.clear();
    }

    private boolean isBasketFull(){
        return (this.products.size()) >= maxSize;
    }
}
