package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager(true);
        BasketManager b = new BasketManager();
        //inv.costEachFilling();

        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.getBasket().get(0).addFilling(inv.getInventory().get("FILC"));
        b.getBasket().get(0).addFilling(inv.getInventory().get("FILE"));
        b.add(inv.getInventory().get("COFW"));
        b.add(inv.getInventory().get("COFB"));
        b.add(inv.getInventory().get("FILX"));
        b.add(inv.getInventory().get("ItemNotInStock"));

        //b.showContentsBasket();
        //b.totalCost();

        b.printReceipt();
    }
}
