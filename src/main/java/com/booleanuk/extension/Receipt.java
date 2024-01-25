package com.booleanuk.extension;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Receipt {

    private String timeCreated;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Map<String, Integer> allProducts;
    private Map<String, Integer> discountedProducts;
    private Map<Product, Integer> printMap;
    private List<Discount> listOfDiscounts;
    private double total;

    public Receipt(Map<String, Integer> allProducts,Map<String, Integer> discountedProducts,
                   List<Discount> listOfDiscounts, double total){
        this.allProducts = allProducts;
        this.listOfDiscounts = listOfDiscounts;
        this.discountedProducts = discountedProducts;
        this.printMap = subtractMaps();
        this.total = total;
        this.timeCreated = java.time.LocalDateTime.now().format(formatter);
    }

    @Override
    public String toString() {

        String formattedDateTime = timeCreated;

        StringBuilder result = new StringBuilder();
        result.append("~~~ Bob's Bagels ~~~\n\n");
        result.append(formattedDateTime).append("\n");
        result.append("----------------------------\n");

        for(Discount discount: listOfDiscounts) {
            result.append(String.format("%-20s %2d  £%.2f\n", discount.getName(), discount.getAmount(), discount.getPrice()));
        }

        for(Map.Entry<Product, Integer> entry: printMap.entrySet()) {
            result.append(String.format("%-20s %2d  £%.2f\n", (entry.getKey().getVariant() + " " + entry.getKey().getName()), entry.getValue(), (entry.getKey().getPrice()) * entry.getValue()));
        }

        result.append("----------------------------\n");
        result.append(String.format("Total                 £%.2f\n\n", total));
        result.append("        Thank you\n");
        result.append("      for your order!");

        return result.toString();
    }

    public String receiptextension3() {

        String formattedDateTime = timeCreated;

        StringBuilder result = new StringBuilder();
        result.append("~~~ Bob's Bagels ~~~\n\n");
        result.append(formattedDateTime).append("\n");
        result.append("----------------------------\n");

        for(Discount discount: listOfDiscounts) {
            result.append(String.format("%-20s %2d  £%.2f -(£%.2f)\n", discount.getName(), discount.getAmount(), discount.getPrice(), discount.getDiscountAmount()));
        }

        for(Map.Entry<Product, Integer> entry: printMap.entrySet()) {
            result.append(String.format("%-20s %2d  £%.2f\n", (entry.getKey().getVariant() + " " + entry.getKey().getName()), entry.getValue(), (entry.getKey().getPrice()) * entry.getValue()));
        }

        result.append("----------------------------\n");
        result.append(String.format("Total                 £%.2f\n\n", total));
        result.append("        Thank you\n");
        result.append("      for your order!");

        return result.toString();
    }
    private Map<Product, Integer> subtractMaps() {
        HashMap<Product, Integer> printMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : this.discountedProducts.entrySet()) {
            String key = entry.getKey();
            int amountDisc = entry.getValue();
            if (this.allProducts.containsKey(key)){
                int amountAllProd = this.allProducts.get(key);
                printMap.put(Inventory.getProductById(key), (amountAllProd-amountDisc));
            }
        }

        printMap.entrySet().removeIf(entry -> entry.getValue() == 0);

        return printMap;
    }
}
