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

    private boolean handleChoice(String choice){
        boolean exit = false;
        switch (choice){
            case "MENU" -> this.showMenu();
            case "VIEW" -> this.viewChoices();
            case "CHANGE" -> this.increaseBasketSize();
            case "ADD" -> this.handleProduct(true);
            case "REMOVE" -> this.handleProduct(false);
            case "SHOW" -> this.showProductsWithPrice();
            case "GET" -> this.getCost();
            case "PAY" -> exit = true;
            default -> System.out.println("Wrong choice... Please try again.");
        }
        return exit;
    }

    private void showMenu() {
        System.out.println("=-=-=-=-=-=CHOICES=-=-=-=-=-=-=");
        System.out.println("VIEW products and prices.");
        System.out.println("CHANGE capacity of basket.");
        System.out.println("ADD product to basket.");
        System.out.println("REMOVE product from basket.");
        System.out.println("SHOW basket's products and cost per each");
        System.out.println("GET total cost of products in basket.");
        System.out.println("PAY in the cashier and leave shop.");
        System.out.println("Capital letters indicate your available choices.");
    }

    private void viewChoices() {
        System.out.println(".........Today's Menu.........");
        System.out.println(this.inventory.getProductList());
    }

    private void increaseBasketSize() {
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

    private void handleProduct(boolean adding) {
        Product product = null;
        String productName = "";
        while(product == null) {
            System.out.print("Input the product name you want to " + (adding?"add to":"remove from") + " your basket: ");
            productName = this.userInput.nextLine();
            product = this.inventory.getProductByName(productName);
            if (product == null){
                System.out.println("Product not found in our inventory. Please try again. (e.g. Plain Bagel)");
            }
        }
        if (adding){
            if(this.basket.addProduct(product)){
                System.out.println(productName + " successfully added to basket.");
            } else {
                System.out.println("Basket capacity reached, therefore product cannot be added.");
            }
        } else {
            if(this.basket.removeProduct(product)){
                System.out.println(productName + " successfully removed from basket.");
            } else {
                System.out.println("Product not found in basket.");
            }
        }
    }

    private void showProductsWithPrice() {
        System.out.print(this.basket.showProducts());
    }

    private void getCost() {
        System.out.println("Total Cost = " + this.basket.getTotalCost() + "$");
    }

    public static void main(String[] args) {
        File inventorySkus = new File("./SkusOfBaseProducts.txt");
        int basketCapacity = 6;
        Shop bobBagels = new Shop(inventorySkus, basketCapacity);
        File productList = new File("./FullProductList.txt");
        bobBagels.inventory.loadProducts(productList);
        boolean exit = false;
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=\nWelcome to Bob's Bagels!\n=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        bobBagels.showMenu();
        while (!exit){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("MENU will show up all available choices again.");
            System.out.print("What do you want to do? ");
            String choice = bobBagels.userInput.nextLine().toUpperCase();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            exit = bobBagels.handleChoice(choice);
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=\nBob waves at you. Thanks!\n=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}
