package com.booleanuk.extension;

import com.booleanuk.extension.product.BagelSandwich;
import com.booleanuk.extension.product.Coffee;
import com.booleanuk.extension.product.Product;
import com.booleanuk.extension.product.specialoffer.BagelOffer;
import com.booleanuk.extension.product.specialoffer.BreakfastOffer;
import com.booleanuk.extension.product.specialoffer.SpecialOffer;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptFormatter {
    private static final int RECEIPT_WIDTH = 50;
    private static final String FORMAT = "|%s|\n";
    private static final String TOP_LINE = "_".repeat(RECEIPT_WIDTH + 2) + "\n";
    private static final String HEADER = String.format(FORMAT, center("~~~ Bob's Bagels ~~~"));
    private static final String BLANK_LINE = String.format(FORMAT, " ".repeat(RECEIPT_WIDTH));
    private static final String INNER_LINE = String.format(FORMAT, "-".repeat(RECEIPT_WIDTH));
    private static final String BOTTOM_LINE = "‾".repeat(RECEIPT_WIDTH + 2) + "\n";
    private static final String THANKS = String.format(FORMAT.repeat(2), center("Thank you"), center("For your order!"));

    public static String formatReceipt(List<Product> products, BigDecimal total, BigDecimal saved) {
        return TOP_LINE +
                HEADER +
                BLANK_LINE +
                String.format(FORMAT, generateTimestamp()) +
                BLANK_LINE +
                INNER_LINE +
                BLANK_LINE +
                generateProductSummary(products) +
                BLANK_LINE +
                INNER_LINE +
                String.format(FORMAT, generateTotalVerse(total)) +
                BLANK_LINE +
                String.format(FORMAT, center("You saved a total of $" + saved)) +
                String.format(FORMAT, center("on this shop")) +
                BLANK_LINE +
                THANKS +
                BOTTOM_LINE;
    }

    public static String center(String str) {
        var padding = (RECEIPT_WIDTH - str.length()) / 2;
        var formatStr = " ".repeat(padding + str.length() % 2) + "%s" + " ".repeat(padding);
        return String.format(formatStr, str);
    }

    public static String generateTimestamp() {
        var date = new Date();
        var formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return center(formatter.format(date));
    }

    public static String generateProductSummary(List<Product> products) {
        var leftPadding = Math.round(RECEIPT_WIDTH * 0.7);
        var rightPadding = RECEIPT_WIDTH - leftPadding;
        var rightPaddingLeft = rightPadding / 2 + rightPadding % 2;
        var rightPaddingRight = rightPadding / 2;
        var format = "|%-" + leftPadding + "s%-" + rightPaddingLeft + "s%" + rightPaddingRight + "s|\n";
        var sb = new StringBuilder();
        var fillingAmount = 0;
        for (var productType : Product.Type.values()) {
            switch (productType) {
                case BagelSandwich -> {
                    Map<BagelSandwich.Bagel, Integer> amounts = new HashMap<>();
                    products.stream()
                            .filter(p -> p.getProductType().equals(Product.Type.BagelSandwich))
                            .map(p -> (BagelSandwich) p)
                            .forEach(b -> amounts.merge(b.getBagel(), 1, Integer::sum));
                    for (var e : amounts.entrySet()) {
                        var bagel = e.getKey();
                        var amount = e.getValue();
                        sb.append(String.format(format, " " + bagel.getVariant() + " Bagel", amount, "$" + bagel.getPrice() + " "));
                    }
                    fillingAmount += products.stream()
                            .filter(p -> p instanceof BagelSandwich)
                            .map(p -> (BagelSandwich) p)
                            .map(BagelSandwich::getFillings)
                            .flatMap(Arrays::stream)
                            .count();

                }
                case Coffee -> {
                    Map<Coffee, Integer> amounts = new HashMap<>();
                    products.stream()
                            .filter(p -> p.getProductType().equals(Product.Type.Coffee))
                            .map(p -> (Coffee) p)
                            .forEach(c -> amounts.merge(c, 1, Integer::sum));
                    for (var e : amounts.entrySet()) {
                        var coffee = e.getKey();
                        var amount = e.getValue();
                        sb.append(String.format(format, " " + coffee.getVariant() + " Coffee", amount, "$" + coffee.getPrice() + " "));
                    }
                }
                case SpecialOffer -> {
                    List<SpecialOffer> specialOffers = products.stream()
                            .filter(p -> p.getProductType().equals(Product.Type.SpecialOffer))
                            .map(p -> (SpecialOffer) p)
                            .toList();
                    for (var offerType : SpecialOffer.Type.values()) {
                        switch (offerType) {
                            case BagelOffer -> {
                                Map<BagelOffer.Type, Integer> amounts = new HashMap<>();
                                var bagelOffers = specialOffers.stream()
                                        .filter(o -> o.getOfferType().equals(SpecialOffer.Type.BagelOffer))
                                        .map(o -> (BagelOffer) o)
                                        .toList();
                                bagelOffers.forEach(o -> amounts.merge(o.getBagelOfferType(), 1, Integer::sum));
                                fillingAmount += bagelOffers.stream()
                                        .map(BagelOffer::getBagels)
                                        .flatMap(List::stream)
                                        .map(BagelSandwich::getFillings)
                                        .flatMap(Arrays::stream)
                                        .count();
                                for (var e : amounts.entrySet()) {
                                    var bagelOffer = e.getKey();
                                    var amount = e.getValue();
                                    sb.append(String.format(format, " " + bagelOffer + " Bagel Offer", amount, "$" + bagelOffer.getPrice() + " "));
                                }
                            }
                            case BreakfastOffer -> {
                                var breakfastOffers = specialOffers.stream()
                                        .filter(o -> o.getOfferType().equals(SpecialOffer.Type.BreakfastOffer))
                                        .map(o -> (BreakfastOffer) o)
                                        .toList();
                                var amount = breakfastOffers.size();
                                fillingAmount += breakfastOffers.stream()
                                        .map(BreakfastOffer::getBagel)
                                        .map(BagelSandwich::getFillings)
                                        .flatMap(Arrays::stream)
                                        .count();
                                sb.append(String.format(format, " Breakfast Offer", amount, "$" + BigDecimal.valueOf(1.25) + " "));
                            }
                        }
                    }
                }
                default -> {
                }
            }
        }
        sb.append(String.format(format, " Fillings", fillingAmount, "$" + BagelSandwich.Filling.FILB.getPrice() + " "));

        return sb.toString();
    }

    public static String generateTotalVerse(BigDecimal total) {
        var format = "%-" + RECEIPT_WIDTH / 2 + "s%" + RECEIPT_WIDTH / 2 + "s";
        return String.format(format, " Total", "$" + total + " ");
    }
}
