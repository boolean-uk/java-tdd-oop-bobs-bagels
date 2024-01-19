package com.booleanuk.core;
import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private ArrayList<Product> basket;
    private int size;
     Inventory inventory;
     /**Constructs a new Basket object
      *
     * @param size The maximum size of the basket
     * */
    public Basket( Inventory inventory, int size ){
        this.basket = new ArrayList<>();
        this.size = size;
        this.inventory = inventory;
    }

    /**
     *
     * @param item The bagel to be added to the basket
     * @return true if the bagel was added successfully, false if the bagel was already in the basket or if the basket is full
     */

    public boolean add(Bagel item) {
        if (isFull()) {
            return false;
        }
        else if(!isItemInInventory(item)){
            System.out.println("Product is not in our inventory!");
            return false;
        }
        this.basket.add(item);
        System.out.println(item + " added successfully!");
        return true;
    }

    /**
     *
     * @param item The bagel to be removed from the basket
     * @return a string indicating the result of removing
     * "Basket is empty" if the basket is empty
     * "Item id not in the basket" if the item is not found in the basket
     * "Item removed from basket" if the item is successfully removed
     */
    public String remove(Bagel item){
        if(this.basket.isEmpty()){
            return "Basket is empty";
        }
        if(!this.basket.contains(item)){
            return item + " is not in the basket!";
        }
        this.basket.remove(item);
        return item +" removed from basket";
    }

    /**
     *
     * @return true if the basket is full, otherwise false
     */

    public boolean isFull(){
        if( this.basket.size() >= size){
            System.out.println("Basket is full");
            return true;
        }
        return false;

    }

    /**
     *
     * @param newCapacity the new capacity to set for the basket
     * @return a string indicating that the basket size has been updated to the specified capacity
     */
    public String changeCapacity(int newCapacity){
        this.basket.ensureCapacity(newCapacity);
        return "Basket size is updated to " + newCapacity;
    }

    /**
     *
     * @return the total cost of all products in the basket
     */

    public double getTotalCost(){
        double total = 0.0;
        for(Product item : basket){
           total+= item.getPrice();
        }
        return total;
    }

    /**
     *
     * @param item the product which the cost is to be retrieved
     * @return the cost of the specified product
     */
    public double getItemCost(Bagel item){
        return item.getPrice();
    }

    /**
     * Adds a filling to the basket, but only if a bagel is already added in the basket
     * @param filling filling to be added to the basket
     * @return a string indicating the result
     * "Filling is added" if the filling is successfully added
     * "Please select a bagel before adding filling" if no bagel is found in the basket
     */
    public String addingFillingWhenBagelInBasket( Filling filling) {
        boolean bagelInBasket = false;
        for(Product item : this.basket){
            if(item instanceof Bagel){
                bagelInBasket = true;
                break;
            }
        }
        if(bagelInBasket){
            this.basket.add(filling);
            return filling + " is added";
        }else {
            return "Please select a bagel before adding filling";
        }
    }

    /**
     * Retrieves the cost of a specific filling
     * @param item the filling which the cost is to be retrieves
     * @return the cost of the specified filling
     */
    public double getFillingCost(Filling item){
        return item.getPrice();
    }

    /**
     * Checks if a specific product is present in the inventory
     * @param item the product to check if it is in the inventory
     * @return true if the product is in the inventory, otherwise false
     */
    public boolean isItemInInventory(Product item) {
       return inventory.getInventoryItem().contains(item);
    }

}
