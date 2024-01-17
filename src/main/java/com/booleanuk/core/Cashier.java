package com.booleanuk.core;

import java.util.Scanner;

public class Cashier {
    Scanner userInput;
    public Cashier(){
        this.userInput = new Scanner(System.in);
    }

    private boolean doChoice(char choice) {
        boolean exit = false;
        switch (choice){
            case 'v':
                break;
            case 'a':
                break;
            case 'r':
                break;
            case 'c':
                break;
            case 'p':
                break;
            case 'm':
                break;
            case 'q':
                break;
            default:
                System.out.println("Invalid choice");
        }
        return exit;
    }
    private void menu(){
        System.out.println("===== Random Student Selector Menu =====");
        System.out.println("v. View products");
        System.out.println("a. Add products");
        System.out.println("r. Remove products");
        System.out.println("c. Show basket");
        System.out.println("p. Pay for basket");
        System.out.println("m. Change capacity of basket");
        System.out.println("q. Exit");
        System.out.println("===========================s============");
        System.out.print("Enter your choice: ");
    }
    public static void main(String[] args){
        Cashier cashier = new Cashier();
        boolean exit = false;
        cashier.menu();
        while (!exit){
            char choice = cashier.userInput.next().charAt(0);
            exit = cashier.doChoice(choice);
        }
    }
}
