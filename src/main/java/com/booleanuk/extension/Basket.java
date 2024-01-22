package com.booleanuk.extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basket {
    private ArrayList<Item> items;
    private ArrayList<String> receipt;
    private double allDiscounts;

    private int maxCapacity;

    public Basket(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.items = new ArrayList<>();
        this.receipt = new ArrayList<>();
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
        if(applyDiscounts() == 1.25){
            return 1.25;
        }

        return parsePrice(Double.toString(total - applyDiscounts()));
    }
    private double parsePrice(String price){
        BigDecimal pp = new BigDecimal(price);
        pp = pp.setScale(2, RoundingMode.HALF_UP);
        return pp.doubleValue();
    }
    private double applyDiscounts(){
        receipt.clear();
        double totalDiscount = 0;
        Map<String, Long> itemQuantities = getItemQuantities();

        for(Map.Entry<String, Long> entry : itemQuantities.entrySet()){
            String itemSKU = entry.getKey();
            long itemQuantity = entry.getValue();
            double itemPrice = 0;
            if(itemQuantity >= 12 && itemSKU.startsWith("B")){
                itemPrice = Double.parseDouble(Inventory.getInstance().getPriceInfo(itemSKU));
                totalDiscount += (itemPrice * 12) - 3.99;

                receipt.add(entry.getKey() + "\t\t\t   " + itemQuantity + "\t" + parsePrice(String.valueOf((itemPrice * 12)
                        + (itemPrice * (itemQuantity - 12)) - ((itemPrice * 12) - 3.99))) + "\n\t\t\t\t\t" +
                        "(-" + parsePrice(String.valueOf((itemPrice * 12) - 3.99)) + ")\n");

            }
            else if(itemQuantity >= 6 && itemSKU.startsWith("B") && !itemSKU.endsWith("P")){
                itemPrice = Double.parseDouble(Inventory.getInstance().getPriceInfo(itemSKU));
                totalDiscount += (itemPrice * 6) - 2.49;

                receipt.add(entry.getKey() + "\t\t\t   " + itemQuantity + "\t" + parsePrice(String.valueOf((((itemPrice * 6)
                                + (itemPrice * (itemQuantity - 6)) - totalDiscount)))) + "\n\t\t\t\t\t" +
                        "(-" + parsePrice(String.valueOf((itemPrice * 6 ) - 2.49)) + ")\n");

            }
            else if(itemQuantities.size() == 2 && (itemSKU.startsWith("C") || itemSKU.startsWith("B"))
                    && itemQuantities.keySet().stream().anyMatch(key -> key.startsWith("COF"))){
                totalDiscount = 1.25;

            }
            else{
                itemPrice = Double.parseDouble(Inventory.getInstance().getPriceInfo(itemSKU));

                receipt.add(entry.getKey() + "\t\t\t   " + itemQuantity + "\t"
                        + parsePrice(String.valueOf(itemPrice * itemQuantity)) + "\n");
            }
        }
        allDiscounts = totalDiscount;
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
    public String getReceipt(){
        double totalCost = getTotalCost();
        if(!receipt.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("""
                ~~~ Bob's Bagels ~~~
                
                """ );
            sb.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            sb.append("""
                
                ----------------------------
                """);
            for(String s : receipt){
                sb.append(s);
            }
            sb.append("""
                    
                    ----------------------------
                    """);
            sb.append("Total\t\t\t\t    ").append(totalCost);
            sb.append("\n You saved a total of " + parsePrice(String.valueOf(allDiscounts)) + "\n");
            sb.append("""
                           on this shop
                                        
                            Thank you
                         for your order!
                    """);
            return sb.toString();

        }
        else{
            return "";
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
