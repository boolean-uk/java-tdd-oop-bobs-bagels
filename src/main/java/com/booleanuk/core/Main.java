package com.booleanuk.core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        UI ui = new UI();
        Manager manager = new Manager();
        Inventory inventory = Inventory.getInstance();
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        //while (!sc.next().equals("Q")){
        System.out.println("Hello! Who are you?");
        System.out.println("1. Manager");
        System.out.println("2. Customer");
        System.out.println("Press 1 or 2");
        int intInput = sc.nextInt();
        if(intInput == 1){
            System.out.println("Current capacity is: " + Basket.getCapacity());
            System.out.println("Enter new basket capacity:");
            intInput = sc.nextInt();
            if (manager.changeBasketCapacity(intInput)){
                System.out.println("New basket capacity is: " + intInput);
            } else {
                System.out.println("You can't make the basket capacity smaller, customers would loose their orders!");
                System.out.println("Try again if you want to change it differently");
            }
        } else if (intInput == 2) {
            int customerInput=0;
            while(customerInput!=4)
            {
                System.out.println("1. Show menu");
                System.out.println("2. Show my basket");
                System.out.println("3. Buy items");
                System.out.println("4. Quit");
                System.out.println("Press 1,2,3,4");
                customerInput = sc.nextInt();
                if(customerInput == 1){
                    System.out.println(inventory.getAllItems());
                    System.out.println("Type the number of an item to add it to your basket");
                    int addItem = sc.nextInt();
                    while(addItem< 0 || addItem > inventory.getList().size()) {
                        System.out.println("This item is not in our menu! Choose something else");
                        addItem = sc.nextInt();
                    }
                    if(customer.addToBasket(inventory.getSkuById(addItem)))
                    {
                        System.out.println("Item added to your basket\n\n");
                    }
                    else
                        System.out.println("You don't have enough space in your basket");
                    System.out.println("Current basket capacity is: " + Basket.getCapacity());
                    System.out.println();
                    System.out.println();

                }
                else if(intInput == 2)
                {
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
                    }
                    //else come back to main menu
                }
                else if (intInput==3)
                {
                    System.out.println(ui.printRecipe(customer));
                }
            }
        }
    }
}
