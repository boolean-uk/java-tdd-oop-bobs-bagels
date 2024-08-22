package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// The Discount class allows for the creation of discount objects, which contains the discounts for
// items purchased. The discount is represented as a Double[4] array. The first three spots hold the
// discounts for the flavoured bagels, the plain bagels and the coffee in that order
// The final spot holds the total discount
// This was done to provide information on individual discounts

// As all flavoured bagels are priced the same, I decided the 6/12 discount would apply to all of them
// As plain bagels are cheaper to buy six of than the 6 bagels discount, it received its own
// discount category, with only the 12-discount

// The logic of the system was that the bagel-bulk discounts would have priority over the coffee-bagel discount
// The discPrice() method calculates discount for bulks of twelve, then bulks of six
// then any remaining bagels are given a discount based on the number of coffees
public class Discount {

    Discount(){

    }


    public double[] discPrice(Basket basket){

        int plain=0;
        int bag=0;
        int coff=0;
        double disc=0;
        double diff12=0;
        double diff6=0;

        double bagPrice=0;
        double plainPrice=0;

        double discounts[]=new double[4];
        discounts[0]=0;
        discounts[1]=0;
        discounts[2]=0;
        discounts[3]=0;
        HashMap<Item,Integer> items=basket.getItems();

        for(Item i:items.keySet()){
            if(i.getSKU().contains("BGL")){

                if(i.getName().contains("Plain")){
                    plain+=items.get(i);

                }
                else {
                    bag+=items.get(i);
                }

            }else if(i.getSKU().contains("COF") & i.getName()=="Black Coffee"){
                coff+=items.get(i);
            }
        }


        double discPrice=0;

        if (bag>=12){
            bagPrice=bag/12*12*0.49;
            discPrice=bag/12*3.99;
            disc+=bagPrice-discPrice;
            bag=bag%12;
            discounts[0]+=bagPrice-discPrice;

        }



        if (bag>=6){
            bagPrice=0.49*6;
            discPrice=2.49;
            disc+=6*0.49-2.49;
            bag=bag%6;
            discounts[0]+=6*0.49-2.49;

        }

        if (plain>=12){
            plainPrice=plain/12*12*0.39;
            discPrice=plain/12*3.99;
            disc+=plainPrice-discPrice;
            plain=plain%12;
            discounts[1]+=plainPrice-discPrice;
        }


        int coffDisc=bag+plain;

        if (coff<coffDisc){
            coffDisc=coff;
        }

        while (bag > 0 & coff>0) {
            disc+=0.23;
            bag--;
            coff--;
            discounts[2]+=0.23;

        }


        while (plain > 0 & coff>0) {
            disc+=0.13;
            discounts[2]+=0.13;
            plain--;
            coff--;
        }


        discounts[3]=disc;


        return discounts;
    }




}
