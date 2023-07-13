package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.Set;

public class Receipt {
    private LocalDateTime creationDate;

    public Receipt(){
        this.creationDate = LocalDateTime.now();
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String[] generateReceipt(Basket basket){
        Set<String> keys = basket.getProductsCount().keySet();
        String[] receipt = new String[keys.size() + 12];

        String line = "----------------------------";
        String bob = "~~~ Bob's Bagels ~~~";
        String date = creationDate.toString();
        int lineLength = line.length();

        receipt[0] = " ".repeat((lineLength - bob.length())/2) + bob;
        receipt[1] = "";
        receipt[2] = " ".repeat((lineLength - date.length())/2) + date;
        receipt[3] = "";
        receipt[4] = line;
        receipt[5] = "";

        int keyCounter = 6;
        for(String key : keys){

        }

        return receipt;
    }
}
