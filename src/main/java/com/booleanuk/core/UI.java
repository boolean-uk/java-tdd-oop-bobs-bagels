package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class UI {
    public String printRecipe(Customer customer) {
        String result = "";
        result += "~~~ Bob's Bagels ~~~ \n";
        result += LocalDateTime.now() + "\n";
        result += "----------------------------";
        result += customer.checkBasket();
        result += "----------------------------";
        result += "Total: £" + (double) customer.getTotalCost() / 100;
        result += " Thank you";
        result += "for your order!";
        return result;
    }
}







