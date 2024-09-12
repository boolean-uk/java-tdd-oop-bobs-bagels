package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Product;
import com.booleanuk.core.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasketExtension extends Basket {

    public BasketExtension(User user){
        super(user);
    }

    public BasketExtension(){
        this(null);
    }

    public boolean checkout(){
        if (items > 0){
            applyDiscount();
            printReceipt();
            emptyBasket();
            return true;
        } else {
            System.out.println("Your cart is empty.");
            return false;
        }
    }

    public boolean applyDiscount(){
        boolean discount = false;

        for (Product product : products.keySet()){
            if (products.get(product) == 12 && product instanceof Bagel){
                ((Bagel) product).setPrice(3.99/12);
                discount = true;
            } else if (products.get(product) == 6 && product instanceof Bagel){
                ((Bagel) product).setPrice(2.49/6);
                discount = true;
            }
        }
        return discount;
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
            System.out.printf(" %-25s %-3s %2s\u00A3%.2f %n", item, products.get(product), "", product.getPrice()*products.get(product));

            if (product.hasDiscount()){
                double moneySaved = ((Bagel) product).getMoneySaved();
                System.out.printf("%-31s(-\u00A3%.2f) %n", "", moneySaved * products.get(product));
            }
        }

        System.out.printf("%n--------------------------------------%n");
        System.out.printf(" %-29s \u00A3%5.2f %n%n", "Total", totalCost());

        System.out.printf(" %23s %n", "Thank you");
        System.out.printf(" %26s %n%n", "for your order!");
    }
}
