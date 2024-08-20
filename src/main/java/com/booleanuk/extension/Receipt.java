
package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Receipt {
    private final HashMap<String, Integer> basket;
    private final Store store;


    public Receipt(HashMap<String, Integer> basket, Store store) {
        this.basket = basket;
        this.store = store;

    }

    public void printReceipt() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = date.format(dateFormat);
        System.out.println("~~~ Bob's Bagels ~~~");
        System.out.println(formattedDate);
        System.out.println("----------------------------");

        for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
            String sku = entry.getKey();
            int quantity = entry.getValue();

            Product product = store.getProductBySKU(sku);
        }
    }
}
