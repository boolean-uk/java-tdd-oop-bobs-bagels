package com.booleanuk.core.calculators;

import com.booleanuk.core.basket.BasketItem;
import com.booleanuk.core.enums.ProductName;
import com.booleanuk.core.inventory.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PriceCalculator {

    // TODO: How to write a class comment?
    // This class should calculate price.
    // The aim is to fix so InventoryItem and basket have a common approach on rounding numbers

    // Use double or float, float saves memory, double is easier to work with

    public double round(float total, int numOfDecimals) {

        // TODO: Should I use float or double?
        // change here or change on objects
        // Now the object has float on price, and totalCost has double

        // Resource: https://www.baeldung.com/java-round-decimal-number

        double scale = Math.pow(10, numOfDecimals);
        double rounded = Math.round(total * scale) / scale;

        return rounded;
    }

    public double calculateDiscount(Inventory inventory, Map<Integer, BasketItem> basketItems, ArrayList<SpecialOffer> specialOffers) {

        double discount = 0;

        // Convert special offers to Hashmap
        HashMap<String, SpecialOffer> specialOfferMap = new HashMap<>();
        for (SpecialOffer s : specialOffers) {
            specialOfferMap.put(s.getSKU(), s);
        }

        // Count occurrences of discount items
        HashMap<String, Integer> discountItems = new HashMap<>();
        for (BasketItem item : basketItems.values()) {

            String key_sku = item.getSKU();

            // Store the SKU as key, and count how many times it occurs for SKU's that have special offers
            SpecialOffer offer = specialOfferMap.get(key_sku);
            if (offer != null) {

                if (discountItems.get(key_sku) == null) {
                    discountItems.put(key_sku, 1);
                } else {
                    int numOfItems = discountItems.get(key_sku);
                    discountItems.put(key_sku, numOfItems + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> item : discountItems.entrySet()) {

            SpecialOffer offer = specialOfferMap.get(item.getKey());

            // The special price for the offer, and number of items in this basket that has that offer
            double specialPrice = offer.getOfferPrice();
            int numOfBasketItems = item.getValue();


            //
            // Multi-Price Offer
            //
            if (offer instanceof SpecialOfferMultiPrice) {

                SpecialOfferMultiPrice multiPriceOffer = (SpecialOfferMultiPrice) offer;

                // Get number of items required to get the offer
                int minimumNumOfItems = multiPriceOffer.getNumOfItems();

                if (numOfBasketItems < minimumNumOfItems) {
                    // Too few items, no offer
                    break;
                }

                // Count how many discounts
                int numOfDiscounts = Math.floorDiv(numOfBasketItems, minimumNumOfItems);

                // Get ordinary price for the item, from the inventory
                double itemPrice = inventory.getItem(item.getKey()).getPrice();
                double ordinaryPrice = minimumNumOfItems * itemPrice;
                double diffPrice = ordinaryPrice - specialPrice;

                // Calculate total discount for this offer
                // add to discount
                discount += numOfDiscounts * diffPrice;


            //
            // Combination Offer
            //
            } else if (offer instanceof SpecialOfferCombination) {

                // TODO: I will assume that the offer Coffee + Bagel for 1.25, includes all coffee types and all bagel types.

                SpecialOfferCombination combinationOffer = (SpecialOfferCombination) offer;

                // Get combination of items required to get the offer
                ArrayList<ProductName> offerItems = combinationOffer.getOfferItems();

                // Store the number of occurrences for each offerItem (ProductName type)
                HashMap<ProductName, ArrayList<String>> offerItemOccurrences = new HashMap<>();

                for (ProductName productName : offerItems) {
                    for (BasketItem b : basketItems.values()) {

                        String b_SKU = b.getSKU();
                        InventoryItem inventoryItem = inventory.getItem(b_SKU);

                        if (productName == inventoryItem.getName()){

                        }
                    }
                }


            }
        }

        // TODO: instead of casting to float, change float to double in rest of the program

        return this.round((float) discount, 2);
    }
}
