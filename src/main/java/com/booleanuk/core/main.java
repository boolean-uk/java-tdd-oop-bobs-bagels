package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Store store = new Store(15);
        Customer customer = new Customer("Espen", store);
        Basket basket = new Basket(customer);
        /*
        customer.order("BGLE");
        customer.order("BGLE");
        customer.order("BGLE");
        customer.order("BGLE");

        customer.order("BGLS");
        customer.order("BGLS");
        customer.order("BGLS");

        customer.order("COFL");
        customer.order("COFW");

        customer.finishedOrdering();
        customer.calculateCostBeforeOrder();
        customer.confirmFinished();
*/
        /*
        ArrayList<Item> items = basket.getItems();
        items.add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        items.add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        items.add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));

        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));

        items.add(new Coffee("COFB", 0.99, "Coffee", "Black"));

        items.add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));

        items.add(new Coffee("COFL", 1.29, "Coffee", "Latte"));
        items.add(new Coffee("COFL", 1.29, "Coffee", "Latte"));

        items.add(new Coffee("COFW", 1.19, "Coffee", "White"));
        items.add(new Coffee("COFW", 1.19, "Coffee", "White"));

        items.add(new Filling("FILB", 0.12, "Filling", "Bacon"));
        items.add(new Filling("FILB", 0.12, "Filling", "Bacon"));
        items.add(new Filling("FILB", 0.12, "Filling", "Bacon"));
*/


    //    System.out.println(basket.applyDiscounts());
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
