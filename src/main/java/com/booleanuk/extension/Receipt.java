package com.booleanuk.extension;

import java.time.LocalDateTime;
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
        Map<Product, Integer> quantities = new HashMap<>();

        for(Product p : products) {
            quantities.putIfAbsent(p, 0);
            quantities.put(p, quantities.get(p) + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("   ~~~ Bob's Bagels ~~~   \n");
        sb.append(time+"\n");
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
