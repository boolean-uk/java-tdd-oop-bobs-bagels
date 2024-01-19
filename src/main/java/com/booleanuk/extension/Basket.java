package com.booleanuk.extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basket {
    private ArrayList<Item> items;

    private int maxCapacity;

    public Basket(int maxCapacity){
        this.maxCapacity = maxCapacity;
        items = new ArrayList<>();
    }
    public int getCurrentCapacity(){
        return this.items.size();
    }
    public boolean addItem(String SKU, int amount){
        if(amount + checkCurrentCapacity() > maxCapacity || !checkItemValidity(SKU)){
            return false;
        }
        Inventory i = Inventory.getInstance();
        if(i.checkInventory(SKU, amount)){
            items.addAll(i.getItems(SKU, amount));
            return true;
        }
        else{
            return false;
        }
    }
    public boolean addFillingWithBagel(String bagelSKU, ArrayList<String> fillings ) {

        if (checkCurrentCapacity() + (fillings.size() + 1) > maxCapacity ||(!checkItemValidity(bagelSKU) && !checkItemValidity(fillings)) ) {
            return false;
        }
        Inventory i = Inventory.getInstance();
        Bagel bagel = (Bagel) i.getItems(bagelSKU, 1).get(0);
        ArrayList<Item> fillingsTemp = new ArrayList<>();

        for (String s : fillings) {
            if (i.checkInventory(s, 1)) {
                fillingsTemp.add((Filling) i.getItems(s, 1).get(0));
            } else {
                for (Item item : fillingsTemp) {

                    i.addItems(item);
                }
                i.addItems(bagel);
                return false;
            }

        }
        bagel.addFillings(fillingsTemp);
        items.add(bagel);
        return true;

    }
    public boolean removeItem(String SKU){
            Iterator<Item> iterator = items.iterator();
            while(iterator.hasNext()){
                Item currentItem = iterator.next();
                if(currentItem.getSKU().equals(SKU)){
                    if(currentItem.getSKU().startsWith("B")){
                        ((Bagel) currentItem).removeAllFillings();
                    }
                    iterator.remove();
                    Inventory.getInstance().addItems(currentItem);
                    return true;
                }
            }
            return false;
    }

    public boolean changeBasketCapacity(int capacity){
        return capacity >= this.items.size();
    }
    public double getTotalCost(){
        double total = 0;
        for(Item i : this.items){
            if(i instanceof Bagel bagel){
                for(Item f : bagel.getFillings()){
                    total+= f.getPrice();
                }
            }
            total += i.getPrice();
        }
        return parsePrice(Double.toString(total - applyDiscounts()));
    }
    private double parsePrice(String price){
        BigDecimal pp = new BigDecimal(price);
        pp = pp.setScale(2, RoundingMode.HALF_UP);
        return pp.doubleValue();
    }
    private double applyDiscounts(){
        double totalDiscount = 0;
        Map<String, Long> bagelQuantities = getItemQuantities();

        for(Map.Entry<String, Long> entry : bagelQuantities.entrySet()){
            String itemSKU = entry.getKey();
            long itemQuantity = entry.getValue();
            double itemPrice = 0;
            if(itemQuantity >= 12 && itemSKU.startsWith("B")){
                itemPrice = Double.parseDouble(Inventory.getInstance().getPriceInfo(itemSKU));
                totalDiscount += (itemPrice * 12) - 3.99;

            }
            else if(itemQuantity >= 6 && itemSKU.startsWith("B") && !itemSKU.endsWith("P")){
                itemPrice = Double.parseDouble(Inventory.getInstance().getPriceInfo(itemSKU));
                totalDiscount += (itemPrice * 6) - 2.49;
            }
        }
        return totalDiscount;
    }
    private Map<String, Long> getItemQuantities() {
        List<String> bagelSKUs = items.stream()
                .map(Item::getSKU)
                .toList();

        return bagelSKUs.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private int checkCurrentCapacity(){
        int capacity = items.size();
        for(Item i : items){
            if(i instanceof Bagel){
                for(Item ignored : ((Bagel) i).getFillings()){
                    capacity += 1;
                }
            }
        }
        return capacity;
    }
    private boolean checkItemValidity(String SKU){
       if(getListOfCodes().contains(SKU)){
           return true;
       }
       else{
           return false;
       }

    }
    private boolean checkItemValidity(ArrayList<String> itemsSku){
        for(String s : itemsSku){
            if(!getListOfCodes().contains(s)){
                return false;
            }
        }
        return true;
    }
    private List<String> getListOfCodes(){
        return Arrays.asList(
                "BGLO", "BGLP", "BGLE", "BGLS", // Bagels
                "COFB", "COFW", "COFC", "COFL", // Coffee
                "FILB", "FILE", "FILC", "FILX", "FILS", "FILH" // Fillings
        );
    }

}
