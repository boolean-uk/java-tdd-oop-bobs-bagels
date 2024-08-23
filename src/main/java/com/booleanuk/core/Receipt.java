package com.booleanuk.core;

import java.util.ArrayList;

public interface Receipt {
    void addReceiptLine(String itemName, int quantity, float price);
    void getDiscountedSum(float sum);
    void createFinalReceipt();
    void printReceipt();
    ArrayList<String> getFinalReceipt();
}
