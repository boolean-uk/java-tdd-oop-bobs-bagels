package com.booleanuk.core;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.base.ResourceSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * THIS IS VERY MUCH NOT DONE.
 *
 * Sending order confirmation works and technically reading receiving messages work but it doesn't actually detect incoming messages via server :)
 */
public class SmsService {

    private PhoneNumber servicePhoneNumber;
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    ArrayList<String> handledMessages;
    public SmsService(String servicePhoneNumber) {
        this.servicePhoneNumber = new PhoneNumber(servicePhoneNumber);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        handledMessages = new ArrayList<>();
    }

    public void sendOrderSummary(PhoneNumber customerPhoneNumber, Receipt receipt) {
        Message.creator(customerPhoneNumber, servicePhoneNumber, receipt.toString()).create();
    }

    private void makeOrder(PhoneNumber customerPhoneNumber, String order) throws IOException {
        BufferedReader bufReader = new BufferedReader(new StringReader(order));

        String line=null;
        while( (line=bufReader.readLine()) != null )
        {
            // deal with order
        }
        sendOrderSummary(customerPhoneNumber, null);
    }

    private void seeHistory(PhoneNumber customerPhoneNumber, int no, boolean sent) {
        ResourceSet<Message> messages;
        String history;
        if(sent) {
            messages = Message.reader().setTo(servicePhoneNumber).setFrom(customerPhoneNumber).limit(no).read();
            history = "Latest received messages:\n";
        } else {
            messages = Message.reader().setFrom(servicePhoneNumber).setTo(customerPhoneNumber).limit(no).read();
            history = "Latest sent messages:\n";
        }

        for(Message record : messages) {
            Message message = Message.fetcher(record.getSid())
                    .fetch();
            String body = message.getBody().trim();
            String date = message.getDateCreated().toString();
            history += date + " : " + body.substring(0, Math.min(body.length(), 1600 / (no + 1))) + "\n"; //only send part of long messages to stay under character limit
        }

        Message.creator(customerPhoneNumber, servicePhoneNumber, history).create();
    }

    public void dealWithIncomingMessages() throws IOException {
        while(true) {
            ResourceSet<Message> messages = Message.reader().setTo(servicePhoneNumber).limit(2).read();

            for(Message record : messages) {
                String sid = record.getSid();
                if(!handledMessages.contains(sid)) {
                    Message message = Message.fetcher(sid).fetch();
                    String body = message.getBody().trim();
                    PhoneNumber from = message.getFrom();
                    if(body.equalsIgnoreCase("see sent history")) {
                        seeHistory(from, 3, true);
                    } else if(body.equalsIgnoreCase("see received history")) {
                        seeHistory(from, 3, false);
                    } else if(body.substring(0,5).equalsIgnoreCase("order")) {
                        makeOrder(from, body.substring(5));
                    }
                    handledMessages.add(sid);
                }

            }
        }
    }
}
