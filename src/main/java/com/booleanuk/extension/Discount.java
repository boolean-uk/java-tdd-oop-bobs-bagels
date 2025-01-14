package com.booleanuk.extension;

import com.booleanuk.core.Basket;

public class Discount {

    public double discountPrice(Basket basket) {
        int bagelCount = 0;
        int coffeeCount = 0;
        for (int i = 0; i < basket.getBasketList().size(); i++) {
            if (basket.getBasketList().get(i).getId().substring(0, 1).equals("B")) {
                bagelCount++;
            } else if (basket.getBasketList().get(i).getId().substring(0, 1).equals("C")) {
                coffeeCount++;
            }
        }

        int remain;
        double totalDiscount = 0;

        remain = bagelCount / 12; // 18 = 1,5;

        if (remain >= 1) {
            totalDiscount += 3.99;
            bagelCount = bagelCount - 12;
        }

        remain = bagelCount / 6;

        if(remain >= 1) {
            totalDiscount += 2.49;
            bagelCount = bagelCount - 6;
        }

        if (bagelCount >= 1 && coffeeCount >= 1) {
            totalDiscount += 1.25;
            bagelCount--;
            coffeeCount--;
        }

        if(bagelCount != 0) {
            for (int i = 0; i < basket.getBasketList().size(); i++) {
                if (basket.getBasketList().get(i).getId().substring(0,1).equals("B")) {
                    for (int j = 0; j < bagelCount; i++) {
                        totalDiscount += basket.getBasketList().get(i).getPrice();
                        bagelCount--;
                    }
                }
            }
        }

        if(coffeeCount != 0) {
            for (int i = 0; i < basket.getBasketList().size(); i++) {
                if (basket.getBasketList().get(i).getId().substring(0,1).equals("C")) {
                    for (int j = 0; j < coffeeCount; i++) {
                        totalDiscount += basket.getBasketList().get(i).getPrice();
                        coffeeCount--;
                    }
                }
            }
        }
        return totalDiscount;
    }
}
