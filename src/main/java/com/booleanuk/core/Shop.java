package com.booleanuk.core;

import com.booleanuk.core.Products.*;

import java.util.*;

public class Shop {
    private static final int BASKET_CAPACITY = 30;
    private final Scanner scanner;
    private Basket basket;

    public Shop() {
        this.scanner = new Scanner(System.in);
        this.basket = new Basket(BASKET_CAPACITY);
    }

    public static void main(String[] args) {
        Shop shop = new Shop();


        System.out.println("Welcome to Bob's Bagels!");
        printActions();

        String userInput = shop.scanner.next().toUpperCase();

        while (!userInput.equals("X")) {
            switch (userInput) {
                case "V":
                    System.out.println(shop.basket);
                    break;
                case "M":
                    shop.showInventory();
                    break;
                case "A":
                    shop.addItemToBasket(shop.basket);
                    break;
                case "R":
                    shop.removeFromBasket(shop.basket);
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }

            printActions();
            userInput = shop.scanner.next().toUpperCase();
        }

        System.out.println(shop.basket.printReceipt());
    }

    private static void printActions() {
        System.out.println("-----------------------------------");
        System.out.println("Type A to add an item to your basket");
        System.out.println("Type R to remove an item from your basket");
        System.out.println("Type V to view your basket");
        System.out.println("Type M to see our Menu");
        System.out.println("Type X to ask for your bill and quit");
        System.out.println("-----------------------------------");
    }

    private void showInventory() {
        List<Item> products = basket.getInventory().getInventoryList();
        for (Item product : products) {
            System.out.printf("%-30s €%10s\n", product, product.getPrice());
        }
        System.out.println("Available discounts:");
        System.out.println("12 x any bagels for €3.99!");
        System.out.println("6 x our special bagels for €2.49!");
        System.out.println("Black Coffee and a Plain Bagel for €1.25!");
    }

    private void addItemToBasket(Basket basket) {
        System.out.println("Type B for Bagels");
        System.out.println("Type C for Coffee");
        System.out.println("Type anything else to exit");

        String userInput = scanner.next().toUpperCase();

        if (userInput.equals("B")) {
            List<Item> products = basket.getInventory().getInventoryList();
            listMenuOptions(products, Bagel.class);
            Bagel currentBagel = null;
            int userBagelInput = getIntInput();


            try {
                currentBagel = (Bagel) products.get(userBagelInput);
            } catch (Exception e) {
                System.out.println("Invalid input. Please select a valid Bagel next time.");
                return;
            }
            Bagel newBagel = new Bagel(currentBagel.getSku(), currentBagel.getPrice(), currentBagel.getName(), currentBagel.getVariant());
            newBagel.getFillings().addAll(currentBagel.getFillings());
            addFillingsToBagel(newBagel, products);
            handleAmountSelection(basket, newBagel);

        } else if (userInput.equals("C")) {
            List<Item> products = basket.getInventory().getInventoryList();
            listMenuOptions(products, Coffee.class);

            int userCoffeeInput = getIntInput();
            Coffee coffee = null;
            if (userCoffeeInput >= 0 && userCoffeeInput < products.size()) {
                try {
                    coffee = (Coffee) products.get(userCoffeeInput);

                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    return;
                }
                if (coffee.hasDiscount()) {
                    offerCoffeeDiscount(coffee);
                }
                handleAmountSelection(basket, coffee);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private void addFillingsToBagel(Bagel bagel, List<Item> products) {
        System.out.println("Do you want to add some fillings?");
        System.out.println("Type Y for Yes");
        System.out.println("Type N for No");

        String userWantsFilling = scanner.next().toUpperCase();
        scanner.nextLine();

        while (true) {
            if (userWantsFilling.equals("N")) {
                break;
            } else if (!userWantsFilling.equals("Y")) {
                System.out.println("Invalid input! Please type Y for Yes or N for No.");
            } else {
                listMenuOptions(products, Filling.class);

                int userFillingInput = getIntInput();
                try {
                    bagel.addFilling((Filling) products.get(userFillingInput));
                    System.out.println("Adding " + products.get(userFillingInput) + "!");
                } catch (Exception e) {
                    // Because it can throw both ClassCastException e & IndexOutOfBoundsException i
                    System.out.println("Invalid input. Please select a valid Filling.");
                    continue;
                }
            }

            System.out.println("Do you want to add more fillings?");
            System.out.println("Type Y for Yes");
            System.out.println("Type N for No");
            userWantsFilling = scanner.next().toUpperCase();
            scanner.nextLine();
        }
    }

    private void offerCoffeeDiscount(Coffee coffee) {
        System.out.println("Do you want to get a Plain Bagel with your Coffee for a total of €1.25?");
        System.out.println("Type Y for Yes");
        System.out.println("Type N for No");

        String userWantsBagel = scanner.next().toUpperCase();
        scanner.nextLine();

        if (userWantsBagel.equals("Y")) {
            coffee.setBagelAdded(true);
        }
    }

    private void handleAmountSelection(Basket basket, Item item) {
        System.out.println("How many of this item would you like to order?");

        int amount = getIntInput();

        if (basket.addToBasket(item, amount)) {
            System.out.printf("Added %s %s(s) to your basket!\n", amount, item);
        } else {
            System.out.println("Failed to add this item to your basket.");
        }
    }

    private void removeFromBasket(Basket basket) {
        System.out.println("Which item do you want to remove from your basket?");
        Map<Item, Integer> products = basket.getItemsMap();
        List<Item> items = new ArrayList<>(products.keySet());

        listMenuOptions(items);

        int itemChoice = getIntInput();

        if (itemChoice >= 0 && itemChoice < items.size()) {
            Item itemToRemove = items.get(itemChoice);
            int currentQuantity = products.get(itemToRemove);

            if (currentQuantity > 1) {
                System.out.printf("How many pieces of this item would you like to remove? (1-%d)\n", currentQuantity);

                int amountChoice = getIntInput();

                if (amountChoice >= 1 && amountChoice <= currentQuantity) {
                    basket.removeFromBasket(itemToRemove, amountChoice);
                    System.out.println("Product removed!");
                } else {
                    System.out.println("Invalid choice.");
                }
            } else {
                basket.removeFromBasket(itemToRemove);
                System.out.println("Product removed!");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private int getIntInput() {
        int input = -1;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
        } finally {
            scanner.nextLine();
        }
        return input;
    }

    private void listMenuOptions(List<Item> items, Class<?> itemType) {
        int number = 0;
        for (Item item : items) {
            if (itemType.isInstance(item)) {
                System.out.println("Type \"" + number + "\" for " + String.format("%-30s €%10s",
                        item,
                        item instanceof Coffee ? ((Sellable) item).calculateTotalPriceItem() : item.getPrice()));
            }
            number++;

        }
    }

    private void listMenuOptions(List<Item> items) {
        listMenuOptions(items, Item.class);
    }
}
