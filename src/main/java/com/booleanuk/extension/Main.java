package com.booleanuk.extension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final int INITIAL_CAPACITY = 15;

    private static void printInventory() {
        Manager.prettyPrintAllBagels();
        System.out.println("=".repeat(28));
        System.out.println("You can choose fillings for " +
                "your bagel from the following list:");
        Manager.prettyPrintAllFillings();
    }

    private static void BobSaysHello() {
        System.out.println("Hello, I'm Bob");
        System.out.println("Welcome to Bob's Bagels!!!");
        System.out.println("=".repeat(28));
    }

    private static List<String> toCapitalizedList(List<String> list) {
        return list.stream()
                .map(String::toLowerCase)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.toList());
    }

    private static void goShopping(Client client) {
        while (true) {
            printInventory();
            System.out.println("Which bagel would you like?");
            Scanner input = new Scanner(System.in);
            String bagelChoice = input.nextLine().toLowerCase();
            bagelChoice = bagelChoice.substring(0, 1).toUpperCase() + bagelChoice.substring(1);

            System.out.println("Which filling would you like?");
            String fillingChoice = input.nextLine();

            List<String> fillingChoices = fillingChoice.isBlank() ? Collections.emptyList() :
                    Arrays.asList(fillingChoice.split("\\s*,\\s*"));
            fillingChoices = toCapitalizedList(fillingChoices);

            fillingChoices.forEach(System.out::println);

            System.out.println("Seems like you want to order " + bagelChoice + " with " + fillingChoices + " filling(s).");
            System.out.println("Is that correct? (y/n)");
            String confirmation = input.nextLine().toLowerCase();
            if (confirmation.equals("n")) {
                continue;
            }
                try {
                    client.orderBagel(bagelChoice, fillingChoices);
                    System.out.println("Do you want to order anything else? (y/n)");
                    String lastChanceToOrder = input.nextLine();
                    if (lastChanceToOrder.equals("n")) {
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    break;
                }
        }
    }

    private static void summarize(Client client, Manager manager) {
        while (true) {
            System.out.println("Items in your basket are: " + client.getBasketContents());
            System.out.println("Total price for items in your basket equals: " + client.getTotalBasketCost() + "£");
            System.out.println("Do you want to delete any item from your basket? (y/n)");
            Scanner delete = new Scanner(System.in);
            String confirmation = delete.nextLine().toLowerCase();
            if (confirmation.equals("y")) {
                System.out.println("Which item do you want to delete? ");
                String itemToDelete = delete.nextLine();
                List<String> items = Arrays.asList(itemToDelete.split("\\s*,\\s*"));
                items = toCapitalizedList(items);
                Bagel bagelToDelete = client.getBagelIfPresent(items.get(0), items.subList(1, items.size()));
                try {
                    client.cancelOrder(bagelToDelete);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (confirmation.equals("n")) {
                break;
            }
        }
        System.out.println("=".repeat(28));
        String receipt = manager.applyDiscountsAndGenerateReceipt(client);
        System.out.println(receipt);
    }


    public static void main(String[] args) {
        Manager bob = new Manager(INITIAL_CAPACITY);
        bob.changeBasketsCapacity(INITIAL_CAPACITY + 1);
        BobSaysHello();
        Client client = new Client();
        goShopping(client);
        summarize(client, bob);
    }
}
