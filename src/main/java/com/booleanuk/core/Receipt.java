package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    Basket basket;

    public Receipt(Basket basket){
      this.basket = basket;
      printReceipt();
    }

    public String getCurrentDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void printReceipt(){
        System.out.println("\n~~~ Bob's Bagels ~~~\n");
        System.out.println(getCurrentDateTime());
        System.out.println("\n--------------------\n");
        basket.getAmountOfItems().forEach((key, value) -> System.out.println(value + "x " + key.getSku() + " = " + (double)(key.getPrice() * value))) ;
        System.out.println("\n--------------------\n");
        System.out.println("Total:            " + basket.getTotalCosts() + "\n");
        System.out.println("Thank you");
        System.out.println("for your order! ");

    }

}
