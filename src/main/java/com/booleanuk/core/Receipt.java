package com.booleanuk.core;
import com.booleanuk.core.interfaces.MenuCategory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class Receipt {
    private final Order order;
    private final ArrayList<ReceiptItem> receiptItems;

    public Receipt(Order order) {
        this.order = order;
        this.receiptItems = new ArrayList<>();
    }

    public void printReceipt() {
        System.out.println("\t~~~~ Bobs Bagel ~~~~\n");
        System.out.println("\t" + getFormattedDate() + "\n");
        System.out.println("-----------------------------\n");
        fillReceiptItems(this.order.getBasket());

        StringBuilder sb = new StringBuilder();
        receiptItems.forEach(item -> {
            sb
                    .append("  ")
                    .append(item.getVariant())
                    .append("\t").append(item.getName())
                    .append("\t").append(item.getQuantity())
                    .append("\t").append("$").append(item.getPriceSum())
                    .append("\n");
        });
        System.out.println(sb);
        System.out.println("-----------------------------");
        double total = this.order.getTotalCost();
        System.out.println("Total" + "\t".repeat(5) + "$" + String.format("%.02f", total));

        System.out.println("\n");
        System.out.println("\t ".repeat(2) + "Tank you");
        System.out.println("\t ".repeat(1) + "for your order!");
    }

    private void fillReceiptItems(Basket basket) {
        Map<MenuCategory, Map<String, Long>> variantCount = groupByProductAndCount(basket);
        Map<MenuCategory, Double> variantSum = groupByProductAndPrice(basket);
        iterateMapsAndCreateReceiptItems(variantCount, variantSum);
    }

    private Map<MenuCategory, Map<String, Long>> groupByProductAndCount(Basket basket) {
        return basket.getProducts().stream().collect(groupingBy(Product::getVariant,
                groupingBy(Product::getName, Collectors.counting()))
        );
    }

    private Map<MenuCategory, Double> groupByProductAndPrice(Basket basket) {
        return basket.getProducts().stream().collect(groupingBy(Product::getVariant,
                summingDouble(Product::getPrice)));
    }

    private void iterateMapsAndCreateReceiptItems(
            Map<MenuCategory, Map<String, Long>> variantCount,
            Map<MenuCategory, Double> variantSum
    ) {
        variantCount.forEach((variant, productMap) -> productMap.forEach((name, count) -> {
            double priceSum = variantSum.getOrDefault(variant, 0.0);
            createReceiptItemAndAddToList(variant, name, count, priceSum);
        }));
    }

    private void createReceiptItemAndAddToList(MenuCategory variant, String name, Long count, Double sum) {
        receiptItems.add(new ReceiptItem(variant, name, Math.toIntExact(count), sum));
    }

    public String getFormattedDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(df);
    }
}
