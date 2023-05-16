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
            basket.getTotalWithDiscountBasket();
            int quantityAfterDiscount = basket.getItemQuantityAfterDiscount().get(i);



            System.out.print(item.getClass() == Bagel.class ? item.getVariant() + " " + "bagel": "Coffee");
            System.out.print( "        " + quantity + "  " + "£");
            if (item.getClass() == Bagel.class) {
                if (quantityAfterDiscount == quantity) {
                    System.out.print((double)Math.round(item.getPrice() * quantity * 100) / 100);
                } else {
                    double price = 0.0;
                    while (quantity >= 6) {
                        if (quantity >= 12) {
                            price += 3.99 * quantity / 12;
                            quantity -= (int)(quantity / 12) * 12;
                        } else {
                            price += 2.49 * (int)(quantity / 6);
                            quantity -= (quantity / 6) * 6;
                        }
                    }
                    price += quantity * item.getPrice();
                    System.out.print((double)Math.round(price * 100) / 100);
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
