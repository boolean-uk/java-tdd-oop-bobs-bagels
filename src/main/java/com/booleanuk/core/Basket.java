package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Bagel> bagels;
    private int capacity;

    public Basket( int capacity) {
        bagels = new ArrayList<>(0);
        this.capacity = capacity;
    }

    public List<Bagel> getBagels() {
        return bagels;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        int sum = bagels.size();
        for(Bagel b : bagels){
            sum+= b.getFillings().size();
        }
        if(sum<capacity) return false;
        return true;
    }

    public void add(Bagel bagel){
        if(isFull()) return;
        bagels.add(bagel);
    }

    public boolean doesBagelExist(Bagel bagel) {
        if(bagels.contains(bagel)) return true;
        return false;
    }
    public void remove(Bagel bagel) {
        if(doesBagelExist(bagel)) bagels.remove(bagel);
    }

    public BigDecimal totalCost() {
        BigDecimal sum = BigDecimal.ZERO;
        for(Bagel b : bagels){
            sum=sum.add(b.getPrice());
        }
        return sum;
    }
}
