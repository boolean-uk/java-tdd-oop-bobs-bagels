package com.booleanuk.extension;

import com.booleanuk.core.ItemList;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Receipt {
    HashMap<String, Float> discountBasket;
    HashMap<String, Integer> basket;
    private ItemList itemList = new ItemList();
    private DiscountManager discountManager;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Receipt(HashMap<String, Integer> basket, HashMap<String, Float> discountBasket) {
        this.discountBasket = discountBasket;
        this.basket = basket;
        this.discountManager = new DiscountManager();

    }

    public float calculateBasket() {
        checkBagelDiscountInBasket();
        float totalPrice = 0;
        for (Map.Entry<String, Integer> kvp: this.basket.entrySet()) {
            totalPrice += (itemList.getPriceFromList(kvp.getKey()) * kvp.getValue());
        }
        return  totalPrice + discountManager.totalValueOfDiscount();
    }

    public float calculateOriginalBasket() {
        float originalPrice = 0;
        for (Map.Entry<String, Integer> kvp: this.basket.entrySet()) {
            originalPrice += (itemList.getPriceFromList(kvp.getKey()) * kvp.getValue());
        }
        return  originalPrice;
    }


    private void checkBagelDiscountInBasket() {
        for(Map.Entry <String, Integer> bagel: this.basket.entrySet()) {
            //Checks for bagel discount
            while (bagel.getValue()  - 6 >= 0 && itemList.getTypeFromList(bagel.getKey()).equals("Bagel")) {
                //Loops if the bagels are bigger than 6 as 6 is the smallest discount you can get.
                this.basket.replace(bagel.getKey(), bagel.getValue() - discountManager.checkBagelDiscount(this.basket));
            }

            for (Map.Entry<String, Integer> coffee: this.basket.entrySet()) {
                if(bagel.getValue() > 0 && itemList.getTypeFromList(bagel.getKey()).equals("Bagel") && (coffee.getValue() > 0 && itemList.getTypeFromList(coffee.getKey()).equals("Coffee"))) {

                    //For every bagel that is more than 1 and less than 6 check if there is a coffee in the list still and add it to discountManager. This is O(n^n)...
                    //Checks if there are 1 more of bagel, then add bagelAndCoffeeDiscount the getValue of coffee
                    if(bagel.getValue() - coffee.getValue() >= 0) {
                        discountManager.bagelAndCoffeeDiscount(bagel.getKey(), coffee.getKey(), coffee.getValue());
                        this.basket.replace(bagel.getKey(), bagel.getValue() - coffee.getValue());
                        this.basket.replace(coffee.getKey(), 0);
                    }else if (coffee.getValue() - bagel.getValue() >= 0) {
                        discountManager.bagelAndCoffeeDiscount(bagel.getKey(), coffee.getKey(), bagel.getValue());
                        this.basket.replace(coffee.getKey(), coffee.getValue() - bagel.getValue());
                        this.basket.replace(bagel.getKey(), 0);
                    }
                }
            }
        }
        discountBasket = discountManager.getDiscountBasket();
    }


    public float printOutReceipt() {
        float originalPrice = calculateOriginalBasket();
        float totalPrice = calculateBasket();

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:SS");

        System.out.println(" \t ~~~ Bob's Bagels ~~~ \n");
        System.out.println(" \t" + today.format(formatter) + "\n");
        System.out.println("----------------------------");
        for (Map.Entry<String, Integer> kvp : basket.entrySet()) {
            if(kvp.getValue() > 0) {
                System.out.println(" " + itemList.getNameFromList(kvp.getKey()) + " \t\t\t  " + kvp.getValue() + "x $" + itemList.getPriceFromList(kvp.getKey()));
            }

        }

        for (Map.Entry<String, Integer> kvp : discountManager.getNumberOfItems().entrySet()) {
            if(kvp.getKey().length() > 4) {
                String[] bagelCoffee = kvp.getKey().split(":");
                String bagelSKU = bagelCoffee[0];
                String coffeeSKU = bagelCoffee[1];
                System.out.println(kvp);
                System.out.println(" " + itemList.getNameFromList(bagelSKU) +" " + itemList.getTypeFromList(bagelSKU)+ " + \n " + itemList.getNameFromList(coffeeSKU) + " " + itemList.getTypeFromList(coffeeSKU) + "\t  " + kvp.getValue() + "x $" + discountManager.getDiscountPrice(kvp.getKey()));
                float discountedBagelPrice = itemList.getPriceFromList(bagelSKU) * kvp.getValue() - discountManager.getDiscountPrice(kvp.getKey());
                float discountedCoffeePrice = itemList.getPriceFromList(coffeeSKU) * kvp.getValue() - discountManager.getDiscountPrice(kvp.getKey());
                System.out.println("\t\t\t\t   (-$"+ df.format(discountedBagelPrice + discountedCoffeePrice) +  ")" );

            }else {
                System.out.println(" " + itemList.getNameFromList(kvp.getKey()) + " \t\t\t  " + kvp.getValue() + " $" + discountManager.getDiscountPrice(kvp.getKey()));
                float discountedPrice = itemList.getPriceFromList(kvp.getKey()) * kvp.getValue() - discountManager.getDiscountPrice(kvp.getKey());
                System.out.println("\t\t\t\t   (-$"+ df.format(discountedPrice) +  ")" );
            }
        }

        System.out.println("----------------------------");

        System.out.println(" Total: \t\t\t $" + df.format(totalPrice));
        System.out.println(" Total money saved:\t $" + df.format(originalPrice - totalPrice) );

        return totalPrice;

    }
}
