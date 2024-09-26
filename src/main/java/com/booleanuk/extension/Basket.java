package com.booleanuk.extension;


import javax.swing.*;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private ArrayList<AbstractItem> items;
    private int capacity;
    private Inventory inventory;
    String receipt;

    public Basket() {
        this.items = new ArrayList<>();
        this.capacity = 5; //default value?
        this.inventory = new Inventory();
        receipt = "";
    }

    public Basket(int capacity) {
        this.items = new ArrayList<>();
        this.inventory = new Inventory();
        setCapacity(capacity);
        receipt = "";
    }

    public ArrayList<AbstractItem> getItems() {
        return this.items;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Cannot change the basket capacity to something negative!");
        } else if (capacity < this.items.size()) {
            System.out.println("Cannot change capacity to something smaller than the current number of items in the basket!");
        } else {
            this.capacity = capacity;
        }
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void addItem(AbstractItem item) {
        if (this.items.size() >= capacity) {
            System.out.println("Your basket is full!");
        } else if (!this.inventory.isValid(item)) {
            System.out.println("Item is not valid");
        } else {
            if (items.stream().anyMatch(i -> i.getSku().equals(item.getSku()))) {
                items.forEach((i) -> {
                    if (i.getSku().equals(item.getSku())) {
                        i.setQuantity(i.getQuantity() + 1);
                    }
                });
            } else {
                this.items.add(item);
            }
        }
    }

    public void addItem(Sku sku) {
        for (AbstractItem item : this.inventory.getInventoryItems()) {
            if (sku.equals(item.getSku())) {
                this.addItem(item);
                return;
            }
        }
        System.out.println("Invalid SKU");
    }

    public void removeItem(AbstractItem item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getSku().equals(item.getSku())) {
                item.setQuantity(item.getQuantity() - 1);
                if (item.getQuantity() < 1) {
                    items.remove(i);
                }
                System.out.println("Remove item succeeded!");
                return;
            }
        }
        System.out.println("Remove item failed!");
    }

    public void removeItem(String sku) {
        for (AbstractItem item : this.items) {
            if (sku.equals(item.getSku())) {
                this.removeItem(item);
                return;
            }
        }
        System.out.println("Invalid SKU");
    }

    public double getTotalPrice() {
        String fillings = "";
        double total = 0.0;
        int leftoverBagels = 0, numberOfCoffes = 0;
        for (AbstractItem item : this.items) {
            if (item.getName().equals("Bagel")) {
                int quantity = item.getQuantity();
                while (true) {
                    if (quantity >= 12) {
                        total += 3.99;
//                        String temp = formatLine(item.getVariant()+" Bagel", 12, 3.99);
//                        System.out.println(temp);
//                        this.receipt += item.getVariant() + " Bagel      12\t| $3.99\n\t\t\t\t\t(-" + new DecimalFormat("#.##").format(12 * item.getPrice() - 3.99) + ")\n";
                          this.receipt += formatLine(item.getVariant()+" Bagel", 12, 3.99);
                          this.receipt += formatLine("",0,12 * item.getPrice() - 3.99);
                        if (item.getFillings().size() > 0) {
                            total += ((Bagel) item).getFillingsTotalPrice();
                            for (Filling filling : item.getFillings()) {
//                                this.receipt += filling.getVariant() + " filling    " + filling.getQuantity() + "\t| $" + (filling.getPrice() * filling.getQuantity() + "\n");
                                this.receipt += formatLine(filling.getVariant()+" filling", filling.getQuantity(),filling.getPrice());
                            }
                        }
                        quantity -= 12;
                        item.setQuantity(quantity);
                    } else if (quantity >= 6) {
                        total += 2.49;
//                        String temp = formatLine(item.getVariant()+" Bagel", 12, 3.99);
//                        System.out.println(temp);
//                        this.receipt += item.getVariant() + " Bagel      6\t| $2.49\n\t\t\t\t\t(-" + new DecimalFormat("#.##").format(6 * item.getPrice() - 2.49) + ")\n";
                        this.receipt += formatLine(item.getVariant()+" Bagel", 6, 2.49);
                        this.receipt += formatLine("",0,6 * item.getPrice() - 2.49);
                        if (item.getFillings().size() > 0) {
                            total += ((Bagel) item).getFillingsTotalPrice();
                            for (Filling filling : item.getFillings()) {
//                                this.receipt += filling.getVariant() + " filling    " + filling.getQuantity() + "\t| $" + (filling.getPrice() * filling.getQuantity());
                                this.receipt += formatLine(filling.getVariant()+" filling", filling.getQuantity(),filling.getPrice());
                            }
                        }
                        quantity -= 6;
                        item.setQuantity(quantity);
                    } else {
                        if (item.getFillings().size() > 0) {
                            total += ((Bagel) item).getFillingsTotalPrice();
                            for (Filling filling : item.getFillings()) {
                                fillings+= formatLine(filling.getVariant()+" filling", filling.getQuantity(),filling.getPrice());
                                System.out.println("Added a filling in format   "+ item.getVariant());
                            }
                        }
                        leftoverBagels += quantity;
                        item.setQuantity(quantity);
                        break;
                    }
                }
            if(item.getFillings().size()>0 &&this.items.indexOf(item)>0){
                for(Filling filling:item.getFillings()){
                    this.receipt += formatLine(filling.getVariant()+ " "+filling.getName(),filling.getQuantity(),filling.getPrice());
                }
            }
            }
            if (item.getName().equals("Coffee")) {
                numberOfCoffes += item.getQuantity();
            }
        }
        if (leftoverBagels > numberOfCoffes) {
            leftoverBagels = numberOfCoffes;
        }
        for (int i = 0; i < leftoverBagels; i++) {
            total += 1.25;
            for (int j = 0; j < this.items.size(); j++) {
                if (this.items.get(j).getName().equals("Bagel") && this.items.get(j).getQuantity() > 0) {
                    this.receipt += items.get(j).getVariant() + " Bagel and ";
                    this.removeItem(this.items.get(j));
                }
            }
            for (int j = 0; j < this.items.size(); j++) {
                if (this.items.get(j).getName().equals("Coffee") && this.items.get(j).getQuantity() > 0) {
                    this.receipt += items.get(j).getVariant() + " coffee ";
                    this.removeItem(this.items.get(j));
                }
            }
            this.receipt += "for $1.25\n";
            if(this.items.get(i).getName().equals("Bagel") && this.items.get(i).getFillings().size()>0){
                for(Filling filling:this.items.get(i).getFillings()){
                    this.receipt+=formatLine(filling.getVariant()+ " "+filling.getName(),filling.getQuantity(),filling.getQuantity()* filling.getPrice());
                }
            }
        }
        for (AbstractItem item : this.items) {
            if (item.getQuantity() > 0) {
                total += item.getPrice() * item.getQuantity();
                String temp = formatLine(item.getVariant()+" "+item.getName(), item.getQuantity(), item.getPrice());
//                System.out.println(temp);
//                this.receipt += item.getVariant() + " " + item.getName() + "\t" + item.getQuantity() + "\t| $" + (item.getQuantity() * item.getPrice() + "\n");
                    this.receipt += temp;
                if (item.getFillings().size() > 0) {
                    for (Filling filling : item.getFillings()) {
//                        this.receipt += filling.getVariant() + " filling \t" + filling.getQuantity() + "\t| $" + (filling.getPrice() * filling.getQuantity() + "\n");
                        this.receipt += formatLine(filling.getVariant() + " filling", filling.getQuantity(),filling.getPrice());
                    }
                }
            }
        }
//        System.out.println(this.receipt);
        return total;
    }

    public static String convertEpochTimeToDateTime(long epochTimeInMillis) {
        Instant instant = Instant.ofEpochMilli(epochTimeInMillis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    public void printReceipt() {
        double costBeforeDiscount = this.getCostBeforeDiscount();
        double total = this.getTotalPrice();
        String receipt = "~~~~~ Bob's Bagels ~~~~~";
        receipt += "\n\n" + convertEpochTimeToDateTime(System.currentTimeMillis()) + "\n\n-----------------------------------\n";
        receipt += this.receipt;
        receipt += "\n-----------------------------------\n";
        receipt += "Total:              $" + new DecimalFormat("#.##").format(costBeforeDiscount);

        receipt += "\nAfter discount:     $" + new DecimalFormat("#.##").format(total);
        receipt += "\nVAT:                $" + new DecimalFormat("#.##").format(total * 0.13);
        receipt += "\n\n      Thank you for\n   shopping with us :) \n\n";
        System.out.println(receipt);
    }

    public double getCostBeforeDiscount() {
        double cost = 0.0;
        for (AbstractItem item : this.items) {
            if (item.getName().equals("Bagel")) {
                for (Filling filling : item.getFillings()) {
                    cost += filling.getPrice() * filling.getQuantity();
                }
            }
            cost += item.getPrice() * item.getQuantity();

        }
        return cost;
    }

    public static String formatLine(String description, int quantity, double price) {
        int maxDescriptionLength = 35;  // Adjust this value based on your needs

        // Format the description field
        StringBuilder sb = new StringBuilder();
        sb.append(description);
        sb.append(" ".repeat(maxDescriptionLength - description.length()));

        // Format the quantity field
        if(quantity>0) {
            sb.append(quantity);
            sb.append(" | $");
            sb.append(String.format("%.2f", price));
        }else{
            sb.append(" ");
            sb.append("  (-$");
            sb.append(String.format("%.2f", price));
            sb.append(")");
        }
        // Format the price field


        sb.append("\n");
        return sb.toString();
    }
}
