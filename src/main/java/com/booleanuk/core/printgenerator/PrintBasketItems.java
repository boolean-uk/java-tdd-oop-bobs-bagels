package com.booleanuk.core.printgenerator;

import com.booleanuk.core.basket.BasketItem;
import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.InventoryItem;

import java.util.Map;

public class PrintBasketItems extends PrintGenerator {

    private Inventory inventory;
    private Map<Integer, BasketItem> basketItems;

    public PrintBasketItems(Inventory inventory, Map<Integer, BasketItem> basketItems) {
        this.inventory = inventory;
        this.basketItems = basketItems;
    }

    @Override
    public void print() {

        int outputWidth = 47;

        // Variables for e.g. "%-15s %-15s %n", keep blank space
        String leftAlignSmall = "%-7s ";
        String leftAlign = "%-15s ";
        String newLine = "%n";
        String divider = "-----------------------------------------------";

        System.out.println();
        printCenterTitle("=== Bob's Bagels Menu ===", outputWidth);
        printCenterTitle("~ Basket ~", outputWidth);
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

                InventoryItem product = this.inventory.getItem(basketItem.getSKU());
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
