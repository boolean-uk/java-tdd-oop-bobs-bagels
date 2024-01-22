package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private  HashMap<String, Integer> qtyMap;
    private ArrayList<Bagel> products;
    private static int maxSize;

    public Basket(){
        this.qtyMap = new HashMap<>();
        this.products = new ArrayList<>();
        maxSize = 10;
    }

    public boolean add(Bagel bagel){

        //If the product is not in inventory
        if(!Inventory.isValidBagel(bagel)){
            return false;
        }

        //If basket is full
        if(isBasketFull()){
            return false;
        }
        //Add bagel
        this.products.add(bagel);

        return true;
    }

    public boolean remove(Bagel bagel){
        if (products.contains(bagel)){
            products.remove(bagel);
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

    public ArrayList<Bagel> getProducts() {
        return products;
    }

    public double getCostOfBasket(){
        calculateDiscounts();
        double total = 0;

//        for (Filling filling : bagel.getFillings()){
//
//        }

        for (Bagel bagel: products){
            total += getCostOfBagel(bagel);
        }

        return total;
    }

    public double getCostOfBagel(Bagel bagel){
        double total = bagel.getPrice();
        for(Filling filling : bagel.getFillings()){
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
        for (Bagel product : this.products){
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
