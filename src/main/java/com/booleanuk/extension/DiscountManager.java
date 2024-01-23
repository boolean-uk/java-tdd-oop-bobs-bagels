package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Coffee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static com.booleanuk.core.util.Constants.*;

public class DiscountManager {
    public static double calculateBasketBagelDiscounts(Basket basket) {
        ArrayList<Item> sortedBasket = basket.getBasket();
        LinkedHashMap<String, Integer> bagelItemCount = new LinkedHashMap<>();
        HashMap<String, Double> bagelSkuPrice = new HashMap<>();
        int countBlackCoffee = 0;
        double totalDiscount = 0.0;

        // Make sure combo discount is applied to the cheapest bagel in basket by sorting the list by price
        // To make the discount apply to the most expensive leftover bagel reverse the list
        sortedBasket.sort(Comparator.comparing(Item::getPrice));
        // Get item count by type (sku) and not by item (with filling)
        for (Item item : sortedBasket) {
            if (item instanceof Bagel) {
                if (!bagelItemCount.containsKey(item.getSKU())) {
                    bagelItemCount.put(item.getSKU(), 1);
                    bagelSkuPrice.put(item.getSKU(), item.getPrice());
                } else {
                    bagelItemCount.put(item.getSKU(), bagelItemCount.get(item.getSKU())+1);
                }
            }
            if (item instanceof Coffee && item.getSKU().equalsIgnoreCase(COFFEE_BLACK_SKU)) {
                countBlackCoffee++;
            }
        }

        // Add potential discounts for each item
        for (String bagelSku : bagelItemCount.keySet()) {
            int quantity = bagelItemCount.get(bagelSku);
            double price = bagelSkuPrice.get(bagelSku);

            // Bulk discount
            totalDiscount += calculateItemBulkDiscount(bagelSku, quantity, price);

            // Coffee discount if there are any black coffees and single bagels
            while (quantity % 6 > 0 && countBlackCoffee > 0) {
                totalDiscount += (price + COFFEE_BLACK_PRICE) - BAGEL_COFFEE;
                countBlackCoffee--;
                quantity--;
            }
        }

        return totalDiscount;
    }

    private static double calculateItemBulkDiscount(String sku, int quantity, double price) {
        double discount = 0.0;

        // Get the bulk discount for 12*X bagels of the type
        if (quantity > 11) {
            int setsOf12 = quantity / 12;
            double oldPrice = price * 12;
            discount = (oldPrice * setsOf12) - (BAGELS_BULK_12 * setsOf12);
        }

        // Get the remainder (if there are enough)
        if (quantity % 12 > 5) {
            // Don't give 6-bulk discount for plain bagels
            // This potential "discount" would be more expensive than normal price
            if (!sku.equalsIgnoreCase(BAGEL_PLAIN_SKU)) {
                discount += (price * 6) - BAGELS_BULK_6;
            }
        }

        return discount;
    }
}
