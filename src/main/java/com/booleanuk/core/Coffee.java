package com.booleanuk.core;

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
public class Coffee implements Inventory{

    String sku;
    String itemType;
    String itemName;
    double itemPrice;




    public Coffee(String sku, String itemType, String itemName, double itemPrice) {

        this.setSku(sku);
        this.setItemType(itemType);
        this.setName(itemName);
        this.setPrice(itemPrice);



    }



    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSku() {
        return sku;
    }

    public String getItemType() {
        return itemType;
    }

    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return itemPrice;
    }








}
