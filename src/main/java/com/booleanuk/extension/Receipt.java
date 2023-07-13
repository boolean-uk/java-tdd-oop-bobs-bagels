package com.booleanuk.extension;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Receipt {
    private LocalDateTime time;
    private Basket basket;

    public Receipt(Basket basket) {
        this.basket = basket;
        time = LocalDateTime.now();
    }

    public String printReceipt() {
        List<Product> products = basket.getProducts();
        Map<Product, Integer> quantities = new LinkedHashMap<>();

        for(Product p : products) {
            quantities.putIfAbsent(p, 0);
            quantities.put(p, quantities.get(p) + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("   ~~~ Bob's Bagels ~~~   \n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = time.format(formatter);
        sb.append(formattedTime+"\n");
        sb.append("-------------------------------\n");
        quantities.forEach((product, quantity) -> {
            sb.append(product.getVariant()+" "+product.getName()+"        "+quantity+" "+product.getPrice()+"\n");
            if(product.getName().equals("Bagel")) {
                Bagel bagel = (Bagel) product;
                for(Filling f: bagel.getFillings()){
                    sb.append(f.getVariant()+" "+f.getName()+"        "+quantity+" ("+f.getPrice()+")\n");
                }
            }
        });
        sb.append("-------------------------------\n");
        sb.append("Total                     " + basket.totalCost()+"\n");
        sb.append("Thank you for your order!");
        return sb.toString();
    }

}
