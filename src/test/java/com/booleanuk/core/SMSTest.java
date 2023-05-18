package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SMSTest {

    @Test
    void placeOrderFromSMS() {
        SMS newSMS = new SMS();
        String smsText = "ORDER:\n2 BGLO [FILC FILB]\n3 BGLE [FILS FILX FILH]\n2 COFB\n1 COFC";

        Assertions.assertTrue(newSMS.placeOrderFromSMS(smsText));
        smsText = "ORDER:\n2 BGLO [FIL FILB]";
        Assertions.assertFalse(newSMS.placeOrderFromSMS(smsText));

    }
}