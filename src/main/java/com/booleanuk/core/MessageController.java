package com.booleanuk.core;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class MessageController {
  public static final String TWILIO_ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  public static final String TWILIO_AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
  public static final String TWILIO_PHONE_NUMBER = System.getenv("TWILIO_PHONE_NUMBER");

  static {
    Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
  }

  public static void notifyUser(String messageContent, String toNumber) {
    Message message = Message.creator(new PhoneNumber(toNumber), new PhoneNumber(TWILIO_PHONE_NUMBER), messageContent)
        .create();

    System.out.println("Sent message to phone number '" + toNumber + "'\n" + message.getBody());
  }
}
