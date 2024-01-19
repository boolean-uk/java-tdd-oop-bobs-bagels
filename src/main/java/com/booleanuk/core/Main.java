package com.booleanuk.core;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.enums.ItemType;
import com.booleanuk.core.models.Store;
import com.booleanuk.core.models.item.Bagel;
import com.booleanuk.core.models.item.Filling;
import com.booleanuk.extension.ReceiptPrinter;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Store store = new Store("Bob's Bagels");
        System.out.println("Store object: " + store);

        // User enters the store
        Basket basket = new Basket(50);
        System.out.println("Basket object: " + basket);

        // User would like to see a list of all bagels and fillings
        System.out.println("List of all bagels: " + store.getItemsByItemType(ItemType.BAGEL));
        System.out.println("List of all fillings: " + store.getItemsByItemType(ItemType.FILLING));

        // The user wants to know the price of adding eggs to the bagel aswell as the price of a latte
        System.out.println("Cost of adding eggs: " + store.getItemBySKU("FILE").getPrice());
        System.out.println("Cost of latte: " + store.getItemBySKU("COFL").getPrice());

        // User picks some bagels and some coffee
        // Thirteen plain bagels (one with ham), one sesame bagel with egg and bacon, one latte
        Bagel plain = (Bagel) store.getItemBySKU("BGLP");
        for (int i = 0; i < 12; i++) {
            basket.addItem(plain);
        }
        Bagel bagelPlain1 = (Bagel) basket.addItem(plain);
        Bagel bagelPlain2 = (Bagel) basket.addItem(plain);
        Bagel bagelPlain3 = (Bagel) basket.addItem(plain);
        Bagel bagelSesame = (Bagel) basket.addItem(store.getItemBySKU("BGLS"));
        basket.addFillingToBagel(bagelPlain1, (Filling) store.getItemBySKU("FILH"));
        basket.addFillingToBagel(bagelPlain3, (Filling) store.getItemBySKU("FILH"));
        basket.addFillingToBagel(bagelSesame, (Filling) store.getItemBySKU("FILE"));
        basket.addFillingToBagel(bagelSesame, (Filling) store.getItemBySKU("FILB"));
        basket.addItem(store.getItemBySKU("COFL"));

        // User wants to see basket and total
        System.out.println("The basket: " + basket.getBasket());
        System.out.println("Total cost: " + basket.getTotalCost());

        // User wants to remove one of the plain bagels
        basket.removeItem(bagelPlain2);

        // User wants to see the updated total
        System.out.println("The basket minus one bagel: " + basket.getBasket());
        System.out.println("Updated total cost: " + basket.getTotalCost());

        // User wants the receipt
        ReceiptPrinter receiptPrinter = new ReceiptPrinter(store, basket);
        System.out.println(receiptPrinter.print());
    }
}
