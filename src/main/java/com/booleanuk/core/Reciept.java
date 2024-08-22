package com.booleanuk.core;
import java.util.ArrayList;


public class Reciept {

    Basket basket;
    ArrayList<String> recieptRows;

    public Reciept(Basket basket){
        this.basket = basket;
        this.recieptRows = new ArrayList<>();
        this.createReciept();

    }

    public void printReciept(){
        for(String row : recieptRows){
            System.out.println(row);
        }
    }

    public void createReciept(){
        recieptRows.add("    ~~~ Bob's Bagels ~~~    ");
        recieptRows.add("");
        recieptRows.add("    2021-03-16 21:38:44     ");
        recieptRows.add("");
        recieptRows.add("----------------------------");

        for(Product product : basket.currentBasket.keySet()){
            int quantity = basket.currentBasket.get(product);

            recieptRows.add(product.retrieveVariant() + " " + product.retrieveName() + "       " + quantity + " £");

            //System.out.printf("%6d", basket.currentBasket.get(product) + " £" + basket.costOfFilling(product.retrieveSku()) * Double.valueOf(basket.currentBasket.get(product)));

        }

    }











}
