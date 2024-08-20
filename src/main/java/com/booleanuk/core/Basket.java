package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {

   private  Map<String, Integer> basketItems;
   private int basketLimit;
   private int basketTotal;
   Inventory inventory;



    public Basket(){
        this.inventory = new Inventory();
        this.setBasketLimit(20);
        this.basketTotal = 0;
        this.basketItems = new HashMap<>();

    }

    public Map<String, Integer> getBasketItems() {
        return basketItems;
    }

    public void addBagel (String bagelName, int quantity){
        if(!exceededBasketLimit(getBasketLimit(),this.basketTotal+quantity )){
            if(this.basketItems.containsKey(bagelName)){
                this.basketItems.put(bagelName, this.basketItems.get(bagelName)+quantity);
                this.basketTotal = this.basketItems.values().stream().reduce(0, Integer::sum);
            }else{
                this.basketItems.put(bagelName, quantity);
                this.basketTotal = this.basketItems.values().stream().reduce(0, Integer::sum);
            }
        }else {
            int limitExceededBy = (this.basketTotal + quantity) - getBasketLimit();
            System.out.println("The quantity of bagels you are adding to your basket exceeds the basket limit by " + limitExceededBy +". Please reduce the quantity of bagels by this amount.");
        }
    }

    public boolean exceededBasketLimit(int basketLimit, int basketTotalAfterAddBagel){
        return basketTotalAfterAddBagel > basketLimit;
    }

    public int getBasketLimit() {
        return this.basketLimit;
    }

    public void setBasketLimit(int basketLimit) {
        this.basketLimit = basketLimit;
    }

    public void removeBagel(String bagelName, int quantity){
        if(!this.basketItems.containsKey(bagelName)){
            System.out.println("This bagel isn't in your basket.");
        }
        else{
            if(this.basketItems.get(bagelName) <= quantity){
                this.basketItems.remove(bagelName);
            }else{
                int newQuantity = basketItems.get(bagelName) - quantity;
                this.basketItems.put(bagelName, newQuantity );
            }
        }
    }


    private double getFillingCost(String sku) {
        InventoryItem itemDetails = this.inventory.getInventoryItemDetails(sku);
        return itemDetails.getPrice();
    }

    private boolean isFilling(String sku) {
        InventoryItem itemDetails = this.inventory.getInventoryItemDetails(sku);
        return itemDetails.getName().equals("Filling");
    }

    public void userRequestFillingPrice(String sku){
        double price = 0.0;
        boolean isInInventory = (this.inventory.getInventoryItemDetails(sku) != null);
        if(isInInventory){
            InventoryItem itemDetails = this.inventory.getInventoryItemDetails(sku);
            if(this.isFilling(sku)){
                price = itemDetails.getPrice();
                System.out.println("The price of this filling is: "+ price);
            }else{
                System.out.println("This item is not a filling.");
            }
        }else{
            System.out.println("We do not have this item in our inventory.");
        }
    }

    public void addFillingToBasket(String fillingSku, int quantity){
            if(this.basketItems.containsKey(fillingSku)){
                this.basketItems.put(fillingSku, this.basketItems.get(fillingSku)+quantity);
            }else{
                this.basketItems.put(fillingSku, quantity);
            }
    }





}
