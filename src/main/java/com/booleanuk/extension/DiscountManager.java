package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Item;
import com.booleanuk.core.models.Store;
import com.booleanuk.core.models.item.Bagel;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class DiscountManager {
    private static final String BAGEL_PLAIN = "BGLP";
    private static final double BAGELS_6 = 2.49;
    private static final double BAGELS_12 = 3.99;

    public static double calculateBasketBagelDiscounts(Basket basket) throws FileNotFoundException, URISyntaxException {
        double totalDiscount = 0.0;
        HashMap<String, Integer> bagelItemCount = new HashMap<>();

        for (Item item : basket.getBasket()) {
            if (item instanceof Bagel) {
                if (!bagelItemCount.containsKey(item.getSKU())) {
                    bagelItemCount.put(item.getSKU(), 1);
                } else {
                    bagelItemCount.put(item.getSKU(), bagelItemCount.get(item.getSKU())+1);
                }
            }
        }

        for (String bagelSku : bagelItemCount.keySet()) {
            int quantity = bagelItemCount.get(bagelSku);
            totalDiscount += calculateItemBulkDiscount(bagelSku, quantity);
        }

        return totalDiscount;
    }

    private static double calculateItemBulkDiscount(String sku, int quantity) throws FileNotFoundException, URISyntaxException {
        double discount = 0.0;
        Store store = new Store("Discount");

        int setsOf12 = quantity / 12;
        int setsOf6 = quantity / 6;

        if (quantity > 11) {
            double oldPrice = store.getItemBySKU(sku).getPrice() * 12;
            discount = (oldPrice * setsOf12)-(BAGELS_12 * setsOf12);
        }
        if (quantity % 12 > 5) {
            // Don't give 6-bulk discount for plain bagels
            // This potential "discount" would be more expensive than normal price
            if (!sku.equalsIgnoreCase(BAGEL_PLAIN)) {
                double oldPrice = store.getItemBySKU(sku).getPrice() * 6;
                discount = (oldPrice * setsOf6)-(BAGELS_6 * setsOf6);
            }
        }

        return discount;
    }
}
