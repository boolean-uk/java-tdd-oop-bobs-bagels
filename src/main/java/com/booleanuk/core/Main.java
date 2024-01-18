package com.booleanuk.core;

import com.booleanuk.core.model.Basket;
import com.booleanuk.core.model.ItemType;
import com.booleanuk.core.model.Store;
import com.booleanuk.core.model.item.Bagel;
import com.booleanuk.core.model.item.Filling;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Store store = new Store("Bob's Bagels");
        System.out.println("Store object: " + store);

        // User enters the store
        Basket basket = new Basket();
        System.out.println("Basket object: " + basket);

        // User would like to see a list of all bagels and fillings
        System.out.println("List of all bagels: " + store.getItemsByItemType(ItemType.BAGEL));
        System.out.println("List of all fillings: " + store.getItemsByItemType(ItemType.FILLING));

        // The user wants to know the price of adding eggs to the bagel aswell as the price of a latte
        System.out.println("Cost of adding eggs: " + store.getItemBySKU("FILE").getPrice());
        System.out.println("Cost of latte: " + store.getItemBySKU("COFL").getPrice());

        // User picks some bagels and some coffee
        // Two plain bagels, one sesame with egg and bacon, one latte
        basket.addItem(store.getItemBySKU("BGLP"));
        Bagel bagelPlain2 = (Bagel) basket.addItem(store.getItemBySKU("BGLP"));
        Bagel bagelSesame = (Bagel) basket.addItem(store.getItemBySKU("BGLS"));
        basket.addFillingToBagel(bagelSesame, (Filling) store.getItemBySKU("FILE"));
        basket.addFillingToBagel(bagelSesame, (Filling) store.getItemBySKU("FILB"));
        basket.addItem(store.getItemBySKU("COFL"));

        // User wants to see basket and total
        System.out.println("The basket: " + basket.getBasket());
        System.out.println("Total cost: " + basket.getTotalCost());

        // User wants to remove one of the plain bagels
        basket.removeItem(bagelPlain2);

        // User wants to see the updated total
        System.out.println("Total cost: " + basket.getTotalCost());
    }
}
