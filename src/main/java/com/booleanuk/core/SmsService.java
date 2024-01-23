package com.booleanuk.core;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.base.ResourceSet;


public class SmsService {

    private PhoneNumber servicePhoneNumber;
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public SmsService(String servicePhoneNumber) {
        this.servicePhoneNumber = new com.twilio.type.PhoneNumber(servicePhoneNumber);
    }

    public Message sendOrderSummary(String customerPhoneNumber, Receipt receipt) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(customerPhoneNumber),
                        servicePhoneNumber,
                        receipt.toString())
                .create();
        return message;
    }

    public void makeOrder(String customerPhoneNumber, Basket basket) {

    }

    public void seeHistory(String customerPhoneNumber) {
//        ResourceSet<Message> messages = Message.reader().limit(20).read();
//
//        for(Message record : messages) {
//            Message message = Message.fetcher(record.getSid())
//                    .fetch();
//            System.out.println(message.getBody());
//
//        }

    }
}
