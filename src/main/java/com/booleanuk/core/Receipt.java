package com.booleanuk.core;

public class Receipt {
    Basket basket;

    public Receipt(Basket basket){
      this.basket = basket;
      printReceipt();
    }

    public void printReceipt(){
        basket.getAmountOfItems().forEach((key, value) -> System.out.println(value + "x " + key.getSku() + " = " + (double)(key.getPrice() * value))) ;
    }

}
