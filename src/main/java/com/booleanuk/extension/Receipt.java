package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static java.lang.Math.*;

public class Receipt {

    private Order order;

    Receipt(Order order){
        this.order = order;
    }

    public String printReceipt(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = date.format(dateFormat);
        double totalPriceNoDiscounts = 0;
        double totalPrice = order.getPrice() / 100.0;

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

        result += "---------------------------- \n" +
                "Discounts\n" +
                bagelDiscount() +
                coffeeDiscount() + "\n";

        result += "----------------------------\n" +
                "Total £" + totalPrice + "\n" +
                "Total w/o discounts £" + totalPriceNoDiscounts + "\n" +
                "Thank you for your order!\n" +
                "```";

        System.out.println(result);
        return result;
    }

    private String bagelDiscount(){
        String result = "";
        int bagelCount = order.getBagelList().size();
        if(bagelCount / 12 > 0){
            result += "12 Bagels £3.99 " + bagelCount / 12 + "x";
            if(bagelCount % 12 > 5){
               result += "\n6 Bagels £2.49 1x\n";
            }
        }
        else if(bagelCount / 6 > 0){
            result += "6 Bagels £2.49 1x\n";
        }
        return result;
    }

    private String coffeeDiscount(){
        String result = "";
        int coffeeAmount = order.getCoffeeList().size();
        int singularBagels = order.getBagelList().size() % 6;
        if(coffeeAmount > 0 && singularBagels > 0){
            result += "Coffee & Bagel £1.25 x" + min(coffeeAmount, singularBagels);
        }
        return result;
    }

}