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

    public Basket chooseFilling(Scanner scanner) {
        System.out.println("We detected a bagel in your inventory\nWould you like to order a filling?");
        System.out.println("SKU \t Cost \t Name \t Variant");
        for(Item item : inventory.getItems()) {
            if(item.getInstance().toString().equals("Filling")) {
                System.out.println(item);
            }
        }
        Item filling = store.findItemInList(scanner.nextLine());
        if(filling != null) {
            inventory.getItems().add(filling);
            System.out.println("Filling has been added! Thank you!");
        } else {
            System.out.println("Filling was not found, too bad");
        }
        return inventory;
    }

    public Basket order(String input) {
        Item item = store.findItemInList(input);
        if(inventory.getItems().size() >= store.getCapacity()) {
            System.out.println("Your basket is full");
        } else if(item != null) {
            this.inventory.addItem(item);
            System.out.println("This item has been added to your basket \n" + item.toString());
        } else {
            System.out.println("The item was not found");
        }
        return inventory;
    }

    public Basket finishedOrdering() {
        if(inventory.getItems().isEmpty()) {
            return inventory;
        }
        boolean basketContainsBagel = false;
        for(Item item : inventory.getItems()) {
            if (item.getClass().toString().equals("Bagel")) {
                basketContainsBagel = true;
                break;
            }
        }
        if(basketContainsBagel) {
            chooseFilling(scanner);
        }
        return inventory;
    }

    public String deleteItems(String sku) {
        for(Item item : this.inventory.getItems()) {
            if(item.getSKU().matches(sku)) {
                this.inventory.getItems().remove(item);
                return item.getName() + " " + item.getVariant() + " was deleted";

            }
        }
        return "The item was not found, and could not be deleted";
    }

    public String confirmFinished() {
        String confirmation= "";
        System.out.println("Are you done shopping? (y/n)");
        String input = scanner.nextLine();
        if(input.equals("y")) {
            confirmation = "quit";
        } else if(input.equals("n")) {
            confirmation = "continue";
        } else {
            confirmFinished();
        }
        return confirmation;
    }

    public void showInventory() {
        if(!this.inventory.getItems().isEmpty()) {
            System.out.println("SKU \t Cost \t Name \t Variant");
            for(Item item : this.inventory.getItems()) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are none items in your basket!");
        }
    }
}
