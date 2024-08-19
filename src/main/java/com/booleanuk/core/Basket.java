package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Basket {
    private Integer basketSize;
    private ArrayList<Item> basket = new ArrayList<>();

    public Integer numberOfItemsInBasket(){
        return this.basket.size();
    }

    public String addItemToBasket(Item item){
        if (basketIsFull()){
            return "Basket is full.";
        }

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

    public Float calculateBasketCost(){
        int total = 0;
        for (Item i : basket){
            total += i.getPrice();
        }
        return (float) total/100;
    }

    public Integer getBasketSize(){
        return this.basketSize;
    }

    public Boolean basketIsFull(){
        return Objects.equals(basketSize, basket.size());
    }

    public boolean itemInBasket(){
        return false;
    }

    public boolean changeBasketSize(int newSize){
        if (0 < newSize){
            this.basketSize = newSize;
            System.out.println("Basket size changed successfully");
            return true;
        }
        System.out.println("Basket size can't be less than 1.");
        return false;
    }
}

