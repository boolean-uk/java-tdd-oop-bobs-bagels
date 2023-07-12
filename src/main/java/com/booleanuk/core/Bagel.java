package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bagel extends Item {
    public static HashSet<String> bagelsSkus;
    public HashMap<String, Integer> fillings;
    public static void fillBagelsSkus() {
        bagelsSkus = new HashSet<String>();
        bagelsSkus.add("BGLO");
        bagelsSkus.add("BGLP");
        bagelsSkus.add("BGLE");
        bagelsSkus.add("BGLS");
    }
    public Bagel(String sku) {
        super(sku);
        fillings = new HashMap<String, Integer>();
    }
    public boolean addFilling(String fillingSku) {
        if (Filling.fillingsSkus.contains(fillingSku)) {
            Integer amount = fillings.get(fillingSku);
            fillings.put(fillingSku, amount == null ? 1 : amount + 1);
            setPrice(getPrice() + itemPriceVariants.get(fillingSku).getPrice());
            return true;
        }
        return false;
    }
    public boolean removeFilling(String fillingSku) {
        if (Filling.fillingsSkus.contains(fillingSku))
            if (fillings.containsKey(fillingSku)) {
                fillings.put(fillingSku, fillings.get(fillingSku) - 1);
                if(fillings.get(fillingSku) == 0)
                    fillings.remove(fillingSku);
                setPrice(getPrice() - itemPriceVariants.get(fillingSku).getPrice());
                return true;
            }
        return false;
    }
}
