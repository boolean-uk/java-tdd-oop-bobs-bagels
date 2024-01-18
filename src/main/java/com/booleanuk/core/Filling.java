package com.booleanuk.core;

import java.util.ArrayList;

public class Filling extends Item {
    private String fillingType;
    private static ArrayList<Filling> allFillings = new ArrayList<>();

    public Filling(String fillingType, double fillingCost) {
        super(fillingType, fillingCost);
        allFillings.add(this);
    }

    public static ArrayList<Filling> getAllFillings() {
        return allFillings;
    }

    public static String getAllFillingNames() {
        StringBuilder fillingNames = new StringBuilder();
        for (Filling filling : allFillings) {
            fillingNames.append(filling.getItemName()).append(", ");
        }

        if (!allFillings.isEmpty()) {
            fillingNames.delete(fillingNames.length() - 2, fillingNames.length());
        }

        return fillingNames.toString();
    }

    public static String getAllFillingPrices() {
        StringBuilder fillingNamesAndPrices = new StringBuilder();
        for (Filling filling : allFillings) {
            fillingNamesAndPrices.append(filling.getItemName()).append(" price: ").append(filling.getPrice()).append(", ");
        }

        if (!allFillings.isEmpty()) {
            fillingNamesAndPrices.delete(fillingNamesAndPrices.length() - 2, fillingNamesAndPrices.length());
        }

        return fillingNamesAndPrices.toString();
    }
}
