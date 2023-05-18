package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Receipt {
    private String dateTime;
    private ArrayList<String> productsBought;

    public static final String pound = "\u00a3";

    public Receipt(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);
        this.dateTime = formatDateTime;
        this.productsBought = new ArrayList<>();
    }

    public String getDateTime() {
        return dateTime;
    }
    public ArrayList<String> getProductsBought() {
        return productsBought;
    }

}
