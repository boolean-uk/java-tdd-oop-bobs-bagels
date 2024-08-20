package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Order;

public class Discount {

    Discount(){

    }

    public double discPrice(Order order){
        int onion=0;
        int plain=0;
        int every=0;
        int coff=0;
        int bag=0;
        double disc=0;
        for(Item i:order.getItems()){
            if(i.getType()=="Bagel"){


                if(i.getName().contains("Onion")){
                    onion++;
                    bag++;
                }
                else if (i.getName().contains("Plain")){
                    plain++;
                }
                else if (i.getName().contains("Everything")){
                    every++;
                    bag++;
                }
            }else if(i.getType()=="Coffee" & i.getName()=="Black"){
                coff++;
            }
        }
        disc+=onion/6*0.45;
        disc+=plain/12*0.69;
        disc+=every/6*0.45;

        int remainBag=onion%6;
        int remainPlain=plain%12;

        if(coff>remainBag){
            disc+=remainBag*0.23;
        }else{
            disc+=coff*0.23;
        }

        if(coff>remainPlain){
            disc+=remainPlain*0.13;
        }else{
            disc+=coff*0.13;
        }

    return disc;
    }


}
