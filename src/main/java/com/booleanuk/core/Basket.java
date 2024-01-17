package com.booleanuk.core;

import java.util.Arrays;

public class Basket {
    String[] basketArr;

    public Basket(){
        this.basketArr = new String[5];
    }

    public boolean addToBasket(String product){
        //Check if the basket is full
        boolean bool = false;

        if (this.basketArr[this.basketArr.length - 1] == null) {
            //Go through the array to find the first empty slot
            for (int i = 0; i < basketArr.length; i++) {
                //Add the bagel if the slot is empty
                if (this.basketArr[i] == null) {
                    this.basketArr[i] = product;
                    bool = true;
                    break;
                }
            }
        }

        return bool;
    }

    public boolean removeFromBasket(String product){
        //Go through the array to find the bagel
        boolean bool = false;
        for (int i = 0; i < basketArr.length; i++) {
            //Check if it is empty
            if(basketArr[i]!=null){
                //If it is the same String, remove it
                if(basketArr[i].equals(product)){
                    basketArr[i] = null;
                    bool = true;
                }
            }

        }
        return bool;


    }

    public void changeBasketCapacity(int size){
        String[] newArray = new String[size];
        //Sorting algorithm from stackoverflow
        //needed it to sort the array because of null values
        Arrays.sort(basketArr, (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
        });

        //Loop that adds values into the new array
        for (int i = 0; i < basketArr.length; i++) {
            if(basketArr[i] != null){
                newArray[i] = this.basketArr[i];
            }

        }

        //Makes the original array == the new array
        basketArr = newArray;
    }

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.addToBasket("bagle");
        basket.addToBasket("cofe");
        System.out.println(Arrays.toString(basket.basketArr));
    }


}

