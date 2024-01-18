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
public class Filling {

    String fillingSku;
    String itemType;
    String fillingName;
    double fillingPrice;




    public Filling(String fillingSku, String itemType, String fillingName, double fillingPrice) {

        this.setFillingSku(fillingSku);
        this.setItemType(itemType);
        this.setFillingName(fillingName);
        this.setFillingPrice(fillingPrice);



    }

    public void setFillingSku(String fillingSku) {
        this.fillingSku = fillingSku;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setFillingName(String fillingName) {
        this.fillingName = fillingName;
    }

    public void setFillingPrice(double fillingPrice) {
        this.fillingPrice = fillingPrice;
    }

    public String getSku() {
        return fillingSku;
    }

    public String getItemTypeFilling() {
        return itemType;
    }

    public String getFillingName() {
        return fillingName;
    }

    public double getFillingPrice() {
        return fillingPrice;
    }








}
