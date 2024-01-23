package com.booleanuk.extension;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Receipt {

    String timeCreated;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    Map<Product, Integer> quantityMap;

    public Receipt(Map<Product, Integer> quantityMap){
        this.quantityMap = quantityMap;
        this.timeCreated = java.time.LocalDateTime.now().format(formatter);
    }

    @Override
    public String toString() {
        String formattedDateTime = timeCreated;

        StringBuilder result = new StringBuilder();
        result.append("~~~ Bob's Bagels ~~~\n\n");
        result.append(formattedDateTime).append("\n\n");
        result.append("----------------------------\n");

        return result.toString();
    }
}
