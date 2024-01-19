package com.booleanuk.extension;

import com.booleanuk.core.Basket;

import java.time.LocalDateTime;

public class Receipt {
    private String receipt;
    private LocalDateTime dateAndTime;

    public Receipt(Basket basket) {

    }

    public String generateReceipt(Basket basket) {
        return "";
    }

    public String createHeader() {
        return "";
    }

    public String createFooter() {
        return "";
    }

    public boolean printReceipt() {
        return false;
    }
}
