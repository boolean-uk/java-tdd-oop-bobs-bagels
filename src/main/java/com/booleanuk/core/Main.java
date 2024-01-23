package com.booleanuk.core;

import com.booleanuk.extension.Receipt;

public class Main {
    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager(true);
        BasketManager b = new BasketManager();
        //inv.costEachFilling();

        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.changeCapacity(50);
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("COFB"));
        b.add(inv.getInventory().get("BGLO"));
        b.add(inv.getInventory().get("BGLO"));
        b.getBasket().get(0).addFilling(inv.getInventory().get("FILC"));
        b.getBasket().get(0).addFilling(inv.getInventory().get("FILE"));
        b.getBasket().get(1).addFilling(inv.getInventory().get("FILE"));
        b.add(inv.getInventory().get("COFW"));
        b.add(inv.getInventory().get("COFB"));
        b.add(inv.getInventory().get("FILX"));
        b.add(inv.getInventory().get("ItemNotInStock"));

        b.showContentsBasket();
        b.totalCost();
        //b.printReceipt();

        Receipt r = new Receipt(b, inv);
        r.printReceipt();

        b.changeCapacity(2);
        r = new Receipt(b, inv);
        r.printReceipt();
    }
}
