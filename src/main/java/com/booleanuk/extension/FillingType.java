package com.booleanuk.extension;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public enum FillingType implements IItemType {
    FILB("FILB", 0.12, "Bacon"),
    FILE("FILE", 0.12, "Egg"),
    FILC("FILC", 0.12, "Cheese"),
    FILX("FILX", 0.12, "Cream cheese"),
    FILS("FILS", 0.12, "Smoked salmon"),
    FILH("FILH", 0.12, "Ham");

    FillingType(String sku, double price, String variant) {
        this.sku = sku;
        this.price = price;
        this.variant = variant;
    }
    public double getPrice() {
        return price;
    }
    public String getVariant() {
        return variant;
    }
    public String getSku() { return sku; }
    public final String sku;
    private final double price;
    private final String variant;
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Filling of type: ");
        sb.append(getVariant());
        sb.append(". Price: £");
        sb.append(getPrice());
        return sb.toString();
    }
    public static HashMap<FillingType, Integer> order(HashMap<FillingType, Integer> chosenFillings) {
        Scanner input = new Scanner(System.in);
        for (;;) {
            System.out.println("""
                Available fillings:
                FILB - bacon(£0.12),
                FILE - egg(£0.12),
                FILC - cheese(£0.12),
                FILX - cream cheese(£0.12)
                FILS - smoked salmon(£0.12)
                FILH - ham(£0.12)
                Type preview to preview chosen fillings
                Type add to add filling
                Type remove to add filling
                Type confirm to confirm chosen fillings.
                Type cancel to exit.""");
            String choice = input.next();
            if(choice.equalsIgnoreCase("cancel"))
                return null;
            if(choice.equalsIgnoreCase("confirm"))
                return chosenFillings;
            if(choice.equalsIgnoreCase("preview")) {
                StringBuilder sb = new StringBuilder();
                for(Map.Entry<FillingType, Integer> entry : chosenFillings.entrySet())
                    if(entry.getValue() != 0)
                        sb.append(entry.getKey().toString()).append(". Amount: ")
                                .append(entry.getValue()).append(". Total: £")
                                .append(entry.getKey().getPrice() * entry.getValue()).append("\n");
                System.out.println(sb);
                continue;
            }
            if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("remove")) {
                boolean add = choice.equalsIgnoreCase("add");
                System.out.println("Which variant would you like to " + (add ? "add?" : "remove?"));
                choice = input.next();
                for (FillingType fillingType : FillingType.values())
                    if (fillingType.getSku().equalsIgnoreCase(choice)) {
                        int amount;
                        for (;;) {
                            System.out.println("How may would you like to " + (add ? "add?" : "remove?"));
                            choice = input.next();
                            try {
                                amount = Integer.parseInt(choice);
                                if(amount < 0)
                                    throw new Exception();
                                break;
                            }
                            catch(Exception e) {
                                System.out.println("Wrong number!\n");
                            }
                        }
                        amount = add ? amount : -amount;
                        chosenFillings.put(fillingType, chosenFillings.get(fillingType) + amount);
                        if(chosenFillings.get(fillingType) <= 0)
                            chosenFillings.put(fillingType, 0);
                        break;
                    }
            }
        }
    }
}
