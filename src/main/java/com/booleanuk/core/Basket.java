package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Basket {
    private Integer basketSize;
    private ArrayList<Item> basket = new ArrayList<>();

    public Integer numberOfItemsInBasket(){
        return this.basket.size();
    }

    public String addItemToBasket(Item item){
        this.basket.add(item);
        return item.variant + " " + item.name + " added to basket.";
    }

    public void printBasketContent(){
        for (Item i : basket){
            System.out.println(i.name + " " + i.variant + " " + i.quantity);
        }
    }

    public String removeItemFromBasket(){
        String name = "";
        String variant = "";

        Scanner input = new Scanner(System.in);
        System.out.println("Your basket:");
        printBasketContent();
        System.out.println("\nEnter Which item would you like to remove?");

        try {
            int userInput = Integer.parseInt(input.next());

            if (userInput <= basket.size() & 0 < userInput){
                name = basket.get(userInput-1).name;
                variant = basket.get(userInput-1).variant;
                basket.remove(userInput-1);
                return variant + " " + name + " removed from basket.";
            }

            else {
                return "Invalid option.";
            }

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }



    public Double calculateBasketCost(){
        return 0.0;
    }

    public Boolean basketIsFull(){
        return false;
    }

    public boolean itemInBasket(){
        return false;
    }

    public String changeBasketSize(int newSize){
        return "";
    }
}

