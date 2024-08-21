package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Order;

import java.util.HashMap;

public class Receipt {

    Receipt(){

    }

    public void printReceipt(Order order, boolean receipt){

        Basket basket=new Basket(26);
        double[] discountPrices=new double[4];
        basket.add(order);
        if(receipt){
            Discount discount= new Discount();
            discountPrices=discount.discPriceAlt(order);
            order.setTotal(order.getTotal()- discountPrices[3]);
            basket.adjustTotal(order.getTotal());
        }

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

        if(receipt){
            if (discountPrices[0]>0) {
                System.out.println("Discount due to buying flavored Bagels in bulk: "+-discountPrices[0]);

            }
            if(discountPrices[1]>0){
                System.out.println("Discount due to buying Plain Bagels in bulk: "+-discountPrices[1]);
            }
            if(discountPrices[2]>0){
                System.out.println("Discount due to buying Bagel/Coffee in bulk: "+-discountPrices[2]);
            }
        }

        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("Total"+ " £"+ basket.getTotal());
        System.out.println("");
        System.out.println("Thank you for your order!");


    }
}
