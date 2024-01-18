package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.User;

import java.util.HashMap;

public class BasketExtension extends Basket {

    public BasketExtension(User user) {
        super(user);
    }

    public void checkout(){
        products = new HashMap<>();
        items = 0;
        printReceipt();
    }

    private void printReceipt(){

    }
}
