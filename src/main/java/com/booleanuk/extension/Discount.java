package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Discount {

    Discount(){

    }

    public double discPrice(Order order){
        int onion=0;
        int plain=0;
        int bag=0;
        int coff=0;
        HashMap<Item, Double> bagelPrices=new HashMap<>();
        double disc=0;
        double price=order.getTotal();
        double diff12=0;
        double diff6=0;

        double bagPrice=0;
        double plainPrice=0;

        for(Item i:order.getItems()){
            if(i.getType()=="Bagel"){
                bagelPrices.put(i, i.getPrice());

                if(i.getName().contains("Plain")){
                    plain++;
                    plainPrice+=0.39;

                }
                else {
                    bag++;
                    bagPrice+=0.49;
                }

            }else if(i.getType()=="Coffee" & i.getName()=="Black"){
                coff++;
            }
        }




        if (bag>12){
            diff12=3.99*bag/12;
            disc+=bagPrice-diff12;
        }


        int remain=(bag%12)%6;

        if (coff<remain){
            remain=coff;
        }


        Double [] price= bagelPrices.values().toArray(new Double[0]);
        Arrays.sort(price, Comparator.reverseOrder());


        for (int i=0; i<remain; i++){
            disc+=price[i]+0.99-1.25;
            System.out.println(price[i]);
            System.out.println(disc);
        }


    return disc;
    }


}
