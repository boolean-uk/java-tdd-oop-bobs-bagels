package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Customer;
import com.booleanuk.core.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Receipt {

    private final Basket basket;
    private final Customer customer;

    public Receipt(Basket basket, Customer customer) {
        this.basket = basket;
        this.customer = customer;
    }



    public String printBasket() {

        return formatDate() + "\n" + formatBasketValues(this.basket.getItemList()) + "\n" + formatSavings(this.basket.getItemList());


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
        double discount =
    }
}
