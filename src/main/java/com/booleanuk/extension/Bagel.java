package com.booleanuk.extension;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Bagel extends Item {
    private double price;
    public HashMap<FillingType, Integer> getFillings() {
        return fillings;
    }
    public HashMap<FillingType, Integer> fillings;
    public Bagel(BagelType bagelType) {
        super(bagelType);
        price = bagelType.getPrice();
        fillings = new HashMap<FillingType, Integer>();
    }
    private void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void addFilling(FillingType fillingType) {
        addFilling(fillingType, 1);
    }
    public void addFilling(FillingType fillingType, int amount) {
        Integer fillingAmount = fillings.get(fillingType);
        fillings.put(fillingType, fillingAmount == null ? amount : fillingAmount + amount);
        setPrice(getPrice() + fillingType.getPrice());
    }
    public boolean removeFilling(FillingType fillingType, int amount) {
        if (fillings.containsKey(fillingType)) {
            fillings.put(fillingType, fillings.get(fillingType) - amount);
            if(fillings.get(fillingType) <= 0)
                fillings.remove(fillingType);
            setPrice(getPrice() - fillingType.getPrice());
            return true;
        }
        return false;
    }
    public boolean removeFilling(FillingType fillingType) {
        return removeFilling(fillingType, 1);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bagel of type: ");
        sb.append(getVariant());
        sb.append(". Price: £");
        sb.append(getPrice());
        sb.append("\n");
        return sb.toString();
    }
    public static Bagel order() {
        Scanner input = new Scanner(System.in);
        Bagel bagel = null;
        HashMap<FillingType, Integer> chosenFillings = new HashMap<FillingType, Integer>();
        for(FillingType fillingType : FillingType.values())
            chosenFillings.put(fillingType, 0);
        for (;;) {
            System.out.println("""
                    Available bagels:
                    BGLP - plain(£0.39),
                    BGLO - onion(£0.49),
                    BGLE - everything(£0.49),
                    BGLS - sesame(£0.49).
                    Type preview to preview bagel and its fillings
                    Type modify to add/remove fillings
                    Type confirm to add bagel
                    Type cancel to exit""");
            String choice = input.next();
            if(choice.equalsIgnoreCase("cancel"))
                return null;
            if(choice.equalsIgnoreCase("confirm")) {
                if(bagel == null)
                    return null;
                for(Map.Entry<FillingType, Integer> entry : chosenFillings.entrySet())
                    bagel.addFilling(entry.getKey(), entry.getValue());
                return bagel;
            }
            if(choice.equalsIgnoreCase("preview")) {
                if(bagel == null) {
                    System.out.println("Bagel not chosen");
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(bagel);
                for(Map.Entry<FillingType, Integer> entry : chosenFillings.entrySet()) {
                    if(entry.getValue() != 0)
                        sb.append("\t").append(entry.getKey().toString()).append(" Amount: ")
                            .append(entry.getValue()).append("\n");
                }
                System.out.println(sb.toString());
            }
            if(choice.equalsIgnoreCase("modify")) {
                FillingType.order(chosenFillings);
                continue;
            }
            for(BagelType bagelType : BagelType.values()) {
                if (bagelType.getSku().equals(choice)) {
                    if(bagel != null) {
                        System.out.println("Are you sure you want to choose another bagel? Y/N");
                        if (input.next().equalsIgnoreCase("Y")) {
                            bagel = new Bagel(bagelType);
                            System.out.println("Great choice! ");
                        }
                    }
                    else {
                        bagel = new Bagel(bagelType);
                        System.out.println("Great choice! ");
                    }
                }
            }
        }
    }
}
