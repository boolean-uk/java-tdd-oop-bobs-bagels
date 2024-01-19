package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;

import java.util.Map;

public class Receipt {



    public String printBasket(Basket basket) {

        return formatDate() + "\n" + formatTotal(basket.getItemList()) + "\n" + formatSavings();


    }

    public String formatDate() {

        System.out.println();
    }

    public String formatTotal(Map<Item, Integer> basketMap) {

        for(Map.Entry<Item, Integer> entry : basketMap.entrySet()) {
            for(int)
        }
    }

    public String formatSavings() {
    }
}
