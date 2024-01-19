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
            bagels.add(new Bagel("BGLO","Bagel","Onion", 0.49));
            bagels.add(new Bagel("BGLP","Bagel","Plain", 0.39));
            bagels.add(new Bagel("BGLE","Bagel","Everything", 0.49));
            bagels.add(new Bagel("BGLS","Bagel","Sesame", 0.49));

            coffee.add(new Coffee("COFB","Coffee","Black", 0.99));
            coffee.add(new Coffee("COFW","Coffee", "White", 1.19));
            coffee.add(new Coffee("COFC","Coffee", "Cappuccino", 1.29));
            coffee.add(new Coffee("COFL","Coffee","Latte", 1.29));

            fillings.add(new Filling("FILB","Filling", "Bacon", 0.12));
            fillings.add(new Filling("FILE","Filling","Egg", 0.12));
            fillings.add(new Filling("FILC","Filling","Cheese", 0.12));
            fillings.add(new Filling("FILX","Filling","Cream Cheese", 0.12));
            fillings.add(new Filling("FILS","Filling","Smoked Salmon", 0.12));
            fillings.add(new Filling("FILH","Filling","Ham", 0.12));


        }
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    public boolean checkInventory(String SKU, int amount){
        int count = 0;
        Iterator<Item> iterator;
        switch (SKU.substring(0, 1)) {
            case "B":
                iterator = bagels.iterator();
                break;
            case "C":
                iterator = coffee.iterator();
                break;
            case "F":
                iterator = fillings.iterator();
                break;
            default:
                return false;
        }
        while(iterator.hasNext()){
            Item currentItem = iterator.next();
            if(currentItem.getSKU().equals(SKU)){
                count++;
                if(count == amount){
                    return true;
                }

            }
        }
        return false;
    }
    public ArrayList<Item> getItems(String SKU, int amount){
        ArrayList<Item> items = new ArrayList<>();
        int count = 0;
        Iterator<Item> iterator;
        switch (SKU.substring(0, 1)) {
            case "B":
                iterator = bagels.iterator();
                break;
            case "C":
                iterator = coffee.iterator();
                break;
            case "F":
                iterator = fillings.iterator();
                break;
            default:
                return null;
        }
        while(iterator.hasNext()){
            Item currentItem = iterator.next();
            if(currentItem.getSKU().equals(SKU)){
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

    public String getPriceInfo(String SKU){
        ArrayList<Item> tempArray = new ArrayList<>();
        tempArray.addAll(bagels);
        tempArray.addAll(coffee);
        tempArray.addAll(fillings);
        for(Item i : tempArray){
            if(i.getSKU().equals(SKU)){
                return String.valueOf(i.getPrice());
            }
        }

        return "No item found";
    }
    public String listFillings(){
        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(new Filling("FILB","Filling", "Bacon", 0.12));
        fillings.add(new Filling("FILE","Filling","Egg", 0.12));
        fillings.add(new Filling("FILC","Filling","Cheese", 0.12));
        fillings.add(new Filling("FILX","Filling","Cream Cheese", 0.12));
        fillings.add(new Filling("FILS","Filling","Smoked Salmon", 0.12));
        fillings.add(new Filling("FILH","Filling","Ham", 0.12));
        String s = "List of Fillings:\n";

        for (Filling filling : fillings) {
            s+= "Filling{SKU='" + filling.getSKU() + "', type='" + filling.getType()
                    + "', price=" + filling.getPrice() + "}\n";
        }
        return s;
    }
}