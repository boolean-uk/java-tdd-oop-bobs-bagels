package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Basket {

    private int capacity;
    private ArrayList<Bagel> items = new ArrayList<>();

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Bagel> getItems(){
        return items;
    }

    public void setItems(ArrayList<Bagel> items) {
        this.items = items;
    }

    public boolean isFull() {
        return getItemsSize() == capacity;
    }

    public int getItemsSize() {
        return items.size();
    }

    public void addItem(Bagel bagel) {
        if (isFull()) {
            throw new NoSuchElementException("Basket full cant add bagel");
        }

        items.add(bagel);
    }

    public void remove(Bagel bagel){
        if(!items.contains(bagel)){
            throw new NoSuchElementException("Bagel don't exists");
        }
        items.remove(bagel);
    }

    public double getTotalCost(){
        double cost = 0.0;
        Map<String, Integer> bagels = getBagel();
        for (Bagel bagel : items){
            double priceOfBagel = bagel.getPrice();
            if (bagels.containsKey(bagel.getSku())){
                int count = bagels.get(bagel.getSku());
                double price = getSpecialPriceBagel(bagel.getSku(), count);
                if(price != -1.0){
                    priceOfBagel = price;
                    bagels.put(bagel.getSku(), count -1);
                }
            }
            cost += priceOfBagel;
        }
        return cost;
    }

    public double getTotalCostWithoutDisc(){
        double cost = 0.0;
        for (Bagel bagel : items){
            double bagelCost = bagel.getPrice();
            cost += bagelCost;
        }

        return cost;
    }

    public double getDiscountPrice(){
        return getTotalCostWithoutDisc() - getTotalCost();
    }

    public void changeCapacity(int changeCapacity){
        if(changeCapacity < getItemsSize()){
            throw new IllegalArgumentException("Can't change capacity");
        }
        this.capacity = changeCapacity;
    }

    private double getSpecialPriceBagel(String sku, int count) {
        Map<String, Double> special = new HashMap<>();
        special.put("BGLO", 2.49);
        special.put("BGLP", 3.99);
        special.put("BGLE", 2.49);
        if (special.containsKey(sku) && count > 0){
            int offer = getOffer(sku);
            if (count % offer == 0){
                return special.get(sku) * (count / offer);
            }
        }
        return -1.0;
    }

    private int getOffer(String sku) {
        Map<String, Integer> offer = new HashMap<>();
        offer.put("BGLO", 6);
        offer.put("BGLP", 12);
        offer.put("BGLE", 6);

        return offer.getOrDefault(sku, 1);
    }

    private Map<String, Integer> getBagel() {
        Map<String, Integer> bagels = new HashMap<>();
        for (Bagel bagel : items){
            bagels.put(bagel.getSku(), bagels.getOrDefault(bagel.getSku(), 0) + 1);
        }
        return bagels;
    }


}
