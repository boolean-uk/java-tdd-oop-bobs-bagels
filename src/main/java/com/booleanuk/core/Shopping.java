package com.booleanuk.core;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.products.Coffee;
import com.booleanuk.core.products.Filling;
import com.booleanuk.core.products.Product;
import com.booleanuk.core.receipt.Receipt;
import com.booleanuk.core.Inventory.Inventory;
import com.booleanuk.core.user.Customer;

import java.util.List;
import java.util.Scanner;

public class Shopping {
    static StringBuilder combinedMenuText = new StringBuilder();
    Basket basket = new Basket();
    Customer customer;
    Inventory inventory = Inventory.getInstance();
    String customerName = "";
    String separator = "=".repeat(50);
    String showInventory = "Type I to see Bob's inventory";
    String addToBasket = "Type A to add to Basket";
    String removeFromBasket = "Type R to remove from Basket";
    String showBasket = "Type S to show the basket ";

    public static void main(String[] args) throws InterruptedException {

        Shopping shopping = new Shopping();
        combinedMenuText.append("Type B to start your shopping\n").append("Type M to see menu\n").append("Type I to see Bob's inventory\n").append("=".repeat(50));
        System.out.println("Welcome to Bob's Bagels!");
        System.out.println(shopping.separator);
        System.out.println(combinedMenuText);
        System.out.println("X-to quit, anything else will continue");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        userInput = userInput.toLowerCase();
        System.out.println(shopping.separator);
        while (!userInput.equals("x")) {
            switch (userInput) {
                case "b" -> {
                    if (shopping.customerName.equals("")) {
                        System.out.println("Please insert your name :)");
                        shopping.customerName = scanner.next();
                        shopping.customer = new Customer(shopping.customerName);
                        System.out.println(shopping.separator);
                        System.out.println("Enjoy your shopping " + shopping.customerName + "!");
                        System.out.println(shopping.addToBasket);
                        System.out.println(shopping.showBasket);
                        System.out.println(shopping.showInventory);
                        System.out.println("X-to end your shopping");
                    } else {
                        System.out.println("You already have your basket!");
                    }
                }
                case "m" -> {
                    System.out.println(combinedMenuText);
                    System.out.println(shopping.showBasket);
                    System.out.println(shopping.addToBasket);
                    System.out.println(shopping.removeFromBasket);
                    System.out.println("X-to end your shopping");
                }
                case "i" -> {
                    List<Product> products = shopping.inventory.getAvailableProducts();
                    for (Product product : products) {
                        System.out.printf("%-25s %10s%n", product, "$" + product.getPrice());
                    }
                    System.out.println(shopping.separator);
                    System.out.println(combinedMenuText);
                    System.out.println("X-to end your shopping");
                }
                case "a" -> {
                    if (!shopping.customerName.equals("")) {
                        shopping.addItemToBasket();
                    } else {
                        System.out.println("You need to start shopping first!");
                        System.out.println(combinedMenuText);
                    }
                    System.out.println(shopping.showBasket);
                    System.out.println(shopping.addToBasket);
                    System.out.println(shopping.removeFromBasket);
                    System.out.println("X-to end your shopping");
                }
                case "r" -> {
                    if (!shopping.customerName.equals("") || shopping.basket.getProductsAmount() == 0) {
                        shopping.removeFromBasket();
                        System.out.println(shopping.showBasket);
                        System.out.println(shopping.addToBasket);
                        System.out.println(shopping.removeFromBasket);
                        System.out.println("X-to end your shopping");
                    } else {
                        System.out.println("You can't remove products from an empty basket!");
                        System.out.println(shopping.addToBasket);
                        System.out.println(combinedMenuText);
                        System.out.println("X-to end your shopping");
                    }
                }
                case "s" -> {
                    if (!shopping.customerName.equals("") || shopping.basket.getProductsAmount() != 0) {
                        System.out.println("Your basket capacity:" + shopping.basket.getCapacity());
                        System.out.println("Your products:");
                        if (shopping.basket.getProducts().size() == 0) {
                            System.out.println("Your basket is empty!");
                        }
                        System.out.println(shopping.basket.listBasket());
                        System.out.println(combinedMenuText);
                        System.out.println(shopping.showBasket);
                        System.out.println(shopping.addToBasket);
                        System.out.println(shopping.removeFromBasket);
                    } else {
                        System.out.println("Your basket is empty!");
                        System.out.println(combinedMenuText);
                        System.out.println(shopping.addToBasket);
                    }
                }
            }
            userInput = scanner.next();
            userInput = userInput.toLowerCase();
            System.out.println(shopping.separator);
        }
        System.out.println(shopping.separator);
        System.out.println("\t\t\t  Preparing your receipt");
        System.out.println(shopping.separator);
        Thread.sleep(2000);
        System.out.println(shopping.separator);
        System.out.println();
        Receipt receipt = new Receipt();
        System.out.println(receipt.printReceipt(shopping.basket));
    }

    public void addItemToBasket() {
        System.out.println("Type what u want to add");
        System.out.println("B - For Bagels");
        System.out.println("C - For Coffee");
        System.out.println("Anything else will exit");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        userInput = userInput.toLowerCase();
        switch (userInput) {
            case "b" -> {
                List<Product> products = this.inventory.getAvailableProducts();
                int number = 0;
                for (Product product : products) {
                    if (product instanceof Bagel)
                        System.out.println("Type \"" + number + "\" for " + String.format("%-25s %10s", product, "$" + product.getPrice()));
                    number++;
                }
                int userBagelInput = scanner.nextInt();
                try {
                    System.out.println("You've chosen " + products.get(userBagelInput) + "!");
                    Bagel usersChoice = (Bagel) products.get(userBagelInput);
                    System.out.println("Do you want some fillings?");
                    System.out.println("Y - if yes");
                    System.out.println("N - if no");
                    String userWantFillingInput = scanner.next();
                    userWantFillingInput = userWantFillingInput.toLowerCase();

                    switch (userWantFillingInput) {
                        case "y" -> {
                            number = 0;
                            for (Product product : products) {
                                if (product instanceof Filling)
                                    System.out.println("Type \"" + number + "\" for " + String.format("%-27s %9s", product, "$" + product.getPrice()));
                                number++;
                            }
                            int userFillingInput = scanner.nextInt();
                            System.out.println("Adding " + usersChoice + " with " + products.get(userFillingInput) + "!");
                            usersChoice.addFilling((Filling) products.get(userFillingInput));
                            basket.addProduct(usersChoice);
                        }
                        case "n" -> {
                            basket.addProduct(usersChoice);
                            System.out.println("You don't want filling - maybe next time");
                        }
                    }
                } catch (Exception wrongDataProvided) {
                    System.out.println("Enter proper data next time!");
                }
            }
            case "c" -> {
                List<Product> products = this.inventory.getAvailableProducts();
                int number = 0;
                for (Product product : products) {
                    if (product instanceof Coffee)
                        System.out.println("Type \"" + number + "\" for " + String.format("%-25s %10s", product, "$" + product.getPrice()));
                    number++;
                }
                try {
                    int userCoffeeInput = scanner.nextInt();
                    System.out.println("You've chosen " + products.get(userCoffeeInput) + "!");
                    Coffee usersChoice = (Coffee) products.get(userCoffeeInput);
                    this.basket.addProduct(usersChoice);
                    System.out.println("Added Coffee to your basket!");
                } catch (Exception wrongDataProvided) {
                    System.out.println("Enter proper data next time!");
                }
            }
        }
    }

    public void removeFromBasket() {
        System.out.println("Type what u want to remove");
        System.out.println(separator);
        int number = 0;
        List<Product> products = basket.getProducts();
        for (Product product : products) {
            System.out.println("Type \"" + number + "\" for " + String.format("%-25s %10s", product, "$" + product.getPrice()));
            number++;
        }
        System.out.println(separator);
        Scanner scanner = new Scanner(System.in);

        try {
            int userInput = scanner.nextInt();
            basket.removeProduct(products.get(userInput));
            System.out.println("Product removed!");
        } catch (Exception wrongDataProvided) {
            System.out.println("Enter proper data next time!");
        }

    }
}