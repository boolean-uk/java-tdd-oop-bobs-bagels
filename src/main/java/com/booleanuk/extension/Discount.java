package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Store;

import java.util.List;
import java.util.Objects;

public class Discount {
    private final Basket basket;
    private final Store store;

    public Discount(Basket basket, Store store) {
        this.basket = basket;
        this.store = store;
    }

    public double discountTotalCost() {
        int plainBagelCounter = 0;
        int bagelCounter = 0;
        int coffeeCounter = 0;
        List<Item> items = basket.getItems();
        double discountedPrice = 0.0;

        for (Item item : items) {
            if (Objects.equals(item.getSku(), "BGLP")) {
                plainBagelCounter++;
            }
            if (item.getSku().contains("BGLO") || item.getSku().contains("BGLE") || item.getSku().contains("BGLS")) {
                bagelCounter++;
            }
            if (item.getSku().contains("COFB")) {
                coffeeCounter++;
            }
        }

        if (plainBagelCounter >= 12) {
            discountedPrice += 3.99;

            int remainingPlainBagels = plainBagelCounter - 12;

            if (remainingPlainBagels >= 1) {
                int bagelsToDiscount = Math.min(remainingPlainBagels, coffeeCounter);
                discountedPrice += 1.25 * bagelsToDiscount;
                int remainingPlainBagelsWithoutCoffee = remainingPlainBagels - bagelsToDiscount;
                discountedPrice += remainingPlainBagelsWithoutCoffee * 0.39;

                coffeeCounter -= bagelsToDiscount;
            }
        } else {
            int bagelsToDiscount = Math.min(plainBagelCounter, coffeeCounter);
            discountedPrice += 1.25 * bagelsToDiscount;
            int remainingPlainBagelsWithoutCoffee = plainBagelCounter - bagelsToDiscount;
            discountedPrice += remainingPlainBagelsWithoutCoffee * 0.39;

            coffeeCounter -= bagelsToDiscount;
        }

        if (bagelCounter >= 12) {
            discountedPrice += 3.99;

            int remainingBagels = bagelCounter - 12;
            if (remainingBagels >= 1) {
                int bagelsToDiscount = Math.min(remainingBagels, coffeeCounter);
                discountedPrice += 1.25 * bagelsToDiscount;
                int remainingBagelsWithoutCoffee = remainingBagels - bagelsToDiscount;
                discountedPrice += remainingBagelsWithoutCoffee * 0.49;
            }
        } else if (bagelCounter >= 6) {
            discountedPrice += 2.49;

            int remainingBagels = bagelCounter - 6;
            if (remainingBagels >= 1) {
                int bagelsToDiscount = Math.min(remainingBagels, coffeeCounter);
                discountedPrice += 1.25 * bagelsToDiscount;
                int remainingBagelsWithoutCoffee = remainingBagels - bagelsToDiscount;
                discountedPrice += remainingBagelsWithoutCoffee * 0.49;

                coffeeCounter -= bagelsToDiscount;
            }
        } else {
                int bagelsToDiscount = Math.min(bagelCounter, coffeeCounter);
                discountedPrice += 1.25 * bagelsToDiscount;
                int remainingBagelsWithoutCoffee = bagelCounter - bagelsToDiscount;
                discountedPrice += remainingBagelsWithoutCoffee * 0.49;

                coffeeCounter -= bagelsToDiscount;
        }

        discountedPrice += coffeeCounter * 0.99;

        return discountedPrice;
    }
}
