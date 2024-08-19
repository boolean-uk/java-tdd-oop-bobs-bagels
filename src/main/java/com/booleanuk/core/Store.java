package com.booleanuk.core;

import java.util.HashMap;

public class Store {

    private Product[] inventory = new Product[14];
    private HashMap<String, Order> orders;
    private int basketCapacity;

    Product bagel1, bagel2, bagel3, bagel4,
            coffee1, coffee2, coffee3, coffee4,
            filling1, filling2, filling3, filling4, filling5, filling6;

    public Store(int basketCapacity) {
        this.basketCapacity = basketCapacity;

        bagel1 = new Bagel("BGLO", "Onion", 49);
        bagel2 = new Bagel("BGLP", "Plain", 39);
        bagel3 = new Bagel("BGLE", "Everything", 49);
        bagel4 = new Bagel("BGLS", "Sesame", 49);
        coffee1 = new Coffee("COFB", "Black", 99);
        coffee2 = new Coffee("COFW", "White", 119);
        coffee3 = new Coffee("COFC", "Capuccino", 129);
        coffee4 = new Coffee("COFL", "Latte", 129);
        filling1 = new Filling("FILB", "Bacon", 12);
        filling2 = new Filling("FILE", "Egg", 12);
        filling3 = new Filling("FILC", "Cheese", 12);
        filling4 = new Filling("FILX", "Cream Cheese", 12);
        filling5 = new Filling("FILS", "Smoked Salmon", 12);
        filling6 = new Filling("FILH", "Ham", 12);

        inventory[0] = bagel1;
        inventory[1] = bagel2;
        inventory[2] = bagel3;
        inventory[3] = bagel4;
        inventory[4] = coffee1;
        inventory[5] = coffee2;
        inventory[6] = coffee3;
        inventory[7] = coffee4;
        inventory[8] = filling1;
        inventory[9] = filling2;
        inventory[10] = filling3;
        inventory[11] = filling4;
        inventory[12] = filling5;
        inventory[13] = filling6;
    }

    public boolean contains(String searchedProduct){
        for(Product product : inventory){
            if(product.getSku().equals(searchedProduct)){
                return true;
            }
        }
        return false;
    }

    public int getBasketCapacity(){
        return this.basketCapacity;
    }

    public void setBasketCapacity(int newCapacity){
        this.basketCapacity = newCapacity;
    }
}