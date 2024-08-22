package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static com.booleanuk.core.Menu.*;


public class CashRegister {
    Basket basket;
    private float sum = 0;
    private float discountedSum = 0;
    private float totalDiscount = 0;

    public CashRegister(Basket basket){
        this.basket = basket;
    }

    public String sumOrder() {

        if (basket.isEmpty()) {
            return "Your basket is empty.";
        }
        getDiscountBagel();
        int bagelCount = 0;
        int coffeeCount = 0;

        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()) {
            Item item = getMenuItem(entry.getKey());
            if (item.getItemName().equals("Bagel")){
                bagelCount += entry.getValue();
            }

            if (item.getItemName().equals("Coffee")){
                coffeeCount += entry.getValue();
            }
        }
        if (basket.isEmpty()){
            return "The sum of your order is: " + String.format("%.2f", discountedSum);
        }

        while (bagelCount!=0 && coffeeCount!=0){
            for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
                Item item1 = getMenuItem(entry.getKey());
                if (item1.getItemName().equals("Bagel")){
                    sum += (item1.getItemPrice());
                    basket.removeItem(item1.getItemSKU(), false);
                    break;
                }
            }
            for (HashMap.Entry<String, Integer> entry2 : basket.getBasketItems().entrySet()){
                Item item2 = getMenuItem(entry2.getKey());
                if (item2.getItemName().equals("Coffee")){
                    sum += (item2.getItemPrice());
                    discountedSum += 1.25f;
                    basket.removeItem(item2.getItemSKU(), false);
                    break;
                }
            }
            bagelCount--;
            coffeeCount--;
        }

        if (basket.isEmpty()){
            return "The sum of your order is: " + String.format("%.2f", discountedSum);
        }
        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            Item item = getMenuItem(entry.getKey());
            int quantity = entry.getValue();
            float price = item.getItemPrice();

            sum += quantity*price;
            discountedSum += quantity*price;
        }

        return "The sum of your order is: " + String.format("%.2f", discountedSum);
    }

        /*float sum = 0;
        float discountedSum = 0;
        int bagelCount = 0;
        int coffeeCount = 0;

        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            int quantity = entry.getValue();
            float discount = 0;


            /*if (getMenuItem(entry.getKey()).getItemName().equals("Bagel")){
                discount = getDiscountBagelAndRemainingQuantity(item, quantity)[0];

                bagelCount += (int) getDiscountBagelAndRemainingQuantity(item, quantity)[1];
            }

            if (getMenuItem(entry.getKey()).getItemName().equals("Coffee")){
                coffeeCount += quantity;
            }*/

            /*float price = getMenuItem(entry.getKey()).getItemPrice();

            sum += price * quantity;
            discountedSum += (price * quantity) - discount;
        }

        return "The sum of your order is: " + String.format("%.2f", discountedSum);
    }*/

    public void getDiscountBagel(){
        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            Item item = getMenuItem(entry.getKey());
            if (item.getItemName().equals("Bagel")){
                while (entry.getValue() >= 12){
                    sum += (item.getItemPrice() * 12);
                    discountedSum += 3.99f;
                    for (int i = 0; i<12; i++){
                        basket.removeItem(item.getItemSKU(), false);
                    }
                }
                while (entry.getValue() >= 6){
                    sum += (item.getItemPrice() * 6);
                    discountedSum += 2.49f;
                    for (int i = 0; i<6; i++){
                        basket.removeItem(item.getItemSKU(), false);
                    }
                }
            }

        }

    }

    public float getDiscountBagelCoffee(int bagelCount, int coffeeCount){
        return 0;
    }


    /*while (bagelCount !=0 && quantity != 0){
                        float price = getMenuItem(entry.getKey()).getItemPrice();
                        totalSum += price;
                        bagelCount--;
                        quantity--;
                    }
                    return "The sum of your order is: " + String.format("%.2f", totalSum);*/


    /*public String sumOrderDiscount(){
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
    }*/

}
