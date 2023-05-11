package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Bagel> bagels;
    private int capacity;
    Inventory inventory = new Inventory();


    public Basket(int capacity){
        this.bagels= new ArrayList<>();
        this.capacity = capacity;
    }
    public ArrayList<Bagel> getBagels() {
        return this.bagels;
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
        if(inventory.productIsInStock(SKU) && getCapacity()>bagels.size()){
            Bagel newBagel= new Bagel(SKU,inventory.products.get(SKU).getProductCost(),inventory.products.get(SKU).getVariant());
            bagels.add(newBagel);
            return true;
        }
        return false;
    }

    public boolean remove( String SKU){
        for (Bagel bagel:this.bagels) {
            if (bagel.getSKU().equals(SKU)) {
                return bagels.remove(bagel);
            }
        }
        return false;
    }

    public double getTotalCost(){
        double sum=0;
        for (Bagel bagel : bagels) {
            sum += bagel.getProductCost();
            for (int j = 0; j < bagel.getFillings().size(); j++) {
                sum += bagel.getFillings().get(j).getProductCost();
            }
        }
        return sum;
    }
}
