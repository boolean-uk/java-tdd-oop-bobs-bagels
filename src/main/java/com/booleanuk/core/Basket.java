package com.booleanuk.core;

import java.util.*;

import static com.booleanuk.core.Menu.itemIsOnTheMenu;

public class Basket {
    private Integer basketSize;
    private final ArrayList<Item> basket;
    private int discount;

    public Basket(){
        this.basket = new ArrayList<>();
        this.discount = 0;
        this.basketSize = 20;
    }

    public ArrayList<Item> getBasket(){
        return this.basket;
    }

    public int getDiscount(){
        return this.discount;
    }

    public Integer numberOfItemsInBasket(){
        return this.basket.size();

    }

    public String addItemToBasket(Item item){
        if (basketIsFull()){
            return "Basket is full.";
        }

        if (!itemIsOnTheMenu(item))
        {
            return "This item is not on the menu.";
        }

        if (itemInBasket(item).equals(-1)){
            this.basket.add(item);
        }

        else {
            this.basket.get(itemInBasket(item)).quantity = this.basket.get(itemInBasket(item)).quantity + 1;
        }

        return item.variant + " " + item.name + " added to basket.";
    }

    public void printBasketContent(){
        int counter = 1;

        for (Item i : basket){
            String price = String.format("%.2f", (((float)i.price * i.quantity) /100));
            if (i instanceof Bagel){
                System.out.println(counter+ ". " + i.name + " " + i.variant + " " + i.quantity + " " + price +"$");
                formatFillingPrint((Bagel) i);
            }

            else {
                System.out.println(counter+ " " + i.name + " " + i.variant + " " + i.quantity + " " + price +"$");
            }
            counter++;
        }
    }

    public void formatFillingPrint(Bagel bagel) {
        HashMap<String, Integer> listOfFillings = this.getQuantityOfFillings(bagel);
        System.out.println("Fillings:");
        listOfFillings.forEach((key, value) -> System.out.println("- " + key + " x" + value));
    }

    public HashMap<String, Integer> getQuantityOfFillings(Bagel bagel){
        HashMap<String, Integer> quantityOfFillings = new HashMap<>();

        for (Filling f : bagel.getFillings()){
            quantityOfFillings.merge(f.getVariant(), 1, Integer::sum);
        }

        return quantityOfFillings;
    }

    public String removeItemFromBasket(){
        String itemName;
        String itemVariant;
        int itemQuantity;

        Scanner input = new Scanner(System.in);
        System.out.println("\nYour basket:");
        printBasketContent();
        System.out.println("\nChoose item to remove or press 0 to go back.");

        int userInput = input.nextInt();

        if (userInput <= basket.size() & 0 < userInput){
            Item item = basket.get(userInput-1);

            itemName = item.name;
            itemVariant = item.variant;
            itemQuantity = item.quantity;

            if (1 < itemQuantity){
                basket.get(userInput-1).quantity = itemQuantity -1;
            }

            else {
                basket.remove(userInput-1);
            }

            return itemVariant + " " + itemName + " removed from basket.";
        }

        else {
            return "Invalid option.";
        }
    }

    public Float calculateBasketCost(){
        int total = 0;
        for (Item i : basket){
            total += i.getPrice() * i.getQuantity();
        }

        total = total - this.discount;
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
        /*
        Checks if the filling of two bagels are identical.
        This helps in presenting a better organized receipt.
         */

        if (b1.getFillings().size() != b2.getFillings().size())
        {
            return false;
        }

        ArrayList<String> sortedB1 = new ArrayList<>();
        ArrayList<String> sortedB2 = new ArrayList<>();

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

    public void changeBasketSize(int newSize){
        if (0 < newSize){
            this.basketSize = newSize;
            System.out.println("Basket size changed successfully.");
        }
        System.out.println("Basket size can't be less than 1.");
    }


    public void calculateDiscount(){
        Map<String, Integer> basketOverview = new HashMap<>();

        quantifyItemsInBasket(basketOverview);

        if (6 <= basketOverview.getOrDefault("Onion", 0) | 6 <= basketOverview.getOrDefault("Plain", 0) | 6 <= basketOverview.getOrDefault("Everything", 0) | 6 <= basketOverview.getOrDefault("Sesame", 0)){
            addBagelDiscount(basketOverview);
        }

        if (basketOverview.getOrDefault("Black", 0) != 0 && (basketOverview.getOrDefault("Onion", 0) != 0 | basketOverview.getOrDefault("Plain", 0) != 0 | basketOverview.getOrDefault("Everything", 0) != 0 | basketOverview.getOrDefault("Sesame", 0) != 0)){
            addCoffeeDiscount(basketOverview);
        }
    }

    public void quantifyItemsInBasket(Map<String, Integer> basketOverview){
        for (Item i : this.basket){
            switch (i.variant){
                case "Black":{
                    basketOverview.merge("Black", i.getQuantity(), Integer::sum);
                    break;
                }

                case "Onion":{
                    basketOverview.merge("Onion", i.getQuantity(), Integer::sum);
                    break;
                }

                case "Plain":{
                    basketOverview.merge("Plain", i.getQuantity(), Integer::sum);
                    break;
                }

                case "Everything":{
                    basketOverview.merge("Everything", i.getQuantity(), Integer::sum);
                    break;
                }

                case "Sesame":{
                    basketOverview.merge("Sesame", i.getQuantity(), Integer::sum);
                    break;
                }
            }
        }

    }

    public void addBagelDiscount(Map<String, Integer> basketOverview){
        int discount = 0;
        while(true) {
            if (6 <= basketOverview.getOrDefault("Onion", 0)) {
                if (12 <= basketOverview.get("Onion")) {
                    basketOverview.merge("Onion", -12, Integer::sum);
                    discount = discount + 189;
                    continue;
                }
                basketOverview.merge("Onion", -6, Integer::sum);
                discount = discount + 45;

            } else if (6 <= basketOverview.getOrDefault("Plain", 0)) {
                if (12 <= basketOverview.get("Plain")) {
                    basketOverview.merge("Plain", -12, Integer::sum);
                    discount = discount + 69;
                    continue;
                }
                basketOverview.merge("Plain", -6, Integer::sum);
                discount = discount - 15;

            } else if (6 <= basketOverview.getOrDefault("Everything", 0)) {
                if (12 <= basketOverview.get("Everything")) {
                    basketOverview.merge("Everything", -12, Integer::sum);
                    discount = discount + 189;
                    continue;
                }
                basketOverview.merge("Everything", -6, Integer::sum);
                discount = discount + 45;

            } else if (6 <= basketOverview.getOrDefault("Sesame", 0)) {
                if (12 <= basketOverview.get("Sesame")) {
                    basketOverview.merge("Sesame", -12, Integer::sum);
                    discount = discount + 189;
                    continue;
                }
                basketOverview.merge("Sesame", -12, Integer::sum);
                discount = discount + 45;
            } else {
                break;
            }
        }
        this.discount = this.discount + discount;
    }

    public void addCoffeeDiscount(Map<String, Integer> basketOverview){
        int discount = 0;
        while (basketOverview.getOrDefault("Black", 0) != 0 && (basketOverview.getOrDefault("Onion",0) != 0 | basketOverview.getOrDefault("Plain", 0) != 0 | basketOverview.getOrDefault("Everything",0) != 0 | basketOverview.getOrDefault("Sesame",0) != 0)){
            basketOverview.merge("Black", -1, Integer::sum);

            if (basketOverview.getOrDefault("Onion",0) != 0){

                basketOverview.merge("Onion", -1, Integer::sum);
                discount = discount + 23;
                continue;
            }

            else if (basketOverview.getOrDefault("Everything", 0) != 0){
                basketOverview.merge("Everything", -1, Integer::sum);
                discount = discount + 23;
                continue;
            }

            else if (basketOverview.getOrDefault("Sesame",0) != 0){
                basketOverview.merge("Sesame", -1, Integer::sum);
                discount = discount + 23;
                continue;
            }

            basketOverview.merge("Plain", -1, Integer::sum);
            discount = discount + 13;
        }
        this.discount = this.discount + discount;
    }
}



