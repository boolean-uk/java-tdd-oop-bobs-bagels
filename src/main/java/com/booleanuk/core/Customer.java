package com.booleanuk.core;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static AtomicInteger count;
    private int id;
    private String name;
    private Basket inventory;
    private Store store;
    private Scanner scanner = new Scanner(System.in);

    public Customer(String name, Store store) {
        count = new AtomicInteger(0);
        this.id = count.incrementAndGet();
        this.name = name;
        this.inventory = new Basket(this);
        this.store = store;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Basket getInventory() {
        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Store getStore() {
        return store;
    }

    public double calculateCostBeforeOrder() {
        return this.inventory.calculateTotalCost();
    }

    // Runs if basket contains a bagel
    // Asks if user wants to add filling
    // if yes, prints list of all fillings
    // user orders filling by writing SKU of filling
    public Basket chooseFilling(Scanner scanner) {
        System.out.println("A bagel has been added to your inventory\nWould you like to order a filling?");
        System.out.println("SKU \t Cost \t Name \t Variant");
        for(Item item : store.getItemsInStock()) {
            if(item.getClass() == Filling.class) {
                System.out.println(item);
            }
        }
        Item filling = store.findItemInList(scanner.nextLine());
        if(filling != null && filling.getClass()==Filling.class) {
            inventory.getItems().add(filling);
            System.out.println("Filling has been added! Thank you!");
        } else {
            System.out.println("Filling was not found, too bad");
        }
        return inventory;
    }


    /*
    Tries to match the given SKU to an item in stock
    Checks if basket is full
    Checks if there were a match with stock
    If match:
        add the item to basket
        if the item were a bagel, run chooseFilling()
    return: updatedBasket
     */
    public Basket order(String input) {
        Item item = store.findItemInList(input);
        if(inventory.getItems().size() >= store.getCapacity()) {
            System.out.println("Your basket is full");
        } else if(item != null) {
            this.inventory.getItems().add(item);
            if(item.getClass() == Bagel.class) {
                chooseFilling(scanner);
            } else {
                System.out.println("This item has been added to your basket \n" + item.toString());
            }
        } else {
            System.out.println("The item was not found");
        }
        return inventory;
    }

    /*
    Checks if the given sku matches a item in Basket
    Deletes item from Basket if item was found
    */
    public String deleteItems(String sku) {
        for(Item item : this.inventory.getItems()) {
            if(item.getSKU().matches(sku)) {
                this.inventory.getItems().remove(item);
                return item.getName() + " " + item.getVariant() + " was deleted";

            }
        }
        return "The item was not found, and could not be deleted";
    }
    /*
    MADE FOR TESTING IN MAIN
    If input from user is 'y', print the receipt and exit program
    If input is not 'y' or 'n', rerun the check
     */
    public String confirmFinished() {
        String confirmation= "";
        System.out.println("Are you done shopping? (y/n)");
        String input = scanner.nextLine();
        if(input.equals("y")) {
            confirmation = "quit";
            this.inventory.showReceipt();
        } else if(input.equals("n")) {
            confirmation = "continue";
        } else {
            confirmFinished();
        }
        return confirmation;
    }

}
