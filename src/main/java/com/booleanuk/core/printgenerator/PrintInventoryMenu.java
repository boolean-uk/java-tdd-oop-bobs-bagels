package com.booleanuk.core.printgenerator;

import com.booleanuk.core.ProductName;
import com.booleanuk.core.inventory.InventoryItem;

import java.util.Map;

public class PrintInventoryMenu extends PrintGenerator{

    private Map<String, InventoryItem> inventoryItems;

    public PrintInventoryMenu(Map<String, InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    private void printMenuPart(ProductName productName, String title, int outputWidth) {

        // Variables for e.g. "%-15s %-15s %n", keep blank space
        String center = "%16s ";
        String skuAlign = "%-8s ";
        String leftAlign = "%-16s ";
        String newLine = "%n";
        String divider = "-------------------------------";

        printCenterTitle(title, outputWidth);

        for (InventoryItem item : inventoryItems.values()) {
            if (item.getName() == productName) {
                System.out.printf(
                        skuAlign + leftAlign + leftAlign + newLine,
                        item.getSKU()+"  | ", item.getVariant().toString(), "$" + item.getPrice()
                );
            }
        }
        System.out.println();
    }

    @Override
    public void print() {

        int outputWidth = 32;

        System.out.println();
        printCenterTitle("=== Bob's Bagels Menu ===", outputWidth);
        System.out.println();

        printMenuPart(ProductName.COFFEE, "~ Coffee ~", outputWidth);
        printMenuPart(ProductName.BAGEL, "~ Bagels ~", outputWidth);
        printMenuPart(ProductName.FILLING, "~ Bagel Fillings ~", outputWidth);
    }

}
