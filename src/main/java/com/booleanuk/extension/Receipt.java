package com.booleanuk.extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Receipt {
    private ArrayList<Item> itemList;
    private ArrayList<String> receipt;

    private double allDiscounts;

    private double totalCost;
    public Receipt(ArrayList<Item> itemList){
        this.itemList = itemList;
        this.receipt = new ArrayList<>();
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
    public double getTotalCost(){
        double total = 0;
        for(Item i : this.itemList){
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
        List<String> bagelSKUs = itemList.stream()
                .map(Item::getSKU)
                .toList();

        return bagelSKUs.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
