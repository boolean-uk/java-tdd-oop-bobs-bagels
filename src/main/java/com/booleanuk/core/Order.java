package com.booleanuk.core;

import java.util.Scanner;

import static com.booleanuk.core.Menu.*;

public class Order {
    private final Basket basket;

    public Order (Basket basket){
        this.basket = basket;
    }

    public void order() {
        Scanner input = new Scanner(System.in);

        int customerOrManager = customerOrManager(input);

        if (customerOrManager == 1) {
            customerMenu(input);
        }

        else if (customerOrManager == 2){
            managerMenu(input);
        }
    }

    private int customerOrManager(Scanner input){
        System.out.println("""
                Howdy!
                Welcome to Bob's bagels. Select one of the following options
                
                1. I am a customer
                
                2. I am a manager
                
                3. Exit
                """);
        while (true)
        {
            int customerOrManager = input.nextInt();

            if (customerOrManager == 1){
                return 1;
            }

            else if (customerOrManager == 2){
                return 2;
            }

            else if (customerOrManager == 3){
                return 3;
            }

            else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void customerMenu(Scanner input){
        System.out.println("Welcome to Bob's bagels. Please select one of the following options:");
        while (true){
            System.out.println("\n1. Add item to your basket.");
            System.out.println("2. Remove item from your basket.");
            System.out.println("3. View your basket.");
            System.out.println("4. Proceed to checkout.\n");

            switch (input.nextInt()){
                case 1: {
                    printMenu();
                    System.out.println("Select item to add to your basket, or press 0 to go back.\n");

                    Item chosenItem = selectItemFromMenu();

                    if (chosenItem == null)
                        break;

                    if (chosenItem instanceof Bagel bagel){
                        printFillingMenu();
                        System.out.println("Select fillings to add to your bagel, or press 0 to continue.");
                        bagel.addFillingsToBagel(input);
                        this.basket.addItemToBasket(bagel);
                        break;
                    }

                    this.basket.addItemToBasket(chosenItem);
                    break;
                }
                case 2: {
                    this.basket.removeItemFromBasket();
                    break;
                }
                case 3: {
                    this.basket.printItemsInBasket();
                    break;
                }
                case 4: {
                    this.basket.calculateDiscount();
                    Receipt receipt = new Receipt(this.basket);
                    receipt.printReceipt();
                    return;
                }
            }
        }
    }

    private void managerMenu(Scanner input){
        System.out.println("You have only one option:");
        while (true){
            System.out.println("1. Change basket size.\n");

            if (input.nextInt() == 1){
                    System.out.println("Enter new size of the basket.");
                    int newBasketSize = input.nextInt();
                    this.basket.changeBasketSize(newBasketSize);
                    break;
            }
            else {
                    System.out.println("That is not a viable option, is it?");
            }
        }
    }
}
