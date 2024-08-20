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
        int every=0;
        int coff=0;
        HashMap<Item, Double> bagelPrices=new HashMap<>();
        double disc=0;
        for(Item i:order.getItems()){
            if(i.getType()=="Bagel"){
                bagelPrices.put(i, i.getPrice());

                if(i.getName().contains("Onion")){
                    onion++;

                }
                else if (i.getName().contains("Plain")){
                    plain++;
                }
                else if (i.getName().contains("Everything")){
                    every++;
                }
            }else if(i.getType()=="Coffee" & i.getName()=="Black"){
                coff++;
            }
        }
        disc+=onion/6*0.45;
        disc+=plain/12*0.69;
        disc+=every/6*0.45;

        int remain=onion%6+plain%12+every%6;

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
