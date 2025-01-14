package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Receipt {

    public HashMap<String, Integer> receiptBuilder(Basket basket) {
        HashMap<String, Integer> boughtItems = new HashMap<>();

        int quantityBagel = 0;
        int quantityFilling = 0;
        int quantityCoffee = 0;

        for (int i = 0; i < basket.getBasketList().size(); i++) {
            if (basket.getBasketList().get(i).getId().substring(0, 1).equals("B")) {
                if (!boughtItems.containsKey(basket.getBasketList().get(i).getDescription())) {
                    quantityBagel++;
                    boughtItems.put(basket.getBasketList().get(i).getId(), quantityBagel);
                } else {
                    boughtItems.remove(basket.getBasketList().get(i).getId(), quantityBagel);
                    quantityBagel++;
                    boughtItems.put(basket.getBasketList().get(i).getId(), quantityBagel);
                }
            }

            if (basket.getBasketList().get(i).getId().substring(0, 1).equals("F")) {
                if (!boughtItems.containsKey(basket.getBasketList().get(i).getDescription())) {
                    quantityFilling++;
                    boughtItems.put(basket.getBasketList().get(i).getId(), quantityFilling);
                } else {
                    boughtItems.remove(basket.getBasketList().get(i).getId(), quantityFilling);
                    quantityFilling++;
                    boughtItems.put(basket.getBasketList().get(i).getId(), quantityFilling);
                }
            }

            if (basket.getBasketList().get(i).getId().substring(0, 1).equals("C")) {
                if (!boughtItems.containsKey(basket.getBasketList().get(i).getDescription())) {
                    quantityCoffee++;
                    boughtItems.put(basket.getBasketList().get(i).getId(), quantityCoffee);
                } else {
                    boughtItems.remove(basket.getBasketList().get(i).getId(), quantityCoffee);
                    quantityCoffee++;
                    boughtItems.put(basket.getBasketList().get(i).getId(), quantityCoffee);
                }
            }
        }
        return boughtItems;
    }

    public StringBuilder printReceipt(Basket basket) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> list = receiptBuilder(basket);
        DecimalFormat df = new DecimalFormat();
        String desc = "";
        String type = "";
        double price = 0;

        sb.append("~~~ Bob's Bagels ~~~\n");
        sb.append(java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm\n")));
        sb.append("\n----------------------------\n");

        for (String name : list.keySet()) {
            for (int i = 0; i < basket.getStockList().size(); i++) {
                Item item = basket.getStockList().get(name);
                price = item.getPrice();
                desc = item.getDescription();
                type = item.getType();
            }
            sb.append(desc + " " + type + " " + list.get(name).toString() + " " + df.format(price * list.get(name)) + "£\n");
        }
        sb.append("\n----------------------------\n");
        sb.append("Total cost: " + df.format(basket.getTotalCost()) + "£\n");
        System.out.println(sb);
        return sb;
    }
}

