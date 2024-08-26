package com.booleanuk.core;

import java.util.HashMap;

import static com.booleanuk.core.Menu.*;


public class CashRegister {
    Basket basket;
    Receipt receipt;
    private float discountedSum = 0;
    private float totalDiscount = 0;

    public CashRegister(Basket basket, Receipt receipt){
        this.basket = basket;
        this.receipt = receipt;
    }

    public void printReceipt(){
        sumOrder();
        receipt.createFinalReceipt();
        receipt.printReceipt();

    }

    public String sumOrder() {
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

        receipt.getDiscountedSum(discountedSum);
        receipt.setTotalSaved(totalDiscount);

        return "The sum of your order is: " + String.format("%.2f", discountedSum);
    }

    public void getDiscountBagel(){
        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            Item bagel = getMenuItem(entry.getKey());

            if (bagel.getItemName().equals("Bagel")){
                int bagelOfferCount = 0;
                int twelveOfferCount = 0;
                int sixOfferCount = 0;
                while (entry.getValue() >= 12){
                    discountedSum += 3.99f;

                    for (int i = 0; i<12; i++){
                        basket.removeItem(bagel.getItemSKU(), false);
                    }
                    bagelOfferCount += 12;
                    twelveOfferCount++;
                }

                while (entry.getValue() >= 6){
                    discountedSum += 2.49f;

                    for (int i = 0; i<6; i++){
                        basket.removeItem(bagel.getItemSKU(), false);
                    }
                    bagelOfferCount += 6;
                    sixOfferCount++;
                }
                if (bagelOfferCount>0){
                    float totalDiscountPrice = sixOfferCount*2.49f + twelveOfferCount*3.99f;
                    float priceWithoutDiscount = bagelOfferCount*bagel.getItemPrice();
                    float saved = priceWithoutDiscount-totalDiscountPrice;
                    String fullName = bagel.getItemVariant() + " " + bagel.getItemName();
                    receipt.addReceiptLine(fullName, bagelOfferCount, totalDiscountPrice);
                    receipt.addReceiptLine("", 0, saved);
                    totalDiscount += saved;
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
        int coffeeBagelOffer = 0;

        float coffeePrice = 0;
        float bagelPrice = 0;
        while (bagelCount!=0 && coffeeCount!=0){
            for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
                Item bagel = getMenuItem(entry.getKey());

                if (bagel.getItemName().equals("Bagel") && entry.getValue()!= 0){
                    bagelPrice = bagel.getItemPrice();
                    basket.removeItem(bagel.getItemSKU(), false);
                    break;
                }
            }

            for (HashMap.Entry<String, Integer> entry2 : basket.getBasketItems().entrySet()){
                Item coffee = getMenuItem(entry2.getKey());

                if (coffee.getItemName().equals("Coffee") && entry2.getValue()!= 0){
                    coffeePrice = coffee.getItemPrice();
                    discountedSum += 1.25f;
                    basket.removeItem(coffee.getItemSKU(), false);
                    coffeeBagelOffer++;
                    break;
                }
            }
            bagelCount--;
            coffeeCount--;
        }

        if (coffeeBagelOffer>0){
            String offerName = "Coffee & Bagel";
            float originalSum = coffeePrice+bagelPrice;
            float saved = originalSum - 1.25f;
            receipt.addReceiptLine(offerName, coffeeBagelOffer, 1.25f*coffeeBagelOffer);
            receipt.addReceiptLine("", 0, saved);
            totalDiscount+=saved;
        }
    }

    public void getRemainingSum(){
        for (HashMap.Entry<String, Integer> entry : basket.getBasketItems().entrySet()){
            if (entry.getValue() != 0){
                Item item = getMenuItem(entry.getKey());
                int quantity = entry.getValue();
                float price = item.getItemPrice();

                discountedSum += quantity*price;
                String fullName = item.getItemVariant() + " " + item.getItemName();
                receipt.addReceiptLine(fullName, quantity, quantity*price);

                for (int i = 0; i < quantity; i++){
                    basket.removeItem(entry.getKey(), false);
                }
            }
        }
    }
}
