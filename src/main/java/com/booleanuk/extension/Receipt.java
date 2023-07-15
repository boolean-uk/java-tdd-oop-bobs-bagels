package com.booleanuk.extension;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
public class Receipt {
        private static final String LINE_SEPARATOR = "----------------------------";
        private static final String THANK_YOU_MESSAGE = "         Thank you\n      for your order!";

        private final Order order;

        public Receipt(Order order) {
            this.order = order;
        }

        public void printReceipt() {
            printStoreName();
            printCurrentDateTime();
            System.out.println(LINE_SEPARATOR);
            printItems();
            System.out.println(LINE_SEPARATOR);
            printTotalPrice();
            printThankYouMessage();
        }

        private void printStoreName() {
            System.out.println("    ~~~ Bob's Bagels ~~~");
        }

        private void printCurrentDateTime() {
            LocalDateTime now = LocalDateTime.now();
            String formattedDateTime = now.format(DateTimeFormatter.ofPattern("    yyyy-MM-dd HH:mm:ss"));
            System.out.println(formattedDateTime);
        }

        private void printItems() {
            Map<Item, Integer> items = order.getItems();

            for (Map.Entry<Item, Integer> entry : items.entrySet()) {
                Item item = entry.getKey();
                int quantity = entry.getValue();
                BigDecimal price = item.getPrice().multiply(BigDecimal.valueOf(quantity));
                if ((entry.getKey().getName()).equals("Bagel")) {
                    String line = String.format("%-6s%-9s %2d %7s", entry.getKey().getName(),
                            entry.getKey().getVariant(), quantity, formatPrice(price));
                    System.out.println(line);
                } else {
                    String line = String.format("%-7s%-8s %2d %7s", entry.getKey().getName(),
                            entry.getKey().getVariant(), quantity, formatPrice(price));
                    System.out.println(line);
                }
            }
        }

        private void printTotalPrice() {
            BigDecimal totalPrice = order.getTotalPriceAfterDiscount();
            System.out.printf("Total%23s%n", formatPrice(totalPrice));
        }

        private void printThankYouMessage() {
            System.out.println();
            System.out.println(THANK_YOU_MESSAGE);
        }

        private String formatPrice(BigDecimal price) {
            return "£" + price.setScale(2).toString();
        }
}
