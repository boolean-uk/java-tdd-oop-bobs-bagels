package com.booleanuk.core;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Store store = new Store(5);
        System.out.println("Write name of customer and press enter:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Customer customer = store.addCustomer(input);
        while(!input.equals("quit")) {
            System.out.println("1: Add a new Customer \n" +
                    "2: Order something \n" +
                    "3: Finished shopping \n" +
                    "4: Delete an item \n" +
                    "5: Show the damage \n" +
                    "6: Show store methods \n");
            switch (scanner.nextLine()) {
                case "1": {
                    customer = store.addCustomer(scanner.nextLine());
                    break;
                    }
                case "2": {
                    System.out.println("What do you like to order?");
                    customer.order(scanner.nextLine());
                    break;
                }
                case "3": {
                    customer.finishedOrdering();
                    customer.calculateCostBeforeOrder();
                    customer.confirmFinished();
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
                case "0": {
                    input = "quit";
                }
                default: {
                    System.out.println("Please provide a valid input");
                }
            }
        }
        System.out.println("Goodbye");
    }
}
