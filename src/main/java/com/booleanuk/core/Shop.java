package com.booleanuk.core;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.Coffee;
import com.booleanuk.core.Products.Filling;
import com.booleanuk.core.Products.Item;

import java.util.*;

public class Shop {
    String showInventory = "Type M to see our Menu";
    String addToBasket = "Type A to add an item to your basket";
    String removeFromBasket = "Type R to remove an item from your basket";
    String showBasket = "Type V to view your basket ";
    String exitTheShop = "Type X to quit";
    String clientName = "";
    static final int basketCapacity = 30;
    Inventory inventory;

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.inventory = Inventory.getInstance();

        Basket basket = new Basket(shop.inventory, basketCapacity);

        Scanner scanner = new Scanner(System.in);
        //class att


        System.out.println("Welcome to Bob's Bagels!");
        System.out.println("Please tell us your name..");
        shop.clientName = scanner.next();
        printActions(shop);
        String userInput = scanner.next().toUpperCase();

        while (!userInput.equals("X")) {


            if (userInput.equals("V")) {

                System.out.println("Your basket's capacity is " + basket.getCapacity() + ".\n");
                System.out.println("Your products:");
                if (basket.getBasketSize() == 0) {
                    System.out.println("You have no items in your basket yet.");
                } else {
                    System.out.println(basket);
                    System.out.println("-----------------------------------");
                    printActions(shop);
                }


            } else if (userInput.equals("M")) {
                List<Item> products = shop.inventory.getInventoryList();
                for (Item product : products) {
                    System.out.printf("%-30s %10s\n", product, "EUR " + product.getPrice());
                }
                System.out.println("-----------------------------------");
                printActions(shop);
            } else if (userInput.equals("A")) {
                shop.addItemToBasket(basket);
            } else if (userInput.equals("R")) {
                if (basket.getBasketSize() != 0) {
                    shop.removeFromBasket(basket);
                    System.out.println("-----------------------------------");
                    printActions(shop);

                } else {
                    System.out.println("Your basket is empty! Nothing to remove.");

                }
                System.out.println("-----------------------------------");
                printActions(shop);
            }
            userInput = scanner.next().toUpperCase();
        }
// else if (userInput.equals("X")) => add logic for receipts, discounts etc. HERE


    }

    private static void printActions(Shop shop) {
        System.out.println("-----------------------------------");
        System.out.println(shop.addToBasket);
        System.out.println(shop.removeFromBasket);
        System.out.println(shop.showBasket);
        System.out.println(shop.showInventory);
        System.out.println("-----------------------------------");

    }

    public void addItemToBasket(Basket basket) {
        System.out.println("Type B for Bagels");
        System.out.println("Type C for Coffee");
        System.out.println("Type anything else to exit");
        Scanner scanner = new Scanner(System.in);
        //scanner should be class member?
        String userInput = scanner.next().toUpperCase();

        if (userInput.equals("B")) {
            List<Item> products = this.inventory.getInventoryList();

            int number = 0;
            for (Item product : products) {
                if (product instanceof Bagel)
                    System.out.println("Type \"" + number + "\" for " + String.format("%-30s %10s", product, "EUR " + product.getPrice()));
                number++;
            }
            int userBagelInput = scanner.nextInt();
            Bagel currentBagel = (Bagel) products.get(userBagelInput);
            System.out.println("Do you want to add some fillings?");
            System.out.println("Type Y for Yes");
            System.out.println("Type N for No");

            String userWantsFilling = scanner.next().toUpperCase();
            while (!userWantsFilling.equals("N")) {
                number = 0;
                for (Item product : products) {
                    if (product instanceof Filling)
                        System.out.println("Type \"" + number + "\" for " + String.format("%-30s %10s", product, "EUR" + product.getPrice()));
                    number++;
                }
                int userFillingInput = scanner.nextInt();
                System.out.println("Adding " + products.get(userFillingInput) + " filling!");
                currentBagel.addFilling((Filling) products.get(userFillingInput));
                System.out.println("Do you want to add more fillings?");
                System.out.println("Type Y for Yes");
                System.out.println("Type N for No");
                userWantsFilling = scanner.next().toUpperCase();
                scanner.nextLine();

            }
            System.out.println("How many of this bagel would you like to order?");
            int amount = Integer.parseInt(scanner.nextLine());
            basket.addToBasket(currentBagel, amount);
//            System.out.println("Adding " + products.get(userFillingInput) + " filling!");
//            Adding %s Bagel with fillings.join(", ") fillings!
        } else if (userInput.equals("C")) {
            List<Item> products = this.inventory.getInventoryList();
            int number = 0;
            for (Item product : products) {
                if (product instanceof Coffee)
                    System.out.println("Type \"" + number + "\" for " + String.format("%-30s %10s", product, "EUR " + product.getPrice()));
                number++;
            }
            try {
                int userCoffeeInput = scanner.nextInt();
                Coffee coffee = (Coffee) products.get(userCoffeeInput);
                System.out.println("How many coffees would you like to order?");
                int amount = Integer.parseInt(scanner.nextLine());
                basket.addToBasket(coffee, amount);
                System.out.printf("Added %s Coffee to your basket!",coffee.getVariant());
            } catch (Exception invalidInputProvided) {
                System.out.println("Invalid input!");
            }
        }

    }

    public void removeFromBasket(Basket basket) {
        System.out.println("Which item do you want to remove from your basket?");
        int number = 0;
        Map<Item, Integer> products = basket.getItemsMap();
        List<Item> items = new ArrayList<>(products.keySet());

        for (Item item : items) {
            System.out.println("Type \"" + number + "\" for " + String.format("%-30s %10s", item, "EUR " + item.getPrice()));
            number++;
        }

        Scanner scanner = new Scanner(System.in);
        try {
            int itemChoice = scanner.nextInt();
            if (itemChoice >= 0 && itemChoice < items.size()) {
                Item itemToRemove = items.get(itemChoice);
                int currentQuantity = products.get(itemToRemove);

                if (currentQuantity > 1) {
                    System.out.printf("How many pieces of this item would you like to remove? (1-%d)\n", currentQuantity);
                    int amountChoice = scanner.nextInt();
                    basket.removeFromBasket(itemToRemove, amountChoice);
                } else {
                    basket.removeFromBasket(itemToRemove);
                }

                System.out.println("Product removed!");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number.");
        }
    }
}


