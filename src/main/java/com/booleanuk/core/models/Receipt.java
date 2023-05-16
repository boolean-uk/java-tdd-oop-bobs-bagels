package com.booleanuk.core.models;

import com.booleanuk.core.Basket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    Basket basket;
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Receipt(Basket basket) {
        this.basket = basket;
    }

    public void printReceipt() {
        System.out.println();
        System.out.println("    ~~~ Bob's Bagels ~~~");
        System.out.println();
        System.out.println("    " + dateTime.format(formatter));
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();


        //TODO Loop through items
        for (int i = 0; i < basket.getBasket().size(); i++) {
            Item item = basket.getBasket().get(i);
            int quantity = basket.getBasketQuantity().get(i);

            System.out.print(item.getClass() == Bagel.class ? item.getVariant() + " " + "bagel": "Coffee");
            System.out.print( "        " + quantity + "  " + "£");
            if (item.getClass() == Bagel.class) {
                if (quantity == 12) {
                    System.out.print("3.99");
                } else if (quantity == 6 ) {
                    System.out.print("2.49");
                } else {
                    System.out.print(item.getPrice() * quantity);
                }
            }


        }

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Total                 £"+basket.getTotalWithDiscountBasket());
        System.out.println();
        System.out.println("        Thank you");
        System.out.println("      for your order!");
        System.out.println();

    }


}
