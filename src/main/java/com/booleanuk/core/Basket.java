package com.booleanuk.core;

import java.util.*;

public class Basket {
    private Inventory inventory;
    private LinkedHashMap<Integer, BasketItem> basketItems;
    private int idCount;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basketItems = new LinkedHashMap <>();
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

    // TODO: Refactor and remove this and add generic function nsad
    public void addCoffee(String SKU) {
        BasketItem item = new BasketItem(SKU);
        this.basketItems.put(createID(), item);
        printBasket();
    }


    public void addBagel(String SKU) {
        BasketItem item = new BasketItem(SKU);
        this.basketItems.put(createID(), item);
    }


    public void addBagel(String SKU, List<String> SKUfillings) {
        BasketItem item = new BasketItem(SKU);
        this.basketItems.put(createID(), item);

        int count = 1;
        for (String SKU_f : SKUfillings) {

            // Store the created id for the filling
            int fillingId = createFillingId(String.valueOf(count));

            // Add filling to this basket
            this.basketItems.put(fillingId, new BasketItem(SKU_f));

            // Store filling id in bagel basketIem so it is possible to delete later
            item.addFillingId(fillingId);

            count++;
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
