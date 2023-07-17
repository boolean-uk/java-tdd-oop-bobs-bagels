package com.booleanuk.extension;

import com.booleanuk.extension.product.BagelSandwich;
import com.booleanuk.extension.product.Coffee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var basket = new Basket(10);
        basket.addBagel(new BagelSandwich(BagelSandwich.Bagel.BGLO, BagelSandwich.Filling.values()));
        basket.addCoffee(Coffee.COFB);

        var receipt = basket.getReceipt();

        System.out.println(receipt);

        var in = new Scanner(System.in);
        System.out.println("Enter phone number (including area code) to send the receipt to: ");
        var recipientPhoneNumber = in.next();

        var message = "Your order from Bob's Bagels has been confirmed";

        TwilioService.sendSmsMessage(recipientPhoneNumber, message);
    }
}
