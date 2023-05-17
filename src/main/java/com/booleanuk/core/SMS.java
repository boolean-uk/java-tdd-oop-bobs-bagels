package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        System.out.println(this.SMSContent);
    }
}
