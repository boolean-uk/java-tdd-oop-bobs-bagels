package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.BobsBagels;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.MessagingResponse;

import static spark.Spark.*;
public class TwilioApp {

    public static void main(String[] args) {
        BobsBagels bobsBagels = new BobsBagels();

        port(8080);
        post("/sms", (req, res) -> {
            res.type("application/xml");
            String[] userMsg = req.queryParams("Body").split(" ");
            String user = req.queryParams("From");
            Basket basket = bobsBagels.getBasket(user);
            String response = "";

            switch (userMsg[0].toLowerCase()) {
                case "add":
                    response = basket.add(userMsg[1].toUpperCase());
                    break;
                case "remove":
                    response = basket.remove(userMsg[2].toUpperCase());
                    break;
                case "order":
                    response = basket.orderSummary();
                    break;
                default:
                    response = "Please input correct commands: \n 1. add [SKU]\n 2. remove [SKU]\n 3. order";
            }

            Body body = new Body
                    .Builder(response)
                    .build();
            Message sms = new Message
                    .Builder()
                    .body(body)
                    .build();
            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
            return twiml.toXml();
        });
    }
}
