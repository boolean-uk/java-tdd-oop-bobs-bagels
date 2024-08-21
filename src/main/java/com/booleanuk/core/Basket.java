package com.booleanuk.core;

import java.util.*;

public class Basket {
    private Inventory inventory;
    private LinkedHashMap<Integer, Product> basketItems;
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

    public void addCoffee(String SKU) {
        Coffee coffee = inventory.getCoffeeProduct(SKU);
        this.basketItems.put(createID(), coffee);
        printBasket();
    }

    public void addBagel(String SKU, List<String> SKUfillings) {
        Bagel bagel = inventory.getBagelProduct(SKU);
        this.basketItems.put(createID(), bagel);

        int count = 1;
        for (String SKUf : SKUfillings) {
            Filling filling = this.inventory.getFillingProduct(SKUf);
            bagel.addFilling(filling);
            this.basketItems.put(createFillingId(String.valueOf(count)), filling);
            count++;
        }
    }

//    private void addFilling(String SKU) {
//        Filling filling = inventory.getFillingProduct(SKU);
//        this.basketItems.put(createID(), filling);
//    }

    public LinkedHashMap<Integer, Product> getAll() {
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
            for (Map.Entry<Integer, Product> item : basketItems.entrySet()) {
                int key = item.getKey();
                Product product = item.getValue();
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
