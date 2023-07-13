package com.booleanuk.core;

import java.util.Scanner;

public class UI {
    //private static Manager manager;

//    public UI(){
//        manager = new Manager();
//    }

    public static void main(String[] args) {
        //UI ui = new UI();
        Manager manager = new Manager();
        Inventory inventory = Inventory.getInstance();
        Scanner sc = new Scanner(System.in);
        //while (!sc.next().equals("Q")){
            System.out.println("Hello! Who are you?");
            System.out.println("1. Manager");
            System.out.println("2. Customer");
            System.out.println("Press 1 or 2");
            int intInput = sc.nextInt();
            if(intInput == 1){
                System.out.println("Enter new basket capacity:");
                intInput = sc.nextInt();
                if (manager.changeBasketCapacity(intInput)){
                    System.out.println("New basket capacity is: " + intInput);
                } else {
                    System.out.println("You can't make the basket capacity smaller, customers would loose their orders!");
                    System.out.println("Try again if you want to change it differently");
                }
            } else if (intInput == 2) {
                System.out.println("1. Show menu");
                System.out.println("2. Show my basket");
                System.out.println("Press 1 or 2");
                intInput = sc.nextInt();
                if(intInput == 1){
                    System.out.println(inventory.getAllItems());
                    System.out.println("Type the number of an item to add it to your basket");
                    int addItem = sc.nextInt();
                    while(addItem< 0 || addItem > inventory.getList().size()) {
                        System.out.println("This item is not in our menu! Choose something else");
                        addItem = sc.nextInt();
                    }
                    System.out.println("How many? Type the number");
                    addItem = sc.nextInt();


                    
                } else if(intInput == 2){

                }
            }
       // }
    }
}
