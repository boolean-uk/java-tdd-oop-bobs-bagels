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

        this.setBagelSku(bagelSku);
        this.setItemTypeBagel(itemTypeBagel);
        this.setBagelName(bagelName);
        this.setBagelPrice(bagelPrice);






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

    public void setBagelSku(String bagelSku) {
        this.bagelSku = bagelSku;
    }

    public void setBagelName(String bagelName) {
        this.bagelName = bagelName;
    }

    public void setItemTypeBagel(String itemTypeBagel) {
        this.itemTypeBagel = itemTypeBagel;
    }

    public void setBagelPrice(double bagelPrice) {
        this.bagelPrice = bagelPrice;
    }
}
