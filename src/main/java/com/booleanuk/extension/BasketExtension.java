package com.booleanuk.extension;

import com.booleanuk.core.Inventory;
import com.booleanuk.core.Product;
import com.booleanuk.core.Bagel;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BasketExtension {
    public ArrayList<Product> bagelBasket;
    Inventory inventory = new Inventory();


    private int size = 2;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public BasketExtension() {
        this.bagelBasket = new ArrayList<>();
    }


    public int getItemsInBasket() {
        int numberOfItems = 0;

        for (Product product : bagelBasket) {

            numberOfItems += product.getQuantity();
        }

        return numberOfItems;

    }

    public void addItem(Product product, int numberOfItem) {
        if (getItemsInBasket()+numberOfItem >= size) {
            System.out.println("Basket is full");
            return;
        }
        if (!inventory.inventory.contains(product)) {
            System.out.println("Item not in inventory");
            return;

        }
        if (bagelBasket.contains(product)) {
            bagelBasket.get(bagelBasket.indexOf(product)).quantity += numberOfItem;
            return;
        }

        System.out.println(product.getPrice());
        bagelBasket.add(product);
        bagelBasket.get(bagelBasket.indexOf(product)).quantity += numberOfItem;
    }

    public boolean removeItem(Product product) {
        if (bagelBasket.contains(product)) {
            bagelBasket.remove(product);
            return true;
        }
        System.out.println("Item not in basket");
        return false;

    }

    public double discount(double totalCost, Product product) {
        int quantity = product.getQuantity();
        double individualPrice = product.getPrice();


        if (quantity >= 12) {

            int offerQuantity = 12;
            double offerPrice = 3.99;
            int remainingQuantity = quantity % offerQuantity;

            totalCost += offerPrice + (remainingQuantity * individualPrice);
        } else if (quantity >= 6) {
            int offerQuantity = 6;
            double offerPrice = 2.49;
            int remainingQuantity = quantity % offerQuantity;
            totalCost += offerPrice + individualPrice * remainingQuantity;
        } else {
            totalCost += individualPrice * quantity;
        }
        return totalCost;
    }



    public double calculateTotalCost() {
        double totalCost = 0.0;

        for (Product product : bagelBasket) {
                totalCost=discount(totalCost,product);
//            int quantity = product.getQuantity();
//            double individualPrice = product.getPrice();
//
//
//            if (quantity >= 12) {
//
//                int offerQuantity = 12;
//                double offerPrice = 3.99;
//                int remainingQuantity = quantity % offerQuantity;
//
//                totalCost +=  offerPrice + (remainingQuantity * individualPrice);
//            } else if (quantity >= 6) {
//                int offerQuantity = 12;
//                double offerPrice = 2.49;
//                int remainingQuantity = quantity % offerQuantity;
//                totalCost += offerPrice + individualPrice * remainingQuantity;}
//            else {
//                totalCost += individualPrice * quantity;
//            }
        }

        return totalCost;

    }


    public void printReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(new Date());

        System.out.println("~~~ Bob's Bagels ~~~");
        System.out.println("\n" + dateStr + "\n");
        System.out.println("---------------------------------");

        for (Product item : bagelBasket) {
            System.out.printf("%-10s %-10s %-3d $%.2f\n",
                    item.getName(), item.getVariant(), item.getQuantity(), discount(0,item));
        }

        System.out.println("---------------------------------");
        System.out.printf("%-25s $%.2f\n", "Total", calculateTotalCost());
        System.out.println("\n        Thank you");
        System.out.println("      for your order!");
    }


}