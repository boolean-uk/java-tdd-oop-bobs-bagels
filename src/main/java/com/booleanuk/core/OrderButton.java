package com.booleanuk.core;

import com.migzus.terminal.menus.Button;
import com.migzus.terminal.menus.Callable;

import java.util.Scanner;

public class OrderButton extends Button {
    public Callable targetBasketAdder;
    public String itemFullName;

    public OrderButton(String name) {
        super(name);
    }

    public OrderButton(String name, Callable callback) {
        super(name, callback);
    }

    public void makeOrder(String uuid) {
        System.out.println("Specify the amount for " + itemFullName + ":");
        Scanner _scanner = new Scanner(System.in);

        try {
            targetBasketAdder.call(uuid, Integer.parseInt(_scanner.next()));
        }
        catch (Exception e) {
            System.out.println("That is not a valid number! Terminating order.");
        }
    }
}
