package com.booleanuk.extension;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class ReceiptGenerator {

    public String generateReceipt(Receipt receipt) {

        String initialLine = "~".repeat(3) + " Bob's Bagels " + "~".repeat(3);
        String emptyLine = "\n\n";
        String dataLine = getDateLine(receipt);
        String totalSavingsLine = "You saved a total of £%.2f".formatted(receipt.getTotalDiscount());

        int lineLength = getLineLength(receipt, totalSavingsLine.length(), 6);

        String totalLine = getTotalLine(receipt, lineLength);
        String dashLine = "-".repeat(lineLength);

        StringBuilder receiptBuilder = new StringBuilder();

        generateTopOfTheReceipt(
                receiptBuilder,
                initialLine,
                emptyLine,
                dataLine,
                dashLine,
                lineLength
        );

        generateProductCostsAndDiscountsLines(receiptBuilder, receipt, lineLength);

        generateBottomOfTheReceipt(
                receiptBuilder,
                emptyLine,
                dashLine,
                totalLine,
                totalSavingsLine,
                lineLength
        );

        return receiptBuilder.toString();
    }

    private void generateTopOfTheReceipt(
            StringBuilder receiptBuilder,
            String initialLine,
            String emptyLine,
            String dataLine,
            String dashLine,
            int lineLength
    ) {
        receiptBuilder.append(centerText(initialLine, lineLength))
                .append(emptyLine)
                .append(centerText(dataLine, lineLength))
                .append(emptyLine)
                .append(dashLine)
                .append(emptyLine);
    }

    private void generateBottomOfTheReceipt(
            StringBuilder receiptBuilder,
            String emptyLine,
            String dashLine,
            String totalLine,
            String totalSavingsLine,
            int lineLength
    ) {
        receiptBuilder.append('\n')
                .append(dashLine)
                .append('\n')
                .append(totalLine)
                .append(emptyLine)
                .append(centerText(totalSavingsLine, lineLength))
                .append('\n')
                .append(centerText("on this shop", lineLength))
                .append(emptyLine)
                .append(centerText("Thank you", lineLength))
                .append('\n')
                .append(centerText("for your order!", lineLength));
    }

    private String getDateLine(Receipt receipt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm:ss");
        return receipt.getCreationDate().format(formatter);
    }

    private String getTotalLine(Receipt receipt, int lineLength) {
        String totalCostFormatted = "£%.2f".formatted(receipt.getTotalCost());
        int totalAlign = lineLength - totalCostFormatted.length();
        String totalLineFormat = "Total %" + totalAlign + "s";
        return totalLineFormat.formatted(totalCostFormatted);
    }

    private void generateProductCostsAndDiscountsLines(
            StringBuilder receiptBuilder,
            Receipt receipt,
            int lineLength
    ) {
        for (String productSKU: receipt.getCosts().keySet()) {
            generateProductCostLine(receiptBuilder, receipt, productSKU, lineLength);
            generateDiscountLine(receiptBuilder, receipt, productSKU, lineLength);
        }
    }

    private void generateProductCostLine(
            StringBuilder receiptBuilder,
            Receipt receipt,
            String productSKU,
            int lineLength
    ) {
        receiptBuilder.append(getProductCostLine(receipt, productSKU, lineLength));
    }

    private String getProductCostLine(
            Receipt receipt,
            String productSKU,
            int lineLength
    ) {
        String productDescriptionFormat =
                "%-" +
                getLengthOfTheLongestProductDescription(receipt) +
                "s";
        String productQuantityFormat =
                "%-" +
                getLengthOfTheLongestProductQuantityString(receipt) +
                "s";

        int space = lineLength - getLengthOfTheLongestProductLine(receipt);
        String firstPartFormat =
                productDescriptionFormat +
                " ".repeat(space / 2) +
                productQuantityFormat;

        String firstPart = firstPartFormat.formatted(
                Inventory.getProductDescription(productSKU),
                receipt.getQuantity(productSKU)
        );

        int costAlign = lineLength - firstPart.length();
        String productCostFormat = "%" + costAlign + "s\n";

        String costFormatted = "£%.2f".formatted(receipt.getCost(productSKU));

        return firstPart + productCostFormat.formatted(costFormatted);
    }

    private int getLengthOfTheLongestProductQuantityString(Receipt receipt) {
        return receipt.getAmounts()
                .values()
                .stream()
                .map(Object::toString)
                .map(String::length)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);
    }
    private int getLengthOfTheLongestProductDescription(Receipt receipt) {
        return receipt.getCosts()
                .keySet()
                .stream()
                .map(Inventory::getProductDescription)
                .map(String::length)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);
    }

    private void generateDiscountLine(
            StringBuilder receiptBuilder,
            Receipt receipt,
            String productSKU,
            int lineLength
    ) {
        if (!receipt.getDiscounts().containsKey(productSKU))
            return;

        receiptBuilder.append(getDiscountLine(receipt, productSKU, lineLength));
    }

    private String getDiscountLine(
            Receipt receipt,
            String productSKU,
            int lineLength
    ) {
        String discountFormatted = "(-£%.2f)".formatted(receipt.getDiscount(productSKU));
        String discountLineFormat = "%" + (lineLength + 1) + "s\n";
        return discountLineFormat.formatted(discountFormatted);
    }

    private String centerText(String text, int lineLength) {
        int spaceSize = lineLength - text.length();
        int prefixSize = spaceSize / 2;
        int suffixSize = (spaceSize + 1) / 2;

        return lineLength > text.length()
                ? " ".repeat(prefixSize) + text + " ".repeat(suffixSize)
                : text;
    }

    private int getLineLength(Receipt receipt, int longestDefaultLine, int additionalLength) {
        return Integer.max(getLengthOfTheLongestProductLine(receipt), longestDefaultLine) + additionalLength;
    }

    private int getLengthOfTheLongestProductLine(Receipt receipt) {
        int longestLineLength = 0;

        for (String productSKU: receipt.getCosts().keySet()) {
            int lineLength = 0;

            lineLength += Inventory.getProductDescription(productSKU).length();

            lineLength += receipt.getAmounts().get(productSKU).toString().length();
            lineLength += receipt.getCosts().get(productSKU).toString().length();

            longestLineLength = Integer.max(longestLineLength, lineLength);
        }

        return longestLineLength;
    }
}
