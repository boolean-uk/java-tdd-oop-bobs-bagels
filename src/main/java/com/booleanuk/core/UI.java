package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class UI {
    Inventory inventory = Inventory.getInstance();
    Customer customer = new Customer();
    Manager manager = new Manager();
    public void displayRecipe() {
        System.out.println("~~~ Bob's Bagels ~~~ \n");
        System.out.println(LocalDateTime.now() + "\n");
        System.out.println("----------------------------");
        System.out.println(customer.checkBasket());
        System.out.println("----------------------------");
        System.out.println("Total: £" + (double) customer.getTotalCost() / 100);
        System.out.println(" Thank you");
        System.out.println("for your order!");
    }
    public void displayLoginMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Who are you?");
        System.out.println("1. Manager");
        System.out.println("2. Customer");
        System.out.println("Press 1 or 2");
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
        System.out.println("1. Show menu");
        System.out.println("2. Show my basket");
        System.out.println("3. Buy items");
        System.out.println("4. Quit");
        System.out.println("Press 1,2,3,4");
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
            displayRecipe();
        }
        else if(customerInput==4)
            displayLoginMenu();
    }
    public void displayManagerMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Current capacity is: " + Basket.getCapacity());
        System.out.println("Enter new basket capacity:");
        int newCapacity = sc.nextInt();
        if (manager.changeBasketCapacity(newCapacity)){
            System.out.println("New basket capacity is: " + newCapacity);
            displayLoginMenu();
        } else {
            System.out.println("You can't make the basket capacity smaller, customers would loose their orders!");
            System.out.println("Try again if you want to change it differently");
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
        if(customer.addToBasket(inventory.getSkuById(addItem)))
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
        System.out.println(customer.checkBasket());
        System.out.println("\nTotal Cost: "+customer.getTotalCost());
        System.out.println("1. Remove item");
        System.out.println("2. Go back");
        int basketMenu = sc.nextInt();
        if(basketMenu ==1)
        {
            System.out.println(customer.checkBasket());
            System.out.println("Type the number of an item you want to remove");
            int removeItem = sc.nextInt();
            if (customer.removeFromBasket(customer.getSkuByIndex(removeItem)))
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







