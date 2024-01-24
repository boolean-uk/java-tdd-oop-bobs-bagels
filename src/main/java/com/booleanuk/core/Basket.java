package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;

public class Basket {
    public int capacity;
    public ArrayList<Item> inventoryList;
    public ArrayList<String> basketList;

    public Basket(){
        this.inventoryList = new ArrayList<>();
        this.basketList = new ArrayList<>();
        this.capacity = 3;
        inventoryList.add(new Bagel("BGLO", 0.49d, "Bagel", "Onion"));
        inventoryList.add(new Bagel("BGLP", 0.39d, "Bagel", "Plain"));
        inventoryList.add(new Bagel("BGLE", 0.49d, "Bagel", "Everything"));
        inventoryList.add(new Bagel("BGLS", 0.49d, "Bagel", "Sesame"));
        inventoryList.add(new Coffee("COFB", 0.99d, "Coffee", "Black"));
        inventoryList.add(new Coffee("COFW", 1.19d, "Coffee", "White"));
        inventoryList.add(new Coffee("COFC", 1.29d, "Coffee", "Cappuccino"));
        inventoryList.add(new Coffee("COFL", 1.29d, "Coffee", "Latte"));
        inventoryList.add(new Filling("FILB", 0.12d, "Filling", "Bacon"));
        inventoryList.add(new Filling("FILE", 0.12d, "Filling", "Egg"));
        inventoryList.add(new Filling("FILC", 0.12d, "Filling", "Cheese"));
        inventoryList.add(new Filling("FILX", 0.12d, "Filling", "Cream Cheese"));
        inventoryList.add(new Filling("FILS", 0.12d, "Filling", "Smoked Salmon"));
        inventoryList.add(new Filling("FILH", 0.12d, "Filling", "Ham"));
    }

    public boolean addItem(String itemSKU){
        //Checks if input exist in inventory
        for (int i = 0; i < inventoryList.size(); i++) {
            if(basketList.size() < capacity){
                if(itemSKU.equals(inventoryList.get(i).getSku())){
                    basketList.add(inventoryList.get(i).getSku()
//                            + " "
//                            + inventoryList.get(i).getName()
//                            + " "
//                            + inventoryList.get(i).getVariant()
                              );
                    return true;
                }

            }else return false;
        }
        return false;
    }

    public boolean removeItem(String itemSKU) {
        if(basketList.contains(itemSKU)){
            basketList.remove(itemSKU);
            return true;
        }
        return false;
    }

    public double totalCost() {
        double totalPrice = 0;
        //Running 2 loops, try to match from basket to inventory,
        // if match: get the pricetag from inventory
        for (int i = 0; i < basketList.size(); i++) {
            for (int j = 0; j < inventoryList.size(); j++) {
                if (basketList.get(i).equals(inventoryList.get(j).getSku())){
                     totalPrice += inventoryList.get(j).getPrice();
                }
            }

        }
        return totalPrice;
    }

    public String changeCapacity (int capacity) {
        ArrayList <String> newList = new ArrayList<>();
        this.capacity = capacity;

        if (!basketList.isEmpty()){
            for (int i = 0; i < capacity ; i++) {
                newList.add(basketList.get(i));
            }

            //Does not remove filling after changing capacity
            for (int i = 0; i < basketList.size() ; i++) {
                if (basketList.get(i).startsWith("FIL")){
                    newList.add(basketList.get(i));}
            }
        }



        basketList = newList;
        return basketList.toString();
    }

    public double checkPrice(String itemSKU) {
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getSku().equals(itemSKU)){
                return inventoryList.get(i).getPrice();
            }
        }
        return 0;
    }

    public String addFilling(String itemSKU, String fillingSKU){
        //Checks if input exist in inventory
        for (int i = 0; i < inventoryList.size(); i++) {
            if(itemSKU.equals(inventoryList.get(i).getSku())){
                //Adds the filling next to the bagel, instead of adding at the end of list
                for (int j = 0; j < basketList.size(); j++) {
                    if (itemSKU.equals(basketList.get(j))){
                        basketList.add(j+1,fillingSKU);
                        return basketList.toString();
                    }
                }
            }

        }
        return basketList.toString();
    }

//  problem 1, adding too much filling will restrict adding Item
//  (adding 1 bagel + 4 filling = full basket, bad practice) Work around is to use addFilling after everything
//  problem 2, when using changeCapacity to less, it deletes the filling to the bagel
//  problem 3, removing the bagel does not remove the filling from basket
//  know the reason, hard to come up with solution based on what I have

    //Make discount item
    //make method to count amount of bagel, resets at 12
    //method has arraylist<String> discount
    //the left over bagels compares with coffee

    //--------------------------EXTENSION 1--------------------------//
    public double discount() {
        double price = 0;
        ArrayList<String> discount = new ArrayList<>();
        inventoryList.add(new Bagel("DIS6", 2.49d, "Discount", "6 bagels"));
        inventoryList.add(new Bagel("DIS12", 3.99d, "Discount", "12 bagels"));
        inventoryList.add(new Bagel("DISCB", 1.25d, "Discount", "Coffee + Bagel"));

        Collections.sort(basketList);
        int counterBGL = 0;
        int counterCOF = 0;

        for (int i = 0; i < basketList.size(); i++) {
            if (basketList.get(i).startsWith("BGL")){
                counterBGL ++;
            } else if (basketList.get(i).startsWith("COF")){
                counterCOF ++;
            }else if (basketList.get(i).startsWith("FIL")){
                discount.add(basketList.get(i));
            }
        }
        //Converts to discount code starts here
        int discount12 = counterBGL/12; // 20/12 = 1
        int remainingAfter12 = counterBGL%12; // 20%12 = 8
        int discount6 = remainingAfter12/6; // 8/6 = 1
        int remainingAfter6 = remainingAfter12%6; // 8%6 = 2

        //Generating how many discounts for bagel
        for (int i = 0; i < discount12; i++) {
            discount.add("DIS12");
        }

        for (int i = 0; i < discount6; i++) {
            discount.add("DIS6");
        }

        //Generating how many discounts with coffee + bagel
        if (counterCOF >= remainingAfter6){
            int discountCB = counterCOF*remainingAfter6/counterCOF;
            for (int i = 0; i < discountCB ; i++) {
                discount.add("DISCB");
            }
            int remainder = counterCOF - remainingAfter6;
            int counter = 0;
            for (int i = 0; i < remainder; i++) {
                for (int j = 0; j < basketList.size(); j++) {
                    if (basketList.get(j).startsWith("COF") & counter < remainder){
                        counter++;
                        discount.add(basketList.get(j));
                    }
                }
            }
        }
        if (remainingAfter6 > counterCOF){
            int discountCB = remainingAfter6*counterCOF/remainingAfter6;
            for (int i = 0; i < discountCB; i++) {
                discount.add("DISCB");
            }
            int remainder = remainingAfter6 - counterCOF;
            int counter = 0;
            for (int i = 0; i < remainder; i++) {
                for (int j = 0; j < basketList.size(); j++) {
                    if (basketList.get(j).startsWith("BGL") & counter < remainder){
                        counter++;
                        discount.add(basketList.get(j));
                    }
                }
            }
        }
        //Calculate the total price with discount
        for (int i = 0; i < discount.size(); i++) {
            for (int j = 0; j < inventoryList.size(); j++) {
                if (discount.get(i).equals(inventoryList.get(j).getSku())){
                    price += inventoryList.get(j).getPrice();
                }
            }
        }
        return Double.parseDouble(String.format("%.2f",price));
    }

    //--------------------------EXTENSION 2--------------------------//
    public String printReceipt() {
        ArrayList<String> receipt = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        String name = basketList.get(0);
        double totalPrice = 0;
        builder
                .append("~~~ Bob's Bagel ~~~\n")
                .append(String.format("%-20s%20s%20s\n","ITEM","QTY.","TOTAL"))
                .append(String.format("---------------------------------------------------------------------\n"));


        for (int i = 0; i < inventoryList.size(); i++) {
            for (int j = 0; j < basketList.size(); j++) {
                if (inventoryList.get(i).getSku().equals(basketList.get(j))){
                    name = basketList.get(j);
                }

                if (!receipt.contains(name)) {
                    //if (basketList.get(j).equals(inventoryList.get(i).getSku())) {
                    receipt.add(name);

                    double price = inventoryList.get(i).getPrice() * Collections.frequency(basketList,name);
                    totalPrice += price;
                    String formatPrice = String.format("%.2f",price);

                    builder

                            .append(String.format("%-15s",inventoryList.get(i).getVariant()))
                            .append(" ")
                            .append(String.format("%-20s",inventoryList.get(i).getName()))
                            //.append("\t")
                            .append(String.format("%-20s",Collections.frequency(basketList,name)))
                            //.append("\t\t")
                            .append(String.format("%-20s",formatPrice+"£"))
                            .append("\n");


                }
            }
        }
        builder
                .append("---------------------------------------------------------------------\n")
                .append(String.format("%62s" ,totalPrice+"£"));
        return builder.toString();
    }

    public static void main(String[] args) {
        //Testing receipt
        Basket basket = new Basket();
        basket.changeCapacity(100);
        basket.addItem("BGLO");
        basket.addItem("BGLO");

        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");

        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");

        basket.addItem("COFB");
        basket.addItem("COFB");
        basket.addItem("COFB");

        System.out.println(basket.printReceipt());
    }
}
