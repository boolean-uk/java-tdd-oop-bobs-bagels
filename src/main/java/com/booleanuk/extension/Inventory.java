package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

    private static Inventory instance;

    private ArrayList<Item> items;
    private Inventory() {
        items = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            items.add(new Bagel("BGLO","Bagel","Onion", 0.49));
            items.add(new Bagel("BGLP","Bagel","Plain", 0.39));
            items.add(new Bagel("BGLE","Bagel","Everything", 0.49));
            items.add(new Bagel("BGLS","Bagel","Sesame", 0.49));

            items.add(new Coffee("COFB","Coffee","Black", 0.99));
            items.add(new Coffee("COFW","Coffee", "White", 1.19));
            items.add(new Coffee("COFC","Coffee", "Cappuccino", 1.29));
            items.add(new Coffee("COFL","Coffee","Latte", 1.29));

            items.add(new Filling("FILB","Filling", "Bacon", 0.12));
            items.add(new Filling("FILE","Filling","Egg", 0.12));
            items.add(new Filling("FILC","Filling","Cheese", 0.12));
            items.add(new Filling("FILX","Filling","Cream Cheese", 0.12));
            items.add(new Filling("FILS","Filling","Smoked Salmon", 0.12));
            items.add(new Filling("FILH","Filling","Ham", 0.12));


        }
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    public static void resetInstance() {
        instance = null;
    }
    public boolean checkInventory(String SKU, int amount){
        int count = 0;
        for (Item currentItem : items) {
            if (currentItem.getSKU().equals(SKU)) {
                count++;
                if (count == amount) {
                    return true;
                }

            }
        }
        return false;
    }
    public ArrayList<Item> getItems(String SKU, int amount){
        ArrayList<Item> temp = new ArrayList<>();
        int count = 0;
        Iterator<Item> iterator = items.iterator();
        while(iterator.hasNext()){
            Item currentItem = iterator.next();
            if(currentItem.getSKU().equals(SKU)){
                count++;
                temp.add(currentItem);
                iterator.remove();
                if(count == amount){
                    return temp;
                }
            }
        }
        return null;
    }
    public void addItems(Item item){
        items.add(item);
    }

    public String getPriceInfo(String SKU){
        for(Item i : items){
            if(i.getSKU().equals(SKU)){
                return String.valueOf(i.getPrice());
            }
        }

        return "No item found";
    }
    public String getItemNameType(String SKU){;
        for(Item i : items){
            if(i.getSKU().equals(SKU)){
                return i.getName() + " " + i.getType();
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