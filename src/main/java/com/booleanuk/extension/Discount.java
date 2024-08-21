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
            if(i.getType()=="Bagel"){

                if(i.getName().contains("Plain")){
                    plain++;

                }
                else {
                    bag++;
                }

            }else if(i.getType()=="Coffee" & i.getName()=="Black"){
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

    public double discPriceAlt(Order order){

        int plain=0;
        int bag=0;
        int coff=0;
        double disc=0;
        double diff12=0;
        double diff6=0;

        double bagPrice=0;
        double plainPrice=0;

        for(Item i:order.getItems()){
            if(i.getType()=="Bagel"){

                if(i.getName().contains("Plain")){
                    plain++;

                }
                else {
                    bag++;
                }

            }else if(i.getType()=="Coffee" & i.getName()=="Black"){
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


        if (bag>=6){
            bagPrice=0.49*bag;
            discPrice=2.49*bag/6;
            disc+=bagPrice-discPrice;
            bag=bag%6;
        }

        if (plain>=12){
            plainPrice=0.39*bag;
            diff12=3.99*bag/12;
            disc+=plainPrice-diff12;
            plain=plain%12;
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




}
