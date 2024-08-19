package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemHandler {

    private final ArrayList<Item> basket;
    private int basketCapacity;
    private HashMap<String, String> allItems;
    private int idTracker;
    private HashMap<String, ArrayList<Item>> discountCounterMap;

    public ItemHandler() {
        this.idTracker = 0;
        this.basketCapacity = 1;
        this.basket = new ArrayList<>();
        setUpAllItems();
        discountCounterMap = new HashMap<>();
    }

    public Bagel addBagel(String SKU) {
        if (this.basket.size() >= this.basketCapacity) {
            System.out.println("Basket is full.");
            return null;
        }
        if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Bagel")) {
            Bagel bagel = new Bagel(SKU, idTracker);
            this.idTracker++;
            this.basket.add(bagel);
            System.out.println(bagel.getName() + ", " + bagel.getVariant() + ", price: " + bagel.getPrice());
            return bagel;
        }
        System.out.println("No such bagel exists.");
        return null;
    }

    public Coffee addCoffee(String SKU) {
        if (this.basket.size() >= this.basketCapacity) {
            System.out.println("Basket is full.");
            return null;
        }
        if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Coffee")) {
            Coffee coffee = new Coffee(SKU, idTracker);
            this.idTracker++;
            this.basket.add(coffee);
            System.out.println(coffee.getName() + ", " + coffee.getVariant() + ", price: " + coffee.getPrice());
            return coffee;
        }
        System.out.println("No such coffee exists.");
        return null;
    }

    public Filling addFilling(String SKU, Bagel bagel) {
        if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Filling")) {
            if (basket.contains(bagel)) {
                Filling filling = new Filling(SKU, idTracker, bagel);
                idTracker++;
                System.out.println(filling.getName() + ", " + filling.getVariant() + ", price: " + filling.getPrice());
                return filling;
            } else {
                System.out.println("No such bagel exists in the basket.");
                return null;
            }
        } else {
            System.out.println("No filling exists with that SKU.");
            return null;
        }
    }

    public boolean removeItem(int id) {
        for (int i = 0; i < this.basket.size(); i++) {
            if (this.basket.get(i).getId() == id) {
                this.basket.remove(i);
                return true;
            } else if (this.basket.get(i) instanceof Bagel) {
                if (this.basket.get(i).removeFilling(id)) {
                    return true;
                }
            }
        }
        System.out.println("No such item was found.");
        return false;
    }

    public boolean setCapacity(int newCapacity) {
        if (this.basket.size() > newCapacity) {
            System.out.println("Capacity cant be smaller than the current size of the basket");
            return false;
        }
        this.basketCapacity = newCapacity;
        return true;
    }

    public void setUpAllItems() {
        this.allItems = new HashMap<>();
        this.allItems.put("BGLO", "Bagel");
        this.allItems.put("BGLP", "Bagel");
        this.allItems.put("BGLE", "Bagel");
        this.allItems.put("BGLS", "Bagel");

        this.allItems.put("COFB", "Coffee");
        this.allItems.put("COFW", "Coffee");
        this.allItems.put("COFC", "Coffee");
        this.allItems.put("COFL", "Coffee");

        this.allItems.put("FILB", "Filling");
        this.allItems.put("FILE", "Filling");
        this.allItems.put("FILC", "Filling");
        this.allItems.put("FILX", "Filling");
        this.allItems.put("FILS", "Filling");
        this.allItems.put("FILH", "Filling");
    }

    public double getTotal() {
        calcDiscounts();
        for (ArrayList<Item> itemArrayList : discountCounterMap.values()) {
            if (itemArrayList.size() > 5) {
                sixBagelDiscount(itemArrayList);
            }
        }
        double total = 0;
        for (Item item : basket) {
            total += item.getTotal();
            item.setDiscountPrice(-1);
        }
        return total/1000;
    }

    public void sixBagelDiscount(ArrayList<Item> listToDiscount) {
        for (int i = 0; i < 6; i++) {
            listToDiscount.get(i).setDiscountPrice(415);
        }
    }

    public void calcDiscounts() {
        discountCounterMap = new HashMap<>();
        for (Item item : basket) {
            if (discountCounterMap.containsKey(item.getSKU())) {
                discountCounterMap.get(item.getSKU()).add(item);
            } else {
                ArrayList<Item> itemArrayList = new ArrayList<>();
                itemArrayList.add(item);
                discountCounterMap.put(item.getSKU(), itemArrayList);
            }
        }
    }

    public double searchItem(String SKU) {
        Item item;
        if (this.allItems.containsKey(SKU)) {
            if (this.allItems.get(SKU).equals("Coffee")) {
                item = new Coffee(SKU, idTracker);
                return item.getTotal();
            } else if (this.allItems.get(SKU).equals("Bagel")) {
                item = new Bagel(SKU, idTracker);
                return item.getTotal();
            } else if (this.allItems.get(SKU).equals("Filling")) {
                Bagel bagel = new Bagel("BGLO", idTracker);
                item = new Filling(SKU, idTracker, bagel);
                return item.getTotal();
            }
        }
        System.out.println("No such item exists.");
        return -1;
    }

    public ArrayList<Item> getBasket() {
        return basket;
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public HashMap<String, String> getAllItems() {
        return allItems;
    }

    public int getIdTracker() {
        return idTracker;
    }
}
