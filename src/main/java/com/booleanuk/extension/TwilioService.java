package com.booleanuk.extension;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TwilioService {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = TwilioService.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static final String ACCOUNT_SID = properties.getProperty("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = properties.getProperty("TWILIO_AUTH_TOKEN");
    private static final String SELF_NUMBER = properties.getProperty("TWILIO_SELF_NUMBER");

    public static String sendReceipt(String to, String receipt) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(SELF_NUMBER),
                receipt
        ).create();

        return message.getSid();
    }
}
