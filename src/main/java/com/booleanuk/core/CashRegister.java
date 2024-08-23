package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

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
        //HashMap<String, Integer> basketCopy = basket.getBasketItems();
        HashMap<String, Integer> basketCopy;
        basketCopy = basket.getBasketItems();

        sum = 0;
        discountedSum = 0;
        totalDiscount = 0;

        if (basket.isEmpty()) {
            return "Your basket is empty.";
        }

        if (!basket.isEmpty()){
            getDiscountBagel();
        }
        if (!basket.isEmpty()) {
            getDiscountCoffeeBagel();
        }
        if (!basket.isEmpty()) {
            getRemainingSum();
        }

         basket.setBasketItems(basketCopy);

        return "The sum of your order is: " + String.format("%.2f", discountedSum);
    }

    public void getDiscountBagel(){
        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            Item bagel = getMenuItem(entry.getKey());

            if (bagel.getItemName().equals("Bagel")){
                while (entry.getValue() >= 12){
                    sum += (bagel.getItemPrice() * 12);
                    discountedSum += 3.99f;

                    for (int i = 0; i<12; i++){
                        basket.removeItem(bagel.getItemSKU(), false);
                    }
                }

                while (entry.getValue() >= 6){
                    sum += (bagel.getItemPrice() * 6);
                    discountedSum += 2.49f;

                    for (int i = 0; i<6; i++){
                        basket.removeItem(bagel.getItemSKU(), false);
                    }
                }
            }
        }
    }

    public void getDiscountCoffeeBagel(){
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

        while (bagelCount!=0 && coffeeCount!=0){
            for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
                Item bagel = getMenuItem(entry.getKey());

                if (bagel.getItemName().equals("Bagel") && entry.getValue()!= 0){
                    sum += (bagel.getItemPrice());
                    basket.removeItem(bagel.getItemSKU(), false);
                    break;
                }
            }

            for (HashMap.Entry<String, Integer> entry2 : basket.getBasketItems().entrySet()){
                Item coffee = getMenuItem(entry2.getKey());

                if (coffee.getItemName().equals("Coffee") && entry2.getValue()!= 0){
                    sum += (coffee.getItemPrice());
                    discountedSum += 1.25f;
                    basket.removeItem(coffee.getItemSKU(), false);
                    break;
                }
            }
            bagelCount--;
            coffeeCount--;
        }
    }

    public void getRemainingSum(){
        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            if (entry.getValue() != 0){
                Item item = getMenuItem(entry.getKey());
                int quantity = entry.getValue();
                float price = item.getItemPrice();

                sum += quantity*price;
                discountedSum += quantity*price;

                for (int i = 0; i < quantity; i++){
                    basket.removeItem(entry.getKey(), false);
                }
            }
        }
    }

}
