
package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Receipt {
    private final Store store;
    private final Order order;


    public Receipt(Order order, Store store) {
        this.order = order;
        this.store = store;

    }

    public void printReceipt() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = date.format(dateFormat);
        System.out.println("\n~~~ Bob's Bagels ~~~");
        System.out.println(formattedDate);
        System.out.println("\n----------------------------");
        int totalPrice = 0;
        int totalDiscount = 0;

        for (HashMap.Entry<String, Integer> entry : order.getBasket().entrySet()) {
            String sku = entry.getKey();
            int quantity = entry.getValue();
            Product product = store.getProductBySKU(sku);
            if (product instanceof Bagels) {
                totalPrice += (int) (product.getPrice() * quantity * 100);
                System.out.printf("%-16s %5d %15s %n",
                        product.getVariant() + " Bagel",
                        quantity,
                        "$" + String.format("%.2f", product.getPrice() * quantity));

                ((Bagels) product).printFillings();
            }
            if (product instanceof Coffee) {
                totalPrice += (int) (product.getPrice() * quantity * 100);
                System.out.printf("%-16s %5d %15s %n",
                        product.getVariant() + " Coffee",
                        quantity,
                        "$" + String.format("%.2f", product.getPrice() * quantity));

            }

        }
        totalDiscount = (int) ( totalPrice - order.getTotalPrice() * 100);

        System.out.println("\n----------------------------");
        System.out.println("Discounts");
        System.out.println(order.getCoffeeDiscounts());
        System.out.println(order.getBagelTwelveDiscount());
        System.out.println(order.getBagelSixDiscount());
        System.out.println("\n----------------------------");
        if(totalPrice - order.getTotalPrice() * 100 > 0) {
            System.out.println("You saved:                       $" + totalDiscount / 100.0);
        }

        System.out.println("Total                            " + "$" + order.getTotalPrice());
        System.out.println("\n       Thank you");
        System.out.println("     for your order!");
    }






}
