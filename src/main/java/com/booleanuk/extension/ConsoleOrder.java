package com.booleanuk.extension;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class ConsoleOrder {
    Basket basket;
    public ConsoleOrder() {
        basket = new Basket();
    }
    public void run() {
        System.out.println("Hello, welcome to Bob's Bagels!");
        Scanner input = new Scanner(System.in);
        for(;;) {
            System.out.println("""
                    What can I do for you?
                    bagel - order bagel
                    coffee - order coffee
                    receipt - generate receipt""");
            String choice = input.next();
            if(choice.equalsIgnoreCase("bagel")){
                if(basket.isFull())
                    System.out.println("Too many items in your basket.\n");
                Bagel bagel = Bagel.order();
                if (bagel != null)
                    basket.addItem(bagel);
            }
            else if(choice.equalsIgnoreCase("coffee")) {
                if(basket.isFull())
                    System.out.println("Too many items in your basket.\n");
                CoffeeType coffeeType = CoffeeType.order();
                if (coffeeType != null)
                    basket.addItem(coffeeType);
            }
            else if(choice.equalsIgnoreCase("receipt")) {
                System.out.println("Here's your receipt:");
                System.out.println("-".repeat(31));
                System.out.println(basket.getReceipt());
                break;
            }
        }
    }
}

