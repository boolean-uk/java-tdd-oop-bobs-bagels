package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.items.Bagel;

import java.util.HashMap;

import static com.booleanuk.core.util.Constants.*;

public class DiscountManager {
    public static double calculateBasketBagelDiscounts(Basket basket) {
        double totalDiscount = 0.0;
        HashMap<String, Integer> bagelItemCount = new HashMap<>();
        HashMap<String, Double> bagelSkuPrice = new HashMap<>();

        // Get item count by type (sku) and not by item (with filling)
        for (Item item : basket.getBasket()) {
            if (item instanceof Bagel) {
                if (!bagelItemCount.containsKey(item.getSKU())) {
                    bagelItemCount.put(item.getSKU(), 1);
                    bagelSkuPrice.put(item.getSKU(), item.getPrice());
                } else {
                    bagelItemCount.put(item.getSKU(), bagelItemCount.get(item.getSKU())+1);
                }
            }
        }

        // Add potential discounts for each item
        for (String bagelSku : bagelItemCount.keySet()) {
            int quantity = bagelItemCount.get(bagelSku);
            double price = bagelSkuPrice.get(bagelSku);
            totalDiscount += calculateItemBulkDiscount(bagelSku, quantity, price);
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
            if (!sku.equalsIgnoreCase(BAGEL_PLAIN)) {
                discount += (price * 6) - BAGELS_BULK_6;
            }
        }

        return discount;
    }
}
