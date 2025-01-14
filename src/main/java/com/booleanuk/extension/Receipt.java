package com.booleanuk.extension;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class Receipt {
    private ArrayList<Item> itemsInBasket;
    private HashMap<String, ArrayList<Item>> itemCount = new HashMap<>();
    private ArrayList<String> itemTypes = new ArrayList<>();

    public ArrayList<Item> getItemsInBasket() {
        return itemsInBasket;
    }

    public Receipt(Basket basket) {
        this.itemsInBasket = basket.getBasket();

    }

    public void checkItemTypes() {
        for (Item item : itemsInBasket) {
            if (!itemTypes.contains(item.getId())) {
                itemTypes.add(item.getId());
            }
        }
    }

    public void dataToMap() {
        for (Item item : this.itemsInBasket) {
            itemCount.computeIfAbsent(item.getId(), k -> new ArrayList<>()).add(item);
        }
        System.out.println(itemCount);
    }


    public String constructDate() {
        StringBuilder stringBuilder = new StringBuilder();
        String date = """
        
           ~~~ Bob's Bagels ~~~

                %s

        ---------------------------
        """;
        String dateNow = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        date = String.format(date, dateNow);
        return date;

    }

    public String constructBody() {
        checkItemTypes();
        String body = """
        
        %s
        ---------------------------
        """;
        StringBuilder stringbuilder = new StringBuilder();

        for (String id :  itemTypes) {
            stringbuilder.append(
                                    itemCount.get(id).getFirst().getDescription() + " "
                                    + itemCount.get(id).getFirst().getClass().toString().replace("class com.booleanuk.extension.", "") + "\t\t"
                                    + itemCount.get(id).size() + "\t\t"
                                    + Math.floor(itemCount.get(id).getFirst().getPrice() * (double) itemCount.get(id).size() * 100) /100 + "\n"
            );
        }
        return String.format(body, stringbuilder);
    }

    public String constructTotal() {
        double totalPrice = 0.0;
        for (Item item : this.itemsInBasket) {
            totalPrice += item.getPrice();
        }
        totalPrice = Math.floor(totalPrice * 100)/100;

        String total = """
        Total                 %s

        Thank you for your order!
        """;
        total = String.format(total, totalPrice);
        return total;
    }

    public String conStructReceipt(String header, String body, String total) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(header);
        stringbuilder.append(body);
        stringbuilder.append(total);
        return stringbuilder.toString();
    }







}
