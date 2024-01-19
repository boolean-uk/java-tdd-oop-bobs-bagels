package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Item;
import com.booleanuk.core.util.FileHandler;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class DiscountManager {
    public static double getBasketDiscount(Basket basket) throws FileNotFoundException, URISyntaxException {
        ArrayList<String[]> bulkDiscounts = FileHandler.fetchBulkDiscountsFromFile();
        double totalDiscount = 0.0;
        for (String[] bulkDiscount : bulkDiscounts) {
            totalDiscount += calculateMultiPriceDiscount(basket, bulkDiscount[0], Integer.parseInt(bulkDiscount[1]), Double.parseDouble(bulkDiscount[2])-Double.parseDouble(bulkDiscount[3]));
        }
        return totalDiscount;
    }

    private static double calculateMultiPriceDiscount(Basket basket, String sku, int quantityThreshold, double discount) {
        double totalDiscount = 0.0;
        int itemCount = 0;

        for (Item item : basket.getBasket()) {
            if (item.getSKU().equalsIgnoreCase(sku)) {
                itemCount++;
            }
        }
        if (itemCount >= quantityThreshold) {
            totalDiscount += discount;
        }
        return totalDiscount;
    }
}
