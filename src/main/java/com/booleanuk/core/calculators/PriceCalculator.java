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

    /**
     * Calculate Multi-Price discounts and returns an ArrayList with
     * all the items from the basket together with eventual discounts.
     * @param inventory
     * @param basketItems
     * @param specialOffers
     * @return
     */
    public ArrayList<DiscountObjectMultiPrice> calculateSpecialOfferMultiPrice(
            Inventory inventory, Map<Integer,
            BasketItem> basketItems,
            ArrayList<SpecialOfferMultiPrice> specialOffers)
    {
        ArrayList<DiscountObjectMultiPrice> discountList = new ArrayList<>();

        // Store list of SKU with number of occurrences (basket items).
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
        int numOfDiscounts;
        int numOfDiscountItems;
        int numOfOrdinaryItems;
        double priceForDiscountItems;
        double priceForOrdinaryItems;
        double discountSum;
        for (Map.Entry<String, Integer> skuEntry : skuOccurrences.entrySet()) {

            String sku = skuEntry.getKey();

            int numOfBasketItems = skuEntry.getValue();
            numOfOrdinaryItems = numOfBasketItems;      // If there is no discount items, all basket items with this SKU are ordinary items

            // Get standard price for item with this SKU
            double itemPrice = inventory.getItem(sku).getPrice();
            priceForOrdinaryItems = numOfOrdinaryItems * itemPrice;     // If there is no discounts, this is the price for all items.
            priceForOrdinaryItems = this.round((float) priceForOrdinaryItems, 2);

            if (skuSpecialOfferPairs.get(sku) != null) {

                int minimumNumOfItems = skuSpecialOfferPairs.get(sku).getNumOfItems();      // Minimun number of items required to get an offer

                // Count how many discounts
                numOfDiscounts = Math.floorDiv(numOfBasketItems, minimumNumOfItems);
                numOfDiscountItems = (numOfDiscounts * minimumNumOfItems);
                numOfOrdinaryItems = numOfBasketItems - numOfDiscountItems;

                // Calculate the discount price by subtraction ordinary price by special offer price
                double ordinaryPrice = minimumNumOfItems * itemPrice;
                double specialOfferPrice = skuSpecialOfferPairs.get(sku).getOfferPrice();
                double diffPrice = ordinaryPrice - specialOfferPrice;

                // Calculate total discount for this offer
                // add to discount
                discountSum = numOfDiscounts * diffPrice;
                discountSum = this.round((float) discountSum, 2); // TODO: Change fromm float to double

                priceForDiscountItems = numOfDiscounts * specialOfferPrice;
                priceForOrdinaryItems = numOfOrdinaryItems * itemPrice;

                priceForDiscountItems = this.round((float) priceForDiscountItems, 2);
                priceForOrdinaryItems = this.round((float) priceForOrdinaryItems, 2);

                discountList.add(
                        new DiscountObjectMultiPrice(
                                sku,
                                numOfDiscounts,
                                numOfDiscountItems,
                                priceForDiscountItems,
                                discountSum,
                                numOfOrdinaryItems,
                                priceForOrdinaryItems
                        ));

            } else {
                discountList.add(
                        new DiscountObjectMultiPrice(
                                sku,
                                0,
                                0,
                                0.0,
                                0.0,
                                numOfOrdinaryItems,
                                priceForOrdinaryItems
                        ));
            }


        }

        return discountList;
    }

    /**
     * Calculates Combination discounts, and returns an ArrayList of discount objects with:
     * A list of included product names of the items in the combination offer. E.g. 'COFFEE, BAGEL'
     * the total discount price
     * the number of discounts
     * @param inventory
     * @param basketItems
     * @param specialOffers
     * @return
     */
    public ArrayList<DiscountObjectCombination> calculateSpecialOfferCombination(
            Inventory inventory, Map<Integer,
            BasketItem> basketItems,
            ArrayList<SpecialOfferCombination> specialOffers)
    {
        ArrayList<DiscountObjectCombination> discountList = new ArrayList<>();

        // TODO: Could this be simplified?

        // Calculate special offers for each offer.
        // E.g. if there exist more than one offer like 'Coffee + Bagel for 1.25', 'Juice + cookie for 0.5'
        for (SpecialOfferCombination offer : specialOffers) {

            ArrayList<ProductName> offerItems = offer.getOfferItems();

            // Store an copy of an InventoryITem for each basket item, sorted into ProductNames (e.g. COFFEE, BAGEL),
            // The ProductNames represents the combination of items that offer includes, e.g. 'Coffee + Bagel' offer.
            HashMap<ProductName, ArrayList<InventoryItem>> itemsSortedByProductName = new HashMap<>();
            for (ProductName productName : offerItems) {
                for (BasketItem b : basketItems.values()) {

                    InventoryItem inventoryItem = inventory.getItem(b.getSKU());

                    if (productName == inventoryItem.getName()){

                        if (itemsSortedByProductName.get(productName) == null) {
                            ArrayList<InventoryItem> list = new ArrayList<>();
                            list.add(inventoryItem);

                            itemsSortedByProductName.put(productName, list);
                        } else {
                            ArrayList<InventoryItem> list = itemsSortedByProductName.get(productName);
                            list.add(inventoryItem);

                            itemsSortedByProductName.put(productName, list);
                        }
                    }
                }
            }

            // Find the list of least items, and save the size
            // This is to find how many offers the user will get based on the amount of
            // combinations that exists in the basket
            int minItemSize = -1;
            boolean isValidSpecialOffer = true;
            for (ArrayList<InventoryItem> itemList : itemsSortedByProductName.values()) {

                // If one or more list of basket items (inventory objects) doesn't contain anything,
                // no special offers available
                if (itemList.isEmpty()) {
                    isValidSpecialOffer = false;
                    break;

                } else if (minItemSize == -1) {
                    minItemSize = itemList.size();
                } else if (itemList.size() < minItemSize) {
                    minItemSize = itemList.size();
                }
            }

            // Sort lists by price
            // I assume that the offer will be valid on the cheapest products first
            // Therefore I sort the lists by price
            // Resource: https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
            for (ArrayList<InventoryItem> itemList : itemsSortedByProductName.values()) {
                itemList.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
            }

            // Caclucate discount
            if (isValidSpecialOffer) {

                int numOfDiscounts = 0;
                double discount = 0.0;
                double discountRounded = 0;
                // Calculate number of discounts, and amount of discount
                for (int i = 0; i < minItemSize; i++) {

                    // Store the combination of items included in the offer
                    // Starting with the cheapest ones.
                    ArrayList<InventoryItem> combinationItems = new ArrayList<>();
                    for (ArrayList<InventoryItem> itemList : itemsSortedByProductName.values()) {

                        combinationItems.add(itemList.get(i));
                    }

                    double ordinaryPrice = 0;
                    for (InventoryItem item : combinationItems) {
                        ordinaryPrice += item.getPrice();
                    }
                    double specialPrice = offer.getOfferPrice();
                    double diffPrice = ordinaryPrice - specialPrice;

                    // Update
                    numOfDiscounts++;
                    discount += diffPrice;
                    discountRounded = this.round((float) discount, 2);
                }

                discountList.add(new DiscountObjectCombination(offerItems, numOfDiscounts, discountRounded));
            }

        }

        return discountList;
    }
}
