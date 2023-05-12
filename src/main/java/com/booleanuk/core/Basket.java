package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private ArrayList<Product> products;
    private HashMap<String, Integer> productCount;
    private int capacity;
    Inventory inventory = new Inventory();


    public Basket(int capacity){
        this.products= new ArrayList<>();
        this.capacity = capacity;
        this.productCount= new HashMap<>();
    }
    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity>getCapacity()){
            this.capacity = capacity;
        }
    }

    public boolean add( String SKU){
        if(inventory.productIsInStock(SKU) && getCapacity()>products.size()){
            Product newProduct= new Product(SKU,inventory.products.get(SKU).getName(),inventory.products.get(SKU).getProductCost(),inventory.products.get(SKU).getVariant());
            products.add(newProduct);

//            //adds SKU to HashMap or updates its value
//            int thisProductInBasketCount;
//            if(productCount.containsKey(SKU)){
//                thisProductInBasketCount = productCount.get(SKU);
//            }else{
//                thisProductInBasketCount = 0;
//            }
//
//            thisProductInBasketCount++;
//            productCount.put(SKU,thisProductInBasketCount);
            return true;
        }
        return false;
    }

    public boolean remove( String SKU){
        for (Product product:this.products) {
            if (product.getSKU().equals(SKU)) {
                return products.remove(product);
            }
        }
        return false;
    }

    public double getTotalCost(){
        double sum=0;
//
//        int bagelCount = productCount.get("Bagel");
//        int fillingCount = productCount.get("Filling");
//        int coffeCount = productCount.get("Coffe");
//
//        for (String keySKU: productCount.keySet()) {
//            int totalProductsOfThisSKU = productCount.get(keySKU);
//            if(keySKU.equals("BGLP") && totalProductsOfThisSKU >= 12){
//                sum += 3.99;
//                for (int i = 0; i < 12; i++) {
//                    products.remove(keySKU);
//                }
//                break;
//            } else if (keySKU.equals("BGLO") || keySKU.equals("BGLO")){
//                if(totalProductsOfThisSKU >= 6){
//                    sum += 2.49;
//                    for (int i = 0; i < 6; i++) {
//                        products.remove(keySKU);
//                    }
//                    break;
//                }
//            }
//        }

        for (Bagel bagel : bagels) {
            sum += bagel.getProductCost();
            for (int j = 0; j < bagel.getFillings().size(); j++) {
                sum += bagel.getFillings().get(j).getProductCost();
            }
        }
        return sum;
    }
}
