package com.booleanuk.core.basket;

import com.booleanuk.core.calculators.DiscountObjectCombination;
import com.booleanuk.core.calculators.DiscountObjectMultiPrice;
import com.booleanuk.core.calculators.PriceCalculator;
import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.InventoryItem;
import com.booleanuk.core.printgenerator.PrintBasketItems;
import com.booleanuk.core.printgenerator.PrintGenerator;
import com.booleanuk.core.printgenerator.PrintReceipt;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private Inventory inventory;
    private Map<Integer, BasketItem> basketItems;
    private int idCount;
    private int size;
    private int maxCapacity;

    private PriceCalculator priceCalculator;
    private PrintGenerator printGenerator;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basketItems = new LinkedHashMap <>();      // LinkedHashMap because I want the items in the order they were added to the basket
        this.idCount = 1;
        this.size = 0;
        this.maxCapacity = 20;
        this.priceCalculator = new PriceCalculator();   // Should maybe have dependency injection instead.
    }

    // Auto create ID
    private int createId() {

        int itemId = this.idCount;
        this.idCount += 1;
        return itemId;
    }

    // Auto create ID for fillings
    private int createFillingId(String idExtension) {

        // TODO: How to make default variable like in python

        // TODO: Should check if idExtension is valid

        // TODO: Could use int input instead of String

        // Store variable id for previous bagel
        int itemId = this.idCount - 1;

        // Add id extension for filling
        String tmp = itemId + "0" + idExtension;
        return Integer.parseInt(tmp);
    }

    // Get Basket size
    public int getSize() {
        return size;
    }

    // Get max capacity, max amount of products allowed in basket.
    // Fillings doesn't count as an item, and fillings can only be added together with a Bagel.
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    // Change max capacity
    // TODO: Should make sure that newMaxCapacity is not a negative value
    public void changeMaxCapacity(int newMaxCapacity) {
        this.maxCapacity = newMaxCapacity;
    }

    // Get all basket items
    public Map<Integer, BasketItem> getAll() {
        return this.basketItems;
    }

    // Get basket item based on id.
    protected BasketItem getBasketItem(int itemId) {
        BasketItem item = this.basketItems.get(itemId);
        if (item == null) {
            throw new InvalidBasketItemException("Basket item with ID #" + itemId + ", doesn't exist. Can't remove from basket.");
        }
        return item;
    }

    // Inner function for add()
    // Validates input
    protected void addToBasket(int itemId, BasketItem item) {
        // Validate input
        if (this.getSize() == maxCapacity) {
            throw new MaxCapacityException("Basket is full, can't add more items.");
        }

        // TODO: Add exception for when id already exist
        // TODO: Can use 'instanceof' instead of checking class name?

        // Fillings can not be added as an item itself
        // Fillings that belongs to a bagel have id's over 100
        if (item.getClass().getName().equals(Filling.class.getName()) && item.getId() < 100) {
            throw new InvalidBasketItemException("Fillings can't be added alone. Must belong to a bagel.");
        }

        // Set id if no exception has been thrown
        item.setId(itemId);

        this.basketItems.put(item.getId(), item);

        // Update size of basket
        this.size++;
    }

    // Add BasketItem (Coffee Bagel or Filling) to basket
    public void add(BasketItem item) {

        try {

            // TODO: Duplication of id with different variables? Simplify?
            //  Could I use some inheritance/polymorphism?

            // Class names
            String thisItemClass = item.getClass().getName();
            String BagelClass = Bagel.class.getName();

            // Add fillings if it is a Bagel
            if (thisItemClass.equals(BagelClass)) {
                Bagel bagel = (Bagel) item;
                List<String> fillingSKUs = bagel.getLinkedFillingSKUs();

                int bagelId = createId();
                this.addToBasket(bagelId, item);
                item.setId(bagelId);

                // Add fillings and save the filling ids' to the bagel
                if (!fillingSKUs.isEmpty()) {
                    List<Integer> fillingIds = bagel.getLinkedFillingIds();

                    int count = 1;
                    for (String f_SKU : fillingSKUs) {
                        int fillingId = createFillingId(String.valueOf(count));

                        BasketItem filling = new Filling(f_SKU);
                        filling.setId(fillingId);

                        this.addToBasket(fillingId, filling);
                        fillingIds.add(fillingId);

                        count++;
                    }
                }
            } else {
                int generalId = createId();
                this.addToBasket(generalId, item);
            }

        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // Inner function for remove()
    // Validates input
    protected void removeFromBasket(int itemId) {
        if (basketItems.get(itemId) == null) {
            throw new InvalidBasketItemException("Basket item with ID #" + itemId + ", doesn't exist. Can't remove from basket.");
        }
        this.basketItems.remove(itemId);

        // Update size of basket
        this.size--;
    }

    // Remove item from basket based on id.
    public void remove(int itemId) {

        try {
            BasketItem item = this.getBasketItem(itemId);

            // Class names
            String thisItemClass = item.getClass().getName();
            String BagelClass = Bagel.class.getName();

            // Remove fillings if it is a Bagel
            if (thisItemClass.equals(BagelClass)) {

                Bagel bagel = (Bagel) item;
                List<Integer> fillingIds = bagel.getLinkedFillingIds();

                // Remove all fillings
                for (int f_id : fillingIds) {
                    this.removeFromBasket(f_id);
                }
            }
            this.removeFromBasket(itemId);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Get total cost of all items in basket
    public double getTotalCost() {
        // TODO Changed to double, this may be unnecessary now

        // TODO: Is it bad performance to loop like this?
        // Should I instead keep track on the price everytime an item is added or removed?

        float total = 0;
        for (BasketItem item : this.basketItems.values()) {
            InventoryItem inventoryItem = inventory.getItem(item.getSKU());
            total += inventoryItem.getPrice();
        }
        return priceCalculator.round(total, 2);
    }

    // Print basket with items and total cost.
    public void printBasket() {

        // TODO: Should I refactor? Feels like it's a poor solution regarding dependencies.
        // Check all PrintGenerator cases.

        printGenerator = new PrintBasketItems(this.inventory, this.basketItems, this.getTotalCost());
        printGenerator.print();
    }

    public void printReceipt() {

        ArrayList<DiscountObjectMultiPrice> itemsAndDiscounts = priceCalculator.calculateSpecialOfferMultiPrice(
                this.inventory,
                this.basketItems,
                this.inventory.getSpecialOffersMultiPrice()
        );
        ArrayList<DiscountObjectCombination> additionalDiscounts = priceCalculator.calculateSpecialOfferCombination(
                this.inventory,
                this.basketItems,
                this.inventory.getSpecialOffersCombination()
        );


        // Create a list of printable objects
        // Calculates MultiPrice discounts
        double totalCost = 0;
        ArrayList<BasketItemFormatted> printableListItems = new ArrayList<>();
        for (DiscountObjectMultiPrice item : itemsAndDiscounts) {

            // TODO: Refactor, unnecessary calculation
            boolean hasDiscountItems = item.getNumOfDiscountItems() != 0;
            boolean hasOrdinaryItems = item.getNumOfOrdinaryItems() != 0;

            InventoryItem inventoryItem = this.inventory.getItem(item.getSKU());
            String variant = inventoryItem.getVariant().toString();
            String name = inventoryItem.getName().getString();

            String combinedName = variant + " " + name;
            int amount;
            double price;
            double discount = item.getDiscount();

            if (hasDiscountItems) {
                amount = item.getNumOfDiscountItems();
                price = item.getPriceForDiscountItems();

                BasketItemFormatted formattedItem = new BasketItemFormatted(
                        combinedName,
                        amount,
                        price,
                        discount
                );
                printableListItems.add(formattedItem);
                totalCost += price;
            }

            if (hasOrdinaryItems) {
                amount = item.getNumOfOrdinaryItems();
                price = item.getPriceForOrdinaryItems();

                BasketItemFormatted formattedItem = new BasketItemFormatted(
                        combinedName,
                        amount,
                        price,
                        discount
                );
                printableListItems.add(formattedItem);
                totalCost += price;
            }

        }

        totalCost = priceCalculator.round((float) totalCost, 2);

        // Calculate combination discounts
//        int additionalDiscount = 0;
//        for (DiscountObjectCombination item : additionalDiscounts) {
//            additionalDiscount += item.getDiscountSum();
//        }
//        totalCost = totalCost - additionalDiscount;

        printGenerator = new PrintReceipt(
                printableListItems,
                totalCost
        );

        printGenerator.print();
    }
}
