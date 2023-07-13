package com.booleanuk.core.receipt;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.products.Filling;
import com.booleanuk.core.products.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Receipt {

    private Map<Product, Integer> listOfProducts = new HashMap<>();

    public void createReceipt(Basket basket) {
        for (Product product : basket.getProducts()) {
            if (!listOfProducts.containsKey(product)) {
                listOfProducts.put(product, 1);
            } else {
                listOfProducts.put(product, listOfProducts.get(product) + 1);
            }
        }
    }

    public StringBuilder printReceipt(Basket basket) {


        createReceipt(basket);
        String header = "Bob's Bagels";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedTimeStamp = now.format(formatter);

        String separator = "-----------------------------";
        String thankYouMessage = "Thank you for your order!";

        StringBuilder receipt = new StringBuilder();
        receipt.append("\t ~~~ ").append(header).append(" ~~~\n").append("\t   ").append(formattedTimeStamp).append("\n").append(separator).append("\n");


        String result = "132";
        for (Map.Entry<Product, Integer> entry : listOfProducts.entrySet()) {
            if (!(entry.getKey() instanceof Bagel)) {
                BigDecimal totalPrice = entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue()));
                receipt.append(String.format("%-18s %2d  $%.2f", entry.getKey().toString(), entry.getValue(), totalPrice));
            } else {
                receipt.append(showBagelOnReceipt((Bagel) entry.getKey(), entry.getValue()));
            }

        }
        receipt.append(separator).append("\n").append(String.format("Total                  $%.2f\n\n", basket.summarizeBasket().total())).append("\t").append(thankYouMessage);


        return receipt;
    }


    public Map<Product, Integer> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(Map<Product, Integer> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }


    public StringBuilder showBagelOnReceipt(Bagel bagel, int amount) {
        BigDecimal totalPrice = bagel.getPriceWithOutFilling().multiply(BigDecimal.valueOf(amount));
        StringBuilder bagelOnReceipt = new StringBuilder();
        bagelOnReceipt.append(String.format("%-18s %2d  $%.2f\n", bagel, amount, totalPrice));

        for (Filling filling : bagel.getFillings()) {
            totalPrice = filling.getPrice().multiply(BigDecimal.valueOf(amount));
            bagelOnReceipt.append(String.format("   %-15s %2d  $%.2f\n", "^" + filling, amount, totalPrice));
        }

        return bagelOnReceipt;
    }


}
