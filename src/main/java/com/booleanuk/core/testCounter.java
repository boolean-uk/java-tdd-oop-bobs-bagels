package com.booleanuk.core;

public class testCounter {

    public static void main(String[] args) {
        System.out.println(testCount(13));
    }
    public static int testCount(int amount){
        int count = 0;
        int discountValue = 12;
        while (discountValue < amount){
            discountValue += 12;
            count ++;
        }
        discountValue = 6;
        while (discountValue < amount){
            discountValue += 6;
            count ++;
        }
        return count;
    }
}
