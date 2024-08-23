package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Order;

import java.util.HashMap;
// The receipt class can generate receipts for the items bought, and display the discount if discountShow=true
public class Receipt {

    Receipt(){

    }

    public void printReceipt(Basket basket, boolean discountShow){


        double[] discountPrices=new double[4];

        if(discountShow){
            Discount discount= new Discount();
            discountPrices=discount.discPrice(basket);
            basket.setTotal(basket.getTotal()- discountPrices[3]);
        }

        System.out.println("~~~ Bob's Bagels ~~~");
        System.out.println("");
        System.out.println("2021-03-16 21:38:44");
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("");



        HashMap<Item, Integer> number=basket.getItems();
        for (Item item: number.keySet()){


            System.out.println(item.getName()+"  "+number.get(item)+ " £"+String.format("%.2f",item.getPrice()*number.get(item)));
        }

        if(discountShow){
            double fullDiscount=0;
            if (discountPrices[0]>0) {
                System.out.println("Discount due to buying flavored Bagels in bulk: -£"+String.format("%.2f",discountPrices[0]));
                fullDiscount+=discountPrices[0];

            }
            if(discountPrices[1]>0){
                System.out.println("Discount due to buying Plain Bagels in bulk: -£"+String.format("%.2f",discountPrices[1]));
                fullDiscount+=discountPrices[1];
            }
            if(discountPrices[2]>0){
                System.out.println("Discount due to buying Bagel/Coffee in bulk: -£"+String.format("%.2f",discountPrices[2]));
                fullDiscount+=discountPrices[2];
            }

            System.out.println("You saved a total of: £"+String.format("%.2f",fullDiscount)+" on this purchase");

        }

        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("Total"+ " £"+ String.format("%.2f",basket.getTotal()));
        System.out.println("");
        System.out.println("Thank you for your order!");


    }
}
