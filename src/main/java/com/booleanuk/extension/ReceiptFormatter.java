package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptFormatter {
    private static final int RECEIPT_WIDTH = 30;
    private static final String HEADER = center("~~~ Bob's Bagels ~~~");
    private static final String BLANK_LINE = " ".repeat(RECEIPT_WIDTH);
    private static final String LINE = "-".repeat(RECEIPT_WIDTH);
    private static final String THANKS = String.format("%s\n%s", center("Thank you"), center("For your order!"));

    public static String formatReceipt(List<Product> products, BigDecimal total, BigDecimal saved) {
        var sb = new StringBuilder();
        sb
                .append(HEADER)
                .append(BLANK_LINE)
                .append(generateTimestamp())
                .append(BLANK_LINE)
                .append(LINE)
                .append(BLANK_LINE);
        products.forEach(p -> sb.append(generateProductVerse(p)));
        sb
                .append(BLANK_LINE)
                .append(LINE)
                .append(generateTotalVerse(total))
                .append(BLANK_LINE)
                .append(generateSavingsInformation(saved))
                .append(THANKS);

        return sb.toString();
    }

    private static String center(String str) {
        var padding = (RECEIPT_WIDTH - str.length()) / 2;
        var formatStr = "%" + padding + "s%s%" + padding + "s";
        return String.format(formatStr, str);
    }

    private static String generateTimestamp() {
        // TODO
        return "";
    }

    private static String generateProductVerse(Product product) {
        // TODO
        return "";
    }

    private static String generateTotalVerse(BigDecimal total) {
        // TODO
        return "";
    }

    private static String generateSavingsInformation(BigDecimal savedAmount) {
        // TODO
        return "";
    }
}
