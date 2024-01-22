package com.booleanuk.extension;

import com.booleanuk.core.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Receipt{
    private Basket basket;
    public Receipt(){
        this.basket = new Basket(new Inventory(),6);
    }


    public double calculateTotalItemCost(Basket basket, Product item){
        double price = 0;
        for (int i = 0; i < basket.getItemBasket().size(); i++){
            if (basket.getItemBasket().get(i) == item){
                price += item.getPrice();
            }
        }
        return price;
    }

    public void generateReceipt(Basket basket){
        StringBuilder receipt = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double totalBasketValue = basket.calculateTotalCost();
        receipt.append("~~~ Bob's Bagels ~~~\n\n".indent(7));
        receipt.append(dateFormat.format(new Date()).indent(8)).append("\n");
        receipt.append("------------------------------------\n");

        Map<Product, Integer> itemQuantities = new HashMap<>();

        for (Product item : basket.getItemBasket()) {
            itemQuantities.put(item, itemQuantities.getOrDefault(item, 0) + 1);
        }

        for (Map.Entry<Product, Integer> entry : itemQuantities.entrySet()) {
            Product item = entry.getKey();
            int quantity = entry.getValue();
            receipt.append(String.format("%-25s%-5d£%.2f\n", item.getType() + " " + item.getVariant(),
                    quantity, calculateTotalItemCost(basket, item) * quantity));
        }

        receipt.append("\n").append("------------------------------------\n");
        receipt.append(String.format("Total%25s£%.2f\n\n", "", totalBasketValue));

        System.out.println(receipt.toString());
    }

}

/*
Menu:
        Product onion = new Product("Bagel","BGLO","Onion",0.49);
        Product plain = new Product("Bagel","BGLP","Plain",0.39);
        Product everything = new Product("Bagel","BGLE","Everything",0.49);
        Product sesame = new Product("Bagel","BGLS","Sesame",0.49);
        Product black = new Product("Coffee","COFB","Black",0.99);
        Product white = new Product("Coffee","COFW","White",1.19);
        Product cappuccino = new Product("Coffee","COFC","Cappuccino",1.29);
        Product latte = new Product("Coffee","COFL","Latte",1.29);
        Product bacon = new Product("Filling","FILB","Bacon", 0.12);
        Product egg = new Product("Filling","FILE","Egg", 0.12);
        Product cheese = new Product("Filling","FILC","Cheese", 0.12);
        Product creamCheese = new Product("Filling","FILX","Cream cheese", 0.12);
        Product smokedSalmon = new Product("Filling","FILS","Smoked salmon", 0.12);
        Product ham = new Product("Filling","FILH","Ham", 0.12);
        inventory.addToMenu(onion, 20);
        inventory.addToMenu(plain, 40);
        inventory.addToMenu(everything, 20);
        inventory.addToMenu(sesame, 30);
        inventory.addToMenu(black, 50);
        inventory.addToMenu(white, 30);
        inventory.addToMenu(cappuccino, 40);
        inventory.addToMenu(latte, 40);
        inventory.addToMenu(bacon, 60);
        inventory.addToMenu(egg, 60);
        inventory.addToMenu(cheese, 40);
        inventory.addToMenu(creamCheese, 25);
        inventory.addToMenu(smokedSalmon, 15);
        inventory.addToMenu(ham, 40);
         */
