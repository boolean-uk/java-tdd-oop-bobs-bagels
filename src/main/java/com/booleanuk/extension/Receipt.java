package com.booleanuk.extension;

import com.booleanuk.core.*;

import java.text.SimpleDateFormat;
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



        String returnString = String.format("%-15s %5s %10s", "Item", "Qty", "Price");

        returnString += "\n--------------------------------\n";

        for(Map.Entry<Item, Integer> entry : basketMap.entrySet()) {

            returnString += String.format("%-15s %5d %10.2f", entry.getKey().getVariant() + " " + entry.getKey().getName(),entry.getValue(), (entry.getValue() * entry.getKey().getPrice()));
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
