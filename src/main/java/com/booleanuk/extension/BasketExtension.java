package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Product;
import com.booleanuk.core.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class BasketExtension extends Basket {

    public BasketExtension(User user) {
        super(user);
    }

    public void checkout(){
        if (items > 0){
            printReceipt();
            products = new HashMap<>();
            items = 0;
        } else {
            System.out.println("Your cart is empty.");
        }
    }

    private void printReceipt(){
        LocalDateTime paid = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String paidString = paid.format(formatter);

        System.out.printf("%n           ~~~ Bob's Bagels ~~~          %n%n");
        System.out.printf("%30s %n%n", paidString);
        System.out.printf("--------------------------------------%n%n");

        for (Product product : products.keySet()){
            String item = product.getName() + " " + product.getType();
            System.out.printf(" %-25s %-3s \u00A3%5.2f %n", item, products.get(product), product.getPrice());
        }

        System.out.printf("%n--------------------------------------%n");
        System.out.printf(" %-29s \u00A3%5.2f %n%n", "Total", totalCost());

        System.out.printf(" %23s %n", "Thank you");
        System.out.printf(" %26s %n%n", "for your order!");
    }
}
