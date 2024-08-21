package com.booleanuk.extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static java.lang.Math.*;

public class Receipt {

    private Order order;
    private double totalPriceNoDiscounts;

    Receipt(Order order){
        this.order = order;
        totalPriceNoDiscounts = 0;
    }

    public String printReceipt(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = date.format(dateFormat);
        double totalPrice = order.getPrice() / 100.0;
        boolean discounts = false;

        String result = "```\n" +
                "    ~~~ Bob's Bagels ~~~\n" +
                "    " + formattedDate + "\n" +
                "---------------------------- \n";

        for(HashMap.Entry<String, Integer> entry : order.getBasket().entrySet()){
            Store store = order.getStore();
            String sku = entry.getKey();
            Product product = store.getProduct(sku);
            String name = product.getVariant();
            int price = product.getPrice();
            int amount = entry.getValue();
            String type;

            if(sku.startsWith("BGL")){
                type = "Bagel";
            }
            else if(sku.startsWith("COF")){
                type = "Coffee";
            }
            else{
                type = "Filling";
            }

            result += type + " " + name + " " + amount + " £" + price * amount / 100.0 + "\n";
            totalPriceNoDiscounts += price * amount / 100.0;
        }

        if(!bagelDiscount().isEmpty() || !coffeeDiscount().isEmpty()){
            discounts = true;
            result += "---------------------------- \n" +
                    "          Discounts";
        }

        result += bagelDiscount() +
                coffeeDiscount() + "\n";

        result += "----------------------------\n" +
                "Total £" + totalPrice + "\n";

        if(discounts){
            result += "Total w/o discounts £" + totalPriceNoDiscounts + "\n" +
            "You saved £" + round(totalPriceNoDiscounts - totalPrice, 2) + "!\n";
        }

        result += "Thank you for your order!\n" +
                "```";

        System.out.println(result);
        return result;
    }

    public double getTotalPriceNoDiscounts(){
        return totalPriceNoDiscounts;
    }

    private String bagelDiscount(){
        String result = "";
        int bagelCount = order.getBagelList().size();
        if(bagelCount / 12 > 0){
            result += "\n12 Bagels " + bagelCount / 12 + " £3.99";
            if(bagelCount % 12 > 5){
               result += "\n6 Bagels 1 £2.49";
            }
        }
        else if(bagelCount / 6 > 0){
            result += "\n6 Bagels 1 £2.49";
        }
        return result;
    }

    private String coffeeDiscount(){
        String result = "";
        int coffeeAmount = order.getCoffeeList().size();
        int singularBagels = order.getBagelList().size() % 6;
        if(coffeeAmount > 0 && singularBagels > 0){
            result += "\nCoffee & Bagel " + min(coffeeAmount, singularBagels) + " £1.25";
        }
        return result;
    }

    //Stolen from stackoverflow
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}