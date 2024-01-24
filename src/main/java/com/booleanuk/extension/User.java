package com.booleanuk.extension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class User {
    private String phoneNumber;
    private List<String> messageHistory;

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.messageHistory = new ArrayList<>();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getMessageHistoryList() {
        return messageHistory;
    }

    public void addToMessageHistory(String message, String messenger) {
        SimpleDateFormat DateFormat = new SimpleDateFormat("HH:mm");
        Calendar c = Calendar.getInstance();
        String timeStamp = DateFormat.format(c.getTime());
        this.messageHistory.add(messenger+": "+message+" ("+timeStamp+")");
    }

    public String getMessageHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message: messageHistory) {
            stringBuilder.append(message).append("\n");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }
}
