package com.booleanuk.core;
import com.booleanuk.core.Bagle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Basket {
    private List<String> items;
    private Inventory inventory;
    private int capacity;
    private static final DecimalFormat roundUp = new DecimalFormat("0.00");

    Bagle bagle;

    public Basket(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
        inventory = new Inventory();
    }

    public List<String> getItems() {
        return items;
    }

    public boolean addItem(String item, List<String> fillings) {
        double priceOfProduct = 0;
        if(inventory.checkAvailability(item) == true && items.size() + fillings.size() < capacity) {
            //System.out.println("The product added to basket costs :" + inventory.getItemPrice(item));
            //items.add(item);

            if (item.startsWith("BGL")){
                Bagle bagle = inventory.getBagelBySKU(item);
                priceOfProduct += inventory.getItemPrice(item);
                items.add(bagle.getSKU());
                if(fillings != null && !fillings.isEmpty()){
                    for(String fillingSKU : fillings){
                       if(inventory.checkAvailability(fillingSKU) == true) {
                            items.add(fillingSKU);
                            priceOfProduct += inventory.getItemPrice(fillingSKU);

                        }
                    }
                    System.out.println("Price of product is: " + priceOfProduct);
                }
            }else if(item.startsWith("COF")) {
                System.out.println("Price of product is: " + inventory.getItemPrice(item));
                items.add(item);
            }else {
                return false;
            }
            return true;
        }else {
            return false;
        }

    }


    /*
List<Bagle> bagles;
    public void addFilling(String SKUofBagle,String SKUofFilling) {
        double price = inventory.getItemPrice(SKUofBagle);
        //String variant = inventory.getVariantBySKU(SKUofBagle);
        //if(bagles.contains(bagle)){
        //    bagle.addFilling(SKUofFilling);
        //}
       // bagle = new Bagle(SKUofBagle, price, variant);
        //bagle.addFilling(SKUofFilling);
    }
*/
    public boolean removeItem(String item) {
        if(items.contains(item)) {
            items.remove(item);
            return true;
        }else {
            return false;
        }
    }

    public void changeCapacity(int newCapacity) {
        if(newCapacity > 0 && newCapacity >= items.size()) {
            this.capacity = newCapacity;
        }else if(newCapacity <=0) {
            System.out.println("You can't downsize the basket to negative or 0");
        }else if(newCapacity < items.size()) {
            System.out.println("You already got " + items.size() + " bagles in basket so you can't downsize basket to " + newCapacity + " spaces.");
            System.out.println("New basket size is " + items.size());
            this.capacity = items.size();
        }

    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for(String item : items) {
            totalPrice +=inventory.getItemPrice(item);
        }
        return Math.round(totalPrice*100.0)/100.0;
    }

}
