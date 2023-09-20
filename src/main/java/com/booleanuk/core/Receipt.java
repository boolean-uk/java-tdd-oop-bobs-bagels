package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Receipt {
    private final String businessName;
    private final String endMessage;

    public Receipt(String businessName, String endMessage){
        this.businessName = businessName;
        this.endMessage = endMessage;
    }

    public void printSelf(String productsCost,String discounts, double totalCost, double savedAmount){
        if (totalCost == 0.00d){
            System.out.println("Thanks for visiting " + this.businessName);
            System.out.println("Hope to see you again!");
        } else {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String finalDate = dateTime.format(formatter);
            System.out.println("\n~~~" + this.businessName + "~~~");
            System.out.println(finalDate);
            System.out.println("----------------------\n");
            System.out.println(productsCost);
            if (!Objects.equals(discounts, "")){
                System.out.println(discounts);
            }
            System.out.println("----------------------");
            System.out.println("Total     "+totalCost+"$\n");
            if (savedAmount != 0) {
                System.out.println("You saved a total of " + savedAmount +"$\n     on this shop\n");
            }
            System.out.println(this.endMessage);
        }
    }
}
