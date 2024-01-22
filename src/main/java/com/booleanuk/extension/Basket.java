package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private  HashMap<String, Integer> qtyMap;
    private ArrayList<Product> products;
    private static int maxSize;

    public Basket(){
        this.qtyMap = new HashMap<>();
        this.products = new ArrayList<>();
        maxSize = 10;
    }

    public boolean add(Product product){

        //If the product is not in inventory
        if(!Inventory.isValidProduct(product) || product.getName().equals("Fillings")){
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
        calculateDiscounts();
        double total = 0;

//        for (Filling filling : bagel.getFillings()){
//
//        }

        for (Product product: products){
            total += getCostOfProduct(product);
        }

        return total;
    }

    public double getCostOfProduct(Product product){
        double total = product.getPrice();
        for(Filling filling : product.getFillings()){
            total += getCostOfFilling(filling);
        }
        return total;
    }

    public double getCostOfFilling(Filling filling){
        return filling.getPrice();
    }

    protected void clearBasket(){
        this.products.clear();
    }

    private boolean isBasketFull(){
        return (this.products.size()) >= maxSize;
    }

    private double calculateDiscounts(){

        //Add all products to a map.
        System.out.println(products.size());
        for (Product product : this.products){
            if (!qtyMap.containsKey(product.getId())){
                qtyMap.put(product.getId(), 1);
            }
            else {
                int currentAmount = qtyMap.get(product.getId());
                qtyMap.put(product.getId(), currentAmount +1);
            }
        }
        System.out.println(qtyMap);

        double res = 0;
        for (int qty : qtyMap.values()){
            while (qty>12){
                qty -= 12;
                res += 3.99;
            }
        }
        System.out.println(res);
        System.out.println(qtyMap);
        return res;
    }

}
