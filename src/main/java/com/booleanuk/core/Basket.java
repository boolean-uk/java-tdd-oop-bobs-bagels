package com.booleanuk.core;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Basket {
    private List<String> items;
    private List<Bagle> bagles;
    private Inventory inventory;
    private int capacity;
    private static final DecimalFormat roundUp = new DecimalFormat("0.00");



    public Basket(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
        inventory = new Inventory();
        bagles = new ArrayList<>();
    }

    public List<String> getItems() {
        return items;
    }

    public boolean addItem(String item, List<String> fillings) {
        double priceOfProduct = 0;
        if(inventory.checkAvailability(item) == true && items.size() + fillings.size() < capacity) {

            if (item.startsWith("BGL")){
                Bagle bagle = new Bagle(item, inventory.getItemPrice(item), inventory.getBagelVariant(item));
                priceOfProduct += inventory.getItemPrice(item);
                items.add(bagle.getSKU());

                bagles.add(bagle);
                if(fillings != null && !fillings.isEmpty()){
                    for(String fillingSKU : fillings){
                        if(inventory.checkAvailability(fillingSKU) == true) {
                            items.add(fillingSKU);
                            priceOfProduct += inventory.getItemPrice(fillingSKU);
                            bagle.addFilling(fillingSKU);
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
    public boolean removeFilling(String nameOfBagle, String nameOfFilling) {
        if(items.contains(nameOfBagle) && inventory.checkAvailability(nameOfFilling) == true) {
            items.remove(nameOfFilling);
            return true;
        }
        return false;
    }

    public boolean removeCoffee(String item) {
        if(items.contains(item) && item.startsWith("COF")) {
            items.remove(item);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeBagle(String item) {
        if(items.contains(item)){
            for(Bagle bagle : bagles) {
                if(bagle.getSKU().equals(item)){
                    items.remove(item);
                    for(int i =0; i < bagle.getFillings().size(); i++) {
                        items.remove(bagle.getFillings().get(i));
                    }
                }
            }
            return true;
        }
        return false;
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
