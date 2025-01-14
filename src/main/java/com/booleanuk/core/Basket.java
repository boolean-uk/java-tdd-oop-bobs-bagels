package com.booleanuk.core;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private int capasity = 10;
    private double totalCost;

    private ArrayList<Item> basketList = new ArrayList<>();

    private HashMap<String, Item> stockList = new HashMap<>() {{
        Item bagelOnion = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        put("BGLO", bagelOnion);
        Item bagelPlain = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        put("BGLP", bagelPlain);
        Item bagelEvery = new Bagel("BGLE", 0.49, "Bagel", "Everything");
        put("BGLE", bagelEvery);
        Item bagelSesame = new Bagel("BGLS", 0.49, "Bagel", "Sesame");
        put("BGLS", bagelSesame);
        Item coffeeBlack = new Coffee("COFB", 0.99, "Coffee", "Black");
        put("COFB", coffeeBlack);
        Item coffeeWhite = new Coffee("COFW", 1.19, "Coffee", "White");
        put("COFW", coffeeWhite);
        Item coffeeCapuccino = new Coffee("COFC", 1.29, "Coffee", "Capuccino");
        put("COFC", coffeeCapuccino);
        Item coffeeLatte = new Coffee("COFL", 1.29, "Coffee", "Latte");
        put("COFL", coffeeLatte);
        Item fillBacon = new Filling("FILB", 0.12, "Filling", "Bacon");
        put("FILB", fillBacon);
        Item fillEgg = new Filling("FILE", 0.12, "Filling", "Egg");
        put("FILE", fillEgg);
        Item fillCheese = new Filling("FILC", 0.12, "Filling", "Egg");
        put("FILC", fillCheese);
        Item fillCream = new Filling("FILX", 0.12, "Filling", "Cream Cheese");
        put("FILX", fillCream);
        Item fillSal = new Filling("FILS", 0.12, "Filling", "Smoked Salmon");
        put("FILS", fillSal);
        Item fillHam = new Filling("FILH", 0.12, "Filling", "Ham");
        put("FILH", fillHam);
    }};

    public Basket() {
    }

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public ArrayList<Item> getBasketList() {
        return basketList;
    }

    public void setBasketList(ArrayList<Item> basketList) {
        this.basketList = basketList;
    }

    public HashMap<String, Item> getStockList() {
        return stockList;
    }

    public void setStockList(HashMap<String, Item> stockList) {
        this.stockList = stockList;
    }

    public boolean addToBasket(String id) {
        if (basketList.size() != capasity) {
            if (stockList.containsKey(id)) {
                if(id.substring(0,2).equals("FI")) {
                    if(basketList.size() != 0) {
                        for (int i = 0; i <= basketList.size(); i++) {
                            if (basketList.get(i).getId().substring(0,2).equals("BG")) {
                                basketList.add(stockList.get(id));
                                return true;
                            } else {
                                System.out.println("You need a bagel to buy filling!");
                                return false;
                            }
                        }
                    } else {
                        System.out.println("You can't just buy fillings!");
                        return false;
                    }
                }
                basketList.add(stockList.get(id));
                return true;
            } else {
                System.out.println("Item does not exist in our inventory.");
                return false;
            }
        }
        System.out.println("Cannot add more items!");
        return false;
    }

    public boolean removeItem(String id) {
        if(basketList.size() != 0) {
            for (int i = 0; i < basketList.size(); i++) {
                if (basketList.get(i).getId().equals(id)) {
                    basketList.remove(i);
                    return true;
                } else {
                    System.out.println("Item not in basket!");
                    return false;
                }
            }
        }
        System.out.println("No items in basket!");
        return false;
    }

    public ArrayList<Item> listOfItems() {
        return basketList;
    }

    public double getTotalCost() {
        for (int i = 0; i < basketList.size(); i++) {
            totalCost += basketList.get(i).getPrice();
        }
        return totalCost;
    }

    public int changeCapasity(int c) {
        this.capasity = c;
        return c;
    }

    public HashMap<String, Integer> receiptBuilder() {
        HashMap<String, Integer> boughtItems = new HashMap<>();

        int quantityBagel = 0;
        int quantityFilling = 0;
        int quantityCoffee = 0;

        for (int i = 0; i < basketList.size(); i++) {
            if (basketList.get(i).getId().substring(0,1).equals("B")) {
                if (!boughtItems.containsKey(basketList.get(i).getDescription())) {
                    quantityBagel++;
                    boughtItems.put(basketList.get(i).getId(),quantityBagel);
                } else {
                    boughtItems.remove(basketList.get(i).getId(),quantityBagel);
                    quantityBagel++;
                    boughtItems.put(basketList.get(i).getId(), quantityBagel);
                }
            }

            if (basketList.get(i).getId().substring(0,1).equals("F")) {
                if (!boughtItems.containsKey(basketList.get(i).getDescription())) {
                    quantityFilling++;
                    boughtItems.put(basketList.get(i).getId(),quantityFilling);
                } else {
                    boughtItems.remove(basketList.get(i).getId(),quantityFilling);
                    quantityFilling++;
                    boughtItems.put(basketList.get(i).getId(), quantityFilling);
                }
            }

            if (basketList.get(i).getId().substring(0,1).equals("C")) {
                if (!boughtItems.containsKey(basketList.get(i).getDescription())) {
                    quantityCoffee++;
                    boughtItems.put(basketList.get(i).getId(),quantityCoffee);
                } else {
                    boughtItems.remove(basketList.get(i).getId(),quantityCoffee);
                    quantityCoffee++;
                    boughtItems.put(basketList.get(i).getId(), quantityCoffee);
                }
            }
        }
        return boughtItems;
    }

    public void printReceipt() {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> list = receiptBuilder();
        DecimalFormat df = new DecimalFormat();
        String desc = "";
        String type = "";
        double price = 0;

        sb.append("~~~ Bob's Bagels ~~~\n");
        sb.append(java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm\n")));
        sb.append("\n----------------------------\n");

        for ( String name : list.keySet()) {
            for (int i = 0; i < stockList.size(); i++) {
                Item item = stockList.get(name);
                price = item.getPrice();
                desc = item.getDescription();
                type = item.getType();
            }
            sb.append(desc + " " + type + " " +list.get(name).toString()+ " " + df.format(price*list.get(name)) + "£\n");
        }
        sb.append("\n----------------------------\n");
        sb.append("Total cost: " + df.format(getTotalCost())+"£\n");
        System.out.println(sb);
    }
}
