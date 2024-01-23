package com.booleanuk.extension;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> basket;
    private int capacity;
     Inventory inventoryProduct;
     /**Constructs a new Basket object
      *
     * @param capacity The maximum capacity of the basket
     * */
    public Basket( int capacity ){
        this.basket = new ArrayList<>();
        this.capacity = capacity;
        this.inventoryProduct = new Inventory();
    }

    /**
     *
     * @param item The bagel to be added to the basket
     * @return true if the bagel was added successfully, false if the bagel was already in the basket or if the basket is full
     */

    public boolean addItem(Product item) {
        if (isFull()) {
            return false;
        }
        else if(!isItemInInventory(item)){
            System.out.println("Product is not in our inventory!");
            return false;
        }
        else if(item.getQuantity() > capacity){
            System.out.println("The quantity of the product exceeds the basket's capacity. Please try adding fewer items!");
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
        if( this.basket.size() >= capacity){
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


//    public double getTotalCostWithDiscount(){
//        double totalAfterDiscount = 0.00;
//        double total = 0.0;
//        int countQuantity = 0;
//        for(Product item : basket){
//           if(item instanceof Bagel){
//               if(item.getSKU().equals("BGLO")){
//                   countQuantity ++;
//                   if(countQuantity <= 5){
//                       totalAfterDiscount += item.getPrice();
//                   }
//                   else if(countQuantity == 6){
//                       totalAfterDiscount = (totalAfterDiscount + item.getPrice()) - 0.45;
//                   }
//                   else {
//                       totalAfterDiscount += item.getPrice();
//                   }
//
//               }
//           }
//           total += totalAfterDiscount + item.getPrice();
//
//        }
//        return total - totalAfterDiscount;
//    }

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
       return inventoryProduct.getInventoryItem().contains(item);
    }



    public static void main(String[] arg){
        Basket basket = new Basket(30);
        Product bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Product bagel2 = new Bagel("BGLO",0.49, "Bagel", "Onion" );

        Product comboProduct = new ComboDiscountProduct(new String[]{"COFB", "BGLO"}, 1.25, "Coffee & Bagel");

        Product filling = new Filling("FILB",0.12, "Filling", "Bacon");
        Product quantity = new QuantityDiscountProduct("BGLO", 2.49, "Bagel", "Onion", 6);

        basket.addItem(bagel1);
        basket.addItem(bagel2);

        basket.addItem(comboProduct);
        basket.addItem(filling);
        basket.addItem(quantity);
        System.out.println(basket.getTotalCost());

    }

}
