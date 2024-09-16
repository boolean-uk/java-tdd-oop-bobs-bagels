package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Extension {

    public static class ExtendedBasket extends Basket {
        private static Map<Item, DiscountInfo> discounts;

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

                if (discounts.containsKey(item) && quantity >= discounts.get(item).quantity() && quantity <= discounts.get(item).quantity() * 2) {
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
            System.out.println("");
            System.out.println("    ~~~" + " Bob's Bagels " + "~~~    ");
            System.out.println("");
            System.out.println("    " + new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()));
            System.out.println("");
            System.out.println("-----------------------------");
            System.out.println("");

            double total = basket.getTotalPrice();

            for (Map.Entry<Item, Integer> entry : basket.items.entrySet()) {
                Item item = entry.getKey();
                int quantity = entry.getValue();
                double itemTotal = item.getPrice() * quantity;
                System.out.printf("%-10s %3d    \u00A3%6.2f%n", item.getName(), quantity, itemTotal);
            }

            System.out.println("");
            System.out.println("-----------------------------");
            System.out.println("");

            System.out.printf("%-18s \u00A3%6.2f%n", "Total", total);
            System.out.println("        Thank you");
            System.out.println("");
        }

        public static void printReceiptDiscount(ExtendedBasket basket) {
            System.out.println("");
            System.out.println("    ~~~" + " Bob's Bagels " + "~~~    ");
            System.out.println("");
            System.out.println("    " + new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()));
            System.out.println("");
            System.out.println("-----------------------------");
            System.out.println("");

            double total = basket.getTotalPrice();
            double totalSavings = 0;

            for (Map.Entry<Item, Integer> entry : basket.items.entrySet()) {
                Item item = entry.getKey();
                int quantity = entry.getValue();
                double itemTotal = item.getPrice() * quantity;
                double itemSavings = 0;

                if (discounts.containsKey(item) && quantity >= discounts.get(item).quantity() && quantity <= discounts.get(item).quantity() * 2) {
                    double ItemTotalDiscount = discounts.get(item).price() + ((quantity - discounts.get(item).quantity()) * item.getPrice());
                    itemSavings = (itemTotal - ItemTotalDiscount);
                    itemTotal = ItemTotalDiscount;
                    totalSavings += itemSavings;
                }
                System.out.printf("%-14s %3d    \u00A3%6.2f%n", item.getName(), quantity, itemTotal);
                if (itemSavings > 0) {
                    System.out.printf("%20s (-\u00A3%.2f)%n", "", itemSavings);
                }
            }

            System.out.println("");
            System.out.println("-----------------------------");
            System.out.println("");

            System.out.printf("%-21s \u00A3%6.2f%n", "Total", total);
            System.out.printf("%-18s \u00A3%6.2f%n", "You saved a total of ", totalSavings);
            System.out.println("       on this shop");
            System.out.println("        Thank you");
            System.out.println("");
        }

    }

}
