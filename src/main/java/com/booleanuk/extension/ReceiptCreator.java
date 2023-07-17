package com.booleanuk.extension;

import java.time.LocalDateTime;

public class ReceiptCreator {

    private LocalDateTime receiptCreatedAt;
    private String companyName = "\n    ~~~ Bob's Bagels ~~~    ";

    public ReceiptCreator() {
        generateCreatedAt();
    }


    public String CreateFirstPartOfReceipt(BasketExt basketExt){
        StringBuilder receipt = new StringBuilder(companyName);
        receipt.append("\n   ")
                .append(getReceiptCreatedAt().getYear())
                .append("-").append(receiptCreatedAt.getMonth())
                .append("-").append(receiptCreatedAt.getDayOfMonth())
                .append(" ")
                .append(getReceiptCreatedAt().getHour())
                .append(":")
                .append(getReceiptCreatedAt().getMinute())
                .append(":")
                .append(getReceiptCreatedAt().getSecond())
                .append("    ")
                .append("\n")
                .append("---------------------------");

        return receipt.toString();
    }


    private void generateCreatedAt(){
        setReceiptCreatedAt(LocalDateTime.now());
    }

    public LocalDateTime getReceiptCreatedAt() {
        return receiptCreatedAt;
    }

    public void setReceiptCreatedAt(LocalDateTime receiptCreatedAt) {
        this.receiptCreatedAt = receiptCreatedAt;
    }
}
