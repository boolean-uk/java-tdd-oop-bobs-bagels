package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Receipt {
    private LocalDateTime time;
    private Basket basket;
    private int maxLength;

    public Receipt(Basket basket) {
        this.basket = basket;
        time = LocalDateTime.now();
    }

    public String printReceipt() {
        maxLength = calculateMaxRowLength();
        return printHeader() + printProducts() + printFooter();
    }

    private int calculateMaxRowLength() {
        String totalCost = basket.totalCost().toString();
        String totalDiscount = basket.calculateDiscounts().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add).toString();

        int maxProductLength = getProductRows().stream().mapToInt(ProductRow::length).max().orElse(0);
        int maxFooterLength = Math.max(6 + totalCost.length(), 22 + totalDiscount.length());

        return Math.max(Math.max(maxProductLength, maxFooterLength), 28);
    }

    private String printHeader() {
        String title = " ".repeat((maxLength - 20) / 2) + "~~~ Bob's Bagels ~~~";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = " ".repeat((maxLength - 19) / 2) + time.format(formatter);

        String separator = "-".repeat(maxLength);

        return title + "\n\n" +
                formattedTime +
                "\n\n" +
                separator +
                "\n\n";
    }

    private String printFooter() {
        BigDecimal totalCost = basket.totalCost();
        BigDecimal totalDiscount = basket.calculateDiscounts().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        String separator = "-".repeat(maxLength);
        String total = "Total" + " ".repeat(maxLength - 6 - totalCost.toString().length()) + "£" + totalCost;
        String youSaved = " ".repeat((maxLength - 22 - totalDiscount.toString().length()) / 2) +
                "You saved a total of £" + totalDiscount;
        String onThisShop = " ".repeat((maxLength - 12) / 2) + "on this shop";
        String thankYou = " ".repeat((maxLength - 9) / 2) + "Thank you";
        String forYourOrder = " ".repeat((maxLength - 15) / 2) + "for your order!";

        return "\n" + separator + "\n\n" + total
                + "\n\n" + youSaved
                + "\n" + onThisShop
                + "\n\n" + thankYou
                + "\n" + forYourOrder;
    }

    private String printProducts() {
        List<ProductRow> products = getProductRows();
        Map<Product, BigDecimal> discounts = basket.calculateDiscounts();

        return products.stream()
                .map(row -> {
                    int rowLength = row.length();

                    BigDecimal discount = discounts.get(row.product);
                    String withDiscount = "";

                    if(discount != null && discount.compareTo(BigDecimal.ZERO) > 0) {
                        int discountLength = discount.toString().length();
                        withDiscount = String.format("\n%s(-£%s)", " ".repeat(maxLength - discountLength - 3), discount);
                    }

                    row.setSpacing(maxLength - rowLength + 2);
                    return row + withDiscount + "\n";
                })
                .reduce("", String::concat);
    }

    private Map<String, List<Product>> getProducts() {
        return basket.getProducts().stream()
                .flatMap(p -> {
                    if (p.getName().equals("Bagel"))
                        return Stream.concat(Stream.of(p), ((Bagel) p).getFillings().stream());
                    return Stream.of(p);
                })
                .collect(Collectors.groupingBy(Product::getSku, LinkedHashMap::new, Collectors.toList()));
    }

    private List<ProductRow> getProductRows() {
        Map<String, List<Product>> products = getProducts();

        List<ProductRow> rows = new ArrayList<>();
        products.forEach((sku, productList) -> {
            Product product = productList.get(0);

            BigDecimal productPrice = product.getPrice();
            if(product.getName().equals("Bagel")) {
                BigDecimal fillingsPrice = ((Bagel) product).getFillings().stream().map(Filling::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
                productPrice = productPrice.subtract(fillingsPrice);
            }

            rows.add(new ProductRow(
                    product,
                    product.getVariant() + " " + product.getName(),
                    productList.size(),
                    productPrice.multiply(BigDecimal.valueOf(productList.size()))
            ));
        });

        return rows;
    }

    private record ProductRow(Product product, String name, int quantity, BigDecimal totalPrice) {
        private static int spacing;

        public int length() {
            return name.length() + String.valueOf(quantity).length() + totalPrice.toString().length() + 5;
        }

        public String toString() {
            return name + " ".repeat(spacing) + quantity + " ".repeat(quantity > 10 ? 1 : 2) + "£" + totalPrice;
        }

        public void setSpacing(int spacing) {
            ProductRow.spacing = spacing;
        }
    }
}
