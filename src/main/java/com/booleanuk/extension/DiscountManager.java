package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Item;
import com.booleanuk.core.util.FileHandler;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class DiscountManager {
    Basket basket;
    ArrayList<String[]> bulkDiscounts;

    public DiscountManager(Basket basket) throws FileNotFoundException, URISyntaxException {
        this.basket = basket;
        this.bulkDiscounts = FileHandler.fetchBulkDiscountsFromFile();
    }

    public double getBasketDiscount() {
        double totalDiscount = 0.0;
        for (String[] bulkDiscount : bulkDiscounts) {
            totalDiscount += calculateMultiPriceDiscount(bulkDiscount[0], Integer.parseInt(bulkDiscount[1]), Double.parseDouble(bulkDiscount[2])-Double.parseDouble(bulkDiscount[3]));
        }
        return totalDiscount;
    }

    private double calculateMultiPriceDiscount(String sku, int quantityThreshold, double discount) {
        double totalDiscount = 0.0;
        Item item = basket.getBasket().stream().filter(i -> i.getSKU().equals(sku)).findFirst().orElse(null);
        if (item != null) {
            int itemCount = basket.getItemCount().getOrDefault(item, 0);
            if (itemCount >= quantityThreshold) {
                totalDiscount += discount;
            }
        }
        return totalDiscount;
    }
}
