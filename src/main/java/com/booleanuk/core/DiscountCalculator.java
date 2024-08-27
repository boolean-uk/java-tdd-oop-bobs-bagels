package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
   private Inventory inventory;


    public DiscountCalculator(Inventory inventory) {
        this.inventory = inventory;
    }
       /* Always favour the bulk deals over the coffee and a bagel. One deal at a time/
                NEED TO FIGURE OUT HOW TO WORK OUT 12 * A MIXTURE OF 0.39 AND 0.49.
                DISCOUNT APPLICATION HIERARCHY
        1.  if  bagel price is 0.49 then *12 = 3.99 instead of 5.88. per bagel is 0.3325 total saving = 0.1575 * 12 === 1.89
        2.  if  bagel price is 0.39 then *12 = 3.99 instead of 4.68. per bagel is 0.3325 total saving = 0.0575 * 12 === 0.69
        3.  if bagel price is 0.49 then *6 = 2.49 instead of 2.93. per bagel is 0.415 instead of 0.49. total saving = 0.075 * 6 = 0.45
        4.  if coffee & bagel then price for both is 1.25 which means the bagel is 0.26 total saving = 0.49 - 0.26  === 0.23 || 0.39 - 0.26  === 0.13
                */

    public  Map<String, Double>  calculateDiscountAmounts1(Map<Integer, BasketItem> basketItems) {
        double discount12BagelsAmount = 0.0;
        double discount6BagelsAmount = 0.0;
        double discountCoffeeBagelAmount = 0.0;
        int totalBagels = 0;
        int bagels39 = 0;
        int bagels49 = 0;
        int blackCoffeeNum = 0;

        //Count number of each relevant item
        for (BasketItem value : basketItems.values()) {
            String valueSku = value.getItem().getSku();
            InventoryItem item = inventory.getInventoryItemDetails(valueSku);
            if (item.getName().equals("Bagel")) {
                if (!item.getVariant().equals("Plain")) {
                    bagels49 += 1;
                    totalBagels += 1;
                } else {
                    bagels39 += 1;
                    totalBagels += 1;
                }
            } else if (item.getName().equals("Coffee") && item.getVariant().equals("Black")) {
                blackCoffeeNum += 1;
            }
        }

        //Apply 12 bagel discount to the 0.49 bagels. DISCOUNT APPLICATION 1.
        int remainder49Bagels =  bagels49 % 12;
       // System.out.println("49Remainder: "+ remainder49Bagels);
        double saving12x049 = 1.89; // Amount saved if you get the 12 bagels deal with all 0.49 priced bagels
        discount12BagelsAmount += ((bagels49 / 12) * 1.89);
        bagels49 = remainder49Bagels;

        //Apply 12 bagel discount to the remaining 0.49 bagels and 0.39 bagels if there are enough. DISCOUNT APPLICATION 2.
        int remainder39Bagels = 0;
        double saving49Amount = 0.1575; //The amount saved per 0.49 bagel on the 12 bagel deal
        double saving39Amount = 0.0575; //The amount saved per 0.39 bagel on the 12 bagel deal

        if (bagels39 + bagels49 >= 12 ) {
            remainder39Bagels = (bagels39 + remainder49Bagels) % 12;
            //System.out.println("39Remainder: "+ remainder39Bagels);
            discount12BagelsAmount += remainder49Bagels * saving49Amount;
            discount12BagelsAmount += (bagels39 - remainder39Bagels) * saving39Amount;
            bagels39 = remainder39Bagels;
            bagels49 = 0;
        }
        //Apply coffee &  bagel discount to the remaining 0.49 & 0.39 bagels. DISCOUNT APPLICATION 3.
        double coffeeSaving49Amount = 0.23; //The amount saved per 0.49 bagel on the coffee & bagel deal
        double coffeeSaving39Amount = 0.13; //The amount saved per 0.39 bagel on the coffee & bagel deal
        int loop1 = Math.min(blackCoffeeNum, bagels49);
        for (int i = 1; i <= loop1; i++) {
            discountCoffeeBagelAmount += coffeeSaving49Amount;
            bagels49 -= 1;
        }
        int loop2 = Math.min(blackCoffeeNum, bagels39);
        for (int i = 1; i <= loop2; i++) {
            discountCoffeeBagelAmount += coffeeSaving39Amount;
            bagels39 -= 1;
        }
        //Apply 6 bagel discount to the 0.49 bagels WE DONT APPLY TO 0.39 BAGELS BECAUSE IT WOULD ADD TO THE COST. DISCOUNT APPLICATION 4.
        if(bagels49 >= 6 ){
            remainder49Bagels = bagels49 % 6;
            double saving6x049 = 0.45;
            discount6BagelsAmount += (bagels49 / 6) * saving6x049;
            bagels49 = remainder49Bagels;
        }
        Map<String, Double> discountMap = new HashMap<>();
        discountMap.put("discount12BagelsAmount", discount12BagelsAmount);
        discountMap.put("discount6BagelsAmount", discount6BagelsAmount);
        discountMap.put("discountCoffeeBagelAmount", discountCoffeeBagelAmount);
        discountMap.put("discountTotal", discount12BagelsAmount+discount6BagelsAmount+discountCoffeeBagelAmount);

        return discountMap;
    }


    public Map<String, Double> calculateDiscountAmounts2(Map<Integer, BasketItem> basketItems) {
        double discount12BagelsAmount = 0.0;
        double discount6BagelsAmount = 0.0;
        double discountCoffeeBagelAmount = 0.0;
        int totalBagels = 0;
        int bagels39 = 0;
        int bagels49 = 0;
        int blackCoffeeNum = 0;

        //Count number of each relevant item
        for (BasketItem value : basketItems.values()) {
            String valueSku = value.getItem().getSku();
            InventoryItem item = inventory.getInventoryItemDetails(valueSku);
            if (item.getName().equals("Bagel")) {
                if (!item.getVariant().equals("Plain")) {
                    bagels49 += 1;
                    totalBagels += 1;
                } else {
                    bagels39 += 1;
                    totalBagels += 1;
                }
            } else if (item.getName().equals("Coffee") && item.getVariant().equals("Black")) {
                blackCoffeeNum += 1;
            }
        }

        //Apply coffee &  bagel discount to the remaining 0.49 & 0.39 bagels. DISCOUNT APPLICATION 1.
        double coffeeSaving49Amount = 0.23; //The amount saved per 0.49 bagel on the coffee & bagel deal
        double coffeeSaving39Amount = 0.13; //The amount saved per 0.39 bagel on the coffee & bagel deal
        int loop1 = Math.min(blackCoffeeNum, bagels49);
        for (int i = 1; i <= loop1; i++) {
            discountCoffeeBagelAmount += coffeeSaving49Amount;
            bagels49 -= 1;
        }
        int loop2 = Math.min(blackCoffeeNum, bagels39);
        for (int i = 1; i <= loop2; i++) {
            discountCoffeeBagelAmount += coffeeSaving39Amount;
            bagels39 -= 1;
        }
        int remainder49Bagels = 0;
        //Apply 12 bagel discount to the 0.49 bagels. DISCOUNT APPLICATION 2.

        if (bagels49 >= 12) {

            System.out.println(bagels49 % 12);
            remainder49Bagels =  bagels49 % 12;
            //System.out.println("49Remainder: "+ remainder49Bagels);
            double saving12x049 = 1.89; // Amount saved if you get the 12 bagels deal with all 0.49 priced bagels
           discount12BagelsAmount += ((bagels49 / 12) * 1.89);
            bagels49 = remainder49Bagels;
        }
        //Apply 12 bagel discount to the remaining 0.49 bagels and 0.39 bagels if there are enough. DISCOUNT APPLICATION 3.
        int remainder39Bagels = 0;
        double saving49Amount = 0.1575; //The amount saved per 0.49 bagel on the 12 bagel deal
        double saving39Amount = 0.0575; //The amount saved per 0.39 bagel on the 12 bagel deal

        if (bagels39 + bagels49 >= 12 ) {
            remainder39Bagels = (bagels39 + bagels49) % 12;
            //System.out.println("39Remainder: "+ remainder39Bagels);
            discount12BagelsAmount += bagels49 * saving49Amount;
            discount12BagelsAmount += (bagels39 - remainder39Bagels) * saving39Amount;
            bagels39 = remainder39Bagels;
            bagels49 = 0;
        }

        //Apply 6 bagel discount to the 0.49 bagels WE DONT APPLY TO 0.39 BAGELS BECAUSE IT WOULD ADD TO THE COST. DISCOUNT APPLICATION 4.
        if(bagels49 >= 6 ){
            remainder49Bagels = bagels49 % 6;
            double saving6x049 = 0.45;
            discount6BagelsAmount += (bagels49 / 6) * saving6x049;
            bagels49 = remainder49Bagels;
        }
        Map<String, Double> discountMap = new HashMap<>();
        discountMap.put("discount12BagelsAmount", discount12BagelsAmount);
        discountMap.put("discount6BagelsAmount", discount6BagelsAmount);
        discountMap.put("discountCoffeeBagelAmount", discountCoffeeBagelAmount);
        discountMap.put("discountTotal", discount12BagelsAmount+discount6BagelsAmount+discountCoffeeBagelAmount);

        return discountMap;
    }


}

