package com.booleanuk.core;

import com.migzus.terminal.menus.Button;
import com.migzus.terminal.menus.Callable;

import java.util.Scanner;

public class RemoveOrderButton extends Button {
    public Callable onRefreshButtonList;

    public Callable targetBasketRemover;
    public String itemFullName;

    public RemoveOrderButton(String name) {
        super(name);
    }

    public RemoveOrderButton(String name, Callable callback) {
        super(name, callback);
    }

    public void removeOrder(String uuid) {
        System.out.println("Specify the amount for " + itemFullName + " to remove:");
        Scanner _scanner = new Scanner(System.in);

        try {
            targetBasketRemover.call(uuid, Integer.parseInt(_scanner.next()));
        }
        catch (Exception e) {
            System.out.println("That is not a valid number! Terminating order.");
        }

        if (onRefreshButtonList != null)
            onRefreshButtonList.call();
    }
}
