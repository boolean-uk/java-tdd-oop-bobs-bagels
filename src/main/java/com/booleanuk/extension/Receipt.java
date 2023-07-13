package com.booleanuk.extension;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
        Map<Product, BigDecimal> discounts = basket.calculateDiscounts();

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
            BigDecimal productsPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            sb.append(product.getVariant()+" "+product.getName()+"        "+quantity+" "+productsPrice+"\n");
            if(product.getName().equals("Bagel")) {
                Bagel bagel = (Bagel) product;

                BigDecimal discount = discounts.get(product);
                if(discount != null && !discount.equals(BigDecimal.valueOf(0.0)))
                    sb.append("                    (-" + discount + ")\n");

                Map<Filling, Long> fillingsQuantities = bagel.getFillings().stream()
                        .collect(Collectors.groupingBy(filling -> filling, Collectors.counting()));

                fillingsQuantities.forEach((f, fillingQuantity) -> {
                    BigDecimal fillingsPrice = f.getPrice().multiply(BigDecimal.valueOf(fillingQuantity));
                    sb.append(f.getVariant()+" "+f.getName()+"        "+fillingQuantity+" ("+fillingsPrice+")\n");
                });
            } else {
                BigDecimal discount = discounts.get(product);
                if(discount != null && !discount.equals(BigDecimal.valueOf(0.0)))
                    sb.append("                    (-" + discount + ")\n");
            }
        });
        sb.append("-------------------------------\n");
        sb.append("Total                     " + basket.totalCost()+"\n");
        sb.append("Thank you for your order!");
        return sb.toString();
    }

}
