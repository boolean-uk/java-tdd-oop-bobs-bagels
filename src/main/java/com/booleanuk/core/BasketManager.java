package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasketManager {

    private List<Item> basket;
    private int capacity;

    public BasketManager() {
        this.setBasket();
    }

    /**
     * Logic: check if available capacity is larger than 0, otherwise do not add to basket.
     * @param item
     * @return item
     */
    public Item add(Item item) {
        if (checkItemInInventory(item)) {
            if ((checkCapacity() > 0)) {
                getBasket().add(item);
                return item;
            }
        }
        return null;
    }

    /**
     * Logic: check if basket contains item, if true: remove and return item.
     * @param item
     * @return item
     */
    public Item remove(Item item) {
        if (!checkItemInBasket(item)) {
            return null;
        }
        for(Item i : getBasket()) {
            if (i == item) {
                getBasket().remove(i);
                return i;
            }
        }
        return null;
    }

    /**
     * Dont know if NEEDED - LOOK ON USER STORIES WITH MARIT
     * @return
     */
    private boolean checkItemInBasket(Item item) {
        return getBasket().contains(item) ? true : false;
    }

    /**
     * Logic: the current available capacity of an instance of a basket, by subtracting the current size from capacity
     * @return available capacity.
     */
    public int checkCapacity() {
        return getCapacity() - getBasket().size();
    }

    /**
     * Logic: change capacity of a basket to newCapacity. If newCapacity is smaller than amount of items in basket,
     * it will behave like a stack a remove the most recently added items. @Dave mentioned this as good idea to implement.
     * @param newCapacity
     * @return true, unless newCapacity is less than 0
     */
    public boolean changeCapacity(int newCapacity) {
        if (newCapacity > 0) {
            while(getBasket().size() > newCapacity){
                getBasket().remove(getBasket().size()-1);
            }
            setCapacity(newCapacity);
            return true;
        }
        return false;
    }

    /**
     * Logic: Create instance of InventoryManager which in its constructer initializes its stockpile.
     * Do a constant time lookup if @param item is in stock or not.
     * @param item
     * @return Sys.out and false if item is not in stock, else true.
     */
    public boolean checkItemInInventory(Item item) {
        InventoryManager inv = new InventoryManager();
        try {
            if (inv.getInventory().containsKey(item.getSKU())) {
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("We do not stock the requested item!");
            return false;
        }
        return false;
    }

    /**
     * Logic: self-explanatory
     * @return total cost of items currently in basket.
     */
    public double totalCost() {
        double total = 0.0;
        for(Item i : getBasket()) {
            total += i.getPrice();
            if (i.getFilling() != null) {
                total += i.getFilling().getPrice();
            }
        }
        System.out.println(total+ " DKK,-");
        return total;
    }

    public void showContentsBasket() {
        for(Item item : getBasket()) {
            System.out.println(item.toString());
        }
    }

    /**
     * Getters for member variables
     */

    public List<Item> getBasket() {
        return basket;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Setters for member variables
     */

    private void setBasket() {
        this.capacity = 10;
        this.basket = new ArrayList<>(this.capacity);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * -------------------------------
     * EXTENSION 2
     *--------------------------------
     */

    public void printReceipt() {
        InventoryManager inv = new InventoryManager();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        // Iterate through the basket to collect items
        HashMap<String, Integer> frequencyCounter = new HashMap<>();
        for(Item item : getBasket()) {
            if (frequencyCounter.containsKey(item.getSKU())) {
                frequencyCounter.put(item.getSKU(), frequencyCounter.get(item.getSKU()) + 1);
            } else {
                frequencyCounter.put(item.getSKU(), 1);
            }
        }

        // Header of the receipt
        System.out.println("                ~~~ !Bob's Bagels ~~~\n");
        System.out.println("                 " + formattedDateTime + "\n");
        System.out.println("             ____________SIDES___________\n");

        // Print the quantity of each item based on the frequencyCounter above

        for (String key : frequencyCounter.keySet()) {
            System.out.printf("%-15s %-25s %-8d %-15s%n",
                    inv.getInventory().get(key).getVariant(),
                    inv.getInventory().get(key).getName(),
                    frequencyCounter.get(key),
                    String.format("%.2f%s", inv.getInventory().get(key).getPrice() * frequencyCounter.get(key), "DKK,-"));
        }

        System.out.println();
        System.out.println("             __________FILLINGS__________\n");

        frequencyCounter.clear();

        for(Item item : getBasket()) {
            if ((item.getFilling() != null)) {
                if ((frequencyCounter.containsKey(item.getFilling().getSKU()))) {
                    frequencyCounter.put(item.getFilling().getSKU(), frequencyCounter.get(item.getFilling().getSKU()) + 1);
                } else {
                    frequencyCounter.put(item.getFilling().getSKU(), 1);
                }
            } else {
                continue;
            }
        }

        for (String key : frequencyCounter.keySet()) {
            System.out.printf("%-15s %-25s %-8d %-15s%n",
                    inv.getInventory().get(key).getVariant(),
                    inv.getInventory().get(key).getName(),
                    frequencyCounter.get(key),
                    String.format("%.2f%s", inv.getInventory().get(key).getPrice() * frequencyCounter.get(key), "DKK,-"));
        }

        // stolen logic from totalCost()
        double total = 0.0;
        for(Item i : getBasket()) {
            total += i.getPrice();
            if (i.getFilling() != null) {
                total += i.getFilling().getPrice();
            }
        }

        System.out.println("             ____________________________\n");
        System.out.printf("%-15s %-25s %-8s %-15s%n", "Total", "", "", String.format("%.2f%s", total, "DKK,-"));
        System.out.println("___________________________________________________________\n");

        System.out.println("Contact Information:");
        System.out.println("Telephone: +45 ....");
        System.out.println("Opening hours: 08:30 - 16:30");
        System.out.println("___________________________________________________________\n");

    }
}