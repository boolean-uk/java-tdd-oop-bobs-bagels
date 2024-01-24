package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserConstructor() {
        User user = new User("12345");
        Assertions.assertEquals("12345",user.getPhoneNumber());
    }

    @Test
    void testAddToAndGetMessageHistory() {
        User user = new User("12345");
        user.addToMessageHistory("Yo", "Me");
        user.addToMessageHistory("Yo", "Him");
        SimpleDateFormat DateFormat = new SimpleDateFormat("HH:mm");
        Calendar c = Calendar.getInstance();
        String timeStamp = DateFormat.format(c.getTime());
        Assertions.assertEquals("Me: Yo ("+timeStamp+")\nHim: Yo ("+timeStamp+")", user.getMessageHistory());
    }
}