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

        int plain=0;
        int bag=0;
        int coff=0;
        double disc=0;
        double diff12=0;
        double diff6=0;

        double bagPrice=0;
        double plainPrice=0;

        for(Item i:order.getItems()){
            if(i.getSKU().contains("BGL")){

                if(i.getName().contains("Plain")){
                    plain++;

                }
                else {
                    bag++;
                }

            }else if(i.getSKU().contains("COF") & i.getName()=="Black"){
                coff++;
            }
        }

        double discPrice=0;

        if (bag>=12){
            bagPrice=0.49*bag;
            discPrice=3.99*bag/12;
            disc+=bagPrice-discPrice;
            bag=bag%12;
        }

        if (plain+bag>=12){
            double remainPrice=0.49*bag+0.39*(12-bag);
            disc=remainPrice-3.99;
            plain=plain-(12-bag);
            bag=0;

        }

        if (bag>=6){
            bagPrice=0.49*bag;
            discPrice=2.49*bag/6;
            disc+=bagPrice-discPrice;
            bag=bag%6;
        }

        if (plain>=12){
            plainPrice=0.39*plain;
            discPrice=2.49*plain/12;
            disc+=plainPrice-discPrice;
            plain=plain%12;
        }


        if (plain+bag>=6 & bag>2) {
            double remainPrice=0.49*bag+0.39*plain;
            disc=remainPrice-2.49;
            plain=plain+bag-6;
            bag=0;

        }




        int coffDisc=bag+plain;

        if (coff<coffDisc){
            coffDisc=coff;
        }

        while (bag > 0 & coff>0) {
            disc+=0.23;
            bag--;
            coff--;
        }

        while (plain > 0 & coff>0) {
            disc+=0.13;
            plain--;
            coff--;
        }





    return disc;
    }

    public double[] discPriceAlt(Order order){

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


        for(Item i:order.getItems()){
            if(i.getSKU().contains("BGL")){

                if(i.getName().contains("Plain")){
                    plain++;

                }
                else {
                    bag++;
                }

            }else if(i.getSKU().contains("COF") & i.getName()=="Black Coffee"){
                coff++;
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
