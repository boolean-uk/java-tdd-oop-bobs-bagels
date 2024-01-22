package com.booleanuk.extension;

import com.booleanuk.core.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public class Receipt {

    private final Customer customer;

    public Receipt(Customer customer) {
        this.customer = customer;

    }



    public String printBasket() {
        return formatDate() + "\n" + formatBasketValues(this.customer.getBasket().getItemList()) + "\n"  + "Total                       " + this.customer.getTotalCost(this.customer.getBasket().getItemList());
    }

    public String formatDate() {

        return "     " + new SimpleDateFormat("dd-MM-yyyy : HH-mm-ss").format(new Date());
    }

    public String formatBasketValues(Map<Item, Integer> basketMap) {


        double totalCost = customer.getTotalCost(customer.getBasket().getItemList());
        Map<String, ArrayList<Double>> discounts = customer.getDiscounts();
        int discountCoffeeBagelDeal = 0;


        if(discounts.get("CoffeeBagelDeal") != null) {
            discountCoffeeBagelDeal= discounts.get("CoffeeBagelDeal").size();
        }


        //Remove access bagels and coffees so that i can add them ass CoffeeBagelDeals
        if(discountCoffeeBagelDeal > 0) {
            for(Map.Entry<Item,Integer> entry : basketMap.entrySet()) {
                if(entry.getKey().getName().equalsIgnoreCase("Coffee") || entry.getKey().getName().equalsIgnoreCase("Bagel")) {
                    if(entry.getValue() - 6 - discountCoffeeBagelDeal >= 0 && entry.getValue() - 6 - discountCoffeeBagelDeal < 12) {
                        entry.setValue(entry.getValue() - discountCoffeeBagelDeal);
                    } else if(entry.getValue() - 12 - discountCoffeeBagelDeal >= 0) {
                        entry.setValue(entry.getValue() - discountCoffeeBagelDeal);
                    } else if(entry.getValue() - discountCoffeeBagelDeal >= 0) {
                        entry.setValue(entry.getValue() - discountCoffeeBagelDeal);
                    }
                }

            }

        }




        ArrayList<Item> listOfItems = new ArrayList<>(basketMap.keySet());
        listOfItems.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        String returnString = String.format("%-15s %5s %10s", "Item", "Qty", "Price");

        returnString += "\n--------------------------------\n";



        for(Item item : listOfItems) {
            if(basketMap.get(item) == 0) {
                continue;
            }

            double discount = 0.00;
            double discountCorrect = 0.00;
            BigDecimal discountRounded = new BigDecimal(discount);


            if(discounts.get(item.getSkuCode()) != null) {
                discount = discounts.get(item.getSkuCode()).stream().mapToDouble(f -> f).sum();
                discountRounded = new BigDecimal(discount).setScale(2, RoundingMode.HALF_UP);
                discountCorrect = Double.parseDouble(String.valueOf(discountRounded));


            }


            returnString += String.format("%-15s %5d %10.2f", item.getVariant() + " " + item.getName(),basketMap.get(item), (basketMap.get(item) * item.getPrice() - discountCorrect));


            for(String str: discounts.keySet()) {

                if(str.equalsIgnoreCase(item.getSkuCode())) {


                    String negativeOrPositive = "";
                    if(Double.parseDouble(String.valueOf(discountRounded)) >= 0) {
                        negativeOrPositive = "-";
                    } else{
                        negativeOrPositive = "+";
                    }

                            returnString += "\n                         (" + negativeOrPositive + Math.abs(Double.parseDouble(String.valueOf(discountRounded))) + ")";
                }
            }
            returnString += "\n";

        }


        if(discounts.get("CoffeeBagelDeal") != null) {
            double discount = discounts.get("CoffeeBagelDeal").stream().mapToDouble(f -> f).sum();
            BigDecimal discountRounded = new BigDecimal(discount).setScale(2, RoundingMode.HALF_UP);

            String negativeOrPositive = "";
            if(Double.parseDouble(String.valueOf(discountRounded)) >= 0) {
                negativeOrPositive = "-";
            } else{
                negativeOrPositive = "+";
            }


            returnString += "CoffeeBagelDeal     " + discounts.get("CoffeeBagelDeal").size() + "       " + discounts.get("CoffeeBagelDeal").size() * 1.25;
            returnString += "\n                         (" + negativeOrPositive + Math.abs(Double.parseDouble(String.valueOf(discountRounded))) + ")\n";
        }


        returnString += "--------------------------------";



        return returnString;
    }




    public static void main(String[] args) {

        Customer customer = new Customer();

        Basket basket = new Basket(5);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Filling("Bacon"));
        basket.addItemToBasket(new Coffee("White"));
        basket.addItemToBasket(new Coffee("White"));
        basket.addItemToBasket(new Coffee("White"));
        basket.addItemToBasket(new Bagel("Plain"));

        System.out.println(new Bagel("plain").getName());

        customer.setBasket(basket);
        Receipt receipt = new Receipt(customer);


        System.out.println(receipt.printBasket());


    }
}
