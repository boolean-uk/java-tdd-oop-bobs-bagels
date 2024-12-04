package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UI {
    Inventory inventory = Inventory.getInstance();
    Customer customer = new Customer();
    Manager manager = new Manager();
    public void displayReceipt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTimeNow = LocalDateTime.now().format(formatter);

        System.out.println();
        System.out.println("Thank you for your order!");
        System.out.println("Your receipt:");
        System.out.println();
        System.out.println("      ~~~ Bob's Bagels ~~~ \n");
        System.out.println("      " + formattedDateTimeNow + "\n");
        System.out.println("-------------------------------- \n");
        System.out.println(customer.checkBasketWithQuantity());
        System.out.println("--------------------------------");
        System.out.println("Total:                     £" + customer.getTotalCost());
        System.out.println();
        System.out.println("  You saved £" + customer.getTotalDiscount() + " on this order!");
        System.out.println();
        System.out.println("           Thank you");
        System.out.println("        for your order!");
    }
    public void displayLoginMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Who are you?");
        System.out.println("1. Manager");
        System.out.println("2. Customer");
        System.out.println("Press 1 or 2 and press Enter");
        int intInput = sc.nextInt();
        if (intInput==1)
        {
            displayManagerMenu();
        }
        else
            displayCustomerMenu();
    }
    public void displayCustomerMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Show menu");
        System.out.println("2. Show my basket");
        System.out.println("3. Buy items");
        System.out.println("4. Quit");
        System.out.println("Press 1, 2, 3 or 4 and press Enter");
        int customerInput = sc.nextInt();
        if(customerInput == 1)
        {
            displayBagelMenu();
        }
        else if(customerInput == 2)
        {
            displayBasketMenu();
        }
        else if(customerInput == 3)
        {
            displayReceipt();
        }
    }
    public void displayManagerMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Current capacity is: " + Basket.getCapacity());
        System.out.println("Enter new basket capacity:");
        int newCapacity = sc.nextInt();
        if (manager.changeBasketCapacity(newCapacity)){
            System.out.println("New basket capacity is: " + newCapacity + "\n");
            displayLoginMenu();
        } else {
            System.out.println();
            System.out.println("You can't make the basket capacity smaller, customers would loose their orders!");
            System.out.println("Try again if you want to change it differently");
            System.out.println();
            displayLoginMenu();
        }
    }
    public void displayBagelMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(inventory.getAllItems());
        System.out.println("Type the number of an item to add it to your basket");
        int addItem = sc.nextInt();
        while(addItem< 0 || addItem > inventory.getList().size()) {
            System.out.println("This item is not in our menu! Choose something else");
            addItem = sc.nextInt();
        }
        if(customer.addToBasket(inventory.getItemByIndex(addItem)))
        {
            System.out.println("Item added to your basket\n");
        }
        else
            System.out.println("You don't have enough space in your basket");
        displayCustomerMenu();
    }
    public void displayBasketMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(customer.checkBasket());
        System.out.println("Total Cost: £"+customer.getTotalCost());
        System.out.println();
        System.out.println("1. Remove item");
        System.out.println("2. Go back");
        int basketMenu = sc.nextInt();
        if(basketMenu ==1)
        {
            System.out.println();
            System.out.println(customer.checkBasket());
            System.out.println("Type the number of an item you want to remove");
            System.out.println();
            int removeItem = sc.nextInt();
            System.out.println();
            if (customer.removeFromBasket(removeItem))
            {
                System.out.println("You removed item from the basket");
            }
            else System.out.println("There is no such item");
            displayBasketMenu();
        }
        else
            displayCustomerMenu();
    }
}







