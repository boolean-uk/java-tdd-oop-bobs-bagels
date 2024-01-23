package com.booleanuk.extension;

import com.booleanuk.core.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;
public class TwilioClass {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure




    static Dotenv dotenv = Dotenv.load();

    public static final String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
    public static final String PHONE1 = dotenv.get("TWILIO_ACCOUNT_PONE1");
    public static final String PHONE2 = dotenv.get("TWILIO_ACCOUNT_PONE2");

    public static void main(String[] args) {
        String phoneString = "Error";

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

        phoneString = receipt.printBasket();

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber(PHONE1),
                        new PhoneNumber(PHONE2),
                        phoneString)
                .create();

        System.out.println(message.getSid());
    }
}