package com.booleanuk.core;


import com.booleanuk.extension.Receipt;
import com.booleanuk.extension.SpecialOffer;

import java.text.DecimalFormat;
import java.util.*;


public class Basket {
    private List<String> items;
    private List<Bagle> bagles;
    private Inventory inventory;
    private int capacity;
    private static final DecimalFormat roundUp = new DecimalFormat("0.00");


    public Basket(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
        inventory = new Inventory();
        bagles = new ArrayList<>();

    }

    public List<String> getItems() {
        return items;
    }

    public boolean addItem(String item, List<String> fillings) {
        double priceOfProduct = 0;
        int itemsCapacity = fillings == null ? items.size() : items.size() + fillings.size();
        if (inventory.checkAvailability(item) && itemsCapacity < capacity) {
            if (item.startsWith("BGL")) {
                Bagle bagle = new Bagle(item, inventory.getItemPrice(item), inventory.getBagelVariant(item));
                priceOfProduct += inventory.getItemPrice(item);
                items.add(bagle.getSKU());
                bagles.add(bagle);

                if (fillings != null && !fillings.isEmpty()) {
                    for (String fillingSKU : fillings) {
                        if (inventory.checkAvailability(fillingSKU)) {
                            items.add(fillingSKU);
                            priceOfProduct += inventory.getItemPrice(fillingSKU);
                            bagle.addFilling(fillingSKU);
                        }
                    }

                }
            } else if (item.startsWith("COF")) {

                items.add(item);
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }


    /*
List<Bagle> bagles;
    public void addFilling(String SKUofBagle,String SKUofFilling) {
        double price = inventory.getItemPrice(SKUofBagle);
        //String variant = inventory.getVariantBySKU(SKUofBagle);
        //if(bagles.contains(bagle)){
        //    bagle.addFilling(SKUofFilling);
        //}
       // bagle = new Bagle(SKUofBagle, price, variant);
        //bagle.addFilling(SKUofFilling);
    }
*/
    public boolean removeFilling(String nameOfBagle, String nameOfFilling) {
        if (items.contains(nameOfBagle) && inventory.checkAvailability(nameOfFilling) == true) {
            items.remove(nameOfFilling);
            return true;
        }
        return false;
    }

    public boolean removeCoffee(String item) {
        if (items.contains(item) && item.startsWith("COF")) {
            items.remove(item);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeBagle(String item) {
        if (items.contains(item)) {
            for (Bagle bagle : bagles) {
                if (bagle.getSKU().equals(item)) {
                    items.remove(item);
                    for (int i = 0; i < bagle.getFillings().size(); i++) {
                        items.remove(bagle.getFillings().get(i));
                    }
                }
            }
            return true;
        }
        return false;
    }


    public void changeCapacity(int newCapacity) {
        if (newCapacity > 0 && newCapacity >= items.size()) {
            this.capacity = newCapacity;
        } else if (newCapacity <= 0) {
            System.out.println("You can't downsize the basket to negative or 0");
        } else if (newCapacity < items.size()) {
            System.out.println("You already got " + items.size() + " bagles in basket so you can't downsize basket to " + newCapacity + " spaces.");
            System.out.println("New basket size is " + items.size());
            this.capacity = items.size();
        }

    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        Map<String, Integer> itemQuantities = new HashMap<>();


        for (String item : items) {
            itemQuantities.put(item, itemQuantities.getOrDefault(item, 0) + 1);
        }

        Receipt receipt = new Receipt();

        for (String item : itemQuantities.keySet()) {
            int quantity = itemQuantities.get(item);
            double itemPrice = inventory.getItemPrice(item);
            SpecialOffer specialOffer = inventory.getSpecialOffer(item);

            int remainingCount = 0;
            if (specialOffer != null && quantity >= specialOffer.getQuantity()) {
                int offerCount = quantity / specialOffer.getQuantity();
                remainingCount = quantity % specialOffer.getQuantity();

                double offerPrice = specialOffer.getPrice() * offerCount;
                double remainingPrice = itemPrice * remainingCount;

                if (item.equals("COFB") && itemQuantities.containsKey("BGLP")) {
                    if (quantity > specialOffer.getQuantity()) {
                        System.out.println("Test if");
                        offerPrice = quantity * 0.99;

                    } else if(itemQuantities.get("BGLP") % 12 != 0) {
                        System.out.println("Are we here?");
                        offerPrice = 1.25;
                        remainingPrice = 0;
                        itemQuantities.put("BGLP", itemQuantities.get("BGLP") -1);
                    }else {
                        offerPrice = 0.99;
                    }
                }

                totalPrice += offerPrice + remainingPrice;
                receipt.addItem(getItemName(item), quantity, offerPrice + remainingPrice);
            } else {
                if (item.equals("BGLP") && itemQuantities.containsKey("COFB")) {
                    continue;
                }else {
                    totalPrice += itemPrice * quantity;
                }

                receipt.addItem(getItemName(item), quantity, itemPrice * quantity);
            }
        }

        receipt.printReceipt();

        return Math.round(totalPrice * 100.0) / 100.0;

    }

    private String getItemName(String item) {
        switch (item) {
            case "BGLO":
                return "Onion Bagel";
            case "BGLP":
                return "Plain Bagel";
            case "BGLE":
                return "Everything Bagel";
            case "BGLS":
                return "Sesame Bagel";
            case "COFB":
                return "Coffee Black";
            case "COFW":
                return "Coffee White";
            case "COFC":
                return "Coffee Capuccino";
            case "COFL":
                return "Coffee Latte";
            case "FILB":
                return "Bacon filling";
            case "FILE":
                return "Egg filling";
            case "FILC":
                return "Cheese filling";
            case "FILX":
                return "Creame Cheese filling";
            case "FILS":
                return "Smoked Salmon filling";
            case "FILH":
                return "Ham filling";

            default:
                return "";
        }
    }



}
