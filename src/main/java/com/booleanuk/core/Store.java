package com.booleanuk.core;

import java.util.ArrayList;

public class Store {
    public static int BASKETCAPACITY;
    private ArrayList<Item> itemsInStock;
    private ArrayList<Customer> customerList;

    public Store(int basketCapacity) {
        BASKETCAPACITY = basketCapacity;
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

    private boolean AddItemInStock(Item item) {
        return false;
    }

    private boolean deleteItemFromStock(Item item) {
        return false;
    }

    public Customer addCustomer(String name) {
        Customer newCustomer = new Customer(name);
        this.customerList.add(newCustomer);
        return newCustomer;
    }

    private Customer findCustomerFromList(String name) {
        return new Customer("Hi there");
    }

    private Customer findCustomerFromList(int id) {
        return new Customer("Hi there");
    }

    public boolean setCapacity(int newCapacity) {
        return false;
    }

}
