package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemHandler {

    private final ArrayList<Item> basket;
    private int basketCapacity;
    private HashMap<String, String> allItems;
    private int idTracker;
    private HashMap<String, List<Item>> discountCounterMap;
    private final Receipt receipt;

    public ItemHandler() {
        this.idTracker = 0;
        this.basketCapacity = 1;
        this.basket = new ArrayList<>();
        setUpAllItems();
        this.discountCounterMap = new HashMap<>();
        this.receipt = new Receipt();
    }

    public Item addItem(String SKU) {
        if (this.basket.size() >= this.basketCapacity) {
            System.out.println("Basket is full.");
            return null;
        }
        Item item;
        if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Bagel")) {
            item = new Bagel(SKU, idTracker);
        } else if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Coffee")) {
            item = new Coffee(SKU, idTracker);
        } else {
            System.out.println("Not a correct Coffee or Bagel SKU.");
            return null;
        }
        this.idTracker++;
        this.basket.add(item);
        return item;
    }

    public Filling addItem(String SKU, Item bagel) {
        if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Filling")) {
            if (basket.contains(bagel) && bagel.getFillings() != null) {
                Filling filling = new Filling(SKU, idTracker, (Bagel) bagel);
                idTracker++;
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
            } else if (this.basket.get(i).getFillings() != null) {
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
        calcDiscountCounterMap();

        if (this.discountCounterMap.containsKey("Bagel")) {
            if (this.discountCounterMap.get("Bagel").size() > 11) {
                twelveBagelDiscount();
            }
            if (this.discountCounterMap.get("Bagel").size() > 5) {
                sixBagelDiscount();
            }
        }
        coffeeAndBagelDiscount();

        receipt.printReceipt();
        receipt.resetReceipt();
        double total = 0;
        for (Item item : basket) {
            total += item.getTotal();
            item.setDiscountPrice(-1);
        }
        return total/10000;
    }

    public void coffeeAndBagelDiscount() {
        if (this.discountCounterMap.containsKey("Coffee") && this.discountCounterMap.containsKey("Bagel")) {
            if (!this.discountCounterMap.get("Coffee").isEmpty() && !this.discountCounterMap.get("Bagel").isEmpty()) {
                this.discountCounterMap.get("Coffee").getFirst().setDiscountPrice(9000);
                this.discountCounterMap.get("Coffee").removeFirst();
                this.discountCounterMap.get("Bagel").getFirst().setDiscountPrice(3500);
                this.discountCounterMap.get("Bagel").removeFirst();
                if (!this.discountCounterMap.get("Coffee").isEmpty() && !this.discountCounterMap.get("Bagel").isEmpty()) {
                    coffeeAndBagelDiscount();
                }
            }
        }
    }

    public void twelveBagelDiscount() {
        for (int i = 0; i < 12; i++) {
            this.discountCounterMap.get("Bagel").get(i).setDiscountPrice(3325);
        }
        this.discountCounterMap.put("Bagel", this.discountCounterMap.get("Bagel").subList(12, this.discountCounterMap.get("Bagel").size()));
        if (this.discountCounterMap.get("Bagel").size() > 11) {
            twelveBagelDiscount();
        }
    }

    public void sixBagelDiscount() {
        for (int i = 0; i < 6; i++) {
            this.discountCounterMap.get("Bagel").get(i).setDiscountPrice(4150);
        }
        this.discountCounterMap.put("Bagel", this.discountCounterMap.get("Bagel").subList(6, this.discountCounterMap.get("Bagel").size()));
    }

    public void calcDiscountCounterMap() {
        discountCounterMap = new HashMap<>();
        for (Item item : basket) {
            receipt.addToOrderedItemsListsMap(item);
            if (discountCounterMap.containsKey(item.getName())) {
                if (item.getSKU().equals("BGLP")) {
                    discountCounterMap.get(item.getName()).addFirst(item);
                } else {
                    discountCounterMap.get(item.getName()).add(item);
                }
            } else {
                List<Item> itemArrayList = new ArrayList<>();
                itemArrayList.add(item);
                discountCounterMap.put(item.getName(), itemArrayList);
            }
        }
    }

    public double searchItem(String SKU) {
        Item item;
        if (this.allItems.containsKey(SKU)) {
            switch (this.allItems.get(SKU)) {
                case "Coffee": {
                    item = new Coffee(SKU, idTracker);
                    break;
                }
                case "Bagel": {
                    item = new Bagel(SKU, idTracker);
                    break;
                }
                default: {
                    Bagel bagel = new Bagel("BGLO", idTracker);
                    item = new Filling(SKU, idTracker, bagel);
                    break;
                }
            }
            double total = item.getTotal();
            return total/10000;
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
