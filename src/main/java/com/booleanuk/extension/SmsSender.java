package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.Item;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import io.github.cdimascio.dotenv.Dotenv;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SmsSender {
    public static Dotenv dotenv = Dotenv.load();
    public static final String ACCOUNT_SID = dotenv.get("TWILIO_ACC");
    public static final String AUTH_TOKEN = dotenv.get("TWILIO_TOKEN");
    private Map<String, StringBuilder> orderHistory = new HashMap<>();
    private Basket basket;
    public SmsSender(){
        Inventory.createInventory();
        basket = new Basket(Integer.MAX_VALUE);
    }
    /*public static void main(String[] args) {
        SmsSender sms = new SmsSender();
        String order = """
                Order
                Bagel Onion 5
                Filling Bacon 2
                Coffee Black 2""";
        String order2 = """
                Invalid
                Bagel Onion 5
                Filling Bacon 2
                Coffee Black 2""";
        String order3 = """
                Order
                Bagel Onion 16
                Filling Bacon 12
                Coffee Black 6""";
        sms.sendOrder(order);
        //sms.sendOrder(order2);
        sms.sendOrder(order3);
        sms.checkHistory();


    }*/
    public void sendOrder(String order){
        StringBuilder response = new StringBuilder();
        orderHistory.put("Client",new StringBuilder(order));
        this.basket.getShoppingList().clear();
        String[] items = order.split("\n");

        if(items[0].equals("Order")){

            for(int i=1;i<items.length;i++){
                String name = items[i].split(" ")[0];
                String variant = items[i].split(" ")[1];

                int quantity = Integer.parseInt(items[i].split(" ")[2]);
                for(int j=0;j<quantity;j++){
                    basket.add(name,variant);

                }
            }
            response.append("~~~ Bob's Bagels ~~~\n");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            response.append("Order placed at:  ").append(formattedDateTime).append("\n");
            Random random = new Random();
            response.append("Time for delivery: ").append(random.nextInt(10)+5).append(" minutes\n");
            response.append("------------------------\n");
            for(Map.Entry<Item, Integer> entry : basket.getShoppingList().entrySet()){
                String itemName = entry.getKey().getName();
                String itemVariant = entry.getKey().getVariant();
                String quantity =  String.valueOf(entry.getValue());
                String price = String.format("%.2f",(new BigDecimal(entry.getValue()).multiply(entry.getKey().getPrice()))) + " $";

                StringJoiner joiner = new StringJoiner(" ");
                joiner.add(itemName).add(itemVariant).add(quantity).add(price);

                response.append(joiner).append("\n");
            }

            response.append("Total: ").append(String.format("%.2f", basket.totalCostWithoutDiscounts())).append(" $");
            response.append("\n------------------------\n");
            response.append("Thank you for shopping at Bob's Bagels!");
        }
        else{
            response.append("Dear Customer, your message should begin with 'Order'");
        }

        orderHistory.put("Bob's Bagels" ,response);
        System.out.println(response);
        sendSMS(String.valueOf(response));
    }
    public void sendSMS(String body){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(""),
                        new com.twilio.type.PhoneNumber(""),
                        body)
               .create();

    }

    public void checkHistory(){
        for(Map.Entry<String, StringBuilder> entry : orderHistory.entrySet()){
            System.out.println("Sent by: " + entry.getKey());
            System.out.println("Message content: \n" + entry.getValue() + "\n");

        }
    }
}