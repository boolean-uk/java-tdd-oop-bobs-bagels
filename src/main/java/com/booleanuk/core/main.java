package com.booleanuk.core;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        main main = new main();
        main.start();

    }

    public void start() {
        Store store = new Store(15);
        System.out.println("Write name of customer and press enter:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Customer customer = store.addCustomer(input);
        while(!input.equals("quit")) {
            System.out.println("\n1: Add a new Customer \n" +
                    "2: Order something \n" +
                    "3: Finished shopping \n" +
                    "4: Delete an item \n" +
                    "5: Show the damage \n" +
                    "6: Show store methods \n" +
                    "7: Show items in basket \n" +
                    "0: Exit");
            switch (scanner.nextLine()) {
                case "1": {
                    customer = store.addCustomer(scanner.nextLine());
                    break;
                }
                case "2": {
                    System.out.println("What do you like to order?");
                    store.printAllItems();
                    customer.order(scanner.nextLine());
                    break;
                }
                case "3": {
                    customer.calculateCostBeforeOrder();
                    input = customer.confirmFinished();
                    break;
                }
                case "4": {
                    customer.deleteItems(scanner.nextLine());
                    break;
                }
                case "5": {
                    customer.calculateCostBeforeOrder();
                    break;
                }
                case "6": {
                    store.printStoreMethods();
                    break;
                }
                case "7": {
                    System.out.println(customer.getInventory().showInventory());
                    break;
                }
                case "0": {
                    input = "quit";
                }
                default: {
                    System.out.println("Please provide a valid input");
                }
            }
        }
    }
}
