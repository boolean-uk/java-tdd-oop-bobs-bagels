package com.booleanuk.core;

import java.util.HashMap;
import java.util.Objects;

public class DiscountHandler {

    public static double applyDiscount(Basket basket) {
        double discountedPrice = 0.0;
        int blackCoffeeCount = 0;
        HashMap<String, Integer> bagelCount = new HashMap<>();
        HashMap<String, Double> bagelSkuPrice = new HashMap<>();

        for (Product product : basket.getBasket()) {
            if(Objects.equals(product.getItemName(), "Bagel")){
                if(!bagelCount.containsKey(product.getSku())){
                    bagelCount.put(product.getSku(), 1);
                    bagelSkuPrice.put(product.getSku(), product.getPrice());
                }
                else {
                    bagelCount.put(product.getSku(), bagelCount.get(product.getSku())+1);
                }
            }

            if(Objects.equals(product.getItemName(), "Coffee")){
                if(product.getSku().equalsIgnoreCase("COFB")){
                    blackCoffeeCount++;
                }
            }
        }

        for (String bagelsku : bagelCount.keySet()){
            int amount = bagelCount.get(bagelsku);
            double price = bagelSkuPrice.get(bagelsku);

            // implement method line 40
            discountedPrice += calculateFinalDiscount(bagelsku, amount, price);


            while(amount % 6 > 0 && blackCoffeeCount > 0){
                discountedPrice += (price + 0.99) - 1.25; // coffee and bagel
                blackCoffeeCount--;
                amount--;
            }

        }
        return discountedPrice;
    }

    public static double calculateFinalDiscount(String sku, int amount, double price){
        double discount = 0.0;

        if (amount > 11) {
            int setsOf12 = amount / 12;
            double oldPrice = price * 12;
            discount = (oldPrice * setsOf12) - (3.99 * setsOf12);
        }


        if (amount % 12 > 5) {
            // plain bagels are cheaper without the discount, ignore plain bagels in bulk of 6
            if (!sku.equalsIgnoreCase("BGLP")) {
                discount += (price * 6) - 2.49;
            }
        }

        return discount;
    }
}
