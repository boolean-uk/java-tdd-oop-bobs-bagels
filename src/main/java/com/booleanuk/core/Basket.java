package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;

public class Basket {
    String[] basketArr;
    public ArrayList<Inventory> inventoryList;

    public Basket(){
        this.basketArr = new String[5];
        this.inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory("BGLO",0.49d,"Bagel","Onion"));
        inventoryList.add(new Inventory("BGLP",0.39d,"Bagel","Plain"));
        inventoryList.add(new Inventory("BGLE",0.49d,"Bagel","Everything"));
        inventoryList.add(new Inventory("BGLS",0.49d,"Bagel","Sesame"));
        inventoryList.add(new Inventory("COFB",0.99d,"Coffee","Black"));
        inventoryList.add(new Inventory("COFW",1.19d,"Coffee","White"));
        inventoryList.add(new Inventory("COFC",1.29d,"Coffee","Cappuccino"));
        inventoryList.add(new Inventory("COFL",1.29d,"Coffee","Latte"));
        inventoryList.add(new Inventory("FILB",0.12d,"Filling","Bacon"));
        inventoryList.add(new Inventory("FILE",0.12d,"Filling","Egg"));
        inventoryList.add(new Inventory("FILC",0.12d,"Filling","Cheese"));
        inventoryList.add(new Inventory("FILX",0.12d,"Filling","Cream Cheese"));
        inventoryList.add(new Inventory("FILS",0.12d,"Filling","Smoked Salmon"));
        inventoryList.add(new Inventory("FILH",0.12d,"Filling","Ham"));
    }

    public ArrayList<Inventory> getInventoryList(){
        return inventoryList;
    }



    public String addBagelToBasket(String product){
        //String for return
        String output = "";
        //First check if the product exists
        for (int i = 0; i < inventoryList.size(); i++) {
            Inventory item = inventoryList.get(i);
            if (item.getName().equals(product)){
                //Check if the basket is full
                if (this.basketArr[this.basketArr.length - 1] == null) {
                    //Go through the array to find the first empty slot
                    for (int j = 0; j < basketArr.length; j++) {
                        //Add the bagel if the slot is empty
                        if (this.basketArr[j] == null) {
                            this.basketArr[j] = item.getName();
                            output += item.getName()+ " added to basket";
                            //Stops the loop when the product is added
                            break;
                        }
                    }
                } else{
                    output = "Basket is full";

                }
                //Stops the for loop if bagel was found
                break;
            } else{
                //If it doesnt exist return new output
                output = "That product doesnt exist";
            }


        }

        return output;
    }

    public boolean removeFromBasket(String product){
        //Go through the array to find the bagel
        boolean bool = false;
        for (int i = 0; i < basketArr.length; i++) {
            //Check if it is empty
            if(basketArr[i]!=null){
                //If it is the same String, remove it
                if(basketArr[i].equals(product)){
                    basketArr[i] = null;
                    bool = true;
                }
            }

        }
        return bool;

    }

    public void changeBasketCapacity(int size){
        String[] newArray = new String[size];
        //Sorting algorithm from stackoverflow
        //needed it to sort the array because of null values
        Arrays.sort(basketArr, (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
        });

        //Loop that adds values into the new array
        for (int i = 0; i < basketArr.length; i++) {
            if(basketArr[i] != null){
                newArray[i] = this.basketArr[i];
            }

        }

        //Makes the original array == the new array
        basketArr = newArray;
    }

    public double totalCost(){

        return 0;
    }

    public String createMenu(){
        String output = "";
        for (int i = 0; i < inventoryList.size(); i++) {
            output+=inventoryList.get(i) +"\n";
        }
        return output;
    }


    public static void main(String[] args) {
        Basket basket = new Basket();


        System.out.println(basket.addBagelToBasket("Bogle"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(Arrays.toString(basket.basketArr));

    }


}

