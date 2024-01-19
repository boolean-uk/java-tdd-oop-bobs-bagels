package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Customer;
import com.booleanuk.core.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Receipt {

    private final Customer customer;

    public Receipt(Customer customer) {
        this.customer = customer;

    }



    public String printBasket() {

        System.out.println(formatDate() + "\n" + formatBasketValues(this.customer.getBasket().getItemList()) + "\n" + formatSavings(this.customer.getBasket().getItemList()));
        return formatDate() + "\n" + formatBasketValues(this.customer.getBasket().getItemList()) + "\n" + formatSavings(this.customer.getBasket().getItemList());


    }

    public String formatDate() {

        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    public String formatBasketValues(Map<Item, Integer> basketMap) {
        String returnString = "--------------------";


        for(Map.Entry<Item, Integer> entry : basketMap.entrySet()) {
            returnString += "\n" + entry.getKey().getVariant() +
                    " " + entry.getKey().getName() + "       " + entry.getValue() + "  £" +
                    (entry.getKey().getPrice() * entry.getValue());


        }
        returnString += "\n--------------------";
        return returnString;
    }

    public String formatSavings(Map<Item, Integer> basketMap) {
        return "";
    }
}
