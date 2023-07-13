package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Product> products;
    private int capacity;

    public Basket( int capacity) {
        products = new ArrayList<>(0);
        this.capacity = capacity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        int sum = products.size();
        for(Product p : products){
            sum+= p.getSize();
        }
        if(sum<capacity) return false;
        return true;
    }

    public void add(Product product){
        if(isFull()) return;
        products.add(product);
    }

    public boolean doesProductExist(Product product) {
        if(products.contains(product)) return true;
        return false;
    }
    public void remove(Product product) {
        if(doesProductExist(product)) products.remove(product);
    }

    public BigDecimal totalCost() {
        BigDecimal sum = BigDecimal.ZERO;
        for(Product p : products){
            sum=sum.add(p.getPrice());
        }
        return sum;
    }
}
