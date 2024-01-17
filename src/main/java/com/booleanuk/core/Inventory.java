package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

    private static Inventory instance;
    private ArrayList<Item> bagels;
    private ArrayList<Item> coffee;
    private ArrayList<Item> fillings;
    private Inventory() {
        bagels = new ArrayList<>();
        coffee = new ArrayList<>();
        fillings = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            bagels.add(new Bagel("Bagel","Onion", 0.49));
            bagels.add(new Bagel("Bagel","Plain", 0.39));
            bagels.add(new Bagel("Bagel","Everything", 0.49));
            bagels.add(new Bagel("Bagel","Sesame", 0.49));

            coffee.add(new Coffee("Coffee","Black", 1.19));
            coffee.add(new Coffee("Coffee", "White", 1.19));
            coffee.add(new Coffee("Coffee", "Cappuccino", 1.29));
            coffee.add(new Coffee("Coffee","Latte", 1.29));

            fillings.add(new Filling("Filling", "Bacon", 0.12));
            fillings.add(new Filling("Filling","Egg", 0.12));
            fillings.add(new Filling("Filling","Cheese", 0.12));
            fillings.add(new Filling("Filling","Cream Cheese", 0.12));
            fillings.add(new Filling("Filling","Smoked Salmon", 0.12));
            fillings.add(new Filling("Filling","Ham", 0.12));


        }
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    public boolean checkInventory(String name, String type, int amount){
        int count = 0;
        Iterator<Item> iterator;
        switch (name) {
            case "Bagel" -> iterator = bagels.iterator();
            case "Coffee" -> iterator = coffee.iterator();
            case "Filling" -> iterator = fillings.iterator();
            default -> {
                return false;
            }
        }
        while(iterator.hasNext()){
            Item currentItem = iterator.next();
            if(currentItem.getType().equals(type)){
                count++;
                if(count == amount){
                    return true;
                }

            }
        }
        return false;
    }
    public ArrayList<Item> getItems(String name, String type, int amount){
        ArrayList<Item> items = new ArrayList<>();
        int count = 0;
        Iterator<Item> iterator;
        switch (name) {
            case "Bagel" -> iterator = bagels.iterator();
            case "Coffee" -> iterator = coffee.iterator();
            case "Filling" -> iterator = fillings.iterator();
            default -> {
                return null;
            }
        }
        while(iterator.hasNext()){
            Item currentItem = iterator.next();
            if(currentItem.getType().equals(type)){
                count++;
                items.add(currentItem);
                iterator.remove();
                if(count == amount){
                    return items;
                }
            }
        }
        return null;
    }
    public void addItems(Item item){
        if(item instanceof Bagel){
            bagels.add(item);
        }
        else if(item instanceof Coffee){
            coffee.add(item);
        }
        else if(item instanceof Filling){
            fillings.add(item);
        }
    }
}