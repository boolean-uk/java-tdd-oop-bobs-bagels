package com.booleanuk.extension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class Receipt {
    private ArrayList<Item> itemsInBasket;
    HashMap<String, ArrayList<Item>> itemMap = new HashMap<>();

    public Receipt(Basket basket) {
        this.itemsInBasket = basket.getBasket();
    }


    public void getRelevantInfo() {
        for (Item item : this.itemsInBasket) {
            itemMap.computeIfAbsent(item.getId(), k -> new ArrayList<>()).add(item);
        }

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
        System.out.println(date);
        return date;

    }

    public String constructBody() {
        String body = """
        
        %s
        
        ---------------------------
        """;
        return body;
    }

    public String constructTotal() {
        String total = """
        Total                 %s

        Thank you for your order!
        """;

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
