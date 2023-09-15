package com.booleanuk.core;

import java.io.File;
import java.util.Scanner;

public class Shop {
    private final Inventory inventory;
    private final Basket basket;
    Scanner userInput;

    public Shop(File inventorySkus, int basketCapacity) {
        this.inventory = new Inventory(inventorySkus);
        this.basket = new Basket(basketCapacity);
        this.userInput = new Scanner(System.in);
    }

    public boolean handleChoice(String choice){
        boolean exit = false;
        switch (choice){
            case "VIEW" -> this.viewChoices();
            case "CHANGE" -> this.increaseBasketSize();
            case "ADD" -> System.out.println("add");
            case "REMOVE" -> System.out.println("remove");
            case "GET" -> System.out.println("get");
            case "PAY" -> exit = true;
            default -> System.out.println("Wrong choice... Please try again.");
        }
        return exit;
    }

    public void viewChoices() {
        System.out.println(".........Today's Menu.........");
        System.out.println(this.inventory.getProductList());
    }

    public void increaseBasketSize() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Current capacity is " + this.basket.getCapacity() + ".");
            System.out.print("Input new capacity: ");
            String placeholder = this.userInput.nextLine();
            try {
                int newCapacity = Integer.parseInt(placeholder);
                exit = this.basket.setCapacity(newCapacity);
            } catch (NumberFormatException e){
                System.out.println("That's not a number. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=\nWelcome to Bob's Bagels!\n=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        File inventorySkus = new File("./SkusOfBaseProducts.txt");
        int basketCapacity = 6;
        Shop bobBagels = new Shop(inventorySkus, basketCapacity);
        File productList = new File("./FullProductList.txt");
        bobBagels.inventory.loadProducts(productList);
        boolean exit = false;
        System.out.println();
        while (!exit){
            System.out.println("=-=-=-=-=-=CHOICES=-=-=-=-=-=-=");
            System.out.println("VIEW products and prices.");
            System.out.println("CHANGE capacity of basket.");
            System.out.println("ADD product to basket.");
            System.out.println("REMOVE product from basket.");
            System.out.println("GET total cost of products.");
            System.out.println("PAY in the cashier and leave shop.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Capital letters above indicate your available choices.");
            System.out.println("What do you want to do? ");
            String choice = bobBagels.userInput.nextLine().toUpperCase();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            exit = bobBagels.handleChoice(choice);
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=\nBob waves at you. Thanks!\n=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}
