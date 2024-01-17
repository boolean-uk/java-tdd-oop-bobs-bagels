package com.booleanuk.core;

import java.util.HashMap;

/*SKU	Price	Name	Variant
BGLO	0.49	Bagel	Onion
BGLP	0.39	Bagel	Plain
BGLE	0.49	Bagel	Everything
BGLS	0.49	Bagel	Sesame
COFB	0.99	Coffee	Black
COFW	1.19	Coffee	White
COFC	1.29	Coffee	Capuccino
COFL	1.29	Coffee	Latte
FILB	0.12	Filling	Bacon
FILE	0.12	Filling	Egg
FILC	0.12	Filling	Cheese
FILX	0.12	Filling	Cream Cheese
FILS	0.12	Filling	Smoked Salmon
FILH	0.12	Filling	Ham */
public class Bagel {

    String bagelSku;
    String bagelName;
    String itemTypeBagel;
    double bagelPrice;




    public Bagel(String bagelSku, String itemTypeBagel, String bagelName, double bagelPrice) {

        this.bagelSku = bagelSku;
        this.itemTypeBagel = itemTypeBagel;
        this.bagelName = bagelName;
        this.bagelPrice = bagelPrice;






    }

    public String getSku() {
        return bagelSku;
    }

    public String getItemTypeBagel() {
        return itemTypeBagel;
    }

    public String getBagelName() {
        return bagelName;
    }

    public double getBagelPrice() {
        return bagelPrice;
    }


    Bagel bagel1 = new Bagel("BGLO", "Bagel", "Onion", 0.49);
    Bagel bagel2 = new Bagel("BGLP", "Bagel", "Plain", 0.39);
    Bagel bagel3 = new Bagel("BGLE", "Bagel", "Everything", 0.49);
    Bagel bagel4 = new Bagel("BGLS", "Bagel", "Sesame", 0.49);

    public static void main(String[] args) {

        Bagel bagel5 = new Bagel("fvf", "fvfr", "ffrf", 3.44);

        System.out.println("Hei");
    }

}
