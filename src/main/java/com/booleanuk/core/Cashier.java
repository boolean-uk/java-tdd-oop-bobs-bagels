package com.booleanuk.core;

import java.util.Scanner;

public class Cashier {
    private Scanner userInput;
    private Basket basket;
    private Inventory inventory;

    public Cashier(Inventory inventory, Basket basket) {
        this.userInput = new Scanner(System.in);
        this.inventory = inventory;
        this.basket = basket;
    }

    private boolean doChoice(char choice) {
        boolean exit = false;
        switch (choice) {
            case 'v':
                inventory.printInventory(inventory.getBagelInventory(), "Bagel Inventory");
                inventory.printInventory(inventory.getCoffeeInventory(), "Coffee Inventory");
                inventory.printInventory(inventory.getFillingInventory(), "Filling Inventory");
                break;
            case 'a':
                // add products
                break;
            case 'r':
                // remove products
                break;
            case 'c':
                // show basket
                break;
            case 'p':
                // pay for basket
                break;
            case 'm':
                // change capacity of basket
                break;
            case 'q':
                exit = true;
                break;
            default:
                System.out.println("Invalid choice");
        }
        return exit;
    }

    private void menu() {
        System.out.println("v. View products");
        System.out.println("a. Add products");
        System.out.println("r. Remove products");
        System.out.println("c. Show basket");
        System.out.println("p. Pay for basket");
        System.out.println("m. Change capacity of basket");
        System.out.println("q. Exit");
        System.out.println("===========================");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        Basket basket = new Basket(10);
        Cashier cashier = new Cashier(inventory, basket);

        boolean exit = false;
        cashier.menu();
        while (!exit) {
            char choice = cashier.userInput.next().charAt(0);
            exit = cashier.doChoice(choice);
        }
    }
}
