package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Receipt;
import com.booleanuk.core.SmsService;
import com.booleanuk.core.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtensionFourTest {

    public static final String CUSTOMER_PHONE_NUMBER = System.getenv("CUSTOMER_PHONE_NUMBER");
    public static final String STORE_PHONE_NUMBER = System.getenv("STORE_PHONE_NUMBER");
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");


    @Test
    public void createReceiptForOneProductTest() throws IOException {
//        Store store = new Store();
//        int basketId = store.createBasket();
//        store.addItemToBasket(new Bagel("plain"), basketId);
//        Receipt receipt = store.createReceipt(basketId);
//        Date date = new Date();
//        int width = 28;
//        String dateFormatted = new SimpleDateFormat("dd-MM-yyyy").format(date) + " " + new SimpleDateFormat("H:mm:ss").format(date);
//        dateFormatted = " ".repeat((width-dateFormatted.length())/2)+dateFormatted;
//
//        SmsService smsService = new SmsService(STORE_PHONE_NUMBER);
//
//      //  smsService.sendOrderSummary(CUSTOMER_PHONE_NUMBER, receipt);
//
//        String expected = "Message(body=Sent from your Twilio trial account - ~~~ Bob's Bagels ~~~\n" +
//                "\n" +
//                dateFormatted +
//                "\n" +
//                "----------------------------\n" +
//                "\n" +
//                "Plain Bagel        1   £0.39\n" +
//                "\n" +
//                "----------------------------\n" +
//                "Total                  £0.39\n" +
//                "\n" +
//                "         Thank you\n" +
//                "      for your order!, numSegments=2, direction=outbound-api, from=" +STORE_PHONE_NUMBER+", to=" + CUSTOMER_PHONE_NUMBER+", dateUpdated=2024-01-23T15:08:37Z, price=null, errorMessage=null, uri=/2010-04-01/Accounts/"+ACCOUNT_SID+ "/Messages/SM210da66c5969f04e89870234f96d2e85.json, accountSid="+ACCOUNT_SID+", numMedia=0, status=queued, messagingServiceSid=null, sid=SM210da66c5969f04e89870234f96d2e85, dateSent=null, dateCreated=2024-01-23T15:08:37Z, errorCode=null, priceUnit=USD, apiVersion=2010-04-01, subresourceUris={media=/2010-04-01/Accounts/"+ACCOUNT_SID+"/Messages/SM210da66c5969f04e89870234f96d2e85/Media.json})";
//
//
//        //smsService.makeOrder("", null);
//     //   Assertions.assertEquals(expected, smsService.sendOrderSummary(CUSTOMER_PHONE_NUMBER, receipt).toString());
//        smsService.dealWithIncomingMessages();
    }

}
