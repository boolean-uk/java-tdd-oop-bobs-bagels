
package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        int calculatedTotalPrice = 0;
        int totalDiscount = 0;
        double totalPrice = order.getTotalPrice();

        for (HashMap.Entry<String, Integer> entry : order.getBasket().entrySet()) {
            String sku = entry.getKey();
            int quantity = entry.getValue();
            Product product = store.getProductBySKU(sku);
            if (product instanceof Bagels) {
                calculatedTotalPrice += (int) (product.getPrice() * quantity * 100);
                System.out.printf("%-16s %5d %15s %n",
                        product.getVariant() + " Bagel",
                        quantity,
                        "$" + String.format("%.2f", product.getPrice() * quantity));

                ((Bagels) product).printFillings();
            }
            if (product instanceof Coffee) {
                calculatedTotalPrice += (int) (product.getPrice() * quantity * 100);
                System.out.printf("%-16s %5d %15s %n",
                        product.getVariant() + " Coffee",
                        quantity,
                        "$" + String.format("%.2f", product.getPrice() * quantity));

            }

        }

        totalDiscount = (int) ( calculatedTotalPrice - totalPrice * 100);

        System.out.println("\n----------------------------");
        System.out.println("Discounts");
        if(!getCoffeeDiscounts().isEmpty()) {
            System.out.println(getCoffeeDiscounts());
            System.out.println("                               " + "(-$"+order.coffeeAndBagelDiscount()+")");
        }
        if(!getBagelTwelveDiscount().isEmpty()) {
            System.out.println(getBagelTwelveDiscount());
            System.out.println("                               " + "(-$"+order.bigDiscount()+")");
        }
        if(!getBagelSixDiscount().isEmpty()) {
            System.out.println(getBagelSixDiscount());
            System.out.println("                               " + "(-$"+order.smallDiscount()+")");
        }
        System.out.println("\n----------------------------");
        if(calculatedTotalPrice - totalPrice * 100 > 0) {
            System.out.println("You saved:                       $" + totalDiscount / 100.0);
        }

        System.out.println("Total                            " + "$" + totalPrice);
        System.out.println("\n       Thank you");
        System.out.println("     for your order!");
    }

    private String getCoffeeDiscounts() {
        int counter = order.getPricesBagelsSize();
        int bigDiscountCount = 0;

        bigDiscountCount = counter / 12;
        if (bigDiscountCount > 0) {
            counter -= 12 * bigDiscountCount;
        }

        int smallest = Math.min(counter, order.getPricesCoffeesSize());

        if(smallest != 0) {
            return "Coffee & Bagel" + "       " +smallest + "           $" + 1.25;
        }

        return "";
    }

    private String getBagelTwelveDiscount() {
        int counter = order.getPricesBagelsSize();
        int bigDiscountCount = 0;

        bigDiscountCount = counter / 12;

        if(bigDiscountCount != 0) {
            return "Bagel x12" + "            " + bigDiscountCount + "           $" + 3.99;
        }

        return "";
    }

    private String getBagelSixDiscount() {
        int counter = order.getPricesBagelsSize();
        int bigDiscountCount = 0;
        int smallDiscountCount = 0;

        bigDiscountCount = counter / 12;
        if (bigDiscountCount > 0) {
            counter -= 12 * bigDiscountCount;
        }
        smallDiscountCount = counter / 6;

        if(smallDiscountCount != 0) {
            return "Bagel x6" + "             " + smallDiscountCount + "           $" + 2.49;
        }

        return "";
    }






}
