package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Order;

public class Discount {

    Discount(){

    }

    public void discPrice(Order order){
        int onion=0;
        int plain=0;
        int every=0;
        int coff=0;
        int bag=0;
        double disc=0;
        for(Item i:order.getItems()){
            if(i.getType()=="Bagel"){
                bag++;

                if(i.getName()=="Onion"){
                    onion++;
                }
                else if (i.getName()=="Plain"){
                    plain++;
                }
                else if (i.getName()=="Everything"){
                    every++;
                }
            }else if(i.getType()=="Coffee"){
                coff++;
            }
        }


    }
}
