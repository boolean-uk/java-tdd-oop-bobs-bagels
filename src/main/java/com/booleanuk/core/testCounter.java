package com.booleanuk.core;

public class testCounter {

    public static void main(String[] args) {
        System.out.println(testCount(45,4));
    }
    public static int testCount(int amount, int discountValue){
        int count = 0;
        int orgDisc = discountValue;
        while (discountValue < amount){
            discountValue += orgDisc;
            count ++;
        }
        return count;
    }
}
