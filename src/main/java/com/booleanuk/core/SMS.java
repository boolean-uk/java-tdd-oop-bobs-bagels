package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import static com.booleanuk.core.Inventory.inventoryProducts;

public class SMS {

    private StringBuilder SMSContent;

    private String dateTime;

    public SMS() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);
        this.dateTime = formatDateTime;
        this.SMSContent= new StringBuilder();
    }

    public StringBuilder getSMSContent() {
        return SMSContent;
    }

    public void setSMSContent(StringBuilder SMSContent) {
        this.SMSContent = SMSContent;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public void printSMS(){
        System.out.println(this.SMSContent); //content of order summary and delivery time
    }

    public ArrayList<OrderItem> parseSMSOrderReceived(String smsText){
        // Assuming you have received the SMS text from the customer
        ArrayList<OrderItem> orderItemsList = new ArrayList<>();
        // Remove any leading or trailing whitespace from the SMS text
        smsText = smsText.trim();

        // Check if the SMS text starts with the keyword "ORDER:"
        if (smsText.startsWith("ORDER:")) {
            // Remove the "ORDER:" keyword from the SMS text
            smsText = smsText.substring(6).trim();

            // Split the SMS text into separate lines
            String[] orderLines = smsText.split("\n");

            // Process each order line
            for (String orderLine : orderLines) {
                // Extract the quantity, SKU, and optional fillings (if present)
                String[] orderParts = orderLine.split(" ");
                int quantity = Integer.parseInt(orderParts[0]);
                String sku = orderParts[1];
                if(inventoryProducts.containsKey(sku)){ // If sku is in inventory
                    Product product = inventoryProducts.get(sku);
                    if(inventoryProducts.get(sku).getName().equals("Coffee")){
                        // Add Coffee
                        OrderItem coffee= new OrderItem(quantity,new Product(sku,product.getName(),product.getProductCost(),product.getVariant()));
                        orderItemsList.add(quantity,coffee);
                    }else if (inventoryProducts.get(sku).getName().equals("Bagel")) {

                        // Add Bagel
                        OrderItem bagel= new OrderItem(quantity,new Product(sku,product.getName(),product.getProductCost(),product.getVariant()));
                        orderItemsList.add(bagel);
                        // Check if there are fillings specified
                        if (orderParts.length > 2) {
                            // Extract the fillings (remove the enclosing square brackets)
                            String fillingsString = orderLine.substring(orderLine.indexOf("[") + 1, orderLine.indexOf("]"));
                            String[] fillings = fillingsString.split(" ");

                            // Process each filling
                            for (String fillingSKU : fillings) {
                                // Loop through all fillings of bagel

                                if(inventoryProducts.containsKey(fillingSKU)) {

                                    if (inventoryProducts.get(fillingSKU).getName().equals("Filling")) {
                                        bagel.getProduct().addFilling(fillingSKU);
                                    }

                                }else {
                                    return null;
                                }
                            }
                        }
                    }else{
                        System.out.println("Not Bagel or Coffee SKU");
                        return null;
                    }
                }else {
                    System.out.println("Invalid SKU");
                    return null;
                }


            }
        } else {
            // Invalid SMS format, handle accordingly
            System.out.println("Invalid SMS format");
            return null;
        }


        return orderItemsList;
    }
    public boolean placeOrderFromSMS(String smsOrderText){
        Basket basket = new Basket(100);


        ArrayList<OrderItem> orderitems=parseSMSOrderReceived(smsOrderText);
        if(orderitems==null)
            return false;
        for(OrderItem orderitem: orderitems){

            for(int i=0;i<orderitem.getQuantity();i++){
                //adds SKU to HashMap or updates its value
                Product product =orderitem.getProduct();
                basket.getProducts().add(product);
                int thisProductInBasketCount=0;
                if(basket.getProductCount().containsKey(product.getSKU())){
                    thisProductInBasketCount = basket.getProductCount().get(product.getSKU());
                }else{
                    thisProductInBasketCount = 0;
                }

                thisProductInBasketCount++;
                basket.getProductCount().put(product.getSKU(),thisProductInBasketCount);
            }


        }
        basket.placeOrder();
        return true;
    }
}
