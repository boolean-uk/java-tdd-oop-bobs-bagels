package com.booleanuk.core;

import java.util.*;

import static com.booleanuk.core.Menu.itemIsOnTheMenu;

public class Basket {
    private final HashMap<Item, Integer> basket;
    private int maxBasketSize;
    private int discount;

    public Basket(){
        this.basket = new HashMap<>();
        this.discount = 0;
        this.maxBasketSize = 20;
    }

    public HashMap<Item, Integer> getBasket() { return this.basket; }

    public int getDiscount() { return this.discount; }

    public int getMaxBasketSize() { return this.maxBasketSize; }

    public String addItemToBasket(Item item){
        if (basketIsFull()){
            return "Basket is full.";
        }

        if (!itemIsOnTheMenu(item))
        {
            return "This item is not on the menu.";
        }

        this.basket.merge(item, 1, Integer::sum);

        return item.getName() + " added to basket.";
    }


    public String removeItemFromBasket(){
        Map<Integer, Item> indexedBasket = new HashMap<>();

        // Print the contents of the basket, and indexes each item in indexesBasket.
        printItemsInBasketWithIndex(indexedBasket);

        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        Item item = indexedBasket.get(userInput);

        if (item == null){
            return "Invalid option.";
        }

        int itemQuantity = this.basket.get(item);

        if (1 < itemQuantity){
            this.basket.put(item, this.basket.get(item) - 1);
        } else {
            this.basket.remove(item);
        }

        return item.getName() + " removed from basket.";
    }

    public float calculateBasketCost(){
        int sum = 0;

        for (Map.Entry<Item, Integer> entry : basket.entrySet()){
            sum += entry.getKey().getPrice() * entry.getValue();
        }

        sum = sum - this.discount;
        return (float) sum/100;
    }

    public boolean basketIsFull(){
        return maxBasketSize == basket.size();
    }

    public boolean itemInBasket(Item item){
        return basket.containsKey(item);
    }

    public void changeBasketSize(int newSize){
        if (0 < newSize){
            this.maxBasketSize = newSize;
        }
    }

    public int numberOfItemsInBasket() { return this.basket.size(); }

    private void formatFillingPrint(Bagel bagel) {
        HashMap<String, Integer> listOfFillings = this.getQuantityOfFillings(bagel);
        System.out.println("Fillings:");
        listOfFillings.forEach((key, value) -> System.out.println("- " + key + " x" + value));
    }

    public HashMap<String, Integer> getQuantityOfFillings(Bagel bagel){
        HashMap<String, Integer> quantityOfFillings = new HashMap<>();

        for (Filling f : bagel.getFillings()){
            quantityOfFillings.merge(f.getName(), 1, Integer::sum);
        }

        return quantityOfFillings;
    }



    private void printItemsInBasketWithIndex(Map<Integer, Item> indexedBasket){
        int index = 1;

        System.out.println("\nYour basket:");

        for (Map.Entry<Item, Integer> entry : basket.entrySet())
        {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            // Format the output to float with two decimal places.
            String price = String.format("%.2f", (((float) item.getPrice() * quantity) /100));

            if (item instanceof Bagel){
                System.out.println(index + ". " + item.getName() + " " + quantity + " " + price +"$");
                formatFillingPrint((Bagel) item);
            }

            else {
                System.out.println(index + " " + item.getName() + " " + quantity + " " + price +"$");
            }

            // Add item with index to indexed list, to keep track of the chosen item.
            indexedBasket.put(index, item);
            index++;
        }
        System.out.println("\nChoose item to remove or press 0 to go back.");
    }


    public void calculateDiscount(){
        Map<String, Integer> basketOverview = new HashMap<>();

        quantifyItemsInBasket(basketOverview);

        if (6 <= basketOverview.getOrDefault("Onion Bagel", 0) | 6 <= basketOverview.getOrDefault("Plain Bagel", 0) | 6 <= basketOverview.getOrDefault("Everything Bagel", 0) | 6 <= basketOverview.getOrDefault("Sesame Bagel", 0)){
            addBagelDiscount(basketOverview);
        }

        if (basketOverview.getOrDefault("Black Coffee", 0) != 0 && (basketOverview.getOrDefault("Onion Bagel", 0) != 0 | basketOverview.getOrDefault("Plain Bagel", 0) != 0 | basketOverview.getOrDefault("Everything Bagel", 0) != 0 | basketOverview.getOrDefault("Sesame Bagel", 0) != 0)){
            addCoffeeDiscount(basketOverview);
        }
    }


    public void quantifyItemsInBasket(Map<String, Integer> basketOverview){
        for (Map.Entry<Item, Integer> entry : basket.entrySet()){
            Item item = entry.getKey();
            int quantity = entry.getValue();
            switch (item.getName()) {
                case "Black Coffee": {
                    basketOverview.merge("Black Coffee", quantity, Integer::sum);
                    break;
                }

                case "Onion Bagel": {
                    basketOverview.merge("Onion Bagel", quantity, Integer::sum);
                    break;
                }

                case "Plain Bagel": {
                    basketOverview.merge("Plain Bagel", quantity, Integer::sum);
                    break;
                }

                case "Everything Bagel": {
                    basketOverview.merge("Everything Bagel", quantity, Integer::sum);
                    break;
                }

                case "Sesame Bagel": {
                    basketOverview.merge("Sesame Bagel", quantity, Integer::sum);
                    break;
                }
            }
        }
    }

    private void addBagelDiscount(Map<String, Integer> basketOverview){
        int discount = 0;
        while(true) {
            if (6 <= basketOverview.getOrDefault("Onion Bagel", 0)) {
                if (12 <= basketOverview.get("Onion Bagel")) {
                    basketOverview.merge("Onion Bagel", -12, Integer::sum);
                    discount = discount + 189;
                    continue;
                }
                basketOverview.merge("Onion Bagel", -6, Integer::sum);
                discount = discount + 45;

            } else if (6 <= basketOverview.getOrDefault("Plain Bagel", 0)) {
                if (12 <= basketOverview.get("Plain Bagel")) {
                    basketOverview.merge("Plain Bagel", -12, Integer::sum);
                    discount = discount + 69;
                    continue;
                }
                basketOverview.merge("Plain Bagel", -6, Integer::sum);
                discount = discount - 15;

            } else if (6 <= basketOverview.getOrDefault("Everything Bagel", 0)) {
                if (12 <= basketOverview.get("Everything Bagel")) {
                    basketOverview.merge("Everything Bagel", -12, Integer::sum);
                    discount = discount + 189;
                    continue;
                }
                basketOverview.merge("Everything Bagel", -6, Integer::sum);
                discount = discount + 45;

            } else if (6 <= basketOverview.getOrDefault("Sesame Bagel", 0)) {
                if (12 <= basketOverview.get("Sesame Bagel")) {
                    basketOverview.merge("Sesame Bagel", -12, Integer::sum);
                    discount = discount + 189;
                    continue;
                }
                basketOverview.merge("Sesame Bagel", -12, Integer::sum);
                discount = discount + 45;
            } else {
                break;
            }
        }
        this.discount = this.discount + discount;
    }

    private void addCoffeeDiscount(Map<String, Integer> basketOverview){
        int discount = 0;
        while (basketOverview.getOrDefault("Black Coffee", 0) != 0 && (basketOverview.getOrDefault("Onion Bagel",0) != 0 | basketOverview.getOrDefault("Plain Bagel", 0) != 0 | basketOverview.getOrDefault("Everything Bagel",0) != 0 | basketOverview.getOrDefault("Sesame Bagel",0) != 0)){
            basketOverview.merge("Black Coffee", -1, Integer::sum);

            if (basketOverview.getOrDefault("Onion Bagel",0) != 0){

                basketOverview.merge("Onion Bagel", -1, Integer::sum);
                discount = discount + 23;
                continue;
            }

            else if (basketOverview.getOrDefault("Everything Bagel", 0) != 0){
                basketOverview.merge("Everything Bagel", -1, Integer::sum);
                discount = discount + 23;
                continue;
            }

            else if (basketOverview.getOrDefault("Sesame Bagel",0) != 0){
                basketOverview.merge("Sesame Bagel", -1, Integer::sum);
                discount = discount + 23;
                continue;
            }

            basketOverview.merge("Plain Bagel", -1, Integer::sum);
            discount = discount + 13;
        }
        this.discount = this.discount + discount;
    }

    public void printItemsInBasket(){
        Item item;
        int quantity;

        for (Map.Entry<Item, Integer> entry : basket.entrySet()){
            item = entry.getKey();
            quantity = entry.getValue();

            String price = String.format("%.2f", (((float) item.getPrice() * quantity) /100));
            if (item instanceof Bagel){
                System.out.printf("%-15s %5s %13s%n", item.getName(), quantity, price + "$");
                printFilling((Bagel) item);
            }

            else {
                System.out.printf("%-15s %5s %13s%n", item.getName(), quantity, price + "$");
            }
        }
    }

    private void printFilling(Bagel bagel) {
        HashMap<String, Integer> listOfFillings = getQuantityOfFillings(bagel);
        listOfFillings.forEach((key, value) -> System.out.printf("%-15s %5s%n", "- " + key, value));
    }
}



