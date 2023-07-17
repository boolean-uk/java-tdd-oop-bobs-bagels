package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Receipt {
    private final LocalDateTime date;
    private HashMap<String, String> itemPrices;
    private ArrayList<IItemType> itemOrder;
    private final HashMap<String, String> itemName;
    public Receipt(ArrayList<Item> items, HashMap<String, Integer> activeDiscounts) {
        date = LocalDateTime.now();
        fillItemPrices(items, activeDiscounts);
        fillItemOrder();
        itemName = new HashMap<String, String>();
        itemName.put("BGL", "Bagel");
        itemName.put("COF", "Coffee");
        itemName.put("FIL", "Filling");
    }
    private void fillItemPrices(ArrayList<Item> items, HashMap<String, Integer> activeDiscounts) {
        HashMap<IItemType, Integer> itemCounts = new HashMap<IItemType, Integer>();
        HashMap<IItemType, Double> itemDiscounts = new HashMap<IItemType, Double>();
        itemPrices = new HashMap<String, String>();
        for (BagelType bagelType : BagelType.values()) {
            itemPrices.put(bagelType.getSku(), "");
            itemDiscounts.put(bagelType, 0.0);
            itemCounts.put(bagelType, 0);
        }
        for (CoffeeType coffeeType : CoffeeType.values()) {
            itemPrices.put(coffeeType.getSku(), "");
            itemDiscounts.put(coffeeType, 0.0);
            itemCounts.put(coffeeType, 0);
        }
        for (FillingType fillingType : FillingType.values()) {
            itemPrices.put(fillingType.getSku(), "");
            itemDiscounts.put(fillingType, 0.0);
            itemCounts.put(fillingType, 0);
        }
        for (Item item : items) {
            itemCounts.put(item.getItemType(), itemCounts.get(item.getItemType()) + 1);
            if (item.getSku().startsWith("BGL"))
                for (Map.Entry<FillingType, Integer> entry : ((Bagel)item).getFillings().entrySet())
                    itemCounts.put(entry.getKey(), itemCounts.get(entry.getKey()) + entry.getValue());
        }

        for (String discountString : activeDiscounts.keySet()) {
            double initialPrice = 0;
            List<String> discountedItems = new LinkedList<String>(Arrays.asList(discountString.split(",")));
            String priceString = discountedItems.remove(discountedItems.size() - 1);
            double newPrice = Double.parseDouble(priceString.substring(priceString.indexOf("=") + 1));
            int totalCount = 0;
            for (String itemString : discountedItems) {
                String itemSku = itemString.substring(itemString.indexOf("*") + 1);
                int itemCount = Integer.parseInt(itemString.substring(0, itemString.indexOf("*")));
                totalCount += itemCount * activeDiscounts.get(discountString);
                initialPrice += Basket.itemTypeBySku.get(itemSku).getPrice() * (double)itemCount;
            }
            double difference = (initialPrice - newPrice) * activeDiscounts.get(discountString);
            if(difference == 0.0) continue;
            for (String itemString : discountedItems) {
                String itemSku = itemString.substring(itemString.indexOf("*") + 1);
                int itemCount = Integer.parseInt(itemString.substring(0, itemString.indexOf("*"))) * activeDiscounts.get(discountString);
                itemDiscounts.put(Basket.itemTypeBySku.get(itemSku),
                        itemDiscounts.get(Basket.itemTypeBySku.get(itemSku)) + (Math.round(100000.0 * difference * (double)itemCount / (double)totalCount)) / 100000.0);
            }
        }
        for(String itemSku : itemPrices.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("count=");
            sb.append(itemCounts.get(Basket.itemTypeBySku.get(itemSku)));
            sb.append(",discount=");
            sb.append(itemDiscounts.get(Basket.itemTypeBySku.get(itemSku)));
            itemPrices.put(itemSku, sb.toString());
        }
    }
    private void fillItemOrder() {
        itemOrder = new ArrayList<IItemType>();
        itemOrder.addAll(Arrays.asList(BagelType.values()));
        itemOrder.addAll(Arrays.asList(CoffeeType.values()));
        itemOrder.addAll(Arrays.asList(FillingType.values()));
    }
    public String toStringExtension3() {
        double totalPrice = 0.0;
        StringBuilder sb = new StringBuilder();
        sb.append("\n      ~~~Bob's Bagels~~~      \n\n");
        sb.append(date.format(DateTimeFormatter.ofPattern("     yyyy-MM-dd HH:mm:ss\n\n")));
        sb.append("-".repeat(31));
        sb.append("\n");
        for(IItemType itemType : itemOrder) {
            String itemString = itemPrices.get(itemType.getSku());
            int itemCount = Integer.parseInt(itemString.substring(6, itemString.indexOf(",")));
            double itemDiscount = Double.parseDouble(itemString.substring(itemString.indexOf(",") + 10));
            if(itemCount == 0) continue;
            sb.append(padRightSpaces(itemType.getVariant() + " " + itemName.get(itemType.getSku().substring(0, 3)), 20));
            sb.append(padRightSpaces(String.valueOf(itemCount), 5));
            sb.append("£");
            double itemsPrice = Math.round(((double)itemCount * itemType.getPrice() - itemDiscount) * 10000.0) / 10000.0;
            totalPrice += itemsPrice;
            sb.append(itemsPrice);
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("-".repeat(31));
        sb.append("\n");
        sb.append(padRightSpaces("Total", 25));
        sb.append("£");
        sb.append(Math.round(totalPrice * 100.0) / 100.0);
        sb.append("\n");
        sb.append(padLeftSpaces("Thank you", 20));
        sb.append("\n");
        sb.append(padLeftSpaces("for your order!", 23));
        sb.append("\n");

        return sb.toString();
    }
    public String padRightSpaces(String inputString, int length) {
        if (inputString.length() >= length)
            return inputString;
        StringBuilder sb = new StringBuilder();
        sb.append(inputString);
        while (sb.length() < length)
            sb.append(' ');
        return sb.toString();
    }
    public String padLeftSpaces(String inputString, int length) {
        if (inputString.length() >= length)
            return inputString;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length())
            sb.append(' ');
        sb.append(inputString);
        return sb.toString();
    }
    public String toString() {
        double totalPrice = 0.0;
        double totalDiscount = 0.0;
        StringBuilder sb = new StringBuilder();
        sb.append("\n      ~~~Bob's Bagels~~~      \n\n");
        sb.append(date.format(DateTimeFormatter.ofPattern("     yyyy-MM-dd HH:mm:ss\n\n")));
        sb.append("-".repeat(31));
        sb.append("\n");
        for(IItemType itemType : itemOrder) {
            String itemString = itemPrices.get(itemType.getSku());
            int itemCount = Integer.parseInt(itemString.substring(6, itemString.indexOf(",")));
            double itemDiscount = Double.parseDouble(itemString.substring(itemString.indexOf(",") + 10));
            if(itemCount == 0) continue;
            sb.append(padRightSpaces(itemType.getVariant() + " " + itemName.get(itemType.getSku().substring(0, 3)), 20));
            sb.append(padRightSpaces(String.valueOf(itemCount), 5));
            sb.append("£");
            double itemsPrice = Math.round(((double)itemCount * itemType.getPrice() - itemDiscount) * 10000.0) / 10000.0;
            totalPrice += itemsPrice;
            totalDiscount += itemDiscount;
            sb.append(itemsPrice);
            sb.append("\n");
            if(itemDiscount != 0) {
                String discountString = "(-£" + itemDiscount + ")";
                sb.append(padLeftSpaces(discountString, 23 + discountString.length()));
                sb.append("\n");
            }
        }
        sb.append("\n");
        sb.append("-".repeat(31));
        sb.append("\n");
        sb.append(padRightSpaces("Total", 25));
        sb.append("£");
        sb.append(Math.round(totalPrice * 100.0) / 100.0);
        sb.append("\n\n");
        sb.append(padLeftSpaces("You saved a total of £" + Math.round(totalDiscount * 100.0) / 100.0, 30));
        sb.append("\n\n");
        sb.append(padLeftSpaces("Thank you", 20));
        sb.append("\n");
        sb.append(padLeftSpaces("for your order!", 23));
        sb.append("\n");

        return sb.toString();
    }
}
