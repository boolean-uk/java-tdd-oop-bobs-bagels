package com.booleanuk.core;

import java.util.*;

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

        if (!Menu.itemIsOnTheMenu(item))
        {
            return "This item is not on the menu.";
        }

        if (itemInBasket(item).equals(-1)){
            this.basket.add(item);
        }

        else {
            basket.get(itemInBasket(item)).quantity = basket.get(itemInBasket(item)).quantity + 1;
        }

        return item.variant + " " + item.name + " added to basket.";
    }

    public void printBasketContent(){
        int counter = 1;

        for (Item i : basket){
            if (i instanceof Bagel){
                String price = String.format("%.2f", (((float)i.price * i.quantity) /100));
                System.out.println(counter+ ". " + i.name + " " + i.variant + " " + i.quantity + " " + price +"$");
                formatFillingPrint((Bagel) i);
            }

            else {
                String price = String.format("%.2f", (((float)i.price * i.quantity) /100));
                System.out.println(counter+ " " + i.name + " " + i.variant + " " + i.quantity + " " + price +"$");
            }
            counter++;
        }
    }

    public void formatFillingPrint(Bagel bagel) {
        HashMap<String, Integer> listOfFillings = getListOfFillings(bagel);
        System.out.println("Fillings:");
        listOfFillings.forEach((key, value) -> System.out.println("- " + key + " x" + value));
    }

    public HashMap<String, Integer> getListOfFillings(Bagel bagel){
        HashMap<String, Integer> quantityOfFillings = new HashMap<>();

        for (Filling f : bagel.getFillings()){
            if (quantityOfFillings.containsKey(f.getVariant())) {
                quantityOfFillings.computeIfPresent(f.getVariant(), (k,v) -> v + 1);
            } else {
                quantityOfFillings.put(f.getVariant(), 1);
            }
        }
        return quantityOfFillings;
    }

    public String removeItemFromBasket(){
        String name;
        String variant;
        int quantity;

        Scanner input = new Scanner(System.in);
        System.out.println("\nYour basket:");
        printBasketContent();
        System.out.println("\nChoose item to remove or press 0 to go back.");

        try {
            int userInput = input.nextInt();

            if (userInput <= basket.size() & 0 < userInput){
                name = basket.get(userInput-1).name;
                variant = basket.get(userInput-1).variant;
                quantity = basket.get(userInput-1).quantity;

                if (1 < quantity){
                    basket.get(userInput-1).quantity = basket.get(userInput-1).quantity -1;
                }

                else {
                    basket.remove(userInput-1);
                }

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
            total += i.getPrice() * i.getQuantity();
        }
        return (float) total/100;
    }

    public Integer getBasketSize(){
        return this.basketSize;
    }

    public Boolean basketIsFull(){
        return Objects.equals(basketSize, basket.size());
    }

    public Integer itemInBasket(Item item){
        /*
        If item is in basket, returns index. Else returns -1.
         */
        for (int i = 0; i < numberOfItemsInBasket(); i++){
            if (Objects.equals(item.name, basket.get(i).name) && Objects.equals(item.variant, basket.get(i).variant)){
                if (basket.get(i) instanceof Bagel & item instanceof Bagel){
                    Bagel basketBagel = (Bagel) basket.get(i);
                    Bagel newBagel = (Bagel) item;

                    if (fillingIsIdentical(basketBagel, newBagel)){
                        return i;
                    } else {
                        return -1;
                    }
                }

                else {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean fillingIsIdentical(Bagel b1, Bagel b2){
        ArrayList<String> sortedB1 = new ArrayList<>();
        ArrayList<String> sortedB2 = new ArrayList<>();

        if (b1.getFillings().size() != b2.getFillings().size())
        {
            return false;
        }

        for (Filling f : b1.getFillings()){
            sortedB1.add(f.getVariant());
        }

        for (Filling f : b2.getFillings()){
            sortedB2.add(f.getVariant());
        }

        Collections.sort(sortedB1);
        Collections.sort(sortedB2);

        for (int i = 0; i < sortedB1.size(); i++){
            if (!sortedB1.get(i).equals(sortedB2.get(i))){
                return false;
            }
        }
        return true;
    }

    public boolean changeBasketSize(int newSize){
        if (0 < newSize){
            this.basketSize = newSize;
            System.out.println("Basket size changed successfully.");
            return true;
        }
        System.out.println("Basket size can't be less than 1.");
        return false;
    }
}

