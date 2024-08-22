package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static com.booleanuk.core.Menu.*;


public class CashRegister {
    Basket basket;

    public CashRegister(Basket basket){
        this.basket = basket;
    }

    public String sumOrder(){

        if (basket.isEmpty()){
            return "Your basket is empty.";
        }

        float totalSum = 0;
        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            int quantity = entry.getValue();
            float price = getMenuItem(entry.getKey()).getItemPrice();

            totalSum += price * quantity;
        }
        return "The sum of your order is: " + String.format("%.2f", totalSum);
    }


    /*while (bagelCount !=0 && quantity != 0){
                        float price = getMenuItem(entry.getKey()).getItemPrice();
                        totalSum += price;
                        bagelCount--;
                        quantity--;
                    }
                    return "The sum of your order is: " + String.format("%.2f", totalSum);*/


    public String sumOrderDiscount(){
        if (basket.isEmpty()){
            return "Your basket is empty.";
        }

        float totalSum = 0;
        int bagelCount = 0;
        int coffeeCount = 0;

        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            if (getMenuItem(entry.getKey()).getItemName().equals("Filling")){
                int quantity = entry.getValue();
                float price = getMenuItem(entry.getKey()).getItemPrice();

                float sum = price * quantity;
                totalSum += sum;
            }
            if (getMenuItem(entry.getKey()).getItemName().equals("Bagel")){
                int quantity = entry.getValue();
                bagelCount += quantity;
            }
            if (getMenuItem(entry.getKey()).getItemName().equals("Coffee")){
                int quantity = entry.getValue();
                coffeeCount += quantity;
            }
        }

        while (bagelCount >= 12){
            totalSum += 3.99f;
            bagelCount -= 12;
        }

        while (bagelCount>=6){
            totalSum += 2.49f;
            bagelCount -= 6;
        }

        while (bagelCount>0 && coffeeCount > 0){
            totalSum += 1.25f;
            bagelCount -= 1;
            coffeeCount -= 1;
        }


        if (bagelCount!= 0){
            ArrayList<Float> basketBagelsPrices = new ArrayList<>();

            for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
                Item item = getMenuItem(entry.getKey());
                int quantity = entry.getValue();

                if ("Bagel".equals(item.getItemName())){
                    for (int i = 0; i < quantity; i++ ){
                        basketBagelsPrices.add(item.getItemPrice());
                    }
                }
            }

            Collections.sort(basketBagelsPrices);
            for (int i = 0; i < bagelCount; i++){
                totalSum += basketBagelsPrices.get(i);

            }

            return "The sum of your order is: " + String.format("%.2f", totalSum);
        }
        if (coffeeCount!= 0){
            for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
                if ("Coffee".equals(getMenuItem(entry.getKey()).getItemName())){
                    int quantity = entry.getValue();
                    while (coffeeCount != 0 && quantity != 0){
                        float price = getMenuItem(entry.getKey()).getItemPrice();
                        totalSum += price;
                        coffeeCount--;
                        quantity--;
                    }
                    return "The sum of your order is: " + String.format("%.2f", totalSum);
                }
            }
        }

        return "The sum of your order is: " + String.format("%.2f", totalSum);
    }
}
