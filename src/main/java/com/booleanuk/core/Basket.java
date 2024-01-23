package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Map;

public class Basket {
    Member member;
    public Basket(Member member) {
        this.member = member;
    }
    Inventory in = new Inventory();
    Map<String, Item> items = in.items;
    public ArrayList<Item> list = new ArrayList<>();
    public int capacity = 3;
    public String add(Item item) {
        if (items.containsKey(item.getSku())){
            if (list.size() < capacity) {
                if (list.contains(item)) {
                    return "This item already exists in the Basket";
                }
                list.add(item);
                return "Item successfully added";
            }
            return "Your Basket is full";
        } else {
            return "Item is not in the inventory";
        }
    }

    public String remove(Item item) {
        if (list.contains(item)) {
            return "Item successfully removed";
        } else {
            return "This item is not in the basket";
        }
    }


    public String change(int newCap) throws UserException  {
        if (member.toString().equalsIgnoreCase("customer")){
            throw new UserException("You can't do that");
        }
        if (newCap < list.size()) {
            return "New capacity is smaller than the items in the basket";
        }
        capacity = newCap;
        return "New capacity: " +newCap;
    }

    public double totalCost() {
        double cost = 0.0;
        for(Item item : list) {
            cost += item.getPrice();
        }
        return cost;
    }

    public double seeCost(Item item) {
        return item.getPrice();
    }

    public double discount() {
        double disc = 0.0;
        int counter1 = 0;
        int counter2 = 0;
        for (Item item : list) {
            if (item.getName().equals("Bagel")) {
                counter1 ++;
            }
            if (item.getName().equals("Coffee")){
                counter2 ++;
            }
        }
        if (counter1 > 12) {
            disc = (counter1 / 12) * 1.89;
            if (counter1 % 12 > 6) {
                disc = disc + 0.45;
            }
        } else if (counter1 > 6) {
            disc = 0.45;
        }
        return disc;
    }
}
