package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Discount {
    private ArrayList<DiscountCombo> discountCombos;
    private ArrayList<DiscountQuantity> discountQuantities;
    public Discount(){
        this.discountQuantities = new ArrayList<>();
        this.discountCombos = new ArrayList<>();

        DiscountCombo cb1 = new DiscountCombo(new String[]{"BGL", "COF"}, 1.25);
        discountCombos.add(cb1);
        discountQuantities.add(new DiscountQuantity("BGLO", 6, 2.49));
        discountQuantities.add(new DiscountQuantity("BGLP", 12, 3.99));
        discountQuantities.add(new DiscountQuantity("BGLE", 6, 2.49));
    }


    public ArrayList<DiscountCombo> getDiscountCombos() {
        return discountCombos;
    }

    public ArrayList<DiscountQuantity> getDiscountQuantities() {
        return discountQuantities;
    }
    public static void main(String[] arg){
        Discount object = new Discount();
        for(DiscountQuantity dq : object.getDiscountQuantities()){
            System.out.println(dq);
        }
        for (DiscountCombo dc : object.getDiscountCombos()){
            System.out.println(dc);
        }

    }
}
