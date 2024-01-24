package com.booleanuk.core;

import com.booleanuk.extension.Receipt;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Item, Integer> fullInventory = new HashMap<>();
        Item bglo = new Bagel("BGLO", "Onion", 0.49);
        Item bglp = new Bagel("BGLP","Plain", 0.39);
        Item bgle = new Bagel("BGLE","Everything", 0.49);
        Item bgls = new Bagel("BGLS", "Sesame", 0.49);
        Item cofb = new Coffee("COFB",  "Black", 0.99);
        Item cofw = new Coffee("COFW",  "White", 1.19);
        Item cofc = new Coffee("COFC",  "Capuccino", 1.29);
        Item cofl = new Coffee("COFL",  "Latte", 1.29);
        Item filb = new Filling("FILB",  "Bacon", 0.12);
        Item file = new Filling("FILE",  "Egg", 0.12);
        Item filc = new Filling("FILC",  "Cheese", 0.12);
        Item filx = new Filling("FILX",  "Cream Cheese", 0.12);
        Item fils = new Filling("FILS",  "Smoked Salmon", 0.12);
        Item filh = new Filling("FILH",  "Ham", 0.12);
        fullInventory.put(bglo, 30);
        fullInventory.put(bglp, 30);
        fullInventory.put(bgle, 30);
        fullInventory.put(bgls, 30);
        fullInventory.put(cofb, 30);
        fullInventory.put(cofw, 30);
        fullInventory.put(cofc, 30);
        fullInventory.put(cofl, 30);
        fullInventory.put(filb, 30);
        fullInventory.put(file, 30);
        fullInventory.put(filc, 30);
        fullInventory.put(filx, 30);
        fullInventory.put(fils, 30);
        fullInventory.put(filh, 30);
        BobsBagelsShop shop = new BobsBagelsShop(fullInventory);
        System.out.println(shop.showInventory());

        Basket basket1 = new Basket(shop, 16);
        basket1.add(bglp); basket1.add(bglp); basket1.add(bglp); basket1.add(bglp); basket1.add(bglp); basket1.add(bglp);
        basket1.add(cofb); basket1.add(bgle);
        basket1.add(filb);
        basket1.add(filx);
        basket1.add(file);
        basket1.add(fils);

        Receipt receipt = new Receipt(basket1);
        receipt.generateReceiptWithDiscount();
        receipt.printReceipt();

        receipt.generateReceipt();
        receipt.printReceipt();
    }
}
