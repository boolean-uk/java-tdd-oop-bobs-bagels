package com.booleanuk.extension;

import com.booleanuk.core.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ExtensionReceipt {
    HashMap<Item, Integer> itemsThatArePurchased;
    String dateOfPurchase;

    public ExtensionReceipt(HashMap<Item, Integer> itemsThatArePurchased){
        this.itemsThatArePurchased = itemsThatArePurchased;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateOfPurchase = sdf.format(new Date());
    }
}
