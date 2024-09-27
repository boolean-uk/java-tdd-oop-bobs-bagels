package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class Package implements IProduct {
    final ArrayList<Item> items;
    final double cost;
    final double saving;

    public Package(ArrayList<Item> items, double cost, double saving) {
        this.items = items;
        this.cost = cost;
        this.saving = saving;
    }

    @Override
    public double getCost() { return cost; }

    @Override
    public boolean getAvailable() { return items.stream().allMatch(Item::getAvailable); }

    public String toString() {
        String result = "\nPACKAGE:";
        for (Item item : items) {
            result += String.format(
                "\n%s %s",
                item.variant,
                item.type
            );
        }
        result += String.format(
            "   %s\n" +
            "               (%s)",
                Currency.getInstance(Locale.UK).getSymbol() + this.cost,
                Currency.getInstance(Locale.UK).getSymbol() + this.saving
            );
        return result;
    }
}
