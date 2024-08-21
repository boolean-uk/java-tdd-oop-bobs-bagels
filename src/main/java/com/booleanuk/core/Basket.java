package com.booleanuk.core;

import java.util.HashMap;

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
        basketItems.put(createID(), coffee);

        printBasket();
    }

    public HashMap<Integer, Product> getAll() {
        return basketItems;
    }

    public void printBasket() {
        // Variables for e.g. "%-15s %-15s %n", keep blank space
        String centerSmall = "%27s ";
        String center = "%22s ";
        String leftAlignSmall = "%-7s ";
        String leftAlign = "%-10s ";
        String newLine = "%n";
        String divider = "----------------------------------";

        // TODO: Unnecassary looping
        // TODO: Duplicate code
        System.out.println();
        System.out.printf(centerSmall + newLine, "=== Bob's Bagels ===");
        System.out.printf(center + newLine, "~ Basket ~");
        System.out.println(divider);

        // Print items in basket
        if (basketItems.isEmpty()) {
            System.out.println("\tBasket is empty.");
        } else {
            for (Product item : basketItems.values()) {
                if (item.getName() == ProductName.COFFEE) {
                    System.out.printf(
                            leftAlignSmall + leftAlignSmall + leftAlign + leftAlign + newLine,
                            item.getSKU()+"  | ", item.getName(), item.getVariant().toString(), "$" + item.getPrice()
                    );
                }
            }
            System.out.println(divider);
            System.out.printf(
                    "%s %20s" + newLine,
                    "Total cost: ", "$?.??"
            );
        }
        System.out.println(divider);
        System.out.println();
    }
}
