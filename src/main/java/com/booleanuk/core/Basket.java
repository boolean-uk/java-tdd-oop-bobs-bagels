package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Inventory inventory;
    private HashMap<Integer, Product> basketItems;
    private int idCount;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basketItems = new HashMap();
        this.idCount = 1;
    }

    /**
     * Create new Id for item in basket.
     * Updates idCount afterward.
     * @return int itemId
     */
    private int createID() {
        int itemId = this.idCount;
        this.idCount += 1;
        return itemId;
    }

    public void addCoffee(String SKU) {
        Coffee coffee = inventory.getCoffeeProduct(SKU);
        this.basketItems.put(createID(), coffee);
        printBasket();
    }

    public void addBagel(String SKU) {
        Bagel bagel = inventory.getBagelProduct(SKU);
        this.basketItems.put(createID(), bagel);
    }

    public void addFilling(String SKU) {
        Filling filling = inventory.getFillingProduct(SKU);
        this.basketItems.put(createID(), filling);
    }

    public HashMap<Integer, Product> getAll() {
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
