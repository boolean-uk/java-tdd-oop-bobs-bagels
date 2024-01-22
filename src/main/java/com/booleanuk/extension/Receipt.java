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
        return formatDate() + "\n" + formatBasketValues(this.customer.getBasket().getItemList()) + "\n" + formatSavings(this.customer.getBasket().getItemList())  + "Total                       " + this.customer.getTotalCost(this.customer.getBasket().getItemList());
    }

    public String formatDate() {

        return "     " + new SimpleDateFormat("dd-MM-yyyy : HH-mm-ss").format(new Date());
    }

    public String formatBasketValues(Map<Item, Integer> basketMap) {


        double totalCost = customer.getTotalCost(customer.getBasket().getItemList());
        Map<String, ArrayList<Double>> discounts = customer.getDiscounts();


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

        returnString += "--------------------------------";

        return returnString;
    }

    public String formatSavings(Map<Item, Integer> basketMap) {


        return "";
    }


    public static void main(String[] args) {

        Customer customer = new Customer();

        Basket basket = new Basket(5);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Filling("Bacon"));
        basket.addItemToBasket(new Coffee("White"));

        System.out.println(new Bagel("plain").getName());

        customer.setBasket(basket);
        Receipt receipt = new Receipt(customer);


        System.out.println(receipt.printBasket());


    }
}
