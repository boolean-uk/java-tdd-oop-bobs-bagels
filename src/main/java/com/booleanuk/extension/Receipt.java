package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Order;

import java.util.HashMap;

public class Receipt {

    Receipt(){

    }

    public void printReceipt(Basket basket){


        System.out.println("~~~ Bob's Bagels ~~~");
        System.out.println("");
        System.out.println("2021-03-16 21:38:44");
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("");

        HashMap<String, Integer> number=basket.getItems();
        HashMap<String, Double> prices=basket.getPrices();

        for (String item: number.keySet()){
            System.out.println(item+"  "+number.get(item)+ " £"+prices.get(item)*number.get(item));
        }
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("Total"+ " £"+ basket.getTotal());
        System.out.println("");
        System.out.println("Thank you for your order!");


    }
}
