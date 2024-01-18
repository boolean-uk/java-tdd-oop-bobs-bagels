package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {
        public ArrayList<Product> bagelBasket;


    private int size=2;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public Basket() {
            this.bagelBasket = new ArrayList<>();
        }

        public void addItem(Product product) {
            if (bagelBasket.size()>=size){
                System.out.println("Basket is full");
                return;
            }
            System.out.println(product.getPrice());
            bagelBasket.add(product);
             }

        public boolean removeItem(Product product) {
            if (bagelBasket.contains(product)){
                bagelBasket.remove(product);
                return true;
            }
            System.out.println("Item not in basket");
            return false;

        }


        public double calculateTotalCost() {
            double totalCost = 0.0;

            for (Product product : bagelBasket) {

                totalCost += product.getPrice();
            }

            return totalCost;

        }

}
