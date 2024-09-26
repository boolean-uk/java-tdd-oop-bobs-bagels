package com.booleanuk.core;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Receipt {
    Member customer = new Member();
    Basket basket = new Basket(customer);
    Inventory inventory;

    public void printReceipt() {
        basket.add(inventory.getItem("BGLO"));
        basket.add(inventory.getItem("BGLO"));
        basket.add(inventory.getItem("BGLO"));
        basket.add(inventory.getItem("BGLO"));
        basket.add(inventory.getItem("BGLO"));
        basket.add(inventory.getItem("BGLO"));
        basket.add(inventory.getItem("BGLO"));
        basket.add(inventory.getItem("BGLE"));
        basket.add(inventory.getItem("BGLP"));
        basket.add(inventory.getItem("COFB"));
        basket.add(inventory.getItem("COFB"));
        basket.add(inventory.getItem("COFB"));
        basket.add(inventory.getItem("FILB"));
        basket.add(inventory.getItem("FILE"));
        double cost = basket.totalCost();
        double discount = basket.discount();
        double total = cost - discount;
    }
}
