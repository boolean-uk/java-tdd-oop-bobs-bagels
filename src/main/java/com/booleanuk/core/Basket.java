package com.booleanuk.core;

import java.util.*;

public class Basket {
    private Inventory inventory;
    private LinkedHashMap<Integer, BasketItem> basketItems;
    private int maxCapacity;
    private int idCount;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basketItems = new LinkedHashMap <>();
        this.maxCapacity = 20;
        this.idCount = 1;
    }

    /**
     * Create new Id for item in basket.
     * Updates idCount afterward.
     * @param String idExtension - Add this for fillings, one unique extension for each filling
     * @return int itemId
     */
    private int createID() {
        // Store variable
        int itemId = this.idCount;
        this.idCount += 1;
        return itemId;
    }

    private int createFillingId(String idExtension) {
        //TODO: How to make default variable like in python

        // TODO: Should check if idExtension is valid

        // TODO: Could use int input instead of String

        // Store variable id for previous bagel
        int itemId = this.idCount - 1;

        // Add id extension for filling
        String tmp = String.valueOf(itemId) + "0" + idExtension;
        return Integer.parseInt(tmp);
    }

    // TODO: I need to have this because otherwise I can't make a unit test on it,
    // but I don't want the inventory or other classes to have aceess to this.
    // should I put basket in an own package?
    // Oterwise change back to private
    // See test exceedMaxCapacityShouldThrowError
    protected void addToBasket(int id, BasketItem item) {
        if (this.basketItems.size() == maxCapacity) {
            throw new MaxCapacityException("Basket is full, can't add more items");
        }
        this.basketItems.put(id, item);
    }

    // TODO: Refactor and remove this and add generic function nsad??
    public void addCoffee(String SKU) {
        try {
//            BasketItem item = new BasketItem(SKU);
//            this.basketItems.put(createID(), item);

            this.addToBasket(createID(), new BasketItem(SKU));
            printBasket();
        } catch (MaxCapacityException e) {
            System.out.println(e.getMessage());
        }
    }


    public void addBagel(String SKU) {
        try {
//            BasketItem item = new BasketItem(SKU);
//            this.basketItems.put(createID(), item);

            this.addToBasket(createID(), new BasketItem(SKU));
        } catch (MaxCapacityException e) {
            System.out.println(e.getMessage());
        }
//        // TODO: Can't check throw exception in Test if I handle the exception with try/catch
//        this.addToBasket(createID(), new BasketItem(SKU));


    }


    public void addBagel(String SKU, List<String> SKUfillings) {
        try {
            BasketItem item = new BasketItem(SKU);
//            this.basketItems.put(createID(), item);
            this.addToBasket(createID(), item);

            int count = 1;
            for (String SKU_f : SKUfillings) {

                // Store the created id for the filling
                int fillingId = createFillingId(String.valueOf(count));

                // Add filling to this basket
//                this.basketItems.put(fillingId, new BasketItem(SKU_f));
                this.addToBasket(fillingId, new BasketItem(SKU_f));

                // Store filling id in bagel basketIem so it is possible to delete later
                item.addFillingId(fillingId);

                count++;
            }
        } catch (MaxCapacityException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(int productId) {
        BasketItem item = this.basketItems.get(productId);
        Product product = this.inventory.getProduct(item.getSKU());

        if (product.getName() == ProductName.BAGEL && item.getLinkedIds() != null) {
            // Get filling for this basketItem
            List<Integer> fillingsIds = item.getLinkedIds();
            // Remove the bagel fillings from the basket
            for (Integer fillingId : fillingsIds) {
                this.basketItems.remove(fillingId);
            }
        }
        this.basketItems.remove(productId);
    }

//    private void addFilling(String SKU) {
//        Filling filling = inventory.getFillingProduct(SKU);
//        this.basketItems.put(createID(), filling);
//    }

    public LinkedHashMap<Integer, BasketItem> getAll() {
        return basketItems;
    }

    public void changeMaxCapacity(int newMaxCapacity) {
        this.maxCapacity = newMaxCapacity;
    }

    public void printBasket() {
        // Variables for e.g. "%-15s %-15s %n", keep blank space
        String centerSmall = "%34s ";
        String center = "%29s ";
        String leftAlignSmall = "%-7s ";
        String leftAlign = "%-15s ";
        String newLine = "%n";
        String divider = "-----------------------------------------------";

        // TODO: Unnecassary looping
        // TODO: Duplicate code
        System.out.println();
        System.out.printf(centerSmall + newLine, "=== Bob's Bagels ===");
        System.out.printf(center + newLine, "~ Basket ~");
        System.out.println();

        // Print items in basket
        if (basketItems.isEmpty()) {
            System.out.println("\tBasket is empty.");
        } else {
            System.out.printf(
                    leftAlignSmall + leftAlignSmall + leftAlignSmall + leftAlign + leftAlign + newLine,
                    "SKU   | ", "ID", "Product", "Variant", "Price"
            );
            System.out.println(divider);
            for (Map.Entry<Integer, BasketItem> item : basketItems.entrySet()) {
                int key = item.getKey();
                BasketItem basketItem = item.getValue();
                Product product = this.inventory.getProduct(basketItem.getSKU());
                System.out.printf(
                        leftAlignSmall + leftAlignSmall + leftAlignSmall + leftAlign + leftAlign + newLine,
                        product.getSKU()+"  | ", key,  product.getName(), product.getVariant().toString(), "$" + product.getPrice()
                );
            }
            System.out.println(divider);
            System.out.printf(
                    "%s %33s" + newLine,
                    "Total cost: ", "$?.??"
            );
        }
        System.out.println(divider);
        System.out.println();
    }
}
