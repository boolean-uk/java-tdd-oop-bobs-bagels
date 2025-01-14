package com.booleanuk.extension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopHandler sh = new ShopHandler(new Scanner(System.in));
        sh.placeOrder();
    }
}
