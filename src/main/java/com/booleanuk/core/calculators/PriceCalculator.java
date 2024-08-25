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

    private DiscountObjectMultiPrice discountObjectMultiPrice;

    public double round(float total, int numOfDecimals) {

        // TODO: Should I use float or double?
        // change here or change on objects
        // Now the object has float on price, and totalCost has double

        // Resource: https://www.baeldung.com/java-round-decimal-number

        double scale = Math.pow(10, numOfDecimals);
        double rounded = Math.round(total * scale) / scale;

        return rounded;
    }

    public ArrayList<DiscountObjectMultiPrice> calculateSpecialOfferMultiPrice(Inventory inventory, Map<Integer, BasketItem> basketItems, ArrayList<SpecialOfferMultiPrice> specialOffers) {

        ArrayList<DiscountObjectMultiPrice> discountList = new ArrayList<>();

        // Store list of SKU with number of occurrences.
        HashMap<String, Integer> skuOccurrences = new HashMap<>();
        for (BasketItem item : basketItems.values()) {

            String sku = item.getSKU();
            if (skuOccurrences.get(sku) == null) {
                skuOccurrences.put(sku, 1);
            } else {
                int numOfItems = skuOccurrences.get(sku);
                skuOccurrences.put(sku, numOfItems + 1);
            }
        }

        // Store Special Offers with the corresponding SKU as key in HashMap
        HashMap<String, SpecialOfferMultiPrice> skuSpecialOfferPairs = new HashMap<>();
        for (SpecialOfferMultiPrice offer : specialOffers) {
            skuSpecialOfferPairs.put(offer.getSKU(), offer);
        }

        // Calculate discounts
        for (Map.Entry<String, Integer> skuEntry : skuOccurrences.entrySet()) {

            String sku = skuEntry.getKey();
            int numOfBasketItems = skuEntry.getValue();
            int minimumNumOfItems = skuSpecialOfferPairs.get(sku).getNumOfItems();      // Minimun number of items required to get an offer

            // Count how many discounts
            int numOfDiscounts = Math.floorDiv(numOfBasketItems, minimumNumOfItems);
            int numOfDiscountItems = (numOfDiscounts * minimumNumOfItems);
            int numOfOrdinaryItems = numOfBasketItems - numOfDiscountItems;

            // Get ordinary price for the item, from the inventory
            double itemPrice = inventory.getItem(sku).getPrice();
            double ordinaryPrice = minimumNumOfItems * itemPrice;
            double specialOfferPrice = skuSpecialOfferPairs.get(sku).getOfferPrice();
            double diffPrice = ordinaryPrice - specialOfferPrice;

            // Calculate total discount for this offer
            // add to discount
            double discountSum = numOfDiscounts * diffPrice;
            discountSum = this.round((float) discountSum, 2); // TODO: Change fromm float to double
            discountList.add(
                    new DiscountObjectMultiPrice(
                        sku,
                        numOfDiscounts,
                        numOfDiscountItems,
                        discountSum,
                        numOfOrdinaryItems
                ));
        }

        return discountList;
    }

    public double calculateDiscount(Inventory inventory, Map<Integer, BasketItem> basketItems, ArrayList<SpecialOffer> specialOffers) {

        double discount = 0;
        ArrayList<DiscountObjectMultiPrice> discountObjectMultiPriceList = new ArrayList<>();

        // Convert special offers to Hashmap
        HashMap<String, SpecialOffer> specialOfferMap = new HashMap<>();
//        for (SpecialOffer s : specialOffers) {
//            specialOfferMap.put(s.getSKU(), s);
//        }

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

                            if (offerItemOccurrences.get(productName) == null) {
                                ArrayList<String> list = new ArrayList<>();
                                list.add(b_SKU);

                                offerItemOccurrences.put(productName, list);
                            } else {
                                ArrayList<String> list = offerItemOccurrences.get(productName);
                                list.add(b_SKU);

                                offerItemOccurrences.put(productName, list);
                            }
                        }
                    }
                }

                // Find the list of least items, and save the size
                int minItemSize = 0;
                boolean isValidSpecialOffer = true;
                for (ArrayList<String> skuList : offerItemOccurrences.values()) {

                    // If one or more list of SKU's doesn't contain anything, no special offers available
                    if (skuList.size() == 0) {
                        isValidSpecialOffer = false;
                        break;
                    } else if (skuList.size() < minItemSize) {
                        minItemSize = skuList.size();
                    }
                }


                // Store the price for each offerItem into categories split by ProductName type
                HashMap<ProductName, ArrayList<Double>> offerItemPrices = new HashMap<>();

//                if (isValidSpecialOffer) {
//
//                    // Sort into ProductName, and store Price
//                    for (ProductName productName : offerItems) {
//
//                        for (ArrayList<String> skuList : offerItemOccurrences.values()) {
//
//                            for (String sku : skuList) {
//                                double price = inventory.getItem(sku).getPrice();
//
//                                if (offerItemPrices.get(sku) == null) {
//                                    ArrayList<Double> list = new ArrayList<>();
//                                    list.add(price);
//
//                                    offerItemPrices.put(sku, list);
//                                } else {
//                                    ArrayList<Double> list = offerItemPrices.get(sku);
//                                    list.add(price);
//
//                                    offerItemPrices.put(sku, list);
//                                }
//                            }
//                        }
//                    }
//
//                    // Sort with the cheapest first
//
//                    // Loop minItemSize times
//
//                    // get ordinary price
//
//                    // Calculate difference
//
//                    //return discount
//                }



            }
        }

        // TODO: instead of casting to float, change float to double in rest of the program

        return this.round((float) discount, 2);
    }
}
