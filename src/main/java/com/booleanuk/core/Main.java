package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        // Items in the Inventory
        System.out.println("Inventory items: ");
        for (InventoryItem item : inventory.getInventoryItem()) {
            System.out.println(item);

        }

        Basket basket = new Basket(inventory, 2);

        String coffeeToFind = "COFB";
        String SKUToFind = "BGLO";

        for (InventoryItem itemBagel : inventory.getInventoryItem()) {
            if (itemBagel.getSKU().equals(SKUToFind)) {
                basket.addToBasket(itemBagel);
                break;
            }
        }

         for (InventoryItem itemCoffee : inventory.getInventoryItem()) {
             if (itemCoffee.getSKU().equals(coffeeToFind)) {
                 basket.addToBasket(itemCoffee);
                 break;
             }
         }

                 double totalCost = basket.getTotalCost();
                 System.out.println("Total costs: " + totalCost);


                 basket.addToBasketSize(1);


        for (InventoryItem itemCoffee : inventory.getInventoryItem()) {
            if (itemCoffee.getSKU().equals(coffeeToFind)) {
                basket.removeFromBasket(itemCoffee);
                break;
            }
        }

        double totalCosts = basket.getTotalCost();
        System.out.println("Total costs: " + totalCosts);

    }
}




