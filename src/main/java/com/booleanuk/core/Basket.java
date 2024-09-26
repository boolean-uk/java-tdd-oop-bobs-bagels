package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private ArrayList<ItemInterface> items;
    private Inventory inventory;
    private int basketCapacity;
    private int sumCosts;
    public Map<String, Integer> itemsMap;
    public double totalDiscount;
    public double onionBagelDiscount;
    public double everythingBagelDiscount;
    public double plainBagelDiscount;
    public double coffeeDiscount;


    public Basket(Inventory inventory) {
        this.setItems(new ArrayList<>());
        this.setBasketCapacity(100);
        this.setInventory(inventory);
        this.itemsMap = new HashMap<>();
    }

    public boolean addItem(String sku){
        if (this.getItems().size() < this.getBasketCapacity()) {
            if (getInventory().searchItem(sku) == null){
                System.out.println("Can not add item because this item does not exist!");
                return false;
            } else if(getInventory().searchItem(sku).getSku().equals(sku)) {
                this.getItems().add(getInventory().searchItem(sku.toUpperCase()));
                setSumCosts((int) (getSumCosts() + (this.getInventory().searchItem(sku).getPrice() * 100)));
                return true;
            }
        System.out.println("Basket is full, could not add bagel!");
        }
            return false;
    }

    public boolean removeItem(String sku) {
        boolean itemExistsInBasket = false;
        for (int i = 0; i < this.getItems().size(); i++) {
            if (this.getItems().get(i).getSku().equals(sku)) {
                itemExistsInBasket = true;
                setSumCosts((int) (getSumCosts() - (this.getInventory().searchItem(sku).getPrice() * 100)));
                break;
            }
        }

        if(itemExistsInBasket) {
            this.getItems().remove(this.getInventory().searchItem(sku));
            return true;
        }
            System.out.println("The bagel does not exist in the basket!");
            return false;

    }

    public boolean updateBasketCapacity(int newCapacity) {
        if(newCapacity <= 0) {
            System.out.println("Cannot update basket capacity to zero or less.");
            return false;
        } else if (newCapacity < this.getItems().size()) {
            System.out.println("Cannot update basket capacity to a size smaller than current basket size.");
            return false;
        }
        this.setBasketCapacity(newCapacity);
        return true;
    }

    public double totalCost () {
        int countOnionBagels = 0;
        int numOnionBagelDiscounts = 0;
        int totalOnionBagelDiscount = 0;
        int countPlainBagels = 0;
        int numPlainBagelDiscounts = 0;
        int totalPlainBagelDiscount = 0;
        int remainingPlainBagels = 0;
        int countEverythingBagels = 0;
        int numEverythingBagelDiscounts = 0;
        int totalEverythingBagelDiscount = 0;
        int countBlackCoffee = 0;
        int numBlackCoffeeDiscounts = 0;
        int totalBlackCoffeeDiscount = 0;



        for (int i = 0; i < items.size(); i++) {
            if (this.getItems().get(i).getSku().equals("BGLO")) {
                countOnionBagels++;
                numOnionBagelDiscounts = Math.round((float) countOnionBagels / 6);
                totalOnionBagelDiscount = (int) (numOnionBagelDiscounts * 0.45 * 100);

            } else if (this.getItems().get(i).getSku().equals("BGLP")) {
                countPlainBagels++;
                numPlainBagelDiscounts = Math.round((float) countPlainBagels / 12);
                totalPlainBagelDiscount = (int) (numPlainBagelDiscounts * 0.69 * 100);
            } else if (this.getItems().get(i).getSku().equals("BGLE")) {
                countEverythingBagels++;
                numEverythingBagelDiscounts = Math.round((float) countEverythingBagels / 12);
                totalEverythingBagelDiscount = (int) (numEverythingBagelDiscounts * 0.45 * 100);
            } else if (this.getItems().get(i).getSku().equals("COFB")) {
                countBlackCoffee++;
                if (countPlainBagels % 12 > 0) {
                    remainingPlainBagels = countPlainBagels % 12;
                    numBlackCoffeeDiscounts = Math.min(countBlackCoffee, remainingPlainBagels);
                    totalBlackCoffeeDiscount = (int) (numBlackCoffeeDiscounts * 0.13 * 100);
                }
            }
        }
        totalDiscount = (double)((totalOnionBagelDiscount + totalPlainBagelDiscount + totalEverythingBagelDiscount + totalBlackCoffeeDiscount)/100.0);

        onionBagelDiscount = (double)((totalOnionBagelDiscount)/100.0);
        everythingBagelDiscount = (double)((totalEverythingBagelDiscount)/100.0);
        plainBagelDiscount = (double)((totalPlainBagelDiscount)/100.0);
        coffeeDiscount = (double)((totalBlackCoffeeDiscount)/100.0);


        return (double) ((getSumCosts() - totalOnionBagelDiscount - totalPlainBagelDiscount - totalEverythingBagelDiscount - totalBlackCoffeeDiscount) / 100.0);

    }

    public double itemPrice(String sku) {
        if(this.getInventory().searchItem(sku) == null){
            return 0.00;
        }
        return this.getInventory().searchItem(sku).getPrice();
    }

    public String returnDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dtf.format(dateTime);
    }

    public void printReceipt() {
        for (int i = 0; i < getItems().size(); i++) {
            if (itemsMap.containsKey(getItems().get(i).getSku())) {
                itemsMap.put(getItems().get(i).getSku(), itemsMap.get(getItems().get(i).getSku())+1);
            } else {
                itemsMap.put(getItems().get(i).getSku(), 1);
            }
        }
        double storeTotalCosts = totalCost();

        System.out.println("\n       ~~~ Bob's Bagels ~~~\n");
        System.out.println("        " + returnDateTime() + "\n");
        System.out.println("----------------------------------");
        itemsMap.forEach((key, value) -> {
            System.out.printf("%-20s %-6d $ %.2f \n", inventory.searchItem(key).getVariant() + " " + inventory.searchItem(key).getType(), value, (float)(((itemPrice(key) * value) * 100) / 100.00));
        });
        System.out.println("----------------------------------\n");
        System.out.println("Discounts                   ");
        System.out.println("Everything Bagel          (-$ " + everythingBagelDiscount + ")");
        System.out.println("Plain Bagel               (-$ " + plainBagelDiscount + ")");
        System.out.println("Onion Bagel               (-$ " + onionBagelDiscount + ")");
        System.out.println("Coffee                    (-$ " + coffeeDiscount + ")\n");
        System.out.println("----------------------------------\n");
        System.out.println("Total                       $ " + storeTotalCosts + "\n");
        System.out.println("    You saved a total of $" + totalDiscount + "\n" +
                "           on this shop\n");
        System.out.println("      Thank you for your order!\n");
    }

    public ArrayList<ItemInterface> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemInterface> items) {
        this.items = items;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public void setBasketCapacity(int basketCapacity) {
        this.basketCapacity = basketCapacity;
    }

    public int getSumCosts() {
        return sumCosts;
    }

    public void setSumCosts(int sumCosts) {
        this.sumCosts = sumCosts;
    }

}
