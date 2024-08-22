package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {

   private  Map<Integer, BasketItem> basketItems;
   private int basketLimit;
   private int basketQuantity;
   private double basketPrice;
   Inventory inventory;



    public Basket(){
        this.inventory = new Inventory();
        this.setBasketLimit(20);
        this.basketQuantity = 0;
        this.basketItems = new HashMap<>();
        this.basketPrice = 0.0;
    }

    public Map<Integer, BasketItem> getBasketItems() {
        return basketItems;
    }

    public BasketItem createBasketItem(String itemSku, ArrayList<String> addOnsSku){

        InventoryItem mainItem =  inventory.getInventoryItemDetails(itemSku);
        if(mainItem != null ){
            BasketItem basketItem;
            if(addOnsSku != null && !addOnsSku.isEmpty()) {

                ArrayList<InventoryItem> addOns = new ArrayList<>();
                for (String addOn : addOnsSku) {
                    if (this.isFilling(addOn)) {
                        addOns.add(inventory.getInventoryItemDetails(addOn));
                    } else {
                        System.out.println("The requested item is not a filling.");
                    }
                }
                 basketItem = new BasketItem(mainItem, addOns);
            }else{
                 basketItem = new BasketItem(mainItem);
            }
           return basketItem;
        }else{
            System.out.println("We do not stock the requested item.");
            return null;
        }
    }



    public BasketItem createBasketItem(String itemSku){
        InventoryItem mainItem =  inventory.getInventoryItemDetails(itemSku);
        if(mainItem != null){
            ArrayList<InventoryItem> addOns = new ArrayList<>();
            BasketItem basketItem = new BasketItem(mainItem);
            return basketItem;
        }else{
            System.out.println("We do not stock the requested item.");
            return null;
        }

    }


    public void addBasketItem (BasketItem item){
        if((this.basketQuantity+1) <= this.basketLimit){
            int itemNumber = basketItems.size()+1;
            basketItems.put(itemNumber, item);
            this.basketQuantity += 1;
        }else{
            System.out.println("Your basket is full.");
        }
    }

    public void removeBasketItem (int itemNum){
        if(this.basketItems.get(itemNum) != null){
            this.basketPrice = this.basketPrice - this.basketItems.get(itemNum).getPrice();
            this.basketItems.remove(itemNum);
            this.basketQuantity -= 1;
        }else{
            System.out.println("This item doesn't exist in your basket.");
        }
    }

    /* This isnt private because there is no frontend, if there was a front end then this would be private, and null checks for the return would be done on the front end*/
    public void getInventoryItemCost(String sku){
        InventoryItem item = this.inventory.getInventoryItemDetails(sku);
        if(!item.equals(null)){
            System.out.println(item.getPrice());
        }else{
            System.out.println("We do not have this item in our inventory.");
        }
    }

    public double getBasketItemCost(BasketItem item){

        return item.getPrice();
    }

    public double getBasketItemCost(int itemNum){
        return this.basketItems.get(itemNum).getPrice();
    }

    public double getBasketPrice() {
        double price = 0.0;
        for(int key : this.basketItems.keySet()) {
            price += this.basketItems.get(key).getPrice() ;
        }
        return price;
    }

    public int getBasketLimit() {
        return this.basketLimit;
    }
    public void setBasketLimit(int basketLimit) {
        this.basketLimit = basketLimit;
    }

    private boolean isFilling(String sku) {
        InventoryItem itemDetails = this.inventory.getInventoryItemDetails(sku);
        if(itemDetails != null){
            return itemDetails.getName().equals("Filling");
        }else{
            return false;
        }

    }


}
