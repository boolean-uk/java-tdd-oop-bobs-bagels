package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private ArrayList<Item> items;

    private int maxCapacity;

    public Basket(int maxCapacity){
        this.maxCapacity = maxCapacity;
        items = new ArrayList<>();
    }
    public boolean addItem(String SKU, int amount){
        if(amount + checkCurrentCapacity() > maxCapacity){
            return false;
        }
        Inventory i = Inventory.getInstance();
        if(i.checkInventory(SKU, amount)){
            items.addAll(i.getItems(SKU, amount));
            return true;
        }
        else{
            return false;
        }
    }
    public boolean addFillingWithBagel(String bagelSKU, ArrayList<String> fillings ) {

        if (checkCurrentCapacity() + (fillings.size() + 1) > maxCapacity) {
            return false;
        }
        Inventory i = Inventory.getInstance();
        Bagel bagel = (Bagel) i.getItems(bagelSKU, 1).get(0);
        ArrayList<Item> fillingsTemp = new ArrayList<>();

        for (String s : fillings) {
            if (i.checkInventory(s, 1)) {
                fillingsTemp.add((Filling) i.getItems(s, 1).get(0));
            } else {
                for (Item item : fillingsTemp) {

                    i.addItems(item);
                }
                i.addItems(bagel);
                return false;
            }

        }
        bagel.addFillings(fillingsTemp);
        items.add(bagel);
        return true;

    }
    public boolean removeItem(String SKU){
            Iterator<Item> iterator = items.iterator();
            while(iterator.hasNext()){
                Item currentItem = iterator.next();
                if(currentItem.getSKU().equals(SKU)){
                    if(currentItem.getSKU().startsWith("B")){
                        ((Bagel) currentItem).removeAllFillings();
                    }
                    iterator.remove();
                    Inventory.getInstance().addItems(currentItem);
                    return true;
                }
            }
            return false;
    }

    public boolean changeBasketCapacity(int capacity){
        return capacity >= this.items.size();
    }
    public double getTotalCost(){
        double total = 0;
        for(Item i : this.items){
            if(i instanceof Bagel bagel){
                for(Item f : bagel.getFillings()){
                    total+= f.getPrice();
                }
            }
            total += i.getPrice();
        }
        return total;
    }
    private int checkCurrentCapacity(){
        int capacity = items.size();
        for(Item i : items){
            if(i instanceof Bagel){
                for(Item ignored : ((Bagel) i).getFillings()){
                    capacity += 1;
                }
            }
        }
        return capacity;
    }
    private void checkItemValidity(Item item){


    }

}
