package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.SortedMap;

public class Main {

    /**
     * play with receipt method extensions_2
     * @param lst
     */
    public static void printReceipt(List<Item> lst) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        System.out.println("                ~~~ !Bob's Bagels ~~~\n");
        System.out.println("                 " + formattedDateTime + "\n");
        System.out.println("             ____________________________\n");

        System.out.println("  ____      ____ ");
        System.out.println(" | __ )    / __ \\ ");
        System.out.println(" |  _ \\  | |  | |");
        System.out.println(" | |_) |  | |  | |");
        System.out.println(" |____/   \\\\____/ ");
    }

    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager(true);
        BasketManager b = new BasketManager();
        //inv.costEachFilling();

        printReceipt(b.getBasket());

        b.add(inv.getInventory().get("BGLO"));
        b.getBasket().get(0).addFilling(inv.getInventory().get("FILC"));
        b.getBasket().get(0).addFilling(inv.getInventory().get("FILE"));
        b.add(inv.getInventory().get("COFW"));
        b.add(inv.getInventory().get("COFB"));
        b.add(inv.getInventory().get("FILX"));
        b.add(inv.getInventory().get("ItemNotInStock"));

        b.showContentsBasket();
        b.totalCost();
    }
}
