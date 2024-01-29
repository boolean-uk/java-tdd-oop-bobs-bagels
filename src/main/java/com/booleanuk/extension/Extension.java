package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Extension {

    public static class ExtendedBasket extends Basket {
        private final Map<Item, DiscountInfo> discounts;
        public ExtendedBasket(int capacity) {
            super(capacity);
            discounts = new HashMap<>();
        }

        public void setDiscount(Item item, int quantity, double price) {
            discounts.put(item, new DiscountInfo(quantity, price));
        }

        private record DiscountInfo(int quantity, double price) {
        }

        @Override
        public double getTotalPrice() {
            double totalPrice = 0;

            for (Map.Entry<Item, Integer> entry : items.entrySet()) {
                Item item = entry.getKey();
                int quantity = entry.getValue();

                if (discounts.containsKey(item) &&  quantity >= discounts.get(item).quantity() && quantity <= discounts.get(item).quantity()*2 ) {
                    DiscountInfo discountInfo = discounts.get(item);
                    int discountedQuantity = Math.min(quantity, discountInfo.quantity());
                    int remainingQuantity = quantity - discountedQuantity;
                    double discountedPrice = discountInfo.price();
                    double regularPrice = item.getPrice();
                    double regularTotal = regularPrice * remainingQuantity;
                    totalPrice += discountedPrice + regularTotal;
                } else {
                    double regularTotal = item.getPrice() * quantity;
                    totalPrice += regularTotal;
                }
            }

            return totalPrice;
        }

        public static void printReceipt(ExtendedBasket basket) {
            System.out.println("    ~~~" + " Bob's Bagels " + "~~~    ");
            System.out.println("");
            System.out.println("    " + new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()));
            System.out.println("");
            System.out.println("------------------------------");
            System.out.println("");

            double total = 0;

            for (Map.Entry<Item, Integer> entry : basket.items.entrySet()) {
                Item item = entry.getKey();
                int quantity = entry.getValue();
                double itemTotal = item.getPrice() * quantity;

                System.out.printf("     " + "%-5s %d    " + "\u00A3%.2f%n", item.getName(), quantity, itemTotal);
                total += itemTotal;
            }

            System.out.println("");
            System.out.println("");
            System.out.println("----------------------------");
            System.out.println("");
            System.out.printf("Total                 £%.2f%n", total);
            System.out.println("        Thank you");
            System.out.println("      for your order!");
        }


    }

}
