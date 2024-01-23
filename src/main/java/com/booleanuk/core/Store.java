package com.booleanuk.core;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Store {
    private int basketCapacity;
    private ArrayList<Item> itemsInStock;
    private ArrayList<Customer> customerList;

    public Store(int basketCapacity) {
        this.basketCapacity = basketCapacity;
        this.itemsInStock = new ArrayList<>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
            add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
            add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
            add(new Coffee("COFW", 1.19, "Coffee", "White"));
            add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
            add(new Coffee("COFL", 1.29, "Coffee", "Latte"));
            add(new Filling("FILB", 0.12, "Filling", "Bacon"));
            add(new Filling("FILE", 0.12, "Filling", "Egg"));
            add(new Filling("FILC", 0.12, "Filling", "Cheese"));
            add(new Filling("FILX", 0.12, "Filling", "Cream Cheese"));
            add(new Filling("FILS", 0.12, "Filling", "Smoked Salmon"));
            add(new Filling("FILH", 0.12, "Filling", "Ham"));
        }};
        this.customerList = new ArrayList<Customer>();
    }

    public ArrayList<Item> getItemsInStock() {
        return itemsInStock;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    private boolean addItemInStock(String sku, double cost, String name, String variant) {
        switch (name) {
            case "Bagel" -> {
                itemsInStock.add(new Bagel(sku, cost, name, variant));
                return true;
            }
            case "Coffee" -> {
                itemsInStock.add(new Coffee(sku, cost, name, variant));
                return true;
            }
            case "Filling" -> {
                itemsInStock.add(new Filling(sku, cost, name, variant));
                return true;
            }
        }
        return false;
    }

    private boolean deleteItemFromStock(String sku) {
        Item item = findItemInList(sku);
        if(item != null) {
            itemsInStock.remove(item);
            return true;
        }
            return false;
    }

    public Customer addCustomer(String name) {
        Customer newCustomer = new Customer(name, this);
        customerList.add(newCustomer);
        return newCustomer;
    }

    private Customer findCustomerFromList(String name) {
        for (Customer customer : customerList) {
            if (customer.getName().matches(name)) {
                System.out.println("Found customer with name" + customer.getName());
                return customer;
            }
        }
        System.out.println("Did not find customer with name " + name);
        return null;
    }

    private Customer findCustomerFromList(int id) {
        for(Customer customer : customerList) {
            if(customer.getId() == id) {
                System.out.println("Found customer with name" + customer.getName());
                return customer;
            }
        }
        System.out.println("Did not find customer with id " + id);
        return null;
    }

    public Item findItemInList(String sku) {
        for(Item item : itemsInStock) {
            if(item.getSKU().matches(sku)) {
                return item;
            }
        }
        return null;
    }

    public int getCapacity() {
        return basketCapacity;
    }
    public boolean setCapacity(int newCapacity) {
        this.basketCapacity = newCapacity;
        return capacityChanged();
    }

    private boolean capacityChanged() {
        boolean hasChanged = false;
        if(customerList.isEmpty()) {
            return true;
        }
        for(Customer customer : this.customerList) {
            if(!customer.getInventory().capacityChanged()) {
                hasChanged = false;
                return hasChanged;
            }
        }
        return hasChanged;
    }

    public void printStoreMethods() {
        String menu = "1: Add a new item in stock\n2: Set a new capacity";
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!input.equals("quit")) {
            System.out.println(menu);
            switch (scanner.nextLine()) {
                case "1": {
                    String sku = "";
                    double cost = 0.0;
                    String name = "";
                    String variant = "";
                    System.out.println("Provide SKU");
                    sku = scanner.nextLine();
                    System.out.println("Provide cost");
                    boolean isDouble = false;
                    while (!isDouble) {
                        try {
                            cost = scanner.nextDouble();
                            isDouble = true;
                        } catch (InputMismatchException e) {
                            System.out.println("You didn't provide a double");
                        }
                    }
                    System.out.println("Bagel, Coffee or Filling?");
                    boolean isCorrectType = false;
                    while (!isCorrectType) {
                        input = scanner.nextLine();
                        if(input.equals("Bagel") || input.equals("Coffee") || input.equals("Filling")) {
                            name = input;
                            isCorrectType = true;
                        }
                    }
                    System.out.println("Provide Variant");
                    variant = scanner.nextLine();
                    addItemInStock(sku, cost, name, variant);
                    System.out.println("A new item was added to stock!");
                    break;
                }
                case "2": {
                    boolean isNumber = false;
                    int newCapacity = -1;
                    while(!isNumber) {
                        try {
                            newCapacity = Integer.parseInt(scanner.nextLine());
                            isNumber = true;
                            System.out.println("Capacity was set to " + newCapacity);
                        } catch(InputMismatchException e) {
                            System.out.println("Please provide a whole number");
                        }
                    }
                    setCapacity(newCapacity);
                    break;
                }
                case "0": {
                    input = "quit";
                    break;
                }
                default: {
                    System.out.println("Please provide a valid input");
                    break;
                }
            }
        }
        System.out.println("Back to main menu");
    }

    public void printAllItems() {
        System.out.println("SKU \t Cost \t Name \t Variant");
        for(Item item : itemsInStock) {
            System.out.println(item);
        }
    }

}
