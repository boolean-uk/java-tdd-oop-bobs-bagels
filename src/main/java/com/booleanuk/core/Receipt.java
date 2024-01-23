package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Receipt {

    private HashMap<String, BasketItem> basket;

    private ArrayList<String> receipt;

    // Static receipt variables
    private final int receiptWidth = 28;
    private final String header = "    ~~~ Bob's Bagels ~~~    ";
    private final String blank  = "                            ";
    private final String dashes = "----------------------------";
    private final String thanks = "         Thank you          ";
    private final String order  = "      for your order!       ";

    public Receipt(HashMap<String, BasketItem> basket) {
        this.basket = basket;
        this.receipt = new ArrayList<>();
    }

    public void createReceipt() {
        double total = 0;
        this.receipt.add(this.blank);
        this.receipt.add(this.header);
        this.receipt.add(this.blank);
        this.receipt.add(this.dashes);
        this.receipt.add(this.blank);
        for (String sku: basket.keySet()) {
            BasketItem basketItem = basket.get(sku);
            String name = basketItem.getName();
            String type = basketItem.getType();
            double quantity = (double) (basketItem.getQuantity());
            double price = basketItem.getPrice();
            price = price*quantity;
            total += price;

            String strPrice = Double.toString(price);
            int idx = strPrice.indexOf(".");
            strPrice = strPrice.substring(0, idx+3);
            String strQuantity = Integer.toString((int)(quantity));


            String space = " ";
            for (int i = 0; i < 20 - name.length() - type.length() - 3; i++) {
                space += " ";
            }
            String space2 = " ";
            for (int i = 0; i < 9 - strQuantity.length() - strPrice.length() - 2; i++) {
                space2 += " ";
            }

            String line = type + " " + name + space +  strQuantity + space2 + "$" + strPrice;
            this.receipt.add(line);
        }
        this.receipt.add(this.blank);
        this.receipt.add(this.dashes);
        String strTotal = Double.toString(total);
        strTotal = strTotal.substring(0, strTotal.indexOf(".")+3);
        String space = " ";
        for (int i = 0; i < (28 - 7 -strTotal.length()); i++){
            space += " ";
        }
        String line = "Total" + space + "$" + strTotal;
        this.receipt.add(line);
        this.receipt.add(this.blank);
        this.receipt.add(this.thanks);
        this.receipt.add(this.order);
        this.receipt.add(this.blank);
    }

    public void printReceipt() {
        for (String line: receipt) {
            System.out.println(line);
        }
    }

    public ArrayList<String> getReceipt() {
        return this.receipt;
    }

}
