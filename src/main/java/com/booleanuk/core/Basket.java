package com.booleanuk.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

import static com.booleanuk.core.Inventory.inventoryProducts;
import static com.booleanuk.core.Inventory.productIsInStock;

public class Basket {

    private ArrayList<Product> products;
    private HashMap<String, Integer> productCount;
    private int capacity;


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
        if(productIsInStock(SKU) && getCapacity()>products.size()){
            Product newProduct= new Product(SKU,inventoryProducts.get(SKU).getName(),inventoryProducts.get(SKU).getProductCost(),inventoryProducts.get(SKU).getVariant());
            products.add(newProduct);

//            //adds SKU to HashMap or updates its value
            int thisProductInBasketCount;
            if(productCount.containsKey(SKU)){
                thisProductInBasketCount = productCount.get(SKU);
            }else{
                thisProductInBasketCount = 0;
            }

            thisProductInBasketCount++;
            productCount.put(SKU,thisProductInBasketCount);
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

//
public double getTotalCost() {
    BigDecimal sum = BigDecimal.ZERO;

    for (String keySKU : productCount.keySet()) {
        int totalProductsOfThisSKU = productCount.get(keySKU);

        if (keySKU.equals("BGLP") && totalProductsOfThisSKU >= 12) {
            BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 12)
                    .multiply(BigDecimal.valueOf(3.99));
            BigDecimal remaining = BigDecimal.valueOf(totalProductsOfThisSKU % 12)
                    .multiply(BigDecimal.valueOf(0.39));
            sum = sum.add(discount).add(remaining);
        } else if (keySKU.equals("BGLO") || keySKU.equals("BGLE")) {
            BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 6)
                    .multiply(BigDecimal.valueOf(2.49));
            BigDecimal remaining = BigDecimal.valueOf(totalProductsOfThisSKU % 6)
                    .multiply(BigDecimal.valueOf(0.49));
            sum = sum.add(discount).add(remaining);
        } else if (keySKU.substring(0,2).equals("COF") || productCount.containsKey("BGLP") || productCount.containsKey("BGLO") || productCount.containsKey("BGLE") || productCount.containsKey("BGLS")) {
            // TODO: 12-May-23 count coffee and bagels to calculate discount
        } else {
            sum = sum.add(BigDecimal.valueOf(totalProductsOfThisSKU).multiply(BigDecimal.valueOf(0.49)));
        }
    }

    for (Product product : products) {
        if (product.getName().equals("Bagel")) {
            for (Filling filling : product.getFillings()) {
                sum = sum.add(BigDecimal.valueOf(filling.getProductCost()));
            }
        }
    }

    return sum.doubleValue();
}
}
